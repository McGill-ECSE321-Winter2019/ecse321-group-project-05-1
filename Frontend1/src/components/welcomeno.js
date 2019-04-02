
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function studentDto (student, email,id) {
  this.student = student
  this.email= email
  this.id= id
}
export default {
  name: 'welcomenoo',
  data () {
    return {
      students: [],
      newStudents: '',
    }
  },
//created: function(){
 // const p1=new studentDto('TUSHAR','tushar.agarwal@mail.mcgill.ca', '2234')
 // this.students=[p1]
//},
methods: {
  createstudents: function (Student, Email,Id) {
    this.$router.push({name:'addcoopnew'})
    AXIOS.post(`/students`+'?mcgillID=' + Id +'&name=' + Student + '&email=' + Email)
    .then(response => {
      console.log(response.data.name)
      // JSON responses are automatically parsed.
      this.students.push(response.data)})

    
  }
}
}