import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Welcome from '@/components/Welcome'
import dashboard from '@/components/dashboard'
import addcoopnew from '@/components/addcoopnew'
import returningstudent from '@/components/returningstudent'
import welcomeyes from '@/components/welcomeyes'
import welcomenoo from '@/components/welcomenoo'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome
    },
{
      path: '/returningstudent',
      name: 'returningstudent',
      component: returningstudent
    },
{
     path: '/welcomenoo',
    name: 'welcomenoo',
   component: welcomenoo
  },
{
     path: '/addcoopnew',
     name: 'addcoopnew',
     component: addcoopnew
},
{
     path: '/dashboard/:id/:name/',
     name: 'dashboard',
     component: dashboard
},
{   path: '/dashboard',
    name:'/dashboard',
    component: dashboard
},
{
   path: '/welcomeyes',
   name: 'welcomeyes',
   component: welcomeyes
 }
  ]
})

