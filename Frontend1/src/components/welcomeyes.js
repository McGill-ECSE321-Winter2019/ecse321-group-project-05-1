
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
      idstudent: [],
      name: '',
    }
  },
  created:  async function(idstudent){
      const response = await fetch("https://cryptic-coast-32220.herokuapp.com/studentsAll/"+idstudent)
      .then(response => response.json());
         const body = await response.name;
          this.name = body;
          name = this.name;
          console.log(this.name)
      
//},

   // var progress=this.progress

}
}

