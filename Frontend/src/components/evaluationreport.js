
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function initialDto(idstudent, coopid, evaluationreport, workexperience, technologies, courses ) {
  this.idstudent = idstudent
  this.coopid=coopid
  this.evaluationreport= evaluationreport
  this.workexperience= workexperience
  this.technologies= technologies
  this.courses=courses
}
export default {
  name: 'evaluationreport',
  data () {
    return {
      ereport: [],
      newereport: '',
      id: 0,
    }
  },
  created(){
    this.id= this.$route.params.id;
  },
//created: function(){
 // const p1=new studentDto('TUSHAR','tushar.agarwal@mail.mcgill.ca', '2234')
 // this.students=[p1]
//},
methods: {
  createevaluationreport: function (idstudent, coopid, evaluationreport, workexperience, technologies, courses) {
    AXIOS.put(`/students3/`+ idstudent + '/'+ coopid + "?evaluationReport=" + evaluationreport + "&workExperience=" + workexperience+ "&technologies=" + technologies + "&courses=" + courses)
    .then(response => {
        console.log(response.data.evaluationReport)
      // JSON responses are automatically parsed.
      this.treport.push(response.data)
    })

    
  }
}
 
}