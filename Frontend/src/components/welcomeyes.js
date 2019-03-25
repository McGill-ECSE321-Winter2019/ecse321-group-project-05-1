
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function returningDto (idstudent) {
  this.idstudent= idstudent
}
export default {
  name: 'welcomeyes',
  data () {
    return {
      id: [],
     // progress: [],
     // newStudents: '',
    }
  },
//created: function(){
 // const p1=new studentDto('TUSHAR','tushar.agarwal@mail.mcgill.ca', '2234')
 // this.students=[p1]
//},
methods: {
  returningid: function (id) {
    AXIOS.get(`/students/`+ id )
    .then(data => {
    
        this.progress.push(data)
    })

   // var progress=this.progress

}
}
}
