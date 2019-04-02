<template>
   <body>
        <div v-if="dashboard">
          <table id="head" align="left" >
<tr>
<td>
<h1 align=left id=dashboard1>Welcome {{name}}</h1>
</td>
<td><h1 align=right id=dashboard2>Student ID: {{id}}</h1></td></tr>
</table>
<ul>
  <li ><h5><a class="active">Dashboard</a></h5></li>
  <li button @click="initialreportnew = !initialreportnew ,dashboard= !dashboard, showprogress=!showprogress"><h5><a> Initial Report</a></h5></li>
  <li button @click="technicalreport = !technicalreport, dashboard= !dashboard, showprogress=!showprogress"><h5><a>Technical Report</a></h5></li>
  <li button @click="evaluationreportnew= !evaluationreportnew, dashboard =!dashboard, showprogress=!showprogress"><h5><a>Evaluation From</a></h5></li>
  <li button @click="$router.push({path:'/'})"><h5><a> Main Screen</a></h5></li>
</ul>
<table id=body align=left>
<tr>
<button @click="showprogress =!showprogress, viewprogress(id) ">Show Progress</button>
<h3 v-if="showprogress" id="progress">
Your Co-op progress is {{progress}}%</h3>
<b-progress id="progress" v-if="showprogress" :value="progress" :max="max" show-progress animated></b-progress> 

<tr>
</tr>
</table>
        </div>
         <div v-if="initialreportnew">
        <table id="head" align="left" >
<tr>
<td>
<h1 align=left id=dashboard1>Welcome {{name}}</h1>
</td>
<td><h1 align=right id=dashboard2>Student ID: {{id}}</h1></td></tr>
</table>
<ul>
  <li button @click="dashboard =!dashboard, initialreportnew =!initialreportnew"><h5><a>Dashboard</a></h5></li>
  <li button @click="initialreportnew = !initialreportnew, initialreportnew = !initialreportnew"><h5><a class="active"> Initial Report</a></h5></li>
   <li button @click="technicalreport = !technicalreport, initialreportnew = !initialreportnew"><h5><a>Technical Report</a></h5></li>
  <li button @click="evaluationreportnew =!evaluationreportnew, initialreportnew =!initialreportnew "><h5><a>Evaluation From</a></h5></li>
   <li button @click="$router.push({path:'/'})"><h5><a> Main Screen</a></h5></li>
</ul>
<table id=body>
<tr>
<td align=center><h4 id="tasks">CoopID</h4><input type="number" placeholder="Coopid" v-model="coopid"></td>
</tr>
<tr >
<td align=center><h4 id="tasks">Initial Report</h4><input type="text" placeholder="Place Initial Report link" v-model="irlink"></td>
</tr>
<tr >
<td align=center><h4 id="tasks">WorkLoad</h4><input type="number" placeholder="Number of Hours" v-model="hours"></td>
</tr>
<tr >
<td align=center><button @click="createinitialreport(id,coopid,irlink,hours), dashboard =!dashboard, initialreportnew =!initialreportnew ">Submit</button></td>
</tr>
</table>
</div>
<div v-else-if="technicalreport">
<table id="head" align="left" >
<tr>
<td>
<h1 align=left id=dashboard1>Welcome {{name}} </h1>
</td>
<td><h1 align=right id=dashboard2> Student ID: {{id}}</h1></td></tr>
</table>
<ul>
  <li button @click="dashboard =!dashboard, technicalreport=!technicalreport"><h5><a>Dashboard</a></h5></li>
  <li button @click="initialreportnew = !initialreportnew ,technicalreport= !technicalreport"><h5><a>Initial Report</a></h5></li>
  <li button @click="technicalreport = !technicalreport ,technicalreport= !technicalreport"><h5><a class="active">Technical Report</a></h5></li>
  <li button @click="evaluationreportnew =!evaluationreportnew, technicalreport =!technicalreport"><h5><a>Evaluation From</a></h5></li>
   <li button @click="$router.push({path:'/'})"><h5><a> Main Screen</a></h5></li>
</ul>

<table id=body>
<tr>
<td align=center><h4 id="tasks">CoopID</h4><input type="url" size="50" placeholder="McGill ID " v-model="coopid"></td>
</tr>
<tr >
<td align=center><h4 id="tasks">Technical Report Link</h4><input type="url" v-model="technicalreportlink" size="50" placeholder="Paste Google Drive Link"></td>
</tr>
<tr >
<td align=center><button  @click=" createtechnicalreport(id,coopid,technicalreportlink, dashboard =!dashboard, technicalreport =!technicalreport)">Submit</button></td>
</tr>
</table>
</div>
<div v-else-if="evaluationreportnew">
    <table id="head" align="left" >
