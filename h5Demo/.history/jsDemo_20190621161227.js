function Person(){
 var name = "Nicholas";
 var age= 29;
 var sayName = function(){
	alert(this.name);
 }
}

// Person.prototype.name="Nicholas";
// Person.prototype.age=29;
// Person.prototype.job="Software Engineer";
// Person.prototype.sayName=function(){
// 	alert(this.name);
// }

var person1 = new Person();
person1.sayName();
var person2 = new Person();
person2.sayName();
alert(person1.sayName == person2.sayName);
