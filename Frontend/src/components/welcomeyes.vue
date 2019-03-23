<template>
<div id="welcomeyes">
<h2>Student ID?</h2>
<table align="center">
<tr>
<td>
<input type= "number" v-model="studentid"   placeholder="Student ID">
<button><router-link to="/dashboard">Go to my Dashboard</router-link></button>
</td>
</tr>
</table>
</div>
</template>
<style>
#welcomeyes {
font-family: 'Avenir', Helvetica, Arial, sans-serif;
  color: #2c3e50;
}
input[type=number], select {
  
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;}
</style>
</script>
