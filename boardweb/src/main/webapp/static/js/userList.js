/**
 *  userList.js
 */
console.log('userList.js');

let str = `[{"id":1,"first_name":"Kevan","last_name":"Iggalden","email":"kiggalden0@wikimedia.org","gender":"Male","salary":2544},
{"id":2,"first_name":"Harlene","last_name":"Etherson","email":"hetherson1@google.es","gender":"Female","salary":3997},
{"id":3,"first_name":"Ignacio","last_name":"Hadgkiss","email":"ihadgkiss2@wufoo.com","gender":"Male","salary":4520},
{"id":4,"first_name":"Dominica","last_name":"Seabrocke","email":"dseabrocke3@mit.edu","gender":"Female","salary":4486},
{"id":5,"first_name":"Denna","last_name":"Dudley","email":"ddudley4@slashdot.org","gender":"Female","salary":3066},
{"id":6,"first_name":"Fleming","last_name":"Matschek","email":"fmatschek5@sakura.ne.jp","gender":"Male","salary":3431},
{"id":7,"first_name":"Andy","last_name":"Carbin","email":"acarbin6@admin.ch","gender":"Male","salary":2826},
{"id":8,"first_name":"Asia","last_name":"Ugolini","email":"augolini7@ycombinator.com","gender":"Female","salary":3859},
{"id":9,"first_name":"Sela","last_name":"Iorizzo","email":"siorizzo8@yale.edu","gender":"Female","salary":2559},
{"id":10,"first_name":"Sharona","last_name":"Prettejohns","email":"sprettejohns9@uiuc.edu","gender":"Female","salary":2379},
{"id":11,"first_name":"Lenard","last_name":"Habgood","email":"lhabgooda@elegantthemes.com","gender":"Male","salary":3353},
{"id":12,"first_name":"Sabra","last_name":"Blaxill","email":"sblaxillb@abc.net.au","gender":"Female","salary":2753},
{"id":13,"first_name":"Averil","last_name":"Polino","email":"apolinoc@wsj.com","gender":"Female","salary":2505},
{"id":14,"first_name":"Lotty","last_name":"Brockelsby","email":"lbrockelsbyd@washingtonpost.com","gender":"Female","salary":4592},
{"id":15,"first_name":"Codie","last_name":"Ferie","email":"cferiee@vk.com","gender":"Female","salary":4340}]`;

let json = JSON.parse(str); //문자열 -> object로 변환.
console.log(json);

document.addEventListener('DOMContentLoaded', function(e) {
	document.querySelector('#name').value = '홍길동';
	//thead 생성.
	let title = json[0];
	let tr = document.createElement('tr');
	for (let prop in title) {
		let th = document.createElement('th');
		th.innerText = prop;
		tr.appendChild(th);
	}
	document.querySelector('#tableList thead').appendChild(tr);

	// tbody 영역.
	json.forEach(function(item, idx) {  //forEach 반복문에서만 쓸수 있는 반복문
		console.log(item, idx);  //item -> {}
		if (item.gender == 'Female') {
			let tr = document.createElement('tr')
			for (let prop in item) {
				let td = document.createElement('td');
				td.innerText = item[prop];
				tr.appendChild(td);
			}
		document.querySelector('#tableList tbody').appendChild(tr);
		}
	});
});


