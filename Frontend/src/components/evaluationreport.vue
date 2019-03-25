<template>

<div id="evaluationreport">
<table id="head" align="left" >
<tr>
<td>
<h1 align=left id=dashboard1>Welcome Tushar</h1>
</td>
<td><h1 align=right id=dashboard2>Student ID: 260721680</h1></td></tr>
</table>
<ul>
  <li><h5><a ><router-link to="/dashboard">Dashboard</router-link></a></h5></li>
  <li><h5><a><router-link to="/initialreportnew">Initial Report</router-link></a></h5></li>
  <li><h5><a><router-link to="/technicalreport">Technical Report</router-link></a></h5></li>
  <li><h5><a class="active"><router-link to="/evaluationreport" class="active">Evaluation Form</router-link></a></h5></li>
</ul>

<table id=body>
  <tr >
<tr >
<td align=center><h4 id="tasks">Name</h4><input type="text" v-model="name" placeholder="Name"></td>
</tr>
<tr>
<td align=center><h4 id="tasks">McGillID</h4><input type="text"  v-model="idstudent" placeholder="Paste Evaluation Report Link" id=forms></td>
</tr>
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
<td align=center><button  @click="$router.push({path:'/dashboard/'+idstudent+'/'+name}), createevaluationreport(idstudent,coopid,evaluationreport,workexperience,technologies,courses)">Submit</button></td>

</tr>
</table>
</div>
</template>

<style>
#tasks{
margin-top:30px;
}
#head{background-color:#696969}
#head{width:100%}
#dashboard1{color:white}
#dashboard2{color:white}
h2{color:white}
h2{padding-right:20px}


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

input[type=text], select {
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
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
button {
  position: relative;
  width: 250px; height: 60px;
  background: reddish;
  margin: 0 auto;
  margin-top: 40px;
  overflow: hidden;
  z-index: 1;
  cursor: pointer;
  transition: color .3s;
  /* Typo */
  line-height: 60px;
  text-align: center;
  color: black;
}

button:after {
  position: absolute;
  top: 90%; left: 0;
  width: 100%; height: 100%;
  background: redder;
  content: "";
  z-index: -2;
  transition: transform .3s;
}
button:hover::after {
  transform: translateY(-80%);
  transition: transform .3s;
}


</style>

<script src="./evaluationreport.js">
</script>
