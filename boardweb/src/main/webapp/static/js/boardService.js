/**
 *  boardService.js
 */
//.pagination>a click이벤트
let page= 1;
function pagingFunc(){
  document.querySelectorAll('.pagination>a')// NodeList
        .forEach(item =>{
			item.addEventListener('click', function (e){
			 e.preventDefault(); //a href링크의 기능을 차단.
			 //page = item.innerText; //page로 사용
			 page= parseInt(item.dataset.page);
			 replyList(page);	//링크를 클릭할때마다 목록을 새롭게 그리고
			 pageList();   //페이지목록을 새롭게 그리고
			})
		});
}

//등록이벤트.
document.querySelector('.addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e){
   let reply = 	document.querySelector('input[name="reply"]').value; //name 값이 2개이면 첫번째거를 들고옴
   const addHtp = new XMLHttpRequest();
   addHtp.open('post','addReply.do');
   addHtp.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
   addHtp.send('bno='+bno+'&reply='+reply+'&replyer='+replyer);
   addHtp.onload = function(e){
	   let result = JSON.parse(addHtp.responseText);
	   if(result.retCode == 'Ok'){
		   alert('정상적으로 등록 되었습니다.');
		   document.querySelector('.reply ul').appendChild(makeRow2(result.retVal));//AddReplyControl클래스에서 retVal을 갖고와서 조회한다.
	       document.querySelector('#reply').value= '';
		   replyList(page);	//링크를 클릭할때마다 목록을 새롭게 그리고
		   pageList();   //페이지목록을 새롭게 그리고
	   }else if(result.recode =='NG'){
		   alert('처리중에러');
	   }
   }
   console.log(bno,reply,replyer) //board.jsp안에 값이 있다
}

// 댓글 목록.
function makeRow(obj ={}){
	let fields = ['replyNo','reply','replyer'];        //반복문을 쓰기위해 배열을 만든다.
	let liTag = document.createElement('li');
	liTag.setAttribute('data-rno', obj.replyNo);  //하나의 값을 불러오는 작업
	fields.forEach(prop =>{
		let span = document.createElement('span');
		span.innerText = obj[prop];
		if(prop == 'reply'){
			span.className ='col-sm-6';  //classname=setattribute와 같은 속성
		}else{
			span.className= 'col-sm-2';
		}
		liTag.appendChild(span);
	});
	//삭제버튼
	let span = document.createElement('span');
		span.className= 'col-sm-2';
	let btn = document.createElement('button');
	btn.addEventListener('click',deleteRow);
	btn.innerText='삭제';
	span.appendChild(btn);
	liTag.appendChild(span);
	return liTag;
}
function makeRow2(obj={}){
	let clon = document.querySelector('.content>ul>li:nth-of-type(1)')
	           .cloneNode(true); //하위의 값들을 다가져오는데 default는 false이며 true로 전환해줘야 사용가능하다.
	 clon.setAttribute('data-rno',obj.replyNo);
	 console.log(clon);
	 clon.querySelector('span:nth-of-type(1)').innerText = obj.replyNo;
	 clon.querySelector('span:nth-of-type(2)').innerText = obj.reply;
	 clon.querySelector('span:nth-of-type(3)').innerText = obj.replyer;
	 let btn = document.createElement('button');
	  btn.addEventListener('click',deleteRow);
	  btn.innerText='삭제';
	  clon.querySelector('span:nth-of-type(4)').innerText='';
	  clon.querySelector('span:nth-of-type(4)').appendChild(btn);
	  return clon;
}
// 한건 삭제함수
function deleteRow(e) {
    let rno = this.parentElement.parentElement.dataset.rno; //한건 조회값 가져오기
    let li = this.parentElement.parentElement;
    const delHtp = new XMLHttpRequest(); // 삭제 요청 시 해당 댓글의 번호를 전송
    delHtp.open('post','removeReply.do');
    delHtp.setRequestHeader('Content-Type','application/x-www-form-urlencoded'); //post방식일때 이런식으로 타입을 맞춰야한다.
    delHtp.send('rno='+rno);   //파라메타값 전달하기 RemoveReplyControl클래스에 가보면 rno로 파라메타값을 설정해놓았기때문에 그 변수 이름을 일치시켜야한다.
    delHtp.onload = function(e){
		console.log(delHtp)
		const result = JSON.parse(delHtp.responseText);
		if(result.retCode =='OK'){
			alert(result.retMsg);
			li.remove();   //함수를 설정하면 this의 값이 delHtp의 this로 넘어가 밖으로 따로 변수를 지정해 사용하였다.
		                   //그러고 싶지 않으면 화살표 함수를 이용하면 this의값이 이벤트의 값으로 넘어가 사용이 가능하다
		   replyList(page);	//링크를 클릭할때마다 목록을 새롭게 그리고
		   pageList();   //페이지목록을 새롭게 그리고                
		}else{             
			alert(result.retMsg);
		}
	}
}

