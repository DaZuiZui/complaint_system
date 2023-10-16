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
                        <td>{{ obj.context }}</td>
                        <td>{{ obj.username }}</td>
                        <td>{{ obj.createTime }}</td>
                        <td>{{ obj.updateTime }}</td>
                        <td>
                            <el-link type="primary" @click="check(obj)">查看</el-link>

                            <el-link type="primary" v-if="Admin"
                                @click="openUpdateComplaintInfoWindows(obj.id)">修改</el-link>

                            <el-drawer title="我是标题" :visible.sync="updateWindows" :with-header="false">
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
            <el-drawer title="我是标题" :visible.sync="addWindows" :with-header="false">
                <div>
                    投诉信息
                    <el-input v-model="taskAddByIdBo.task.context" placeholder="输入想要投诉的信息"></el-input>
                    <br>
                    <el-upload class="upload-demo" ref="upload" action="http://localhost:8001/system/imgUpDown"
                        :on-preview="handlePreview" :on-remove="handleRemove" :file-list="fileList" :auto-upload="false">
                        <el-button slot="trigger" size="small" type="primary">选取文件</el-button>

                        <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                    </el-upload>
                    <br>
                    <el-button style="margin-left: 10px;" size="small" type="success" @click="addTask()">上传到服务器</el-button>
                    <!-- <el-button type="primary" @click="addTask()">提交</el-button> -->
                </div>
            </el-drawer>

            <el-pagination :page-size="100" :pager-count="11" @current-change="getMerchantInformation"
                layout="prev, pager, next" :total="count">
            </el-pagination>
        </div>
    </section>
</template>

<script>

import { synRequestPost, synRequestGet } from "../../../static/request"

export default {
    data() {
        return {
            token: getCookie("token"),
            //添加投诉信息
            taskAddByIdBo: {
                token: '',
                task: {
                    context: ''
                }
            },
            //是否为查看
            isCheck: false,
            //查看对象
            checkInfo: {},
            //是否为管理员
            Admin: false,
            //按钮开关
            switchbutton: false,
            //用户数据集合
            list: null,
            count: 0,
            fileList: [],
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
            addWindows: false,
            //用户信息
            taskInfo: {
                id: -1,
                context: ''
            },
            taskImgSelectByIdBo: {
                token: '',
                id: '',
            },
            updataByIdBo: {
                token: "",
                task: {
                    context: '',
                    id: -1,
                }
            }
        }
    },
    mounted() {
        this.deleteByIdBo.token = getCookie("token");
        this.getMerchantInformation(1)
    },

    methods: {
        async check(obj) {
            this.isCheck = true
            this.taskImgSelectByIdBo.id = obj.id;
            let res = await synRequestPost("/task_img/select", this.taskImgSelectByIdBo);
            console.log(res);
        },

        /**
         *  修改投诉信息
         */
        async updateTaskInfo() {
            //todo userInfo 要求username 和password 和name 不可以为空
            this.updataByIdBo.task.context = this.taskInfo.context;
            this.updataByIdBo.task.id = this.taskInfo.id;
            this.updataByIdBo.token = this.token;
            let obj = await synRequestPost("/task/update", this.updataByIdBo);
            console.log(obj);
            alert(obj.message);

            this.updateWindows = false;
            this.getMerchantInformation(1);
        },

        //更新用户信息
        async openUpdateComplaintInfoWindows(id) {
            this.selectByIdBo.id = id;
            this.selectByIdBo.token = this.token
            let obj = await synRequestPost("/task/select", this.selectByIdBo);
            this.taskInfo = obj.data;
            this.updateWindows = true;
        },

        //跳转指定页面  
        async getMerchantInformation(val) {
            this.pagingToGetUserDataBo.start = (val - 1) * this.pagingToGetUserDataBo.size;
            let obj = await synRequestPost("/task/selectAll", this.pagingToGetUserDataBo);
            let role = JSON.parse(localStorage.getItem('role'))
            if (role == 2) {
                this.Admin = true
            }
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
            console.log(this.list);
        },

        //删除用户通过id
        async deleteById(id) {
            this.deleteByIdBo.id = id;
            this.deleteByIdBo.token = token;
            let obj = await synRequestPost("/task/delete", this.deleteByIdBo);
            alert(obj.message);
            this.getMerchantInformation(1);

        },
        //添加投诉信息
        async addTask() {
            if (this.taskAddByIdBo.task.context == '') {
                alert('投诉信息为空!')
                return
            }
            this.taskAddByIdBo.token = this.token
            let obj = await synRequestPost("/task/add", this.taskAddByIdBo);
            // console.log(obj);
            // console.log(this.fileList);
            // const formData = new FormData();
            // formData.append('flie', this.fileList)
            // formData.append('token', token)
            // console.log(formData);

        },

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
