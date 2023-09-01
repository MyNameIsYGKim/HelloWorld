/**
 * 
 */
console.log("member.js");

document.addEventListener('DOMContentLoaded', function() {
	// member.json 데이터로 초기값 입력
	fetch('../AjaxMemberList.do')
		.then(result => (result.json)())
		.then(json => {
			console.log(json);
			for (let i = 0; i < json.length; i++) {
				document.getElementById('list').appendChild(makeTr(json[i]));
			}
		})
		.catch(err => console.log(err))

	//버튼 클릭 이벤트.
	document.getElementById('addBtn').addEventListener('click', addBtnFnc);
	document.getElementById('editBtn').addEventListener('click', editBtnFnc);

	function addBtnFnc() {
		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value;

		if (!no || !name || !phone || !age) {
			alert("값을 입력하세ㅛ");
			return;
		}

		const memb = { no, name, phone, age }
		// json -> obj : JSON.parse()
		// obj -> json : JSON.Stringify()
		fetch("../AjaxMemberAdd.do", {
			method: 'post',
			headers: {
				//'Content-type': 'application/x-www-form-urlencoded' },
				'Content-type': 'application/json'
			},
			body: //'id=' + no + '&name=' + name + '&phone=' + phone + '&age=' + age
				JSON.stringify(memb)
		})
			.then(resolve => resolve.json())
			.then(result => {
				console.log(result);
				if (result.retCode == 'Success') {
					document.getElementById('list').appendChild(makeTr(result.result));
				} else if (result.retCode == 'Fail') {
					alert(result.result);
				}
			})
			.catch(console.log);



		// initialize.
		const nodelist = document.querySelectorAll('table input');
		console.log(nodelist);

		nodelist.forEach(function(item, idx) {
			item.value = "";
		})
	}
	function editBtnFnc() {
		let no = document.querySelector('#no').value;
		let name = document.querySelector('#name').value;
		let phone = document.querySelector('#phone').value;
		let age = document.querySelector('#age').value;



		document.getElementById('mem' + no).children[1].innerText = name;
		document.getElementById('mem' + no).children[2].innerText = phone;
		document.getElementById('mem' + no).children[3].innerText = age;

	}
	function makeTr(member = {}) {
		let tr = document.createElement('tr');
		tr.setAttribute('id', 'mem' + member.mbrId);
		tr.setAttribute('data-no', + member.mbrId);
		tr.addEventListener(('click'), function() {
			document.getElementById('no').value = tr.children[0].innerHTML;
			document.getElementById('name').value = tr.children[1].innerHTML;
			document.getElementById('phone').value = tr.children[2].innerHTML;
			document.getElementById('age').value = tr.children[3].innerHTML;
		})
		for (let field in member) {
			let td = document.createElement('td');
			td.innerText = member[field];
			tr.appendChild(td);
		}
		// 삭제 버튼. td>button
		let btn = document.createElement('button');
		btn.addEventListener('click', deleteHandler);

		btn.innerText = '삭제';
		let td = document.createElement('td');
		td.appendChild(btn);
		tr.appendChild(td);
		return tr;
	}
	function deleteHandler(e) {
		e.stopPropagation(); // event 전파되는 것을 차단.
		console.log(this.parentElement.parentElement.dataset.no);
		let delNo = this.parentElement.parentElement.dataset.no;
		fetch("../AjaxMemberDel.do", {
			method: 'post',
			headers: {'Content-type': 'application/x-www-form-urlencoded'},
			body: 'delNo=' + delNo})
			.then(resolve => resolve.json())
			.then(json =>{
				if (result.retCode == 'Success') {
					document.getElementById('list').appendChild(makeTr(result.result));
				} else if (result.retCode == 'Fail') {
					alert(result.result);
				}
			})
			.catch(console.log);
			this.parentElement.parentElement.remove();
	}
})



