import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Welcome from '@/components/Welcome'
import welcomenoo from '@/components/welcomenoo'
import dashboard from '@/components/dashboard'
import technicalreport from '@/components/technicalreport'
import evaluationreportnew from '@/components/evaluationreportnew'
import addcoopnew from '@/components/addcoopnew'
import initialreportnew from '@/components/initialreportnew'
import returningstudent from '@/components/returningstudent'
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
     path: '/dashboard/:id/:name',
     name: 'dashboard',
     component: dashboard
},
{   path: '/dashboard',
    name:'/dashboard',
    component: dashboard
},
{
    path: '/initialreportnew',
    name: 'initialreportnew',
    component: initialreportnew
  },
  {
    path: '/technicalreport',
    name: 'technicalreport',
    component: technicalreport
  },
  {
    path: '/evaluationreport',
    name: 'evaluationreportnew',
    component: evaluationreportnew
  }
  ]
})

