<template>
    <div class="Register">
        <div>
            <Top></Top>
        </div>

        <!-- Main content -->
        <section>
            <div class="container">
                <!-- Title -->
                <!-- Section title -->
                <div class="row mb-5 justify-content-center text-center">
                    <div class="col-lg-6">

                        <h2 class=" mt-4">注册您的账户</h2>
                        <div class="mt-2">
                            <p class="lead lh-180">Register Your Account</p>
                        </div>

                        <div>
                            <div class="form-group">
                                <label for="exampleInputEmail1">Enter Username</label>
                                <input type="text" class="form-control" v-model="user.username">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter Password</label>
                                <input type="password" class="form-control" v-model="user.password">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter Password again</label>
                                <input type="password" class="form-control" v-model="user.againPassword">
                            </div>

                            <div class="form-group">
                                <label for="exampleInputEmail1">Enter Username</label>
                                <input type="text" class="form-control" v-model="user.name">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter College</label>
                                <br>
                                <el-select v-model="input" placeholder="请选择">
                                    <el-option v-for="item in college" :key="item.value" :label="item.text"
                                        :value="item.value">
                                    </el-option>
                                </el-select>
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter Org</label>
                                <input type="text" class="form-control" v-model="user.org">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter grade</label>
                                <input type="text" class="form-control" v-model="user.grade">
                            </div>
                            <div class="form-group">
                                <label for="exampleInputPassword1">Enter StudentId</label>
                                <input type="text" class="form-control" v-model="user.studentId">
                            </div>
                            <button class="btn btn-primary" style="width:100%" @click="submit()">Submit</button>

                        </div>
                    </div>
                </div>

            </div>
        </section>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>
  
<script>
import Foot from '../frame/Foot.vue';
import Top from '../frame/LoginTop.vue';
import { synRequestPost, synRequestGet } from "../../../static/request"

export default {
    name: 'Register',
    components: {
        Foot, Top
    },
    data() {
        return {
            user: {
                username: "",
                password: "",
                againPassword: "",
                name: '',
                college: '',
                grade: '',
                studentId: '',
            },
            //学院
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
            input: "",
        }
    },
    mounted() {

    },

    methods: {
        //提交登入
        async submit() {
            this.user.college = this.input

            if (this.user.username == "") {
                alert("用户名不能为空!")
                return
            }
            if (this.user.username.length < 3) {
                alert("用户名长度小于3,请重新输入!")
                this.user.username = ""
                return
            }
            if (this.user.username.length > 30) {
                alert("用户名长度大于30,请重新输入!")
                this.user.username = ""
                return
            }

            if (this.user.password == "") {
                alert("密码不能为空!")
                return
            }
            //密码的重复输入正确判断
            if (this.user.password !== this.user.againPassword) {
                alert('密码设置失败');
                return;
            }
            if (this.user.name == "") {
                alert("真实姓名不能为空!")
                return
            }
            if (this.user.name.length < 1) {
                alert("真实姓名长度小于1,请重新输入!")
                this.user.name = ""
                return
            }
            if (this.user.username.length > 4) {
                alert("真实姓名长度大于4,请重新输入!")
                this.user.name = ""
                return
            }
            if (this.user.college == "") {
                alert("学院不能为空!")
                return
            }
            if (this.user.grade == "") {
                alert("年纪不能为空!")
                return
            }
            if (this.user.studentId == "") {
                alert("学号不能为空!")
                return
            }
            let obj = await synRequestPost("/user/userReg", this.user);
            if (obj.code == '0x200') {
                alert(obj.message)
                this.$router.push("/userLogin");
            }

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
  