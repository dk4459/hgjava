/**
 *  num1.js
 */
/*<!--  data/data.json -> object변경. 20건 중에서 Female, 4000이상..정보를  -->
  <!-- targetAry에 담고 출력 -->*/
fetch("data/data.json")
.then(resolve => resolve.json())
.then(result =>{
	console.log(result);
})