<template>
<div id="welcomenoo">
<h2 id="some"> 
Welcome to the cooperator!
</h2>
<table align=center>
<tr>
<td>Full Name</td>
<td>
<input type="text" v-model="student" placeholder="Full Name">
</td>
<tr>
<td>Email ID</td>
<td>
<input type="text"  v-model="email" placeholder="McGill Email">
</td>
</tr>
<tr>
<td>McGill ID</td>
<td>
<input type="number" v-model="id" placeholder="McGill ID Number">
</td>
</tr> 
<tr>
<td></td>
<td>
<button @click="createstudents(student, email,id)">Add me!</button>
</td>
</tr>
</table>
</div>
</template>
<style>
button{color:white
}
#some{
 color:black
}
</style>
<script src="./welcomeno.js">
</script>

