/**
 * center.js
 */

console.log('center.js');

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=lEasnKvE0jY2SKjD7fjEBTFtsOZB03oeKA4Bv0hilh9Du6qEb0pBnhFxE5FrphuZibMW4ukw8VnyHUNd9M3ACQ%3D%3D';

let showFields = ['id', 'centerName', 'phoneNumber', 'sido'];
let tbody = document.querySelector('#list');
let searchValue = document.querySelector('#keyword').value;
let searchSido = document.querySelector('#searchSido');
let centerList = [];
function list() {
	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			result.data.forEach(center =>{
				tbody.append(makeRow(center));
				
			})	
			
		})
		.catch(err => console.log(err));
}
// 조회 이벤트 처리
function search() {
	let btn = document.querySelector('#searchBtn');
	btn.addEventListener('click', searchList);
}

function searchList() {
	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			searchValue = document.querySelector('#keyword').value;
			console.log(searchValue);

			// 기존 데이터 삭제
			tbody.innerHTML = '';

			if (searchValue === '') {
				alert('값을 입력해주세요.');
				list();
				return;
			}
			let check = false
			result.data.forEach(center => {
				if (center['sido'].indexOf(searchValue)>-1) {
					check = true;
					let tr = document.createElement('tr');
					showFields.forEach(field => {
						let td = document.createElement('td');
						if (field == 'centerName') {
							td.innerText = center[field].substring('코로나19'.length);

						} else {
							td.innerText = center[field];
						}
						tr.append(td);
					});
					tbody.append(tr);
				}
			});
			if (!check) {
				alert('조회된 값이 없습니다.');
				list();
			}
		})
		.catch(err => console.log(err));
}
function optionList(){
	let filterAry = [];
	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			centerList=result.data
			console.log(centerList);
			result.data.forEach(center => {
				tbody.append(makeRow(center))
				//화면 전체 데이터 출력.
				//시도정보만 담고 있는 배열을 활용해서 option생성하기
				if (filterAry.indexOf(center.sido) == -1) {
					filterAry.push(center.sido); //동일한 값이 없으면 추가하기
				}
			})//화면에 전체데이터 출력
			    console.log(filterAry);
			    filterAry.forEach(sido => {
				let opt = document.createElement('option');
				opt.innerText = sido;
				searchSido.append(opt);
			})
		})
		.catch(err => console.log(err));
	      
	      searchSido.addEventListener('change', function(e) {
			tbody.innerHTML = '';
		    fetch(url)
			.then(resolve => resolve.json())
			.then(result => {
				result.data.forEach(center => {
					if (searchSido.value == center['sido']) {
						let tr = document.createElement('tr');
						showFields.forEach(field => {
							let td = document.createElement('td');
							if (field == 'centerName') {
								td.innerText = center[field].substring('코로나19'.length);

							} else {
								td.innerText = center[field];
							}
							tr.append(td);
						});
						tbody.append(tr);
					}
				})
			})
	})
}
function makeRow(obj={}) {
       let tr = document.createElement('tr');
				showFields.forEach(field => {
					let td = document.createElement('td');
					if (field == 'centerName') {
						td.innerText = obj[field].substring('코로나19'.length);
						// console.log(td.innerText);
					} else {
						td.innerText = obj[field];
					}
					tr.append(td);
				});
				return tr;
}
//제이슨 전송 db 입력기능
document.getElementById('registerData').addEventListener('click',function (e){
	fetch('../regiserCenter.do',{
		method:'post',
		headers:{
			'Content-type':'apllication/json'
		},
		body:JSON.stringify(centerList)
	})
	.then(resolve => resolve.text())
	.then(result => console.log(result))
	.catch(err => console.log(err));
})

// 초기화 함수 호출
optionList();
search();
list();