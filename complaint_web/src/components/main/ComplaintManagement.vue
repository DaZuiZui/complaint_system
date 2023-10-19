<template>
    <!-- Main content -->
    <section>
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
                        <th><button class="but" @click="addWindows = true"> 增加 </button></th>
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
                                    <h4>投诉信息:</h4>
                                    <div class="check">
                                        <el-input v-model="taskInfo.context" placeholder="更改投诉信息"></el-input>
                                    </div>
                                    
                                    <el-button style="margin-top: 50px;" type="primary" @click="updateTaskInfo()">确认修改</el-button>
                                </div>
                            </el-drawer>

                            <el-link type="success" v-if="Admin" @click="deleteById(obj.id)">删除</el-link>
                        </td>
                    </tr>
                </tbody>
            </table>
            <el-drawer title="我是标题" :visible.sync="addWindows" :with-header="false">
                <div class="check">
                    <h4>
                        投诉信息
                    </h4> <el-input v-model="taskAddByIdBo.task.context" placeholder="输入想要投诉的信息"></el-input>
                    <el-upload class="upload-demo" ref="upload" action="#" :auto-upload="false" drag :http-request="addTask"
                        :limit='1'>
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                        <div class="el-upload__tip" slot="tip">
                            只能上传jpg/png文件，且不超过500kb
                        </div>
                    </el-upload>
                    <span slot="footer" class="dialog-footer">
                        <el-button @click="addWindows = false">取 消</el-button>
                        <el-button type="primary" @click="addTask()">确 定</el-button>
                    </span>
                    <!-- <el-button type="primary" @click="addTask()">提交</el-button> -->
                </div>
            </el-drawer>

            <el-drawer title="我是标题" size="60%" :visible.sync="isCheck" :with-header="false">
                <div>
                    <img width="100%" :src="taskImg.imgUrl" alt="">
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
            //图片
            formData: new FormData,
            taskImg: {
                imgUrl: ''
            },
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
            //投诉信息
            taskInfo: {
                id: -1,
                context: ''
            },
            // 查找投诉图片
            taskImgSelectByIdBo: {
                token: '',
                partId: '',
            },
            //删除投诉图片
            taskImgdeleteByIdBo: {
                token: '',
                partId: '',
            },
            //修改投诉信息
            updataByIdBo: {
                token: "",
                task: {
                    context: '',
                    id: -1,
                }
            },
            // 添加投诉图片
            taskImgAddByBo: {
                token: '',
                taskImg: {
                    imgUrl: '',
                    partId: ''
                }
            },
            //修改投诉图片
            taskImgUpdateByBo: {
                token: '',
                taskImg: {
                    imgUrl: '',
                    partId: ''
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

            this.taskImgSelectByIdBo.partId = obj.id;
            let res = await synRequestPost("/task_img/select", this.taskImgSelectByIdBo);
            console.log(res);
            if (res.code == '0x200') {

                this.taskImg = res.data
                this.isCheck = true
            } else {
                alert('该条投诉没有图片信息.')
            }
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
            let obj = await synRequestPost("/task/selectall", this.pagingToGetUserDataBo);
            let role = JSON.parse(localStorage.getItem('role'))
            if (role == 2) {
                this.Admin = true
            }
            if (obj.code == "0x200") {
                this.list = obj.data;
            }
            // console.log(this.list);
        },

        //删除用户通过id
        async deleteById(id) {
            this.deleteByIdBo.id = id;
            this.deleteByIdBo.token = this.token;
            let obj = await synRequestPost("/task/delete", this.deleteByIdBo);
            this.taskImgdeleteByIdBo.partId = obj.data
            this.taskImgdeleteByIdBo.token = this.token
            let res = await synRequestPost("/task_img/delete", this.taskImgdeleteByIdBo);
            // console.log(res);
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
            if (this.$refs.upload.uploadFiles.length != 0) {
                this.taskImgAddByBo.taskImg.partId = obj.data
                const files = this.$refs.upload.uploadFiles;
                // files.forEach(async (item, index) => {
                // 遍历文件列表添加文件
                this.formData.append("file", files[0].raw);
                this.formData.append("token", this.token);
                let uploadObj = await synRequestPost("/system/imgUpDown", this.formData);
                this.taskImgAddByBo.taskImg.imgUrl = uploadObj.data
                // });
                // 这里是我请求额外携带的一个token参数
                this.taskImgAddByBo.token = this.token
                console.log(this.taskImgAddByBo);
                let res = await synRequestPost("/task_img/add", this.taskImgAddByBo);
                console.log(res);
            }
            this.addWindows = false;
            this.getMerchantInformation();

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
.but{
    border: none;
    background-color: #fff;
    font-size: 15px;
}
>>>.el-drawer__body {

    margin: 10px 0;
    /* display: flex;
    align-items: center;
    justify-content: center; */
}

>>>.el-drawer__body .check {
    margin-top: 50px;
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    align-items: center;
}

>>>.el-drawer__body .check div {
    margin-top: 20px;
}

>>>.el-drawer__body .check span {
    margin-top: 20px;
}
>>>.el-drawer__body .check button{
    margin-top: 20px;
}
</style>
