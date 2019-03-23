<template>
<div id="welcomenoo">
<h2> 
Welcome to the cooperator!
</h2>
<table align=center>
<tr>
<td>Full Name</td>
<td>
<input type="text" v-model="newFirstname" placeholder="Full Name">
</td>
  <tr v-for="fullname in firstnames" >
      <td>{{ fullname.firstname }}</td>
  </tr>

<tr>
<td>Email ID</td>
<td>
<input type="text" placeholder="McGill Email">
</td>
</tr>
<tr>
<td>McGill ID</td>
<td>
<input type="number" placeholder="McGill ID Number">
</td>
</tr> 
<tr>
<td></td>
<td>
<button @click="createFirstname(newFirstname)"><router-link to="/addcoop">Add me!</router-link></button>
</td>
</tr>
</table>
</div>
</template>
<style>
button{color:black
}
</style>
<script src="./welcomeno.js">
</script>

