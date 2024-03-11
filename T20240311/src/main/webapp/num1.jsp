<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
</body>
<script>
/*<!--  data/data.json -> object변경. 20건 중에서 Female, 4000이상..정보를  -->
<!-- targetAry에 담고 출력 -->*/
let targetAry = [];
fetch("data/data.json")
.then(resolve => resolve.json())
.then(result =>{
	result.forEach(prop =>{
		if(prop.gender=='Female' && prop.salary>4000){
			if (targetAry.indexOf(prop.gender) == -1) {
		     	  targetAry.push(prop);
			}
		}
	})
console.log(targetAry)
})
.catch(err => console.log(err));
</script>
</html>