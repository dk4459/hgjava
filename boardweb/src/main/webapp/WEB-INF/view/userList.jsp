<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>UserList page</h3>

<script src="static/js/userList.js"></script>
<input type="text" id="name" >

<input type="text" id="name">
<select id="genderList">
   <option value="Male">남성</option>
    <option value="Female" selected>여성</option>	
</select>

<div id="show">
    <table border="1" id="tableList">
      <thead>
<!--     
        <tr>
           <th>id</th>
           <th>first_name</th>
           <th>last_name</th>
           <th>email</th>
           <th>salary</th>
        </tr> --> 
      </thead>
      <tbody >
      <tr>
           <td>101</td>
           <td>first_name</td>
           <td>last_name</td>
           <td>email@com</td>
           <td>2345</td>
        </tr>
      </tbody>
    </table>
</div>