import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserManagement from '@/components/main/UserManagement.vue'
import ComplaintManagement from '@/components/main/ComplaintManagement.vue'
import AdminManagement from '@/components/main/AdminManagement.vue'
import UserLogin from '@/components/main/UserLogin.vue'
import UserRegister from '@/components/main/UserRegister.vue'


Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/h',
  
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/userManagement',
      name: 'UserManagement',
      component: UserManagement
    },
    {
      path: '/complaintManagement',
      name: 'complaintManagement',
      component: ComplaintManagement
    },
    {
      path: '/adminManagement',
      name: 'AdminManagement',
      component: AdminManagement
    },
    {
      path: '/userLogin',
      name: 'UserLogin',
      component: UserLogin
    },
    {
      path: '/userRegister',
      name: 'UserRegister',
      component: UserRegister
    },
    
  ]
})
