
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function initialDto(idstudent, coopid, irlink, hours, ) {
  this.idstudent = idstudent
  this.coopid= coopid
  this.irlink= irlink
  this.hours= hours
}
export default {
  name: 'initialreportnew',
  data () {
    return {
      ireport: [],
      newIreport: '',
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
  createinitialreport: function (idstudent,coopid,irlink,hours) {
    AXIOS.put(`/students1/`+ idstudent + '/' +coopid + '?initialReport=' + irlink + '&workLoad='+ hours)
    .then(response => {
        console.log(response.data.initialReport)
      // JSON responses are automatically parsed.
      this.ireport.push(response.data)
    })

    
  }
}
 
}