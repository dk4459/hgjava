<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>

<body>
  <!-- 2023년 3월 달력 출력. 테이블 형식 -->
  <div id="show">
  <table id="calendar"  border="3" align="center" width="800" height="500"  >
      <tr >
        <td colspan="5" align ="center" id="calendarYM">2024년 3월</td>
      </tr>
 
      <tr>
        <td align="center">일</td>
        <td align="center">월</td>
        <td align="center">화</td>
        <td align="center">수</td>
        <td align="center">목</td>
        <td align="center">금</td>
        <td align="center">토</td>
      </tr>
 
    </table>
  </div>
  <script>
    var date = new Date();
    let currentMonth = today.getMonth();
    let currentYear = today.getFullYear(); // 변수에 현재 연도를 나타내는 값을 저장한다.

    const calendar = {
      show() {
       const viewYear = date.getFullYear();
       const viewMonth = date.getMonth();
      }
    }
    calendar.show();
  </script>
</body>

</html>