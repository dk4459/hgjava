/**
 * 
 */
function filterList(gender ='Male'){
	document.querySelector('tbody').innerHTML=''
	
	 json//
	 .filter(function(item){
		return item.gender == gender || gender == 'All';
	})//
	.forEach(function(item){
     document.querySelector('tbody').appendChild(makeRow(item)) 		
	})
}
function reduceList(gender='Female'){
	let tbody = document.querySelector('tbody');
	tbody.innerHTML='';
	
	json.reduce((acc,item) => {
		if (item.gender == gender){
			makeTr(item);
		    acc.appendChild(makeRow(item));
		}
		return acc;
	}, tbody);
}
document.addEventListener('DOMContentLoaded', function(e) {
	console.clear();
	console.log('userService.js')
	//forEach()-> 반환값은 없음.
	let fAry =json.filter(function(item, idx, ary) { //제이슨이 갖고 있는 필터
		return item.salary >3000; //salalry가 3000넘는사람만 반환한다.
	}); // filter() => 새로운 배열 생성. A -> B
	
	// map() A-> A'
	let mAry = fAry.map(item => {   //매개값이 하나면 괄호도 없앨수 있다.
		// item {id,firstName, lastName, email, salalry}
		// item {id, name, salary}
		    return {id: item.id,
		           name: item.first_name + '-' + item.last_name,
		            salary: item.salary}
		            });
	console.log(mAry);
	
	//reduce() => 새로운 값을 생성.
	//json.reduce();
	
	//reduce는 acc라는 매개값이 더있다.
	let result = [1,3,2,4,5].reduce((acc,item,idxs) => { 
		console.log(acc,item, idx); //acc값은 전의 아이템값을 표현한다.
		acc.push(item*2);
		return acc;   //첫번째 acc의값으로 return된다.
	}, []); //0을 초기값 설정  []을 초기값설정
	
	result = json.reduce((acc,item,idx) => {
		if(item.gender == 'Male'){
			acc.push(item);
		}
		return acc;
	},[]);
	
	console.log(result);
});//end of DOMContentLoaded