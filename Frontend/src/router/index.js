import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Welcome from '@/components/Welcome'
import welcomeyes from '@/components/welcomeyes'
import welcomenoo from '@/components/welcomenoo'
import addcoop from '@/components/addcoop'
import dashboard from '@/components/dashboard'
import initialreport from '@/components/initialreport'
import technicalreport from '@/components/technicalreport'
import evaluationreport from '@/components/evaluationreport'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
{
      path: '/welcome',
      name: 'Welcome',
      component: Welcome
    },
{
      path: '/welcomeyes',
      name: 'welcomeyes',
      component: welcomeyes
    },
{
     path: '/welcomenoo',
    name: 'welcomenoo',
   component: welcomenoo
  },
{
     path: '/addcoop',
     name: 'addcoop',
     component: addcoop
},
{
     path: '/dashboard',
     name: 'dashboard',
     component: dashboard
},
{
    path: '/initialreport',
    name: 'initialreport',
    component: initialreport
  },
  {
    path: '/technicalreport',
    name: 'technicalreport',
    component: technicalreport
  },
  {
    path: '/evaluationreport',
    name: 'evaluationreport',
    component: evaluationreport
  }
  ]
})