// 목록함수.
function replyList(rpage = 1){
	const xhtp = new XMLHttpRequest();
	xhtp.open('get','replyList.do?bno='+ bno + '&page=' + rpage);
	xhtp.send();
	xhtp.onload = function(e){
		console.log(xhtp.responseText); //처리된 결과값을 담아오는 것이 responseText이다
		const data= JSON.parse(xhtp.responseText); //받아온것을 제이슨 형식으로 변경
	    //기존목록 삭제
	    document.querySelectorAll('li[data-rno]')
	    .forEach(item => item.remove());
	    //목록,
	    data.forEach(item => {
			document.querySelector('.reply ul').appendChild(makeRow2(item));
		})
	}
}
replyList();

//페이지 목록.
function pageList(){
  const plistHtp = new XMLHttpRequest();
  plistHtp.open('get','getTotal.do?bno='+bno);
  plistHtp.send();
  plistHtp.onload=function(e){
	  //기존페이지 삭제.
	  document.querySelector('div.pagination').innerHTML='';
	 //페이지 목록 만들기
	 let result = JSON.parse(plistHtp.responseText);
	 let totalCnt = result.totalCount;
	 let startPage,endPage; //1~5, 6~10
	 let next,prev;
	 let realEnd = Math.ceil(totalCnt/5);
	 endPage = Math.ceil(page/5)*5; 
     startPage = endPage -4;
     endPage = endPage >realEnd ? realEnd : endPage;
     next = endPage < realEnd ? true : false;
     prev = startPage > 1;
     if(prev){
		 let aTag = document.createElement('a');
		 //aTag.innerText = startPage -1;
		 aTag.innerHTML ='&laquo;'//<<
		 aTag.setAttribute('data-page',startPage-1);
		 console.log(aTag);
		 aTag.href='#';
		 document.querySelector('div.pagination').appendChild(aTag);
	 }
     
     for(let p= startPage; p<= endPage; p++){
		 let aTag = document.createElement('a');
		 aTag.innerText = p;
		 aTag.href='#';
		 aTag.setAttribute('data-page',p);
		 if(p== page){
			 aTag.className='active';
		 }
		 document.querySelector('div.pagination').appendChild(aTag);
	 }
	 if(next){
		 let aTag = document.createElement('a');
		 //aTag.innerText = endPage + 1;
		 aTag.innerHTML ='&raquo;'//>>
         aTag.setAttribute('data-page',endPage+1);
		 aTag.href='#';
		 document.querySelector('div.pagination').appendChild(aTag);
		 
		/* aTag.addEventListener('click', function (e) {
             e.preventDefault();
             page = endPage + 1; // 다음 페이지로 이동
             replyList(page); // 링크를 클릭할 때마다 목록을 새롭게 그리고
             pageList(); // 페이지 목록을 새롭게 그리고
         });*/
	 }
	 pagingFunc();//새로 생성된 a에 이벤트 등록.
  }	
}
replyList();
pageList();