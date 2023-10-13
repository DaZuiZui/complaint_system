import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import UserManagement from '@/components/main/UserManagement.vue'
import ComplaintManagement from '@/components/main/ComplaintManagement.vue'
import AdminManagement from '@/components/main/AdminManagement.vue'
import UserLogin from '@/components/main/UserLogin.vue'
import UserRegister from '@/components/main/UserRegister.vue'
import UserInfo from '@/components/main/UserInfo.vue'
import Home from '@/components/main/Home.vue'


Vue.use(Router)

export default new Router({
  mode: 'history',
  base: '/h',

  routes: [
    {
      path: '/helloworld',
      name: 'HelloWorld',
      component: HelloWorld
    },

    {
      path: '/',
      component:Home,
      children: [
        {
          path: '/complaintManagement',
          name: 'complaintManagement',
          component: ComplaintManagement,
        },
        {
          path: '/userManagement',
          name: 'UserManagement',
          component: UserManagement
        },{
          path: '/userInfo',
          name: 'UserInfo',
          component: UserInfo
        }
      ]
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
