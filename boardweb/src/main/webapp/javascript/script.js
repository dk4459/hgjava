/*
* script.js
*/

console.log("script.js");
console.log(document);

//화면상의 객체를 선택하는 선택자 역할을 함
//button을 찾는데, class가 btn인 버튼. 을 찾아라.
document.querySelector('button.btn').addEventListener('click',clickFnc);
//함수 내용이 안 길면, 매개변수 선언하는 곳에서 정의할 수도 있다고 함.
//내용이 길어서(길어도 가능은 한데, 가독성 X), 아래에 따로 정의함.
function clickFnc(e){
	console.log(e);
	//태그(요소)만들기
	let liTag = document.createElement('li');
	let userValue = document.querySelector('input#name').value;
	liTag.innerText = userValue +' '; //<li>홍길동</li>
	let btn = document.createElement('button')
	btn.innerText = '삭제';
	//liTag.appendChild(btn);
	//let btn2 = document.createElement('button')
	//btn.innerText = '추가';
	liTag.appendChild(btn);
	// init
	document.querySelector('#list').append(liTag);
	document.querySelector('#name').value = '';
}

//str의 값을 활용하여 화면에 출력
function makeTr(){
	for (let student of str) {
	let tr = makeRow(student)
	//각 td에 str 배열 속의 오브젝트값들 집어넣기.
	//tr을 tbody.appendChild		
	document.querySelector('#studlist').append(tr);	
	}
}
makeTr();

document.querySelector('#addBtn').addEventListener('click', addRow)//콜백함수 addRow

function addRow() {
	let sno, sname, score;
	//let obj = {sno: sno, sname: sname, score: score}
	sno = document.querySelector('#sno').value;
	sname = document.querySelector('#sname').value;
	score = document.querySelector('#score').value;
	//let userValue = document.querySelector('input#addBtn').value;
	if (!sno|| !sname || !score) {
		alert('빈값을 채워주세요.');
		return; //함수종료.
	}
	let obj = {sno, sname, score}
	let tr = makeRow(obj);
	document.querySelector('#studlist').appendChild(tr);
	
	//document.querySelectorAll('#stdTable input')
	//		.forEach(function(item, idx, ))
	}

function makeRow(student={sno:1, sname:'test', score:90}) {
	let tr = document.createElement('tr');
	tr.addEventListener('click', displayRow, false);
	for (let prop in student){
		let td = document.createElement('td');
		td.innerText = student[prop];
		tr.appendChild(td);
	}
		//삭제버튼 추가
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.innerText = '삭제';
		//이벤트 연결
		btn.addEventListener('click', deleteRow, false); //deleteRow()로 바꾸면, 클릭시 실행되는 의도와 달리 여기서 그냥 실행되어버림.
		td.appendChild(btn);
		tr.appendChild(btn);
		return tr;
	}
	
function deleteRow(e){
	//하위에서 상위로 이벤트가 진행하는것을 막음
	e.stopPropagation();
	console.log(e.target);
	e.target.parentElement.remove();
}

function displayRow(e){
	document.querySelector('#sno').value = this.children[0].innerText;
	document.querySelector('#sname').value = this.children[1].innerText;
	document.querySelector('#score').value = this.children[2].innerText;
}

document.querySelector('#editBtn').addEventListener('click', editRow)//콜백함수 addRow

function editRow(e){
	let list = document.querySelectorAll('#studlist tr');
		for(let i = 0; i<list.length; i++) {
			if(list[i].children[0].innerText == document.querySelector('#sno').value) {
				list[i].children[1].innerText = document.querySelector('#sname').value;
				list[i].children[2].innerText = document.querySelector('#score').value;
		}	
	}
}