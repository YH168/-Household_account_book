<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dto.Shunyu"%>
    <%@ page import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿 -収入一覧- </title>
<link rel="stylesheet" type="text/css" href="css/result2.css" />
<!-- ttt -->
</head>
<body>
	登録する際はこちら→<a href="./top2" class="btn">登録ページへ</a><br>
	支出一覧へ移動する際はこちら→<a href="./Kakei1" class="btn">支出一覧へ</a>
	<br><br>
	<table>
		<tr>
			<th rowspan="2">登録ID</th>
			<th rowspan="2">内訳</th>
			<th rowspan="2">金額</th>
			<th colspan="3">日付</th>
		</tr>
		<tr>
			<th>年</th>
			<th>月</th>
			<th>日</th>
		</tr>
		<%
		@SuppressWarnings("unchecked")
		ArrayList<Shunyu> shunyu= (ArrayList<Shunyu>) request.getAttribute("shunyu");
		for(Shunyu Shu : shunyu){
		%>
		<tr>
			<td><%=Shu.getId()%></td>
			<td><%=Shu.getName()%></td>
			<td><%=Shu.getKin()%></td>
			<td><%=Shu.getYear()%></td>
			<td><%=Shu.getMon()%></td>
			<td><%=Shu.getDay()%></td>
		</tr>
		<%} %>
	</table>
</body>
</html>