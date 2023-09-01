/**
 * scope.js
 * ES6 
 */

 let age = 10; // 전역변수.
 
 {
	 let age = 20;
	 console.log(age);
 }
 console.log(age);
 
 var age2 = 30;
 var localFnc = function() {
 //function localFnc(){
	 age2 = 33;
	 console.log(age2);
	 age2 = 40;
 }
 localFnc();
 console.log(age2);
 
 
 const obj = {
	 name: "Hong",
	 age: 20,
	 info: function() {
		 return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
	 }
 }
 console.log(obj.name);
 console.log(obj.info());
 
 class Person{
	 constructor(name, age) {
		 this.name = name;
		 this.age = age;
	 }
	 
	 showInfo(){
	 	return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
	 }
 }
 const p1 = new Person("Hong", 25);
 console.log(p1.showInfo());
 
 // 객체의 프로토타입을 정의.
 Person.prototype.showName = function(){
	 return this.name;
 }
 console.log(p1.showName());
 
 