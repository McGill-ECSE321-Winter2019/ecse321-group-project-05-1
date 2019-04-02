<template>
<div id= "Welcome">
<h1>Welcome to the Cooperator</h1>
<h3>Are you a new student?</h3>
<button @click="$router.push({path:'/welcomenoo/'})" >Yes I am!</button>
<button @click="$router.push({path:'/returningstudent/'})"> No not really!</button>
</div>
</template>
<style>

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 2px;
  arddish : #E74C3C;
redder : #C0392B;
cloud : #ECF0F1;
}
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type=url], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;}
input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;}
input[type=date], select {
  width: 100%;
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
  background-color: rgb(141, 1, 1);
  color: white;
  margin:   0 auto;
  margin-top: 40px;
 font-family:sans-serif;

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
