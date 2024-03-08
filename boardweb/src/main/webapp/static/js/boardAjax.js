/**
 *  boardAjax.js
 */
const service ={ //객체만들기
	// 댓글목록(5개씩 보여주는)
	replyList(param={bno: 1,page:1},successCall,errorCall){   //함수형식으로 파라메타 넘기기 
 	$.ajax({
		 url:'replyList.do',
		 method: 'get',
		 data: param,
		 dataType:'json'
	 })
 	.done(successCall)
 	.fail(errorCall)	
	},
	//총페이지 갯수 만들기
	pageList(bno =1,successCall, errorCall){
		$.ajax({
		 url:'getTotal.do?bno='+ bno,
		 method: 'get',
		 dataType:'json'
	 })
 	  .done(successCall)
 	  .fail(errorCall)
	},
	//삭제함수
    removeReply(rno=1,successCall, errorCall){
		$.ajax({
			url: 'removeReply.do',
			method:'post',
			data:{rno},
			dataType :'json'
		})
		.done(successCall)
		.fail(errorCall)
	},
	addReply(param={bno,reply,replyer},successCall,errorCall){
		$.ajax({
			url:'addReply.do',
			method:'post',
			data:param,
			dataType:'json'
		})
		.done(successCall)
		.fail(errorCall)
	}
}
function test(){
	
}
export default service;