<tr>
<td>
<h1 align=left id=dashboard1>Welcome {{name}}</h1>
</td>
<td><h1 align=right id=dashboard2>Student ID: {{id}}</h1></td></tr>
</table>
<ul>
  <li button @click="dashboard =!dashboard, evaluationreportnew=!evaluationreportnew"><h5><a>Dashboard</a></h5></li>
  <li button @click="initialreportnew=!initialreportnew, evaluationreportnew=!evaluationreportnew"><h5><a>Initial Report</a></h5></li>
  <li button @click="technicalreport= !technicalreport, evaluationreportnew =!evaluationreportnew"><h5><a>Technical Report</a></h5></li>
  <li button @click="evaluationreportnew =!evaluationreportnew, evaluationreportnew= !evaluationreportnew"><h5><a class="active">Evaluation Form</a></h5></li>
   <li button @click="$router.push({path:'/'})"><h5><a> Main Screen</a></h5></li>
</ul>

<table id="body">
  
<tr >
<td align=center><h4 id="tasks">CoopID</h4><input type="text"  v-model="coopid" placeholder="Paste Evaluation Report Link" id=forms></td>
</tr>
  <tr >
<td align=center><h4 id="tasks">Evaluation Report</h4><input type="text"  v-model="evaluationreport" placeholder="Paste Evaluation Report Link" id=forms></td>
</tr>
<tr >
<td align=center><h4 id="tasks">Work Experience</h4><input type="text" size="25" id=forms  v-model="workexperience " placeholder="Experience of Internship"></td>
</tr>
<tr >
<td align=center><h4 id="tasks">Technologies</h4><input type="text" id=forms v-model="technologies" placeholder="Used Technologies"></td>
</tr>
<tr >
<td align=center><h4 id="tasks">Courses</h4><input type="text" id=forms  v-model="courses" placeholder="Course used"></td>
</tr>
<tr >
<td align=center><button  @click="createevaluationreport(id,coopid,evaluationreport,workexperience,technologies,courses), dashboard =!dashboard, evaluationreportnew =!evaluationreportnew">Submit</button></td>
</tr>
</table>
</div>
   </body>
</template>

<style>
bprogress{
  background-color: black
}
#prog1{
	margin-top:150px;
}
#head{background-color:black}
#head{width:100%}
#dashboard1{color:white}
#dashboard2{color:white}
h2{color:white}
h2{padding-right:20px}
#router{padding: 0px 16px}
#body{border-color: black}
#progress{ margin-top:20px;
margin-right:0%;

}


input[type=text], select {
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}


ul {
  list-style-type: none;
  padding: 0;
  width: 25%;
  background-color: black;
  position: absolute;
  height: 100%;
  overflow: auto;
  border-color: white;
  margin-top:58px;
  color: white;
}

li a {
  display: block;
  color: white;
  padding: 40px 16px;
  text-decoration: none;
 border-color: white;
  
}
li a.active {
  background-color: rgb(192, 3, 3);
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
border-color: white;
}
#box1{
  margin-top:200%;
  color:grey;
 border: black;
  }
#body{
  margin-top:30px;
   margin-left:50%;
}
 button {
  position: relative;
  width: 250px; height: 60px;
  background-color: rgb(141, 1, 1);
  color: white;
  margin:   0 auto;
  margin-top: 40px;

}

.button:after {
  position: absolute;
  top: 90%; left: 0;
  width: 100%; height: 100%;
  background: redder;
  content: "";
  z-index: -2;
  transition: transform .3s;
}
.button:hover::after {
  transform: translateY(-80%);
  transition: transform .3s;
}
</style>



<script>
import axios from 'axios'
import { callbackify } from 'util';
var config = require('../../config')
var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://' + config.dev.backendHost + ':' + config.dev.backendPort
var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})
function initialDto(idstudent, coopid, irlink, hours) {
  this.idstudent = idstudent
  this.coopid= coopid
  this.irlink= irlink
  this.hours= hours
}
export default{
   name: 'dashboard',
  data() {
     return {
   dashboard: true,
   initialreportnew: false,
   technicalreport: false,
   evaluationreportnew: false,
   showprogress: false,
   id: 0,
  name: '',
  progress:0,
  ireport: [],
  newIreport: '',
  treport: [],
      newTreport: '',
  ereport: [],
      newereport: '',
     }
  },
     created(){
    this.id= this.$route.params.id;
    this.name=this.$route.params.name;},
    methods: {
      viewprogress: async function (id) {
      const response = await fetch("https://cryptic-coast-32220.herokuapp.com/students/" + id)
      .then(response => response.json());
			const body = await response;
      this.progress = body;
		
			
		}
    ,
createinitialreport: function (idstudent,coopid,irlink,hours) {
    AXIOS.put(`/students1/`+ idstudent + '/' +coopid + '?initialReport=' + irlink + '&workLoad='+ hours)
    .then(response => {
        console.log(response.data)
      // JSON responses are automatically parsed.
      this.ireport.push(response.data)
    })
},
createtechnicalreport: function (idstudent,coopid,technicalreport) {
    AXIOS.put(`/students2/`+ idstudent + '/'+ coopid + "?technicalReport=" + technicalreport)
    .then(response => {
        console.log(response.data.technicalReport)
      // JSON responses are automatically parsed.
      this.treport.push(response.data)
    })
  },
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

</script>