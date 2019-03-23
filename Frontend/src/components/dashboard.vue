<template>

<div id="dashboard">
<table id="head" align="left" style="width: 100%">
<tr>
<td>
<h1 align=left id=dashboard1>Welcome Tushar</h1>
</td>
<td><h1 align=right id=dashboard1>Student ID: 260721680</h1></td></tr>
</table>
<ul>
  <li><h5><a class="active"><router-link to="/dashboard">Dashboard</router-link></a></h5></li>
  <li><h5><a><router-link to="/initialreport">Initial Report</router-link></a></h5></li>
  <li><h5><a><router-link to="/technicalreport">Technical Report</router-link></a></h5></li>
  <li><h5><a><router-link to="/evaluationreport">Evaluation From</router-link></a></h5></li>
</ul>
<table id=body align=left>
<tr>
<tr>
<H3 id="progress">
You're Co-op progress is 75%</h3>
<progress max="100" value="75"> </progress>
<tr>
</tr>
</table>
</div>
</template>

<style>

#head{background-color:#696969}
#dashboard1{color:white}
#dashborard{padding-left:20px}
h2{color:white}
h2{padding-right:20px}

#progress{
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
</script>
