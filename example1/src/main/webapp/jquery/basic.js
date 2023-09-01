/**
 * basic.js
 */

//document.addEventListener("DOMContentLoaded", loadFunc); // 페이지 로딩 후 실행시켜라.

// $(document).ready(loadFunc); // 페이지 로딩 후 실행시켜라.

// window.onload = function() {
//	자바스크립트 코드;
//	};

$(loadFunc);

function loadFunc(){
	console.log('test');
	
	var p = document.createElement('p'); // dom 객체.
	var txt = document.createTextNode("Sample"); // text node.
	p.appendChild(txt);
	document.querySelector('body').appendChild(p);
	
	var pTag = $('<p />'); // jquary 객체
	pTag.text("jquery sample");
	$('.bdy').append(pTag); // $() 선택자
	
	console.log(p);
	console.log(pTag);
	//
	var li = document.createElement('li');
	li.innerText = 'Apple';
	document.querySelector('body ul#list1').append(li);
	
	$('body ul#list2').append($('<li />').text('Banana'));

}
