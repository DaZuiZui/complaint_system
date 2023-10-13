<template>
   
        
        <!-- Main content -->
        <section >
            <div class="container">
                <table class="table">
                    <thead>
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">姓名</th>
                        <th scope="col">加1入时间</th>
                        <th scope="col">修改</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr v-for="obj in list" :key="obj.index">
                        <th scope="row">1</th>
                        <td>{{obj.name}}</td>
                        <td>{{obj.createTime}}</td>
                        <td>
                          <el-link type="primary" :disabled="obj.username == 'root'" @click="openUpdateUserInfoWindows(obj.id)">修改</el-link>
                         
                          <el-drawer
                            title="我是标题"
                            :visible.sync="updateWindows"
                            :with-header="false">
                            <div>
                              用户名
                              <el-input v-model="userInfo.username" placeholder="更改用户名"></el-input>
                              <br>
                              密码:
                              <el-input v-model="userInfo.password" placeholder="更改密码"></el-input>
                              <br>
                              名字:
                              <el-input v-model="userInfo.name"     placeholder="更改密码"></el-input>
                              <br>  
                              <el-button type="primary" @click="updateUserInfo()">主要按钮</el-button>
                            </div>
                          </el-drawer>
  
  
                          <el-link type="success" @click="deleteById(obj.id)" :disabled="obj.username == 'root'">删除</el-link>
                        </td>
                      </tr>
                    </tbody>
                  </table>
              
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
        user: {
            username: "",
            password: "",
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
  
          updataByIdBo: {
              token: "",
              user: {
                username: "",
                password: "",
                name: "",
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
        /**
         *  修改用户信息
         */
        async updateUserInfo(){
            //todo userInfo 要求username 和password 和name 不可以为空
            this.updataByIdBo.user.password = this.userInfo.password;
            this.updataByIdBo.user.username = this.userInfo.username;
            this.updataByIdBo.user.name     = this.userInfo.name;
            this.updataByIdBo.user.id       = this.userInfo.id;
            let obj = await synRequestPost("/user/updata",this.updataByIdBo);
            alert(obj.message);
            this.getMerchantInformation(1);
        },
  
        //更新用户信息
        async openUpdateUserInfoWindows(id){
          this.selectByIdBo.id = id;
          let obj = await synRequestPost("/user/selectById",this.selectByIdBo);
          this.userInfo = obj.data;
          this.updateWindows = true;
        },
  
        //跳转指定页面  
        async getMerchantInformation(val){ 
            this.pagingToGetUserDataBo.start = (val -1) * this.pagingToGetUserDataBo.size;
            let obj = await synRequestPost("/user/pagingToGetUserData",this.pagingToGetUserDataBo);
          
            if(obj.code == "0x200"){
                this.list = obj.data.list;
                this.count = obj.data.count;
            }
        },
  
        //删除用户通过id
        async deleteById(id){
          this.deleteByIdBo.id = id;
          let obj = await synRequestPost("/user/delete",this.deleteByIdBo);
          alert(obj.message);
          this.getMerchantInformation(1);
          
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
    