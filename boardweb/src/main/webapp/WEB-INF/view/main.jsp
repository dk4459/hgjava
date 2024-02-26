<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<c:set var="msg" value="hello"/>
<p>message: <c:out value="${msg }"/> </p>

<c:if test="${msg != 'hello' } ">
	<p>거짓입니다.</p>
</c:if>

<c:choose>
   <c:when test="${msg == 'hello' } }">
   <p>참입니다</p>
   </c:when>
 	<c:otherwise>
 	<p>거짓입니다.</p>
 	</c:otherwise>
</c:choose>
   <!-- for(int i; i<=5;i++{} -->
<c:forEach begin ="1" end="5" var="i">
</c:forEach>
 	<h3>Main Page</h3>

