/**
 * center.js 
 */

 console.log('center.js');
 
 let url ='https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=lEasnKvE0jY2SKjD7fjEBTFtsOZB03oeKA4Bv0hilh9Du6qEb0pBnhFxE5FrphuZibMW4ukw8VnyHUNd9M3ACQ%3D%3D';
 
 let showFields = ['id','centerName','phoneNumber','sido']
 let tbody = document.querySelector('#list');
 let labelValue = document.querySelector('label').value
 
 fetch(url)
 .then(resolve => resolve.json())
 .then(result => {
	 console.log(result);
	 result.data.forEach(center =>{
	    let tr = document.createElement('tr');
	    showFields.forEach(field =>{
			let td = document.createElement('td');
			if(field == 'centerName'){
			td.innerText=center[field].substring('코로나19'.length);
			}
			else{
				td.innerText=center[field];
			}
			tr.append(td);
		})
		tbody.append(tr); 	 
	 })
 })
 .catch(err => console.log(err));
 
 //조회이벤트 처리
 function makeRow(obj={}){
	 let btn = document.querySelector('#searchBtn');
	 btn.addEventListener('click',search);
 }
 function search(e){
	 if('sido' == labelValue){
		 alert('ok');
	 }
 }