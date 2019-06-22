
alert(sum(10,10));
var sum = function(num1,num2){
	return num1+num2;
}

function Person(){

}

Person.prototype.name="Nicholas";
Person.prototype.age=29;
Person.prototype.job="Software Engineer";
Person.prototype.sayName=function(){
	alert(this.name);
}

var person1 = new person
