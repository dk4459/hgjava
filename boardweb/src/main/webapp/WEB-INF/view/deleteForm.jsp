<%@page import="co.yedam.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<%
      Board board = (Board)request.getAttribute("board");
    %>
 	<h3>글 삭제</h3>
 	<form action ="removeBoard.do">
 	<input type="hidden" value="<%=board.getBoardNo()%>"name="bno">
 	<table class="table">
 	  <tr>
 	    <th>글번호</th>
 	    <td>99</td>
 	  </tr>
 	  <tr>
 	    <th>제목</th>
 	    <td>테스트입니다</td>
 	  </tr>
 	  <tr>
 	    <td colspan ="2">
 	      <button type = "submit" class="btn btn-danger">삭제</button>
 	      <button type = "reset" class="btn btn-secondary">취소</button>
 	  </tr>
 	</table>
 	</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>