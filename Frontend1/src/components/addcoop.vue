<template>
<div id="newcoop">
<table align="center">
<tr>
<td>StudentID</td>
<td><input type="number" v-model="idstudent" placeholder="Name"></td>
</tr>
<tr>
<td>CoopID</td>
<td><input type="number" v-model="coopid" placeholder="ID number"></td>
</tr>
<tr>
<td>Location</td>
<td><input type="text" v-model="location" placeholder="Location of Coop"></td>
</tr> 
<tr>
<td>Start Date</td>
<td><input type="date" v-model="startdate" placeholder="01/01/2019"></td>
</tr>
<tr>
<td>End Date</td>
<td><input type="date" v-model="enddate" placeholder="01/05/2019"></td>
</tr>
<tr>
<td>Semester</td>
<td><input type="text" v-model="semester" placeholder="Fall/Summer/Winter "></td>
</tr>
<tr>
<td>Company Name</td>
<td><input type="text" v-model="companyname" placeholder="Company name"></td>
</tr>
<tr>
<td>Work Permit</td>
<td><input type="text" v-model="workpermit" placeholder="true OR false"></td>
</tr>
<tr>
<td>Employer Contract</td>
<td><input type="url" v-model="employercontract" placeholder="Paste Drive link"></td>
</tr>
<tr>
<td>Instructor ID</td>
<td><input type="number" v-model="instructorid" placeholder="ID number"></td>
</tr>
<tr>
<td>Foreign Key McGill</td>
<td><input type="number" v-model="fkstudentmcgillid" placeholder="Foreign key"></td>
</tr>
<tr>
<td><button @click="createcoop(coopid, location, startdate, enddate, semester, companyname, workpermit, employercontract, instructorid, fkstudentmcgillid)"><router-link to="dashboard">Add Coop</router-link></button></td>
</tr>
</table>
</div>
</template>
<style>
div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 2px;
}
input[type=text], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=url], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;}
input[type=number], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;}
input[type=date], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
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
  color:black;
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

<script>
</script>

