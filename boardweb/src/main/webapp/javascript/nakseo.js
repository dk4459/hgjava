/**
 * center.js
 */

console.log('center.js');

let url = 'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=lEasnKvE0jY2SKjD7fjEBTFtsOZB03oeKA4Bv0hilh9Du6qEb0pBnhFxE5FrphuZibMW4ukw8VnyHUNd9M3ACQ%3D%3D';

let showFields = ['id', 'centerName', 'phoneNumber', 'sido'];
let tbody = document.querySelector('#list');
let searchValue = document.querySelector('#keyword').value;

fetch(url)
    .then(resolve => resolve.json())
    .then(result => {
        console.log(result);
        result.data.forEach(center => {
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
        });
    })
    .catch(err => console.log(err));

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
                return; // 검색어가 비어 있으면 여기서 함수 종료
            }

            result.data.forEach(center => {
                if (center['sido'] == searchValue) {
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
        })
        .catch(err => console.log(err));
}

// 초기화 함수 호출
search();