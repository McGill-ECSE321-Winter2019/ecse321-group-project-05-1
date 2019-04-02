
import axios from 'axios'
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

function coopDto (coopid, location, startdate, enddate, semester, companyname, workpermit, employercontract, instructorid, fkstudentmcgillid) {
  this.coopid=coopid
  this.location=location
  this.startdate=startdate
  this.enddate=enddate
  this.semester=semester
  this.companyname=companyname
  this.workpermit=workpermit
  this.employercontract=employercontract
  this.instructorid=instructorid
  this.fkstudentmcgillid=fkstudentmcgillid
}
export default {
  name: 'addcoop',  
  data () {
    return {
      coop: [],
      newCoop: '',
      name: '',
    }
  },
//created: function(){
 // const p1=new studentDto('TUSHAR','tushar.agarwal@mail.mcgill.ca', '2234')
 // this.students=[p1]
//},
methods: {
  createcoop: async function (coopid, location, startdate, enddate, semester, companyname, workpermit, employercontract, instructorid, fkstudentmcgillid) {
      const response = await fetch("https://cryptic-coast-32220.herokuapp.com/studentsAll/"+fkstudentmcgillid)
      .then(response => response.json());
         const body = await response.name;
          this.name = body;
          console.log(this.name)
    //   var progress=this.progress
    //  const response = await fetch("https://cryptic-coast-32220.herokuapp.com/coops/"+'?coopID=' + coopid +'&location=' + location + '&startDate=' + startdate + '&endDate=' + enddate+ '&semester=' + semester+ '&companyName=' + companyname+ '&workPermit=' + workpermit+ '&employerContract=' + employercontract + '&instructorID=' + instructorid + '&fkStudentMcgillID=' + fkstudentmcgillid)
    const response1 = await fetch(
      "https://cryptic-coast-32220.herokuapp.com/coops/"+'?coopID=' + coopid +'&location=' + location + '&startDate=' + startdate + '&endDate=' + enddate+ '&semester=' + semester+ '&companyName=' + companyname+ '&workPermit=' + workpermit+ '&employerContract=' + employercontract + '&instructorID=' + instructorid + '&fkStudentMcgillID=' + fkstudentmcgillid,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        }
      }
    );
    const data = await response1.json();
    console.log(data);  
    this.$router.push({path:'/dashboard/'+fkstudentmcgillid+'/'+ this.name})
}
}
}