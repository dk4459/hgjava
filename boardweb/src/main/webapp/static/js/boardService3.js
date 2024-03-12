/**
 *  boardSevice3.js 
 */
import service from './boardAjax.js'
let page = 1;
//댓글목록 5건 출력
service.replyList({ bno: bno, page: page },// 파라메타값1 bno는 board.jsp에 가져온 변수 page는 위에 전역변수로 가져온값
	replyListCall,
	function(err) {
		console.log('err==>' + err);             // 파라메타값3
	}
);
function replyListCall(result) {
	let ul = $('.content>ul');
	//기존목록 삭제
	$('.content>ul>li:gt(1)').remove();
	console.log(result);           // 파라메타값2
	$(result).each(function(idx, item) {
		let clon = $('.content>ul>li:eq(0)').clone();   //하나를 복사
		let delBtn = $('<button>삭제</button>');
		delBtn.click(function(e) {
			service.removeReply(item.replyNo,//
				function(result) {
					if (result.retCode = 'OK') {
						alert(result.retMsg);
						service.replyList({ bno: bno, page: page },
							replyListCall,
							function(err) {
								console.log('err==>' + err);
							}
						);
					} else {
						alert(result.retMsg);
					}
				}),
				err => console.log('err==>' + err)

		})
		clon.find('span:eq(0)').text(item.replyNo);
		clon.find('span:eq(1)').text(item.reply);
		clon.find('span:eq(2)').text(item.replyer);
		clon.find('span:eq(3)').html(delBtn);
		ul.append(clon);
	});
	//페이지 아이콘 새로 생성
	service.pageList(bno,
		createPageElement,
		err => console.log('err==>' + err)       //화살표 함수로 변경
	)
}

function createPageElement(result) {
	document.querySelector('div.pagination').innerHTML = '';
	//페이지 목록 만들기
	let pagination = $('div.pagination')
	pagination.html('');

	let totalCnt = result.totalCount;
	let startPage, endPage; //1~5, 6~10
	let next, prev;
	let realEnd = Math.ceil(totalCnt / 5);
	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;
	next = endPage < realEnd ? true : false;
	prev = startPage > 1;

	if (prev) {
		$('<a/>').attr('href', '#').attr('data-page', startPage - 1).
			html('&laquo;').appendTo(pagination)
	}

	for (let p = startPage; p <= endPage; p++) {
		let aTag = $('<a/>').attr('href', '#').attr('data-page', p).
			html(p).appendTo(pagination)
		if (p == page) {
			aTag.addClass('active');
		}
	}
	if (next) {
		$('<a/>').attr('href', '#').attr('data-page', endPage + 1).
			html('&raquo;').appendTo(pagination)

	}
}

//링크 페이지 이동
$('.pagination').on('click', 'a', function(e) {
	page = $(this).data('page');
	service.replyList({ bno: bno, page: page },// 파라메타값1 bno는 board.jsp에 가져온 변수 page는 위에 전역변수로 가져온값
		replyListCall,
		err => console.log('err==>' + err)            // 파라메타값3
	)
})
//등록이벤트
$('.addReply').on('click', function(e) {
	let reply = $('input[name="reply"]').val();
	console.log(reply, replyer, bno);
	service.addReply({ bno: bno, reply: reply, replyer: replyer },
		function(result) {
			if (result.retCode = 'OK') {
				alert('등록성공')
				page =Math.ceil(result.totalCount/5.0);
				service.replyList({ bno: bno, page: page },// 파라메타값1 bno는 board.jsp에 가져온 변수 page는 위에 전역변수로 가져온값
				replyListCall,
				err=>console.log('err==>' + err)           // 파라메타값3
				
				);
			}else{
				alert('등록실패')
			}
		},
		err => console.log('err==>' + err)
	);
})

