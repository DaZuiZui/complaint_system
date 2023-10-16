<template>
    <div class="hello">
        <div class="top">
            <Top></Top>
        </div>
        <div class="content">
            <div class="left">
                <div class="complaintManagement tab">
                    <router-link to="/complaintManagement">投诉管理</router-link>
                </div>
                <div class="userMangement tab" v-if="Admin">
                    <router-link to="/userManagement">用户管理</router-link>
                </div>
                <div class="userInfo tab">
                    <router-link to="/userInfo">个人信息</router-link>
                </div>
            </div>
            <div class="rigth">
                <router-view />
            </div>
        </div>

        <footer class="position-relative" id="footer-main">
            <Foot></Foot>
        </footer>
    </div>
</template>
<script>
import Foot from '../frame/Foot.vue';
import Top from '../frame/LoginTop.vue'
import { synRequestPost, synRequestGet } from "../../../static/request"

export default {
    name: 'Register',
    components: {
        Foot, Top
    },
    data(){
        return{
            Admin:false
        }
    },
    methods:{
        isAdmin(){
            let role =JSON.parse(localStorage.getItem('role'))
            if (role == 2) {
                this.Admin =true
            }
        }
    },
    mounted(){
        this.isAdmin()
    }

}
</script>
<style scoped>
.content{
    display: flex;
    
}
.left{
    height: 90%;
    width: 15%;
}
.rigth{
    height: 90%;
    width: 85%;

}
.tab{
    margin: 30px;
}
a{
    color: black;
}
</style>