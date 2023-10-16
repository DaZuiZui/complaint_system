<template>
   
        
    
    <section v-if="isCheck">

    </section>
    <!-- Main content -->
    <section v-else>
        <div class="container">
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">#</th>
                    <th scope="col">投诉信息</th>
                    <th scope="col">投诉用户</th>
                    <th scope="col">发布时间</th>
                    <th scope="col">最后一次修改时间</th>
                    <th scope="col">操作</th>
                    <th><button @click="addWindows = true"> 增加 </button></th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="obj in list" :key="obj.index">
                    <th scope="row">{{ obj.id }}</th>
                    <td>{{obj.context}}</td>
                    <td>{{obj.username}}</td>
                    <td>{{obj.createTime}}</td>
                    <td>{{obj.updateTime}}</td>
                    <td>
                        <el-link type="primary" v-if="Admin" @click="check(obj)">查看</el-link>

                      <el-link type="primary" v-if="Admin" @click="openUpdateComplaintInfoWindows(obj.id)">修改</el-link>
                     
                      <el-drawer
                        title="我是标题"
                        :visible.sync="updateWindows"
                        :with-header="false">
                        <div>
                          用户名
                          <el-input v-model="taskInfo.context" placeholder="更改投诉信息"></el-input>
                          <br>
                         
                          <br>  
                          <el-button type="primary" @click="updateTaskInfo()">确认修改</el-button>
                        </div>
                      </el-drawer>

                      <el-link type="success" v-if="Admin" @click="deleteById(obj.id)">删除</el-link>
                    </td>
                  </tr>
                </tbody>
              </table>
              <el-drawer
                        title="我是标题"
                        :visible.sync="addWindows"
                        :with-header="false">
                        <div>
                          投诉信息
                          <el-input v-model="taskAddByIdBo.task.context" placeholder="输入想要投诉的信息"></el-input>
                          <br>
                          <!-- 密码:
                          <el-input v-model="task.image" placeholder=""></el-input> -->
                          <br>
                           
                          <el-button type="primary" @click="addTask()">提交</el-button>
                        </div>
                      </el-drawer>

              <el-pagination
                :page-size="100"
                :pager-count="11"
                @current-change="getMerchantInformation"
                layout="prev, pager, next"
                :total="count">
            </el-pagination>
        </div>
    </section>
</template>

<script>

import {synRequestPost,synRequestGet} from "../../../static/request"

export default {
data () {
  return {

    //添加投诉信息
    taskAddByIdBo:{
        token:'',
        task:{
            context:''
        }
    },
    //是否为查看
    isCheck:false,
    //查看对象
    checkInfo:{},
    //是否为管理员
    Admin:false,
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
      addWindows:false,
      //用户信息
      taskInfo: {
        id: -1,
        context:''
      },
      taskImgSelectByIdBo:{
        token :'',
        id:'',
      },
      updataByIdBo: {
          token: "",
          task: {
            context:'',
            id: -1,
          }
      }
    }
  },
  mounted(){
    this.deleteByIdBo.token = getCookie("token");
    this.getMerchantInformation(1)
  },

methods: {
    async check(obj){
        this.isCheck = true
        this.taskImgSelectByIdBo.id = obj.id;
        let res = await synRequestPost("/task_img/select",this.taskImgSelectByIdBo);
        console.log(res);
    },

    /**
     *  修改用户信息
     */
    async updateTaskInfo(){
        //todo userInfo 要求username 和password 和name 不可以为空
        this.updataByIdBo.task.context = this.taskInfo.context;
        this.updataByIdBo.task.id       = this.taskInfo.id;
        let obj = await synRequestPost("/task/update",this.updataByIdBo);
        console.log(obj);
        alert(obj.message);

        this.updateWindows = false;
        this.getMerchantInformation(1);
    },

    //更新用户信息
    async openUpdateComplaintInfoWindows(id){
      this.selectByIdBo.id = id;
      let obj = await synRequestPost("/task/select",this.selectByIdBo);
      this.taskInfo = obj.data;
      this.updateWindows = true;
    },

    //跳转指定页面  
    async getMerchantInformation(val){ 
        this.pagingToGetUserDataBo.start = (val -1) * this.pagingToGetUserDataBo.size;
        let obj = await synRequestPost("/task/selectAll",this.pagingToGetUserDataBo);
        let role =JSON.parse(localStorage.getItem('role'))
            if (role == 2) {
                this.Admin =true
            }
        if(obj.code == "0x200"){
            this.list = obj.data;
        }
        console.log(this.list);
    },

    //删除用户通过id
    async deleteById(id){
      this.deleteByIdBo.id = id;
      let obj = await synRequestPost("/task/delete",this.deleteByIdBo);
      alert(obj.message);
      this.getMerchantInformation(1);
      
    },
    //添加投诉信息
    async addTask(){
        this.taskAddByIdBo.token = getCookie("token");

        let obj = await synRequestPost("/task/add",this.taskAddByIdBo);
        console.log(obj);

    }

  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
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
