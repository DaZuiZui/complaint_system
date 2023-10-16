<template>
  <div>
    <!-- Main content -->
    <section v-if="view">
      <div class="container">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">#</th>
              <th scope="col">用户名</th>
              <th scope="col">密码</th>
              <th scope="col">学生Id</th>
              <th scope="col">操作</th>
            </tr>

          </thead>
          <tbody>
            <tr v-for="obj in list" :key="obj.index">
              <th scope="row">{{ obj.id }}</th>
              <td>{{ obj.username }}</td>
              <td>{{ obj.password }}</td>
              <td>{{ obj.studentId }}</td>
              <td>
                <el-link type="primary"  @click="openView(obj)">查看</el-link>

                <el-link type="primary"  @click="openUpdateUserInfoWindows(obj.id)">修改</el-link>

                <el-drawer title="我是标题" :visible.sync="updateWindows" :with-header="false">
                  <div>
                    名字:
                      <el-input v-model="userInfo.name" placeholder="更改名字"></el-input>
                    <br>
                    用户名:
                      <el-input v-model="userInfo.username" placeholder="更改用户名"></el-input>
                    <br>
                    密码:
                      <el-input v-model="userInfo.password" placeholder="更改密码"></el-input>
                    <br>
                    
                    
                    <el-button type="primary" @click="updateUserInfo()">提交</el-button>
                  </div>
                </el-drawer>


                <el-link type="success" @click="deleteById(obj.id)">删除</el-link>
              </td>
            </tr>
          </tbody>
        </table>


        <el-pagination :page-size="100" :pager-count="11" @current-change="getMerchantInformation"
          layout="prev, pager, next" :total="count">
        </el-pagination>
      </div>
    </section>
    
    <!-- View content  -->
    <section v-else>
      <!-- 用户名 -->
      <div>
        <div class="key">
          用户名
        </div>
        <div class="value">
          {{ schoolView.username }}
        </div>
      </div>

      <!-- 密码 -->
      <div>
        <div class="key">
          密码
        </div>
        <div class="value">
          {{ schoolView.password }}
        </div>
      </div>

      <!-- 名字 -->
        <div v-if="schoolView.name">
          <div class="key">
            名字
          </div>
          <div class="value">
            {{ schoolView.name }}
          </div>
        </div>

      <!-- 大学 -->
      <div v-if="schoolView.org">
          <div class="key">
            班级
          </div>
          <div class="value">
            {{ schoolView.org }}
          </div>
      </div>

      <!-- 学院 -->
        <div v-if="schoolView.college">
        <div class="key">
            学院
        </div>
          <div class="value">
            {{ schoolView.college }}
          </div>
        </div>


      <!-- 年级 -->
      <div v-if="schoolView.grade">
        <div class="key">
          年级
        </div>
        <div class="value">
          {{ schoolView.grade}}
        </div>
      </div>

      <!-- 学号 -->
        <div v-if="schoolView.student_id">
          <div class="key">
            学号
          </div>
          <div class="value">
            {{ schoolView.student_id }}
          </div>
        </div>

       

    
    </section>

  </div>
</template>
  
<script>

import { synRequestPost, synRequestGet } from "../../../static/request"

export default {
  data() {
    return {
      //是否为查看
      user: {
        username: "",
        password: "",
      },
      //查看学院
      schoolView: {
        
      },
      //按钮开关
      switchbutton: false,
      //用户数据集合
      list: null,
      count: 0,

      //分页查询
      pagingToGetUserDataBo: {
        start: 0,
        size: 100,
        name: "",
        status: 0,
        delFlag: 0,
      },

      //通过id删除
      deleteByIdBo: {
        token: "",
        id: -1
      },

      //查重用户通过id
      selectByIdBo: {
        token: "",
        id: -1,
      },

      //修改窗口
      updateWindows: false,

      //用户信息
      userInfo: {
        id: -1,
        username: "",
        password: "",
        name: "",
      },
      //更新用户信息
      updataByIdBo: {
        token: "",
        user: {
          username: "",
          password: "",
          name: "",
          id: -1,
        }
      },
      //查看
      view: true,
      //学院信息
      college: [
        {
          value: 1,
          text: '信息学院'
        },
        {
          value: 2,
          text: '财经学院'
        },
        {
          value: 3,
          text: '艺术与传媒学院'
        },
        {
          value: 4,
          text: '通识学院'
        }
      ],
    }
  },
  mounted() {
    this.deleteByIdBo.token = getCookie("token");
    this.getMerchantInformation(1)
  },

  methods: {
    /**
     *  修改用户信息
     */
    async updateUserInfo() {
      //todo userInfo 要求username 和password 和name 不可以为空
      this.updataByIdBo.user.password = this.userInfo.password;
      this.updataByIdBo.user.username = this.userInfo.username;
      this.updataByIdBo.user.name = this.userInfo.name;
      this.updataByIdBo.user.id = this.userInfo.id;
      let obj = await synRequestPost("/user/updata", this.updataByIdBo);
      alert(obj.message);
      this.updateWindows = false
      this.getMerchantInformation(1);
    },

    //更新用户信息
    async openUpdateUserInfoWindows(id) {
      this.selectByIdBo.id = id;
      let obj = await synRequestPost("/user/selectById", this.selectByIdBo);
      this.userInfo = obj.data;
      this.updateWindows = true;
    },

    //跳转指定页面  
    async getMerchantInformation(val) {
      this.pagingToGetUserDataBo.start = (val - 1) * this.pagingToGetUserDataBo.size;
      let obj = await synRequestPost("/user/findAll", this.pagingToGetUserDataBo);
      console.log(obj);
      if (obj.code == "0x200") {
        this.list = obj.data;

      }
    },

    //删除用户通过id
    async deleteById(id) {
      this.deleteByIdBo.id = id;
      let obj = await synRequestPost("/user/delete", this.deleteByIdBo);
      alert(obj.message);
      this.getMerchantInformation(1);

    },
    //查看功能
    openView(obj) {
      this.view = false
      // console.log(obj.college);
      // console.log(this.college[obj.college]);
      // obj.college = this.college[obj.college].text
      // console.log(obj.college);
      this.schoolView = obj
    }


  }

}

</script>
    
    <!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1,
h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}


</style>
    