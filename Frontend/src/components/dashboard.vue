
<template>
<div id="dashboard">
<table id="head" align="left" style="width: 100%">
<tr>
<td><h1 id=dashboard1>Welcome {{name}}</h1></td>
<h1 align=left class="dashboard1"></h1>
<td><h1 align=right id=dashboard2>Student ID is {{id}}</h1></td></tr>
</table>
<ul>
  <li><h5><a class="active"><router-link to="/dashboard">Dashboard</router-link></a></h5></li>
  <li><h5><a><router-link to="/initialreportnew">Initial Report</router-link></a></h5></li>
  <li><h5><a><router-link to="/technicalreport">Technical Report</router-link></a></h5></li>
  <li><h5><a><router-link to="/evaluationreport">Evaluation From</router-link></a></h5></li>
</ul>
<table id=body align=left>
<tr>
<tr>
<h3 id="prog1">
Your Co-op progress is 25%!</h3>
<progress max="100" value="25"> </progress>
<tr>
</tr>
</table>
</div>
</template>

<style>
#dashboard3{color:white}
#head{background-color:#696969}
#dashboard1{color:white}
#dashboard1{padding-right:40%}
#dashborard{padding-left:20px}
#dashboard2{color:white}
#dashboard2{padding-left:10%}
h2{color:white}
h2{padding-right:20px}

#prog1{
	margin-top:150px;
}

ul {
  list-style-type: none;
  padding: 0;
  width: 25%;
  background-color: grey;
  position: absolute;
  height: 100%;
  overflow: auto;
  border-color: white;
  margin-top:58px;
}

li a {
  display: block;
  color: white;
  padding: 20px 16px;
  text-decoration: none;
 border-color: white;
  
}
li a.active {
  background-color: #4CAF50;
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
</style>
<script>
import router from '../router'
export default {
  name: 'dashboard',
  date(){
    return{
      id: 0,
      name: '',
      progress:0,
    }
  },
  created(){
    this.id= this.$route.params.id;
    this.name=this.$route.params.name;
    //this will load the name into the ID 
    console.log(id)
AXIOS.get(`/students/`+ id)
    .then(response => {
      //var prog = response.data
return responde.data
      // JSON responses are automatically parsed.
      //console.log(prog)
    })
      this.progress = prog;
  },

}
</script>

