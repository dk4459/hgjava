<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>center</title>
</head>
<body>
    <label>시도</label>
    <input type="text" name="" id="keyword">
    <button id="searchBtn">조회</button>
    
    <button id ="registerData">데이트생성</button>
    <label>시도</label><select id="searchSido">
       
    </select>
    <br>
    <div id="show">
    <table border="1">
        <thead id="title">
            <tr>
                <th>센터id</th>
                <th>센터명</th>
                <th>연락처</th>
                <th>시도</th>
            </tr>
        </thead>
        <tbody id="list"></tbody>
    </table>
 </div>
 <script src="center.js"></script>
 <script>
   /*  const origAry['1','2','1','2','3']
    let filAry=[]
    origAry.forEach(item = {
        if(filAry.indexOf(item.sido) ==-1){
        	filAry.push(item.sido);
        }
    }) */
   // console.log(filAry);
    //<select><option>1</option><option>2</option><select>
    //console.log['1','3','2'].indexOf('1')  //값이 없는것을 조회하는 -1을 리턴한다.
 </script>
</body>
</html>
