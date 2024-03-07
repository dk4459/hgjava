/**
 *  20240307.js
 */

document.getElementById('keyword').addEventListener('change',function(e){
	let kw = this.value;
	console.log(kw);
	document.querySelectorAll('div#show span').forEach(word =>{
		if(word.innerText==kw){
		    console.log(word)
			word.remove()
		}
	})
	this.value='';
})

let timing =100;

const obj = {
	name:"Hong",
	age:20,
	showInfo:function(){
		return `${this.name},${this.age}`;
	},
	showAge(){
		return `${this.age}`;
	}
}
  obj.bloodType = 'O'; //객체 추가

//객체의 메소드 추가
  Number.prototype.format = function(){
	
  }

  Date.prototype.format  =  function(){
	let yyyy= this.getFullYear(); //2024
	let MM = this.getMonth() +1 ; //0이 1월이다
	let dd = this.getDate();
	
	let HH = this.getHours();
	let mm = this.getMinutes();
    let ss = this.getSeconds();
    
    MM=('0'+MM).slice(-2);
    dd=('0'+MM).slice(-2);
    HH=('0'+MM).slice(-2);
    mm=('0'+MM).slice(-2);
    ss=('0'+MM).slice(-2);
    
    return `${yyyy}-${MM}-${dd} ${HH}:${mm}:${ss}`;
}

let job = setInterval(function (){ //span갯수.
    let today = new Date();
    console.log(today.format());
	// 화면상의 span > 0개
	let clearCnt = 0;
	timing--;
	if(clearCnt == 0 && timing >= 0){
		alert('성공');
		document.querySelector('#keyword').setAttribute('disabled',true);
		clearInterval(job);
	}
	if(timing<0){
		alert('실패');
		document.querySelector('#keyword').setAttribute('disabled',true);
		clearInterval(job);
	}
},1000);