function firstnameDto (firstname) {
  this.firstname = firstname
}


export default {
  name: 'welcomenoo',
  data () {
    return {
      firstnames: [],
      newFirstname: '',
      errorFirstname: '',
      response: []
    }
  },

created: function(){
  const p1=new firstnameDto('TUSHAR')
  this.firstnames =[ p1 ]
},

methods: {
  createFirstname: function (firstName) {
    // Create a new person and add it to the list of people
    var p = new firstnameDto(firstName)
    this.firstnames.push(p)
    // Reset the name field for new people
    this.newFirstname = ''
  }
}
}