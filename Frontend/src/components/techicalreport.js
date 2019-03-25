
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function initialDto(idstudent, coopid, technicalreport  ) {
  this.idstudent = idstudent
  this.coopid=coopid
  this.technicalreport= technicalreport
}
export default {
  name: 'technicalreport',
  data () {
    return {
      treport: [],
      newTreport: '',
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
  createtechnicalreport: function (idstudent,coopid,technicalreport) {
    AXIOS.put(`/students2/`+ idstudent + '/'+ coopid + "?technicalReport=" + technicalreport)
    .then(response => {
        console.log(response.data.technicalReport)
      // JSON responses are automatically parsed.
      this.treport.push(response.data)
    })

    
  }
}
 
}