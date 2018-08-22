<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "dto.Shisyutu"%>
    <%@ page import = "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>家計簿 -支出一覧- </title>
<link rel="stylesheet" type="text/css" href="css/result.css" />
<!-- ttt -->
</head>
<body>
	登録する際はこちら→<a href="./top1" class="btn">登録ページへ</a><br>
	収入一覧へ移動する際はこちら→<a href="./Kakei2" class="btn">収入一覧へ</a>
	<br><br>
	<table >
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
		ArrayList<Shisyutu> shisyutu = (ArrayList<Shisyutu>) request.getAttribute("shisyutu");
		int n= 0;
		for(Shisyutu Shi : shisyutu){
		%>
		<tr>
			<td><%=Shi.getId()%></td>
			<td><%=Shi.getName()%></td>
			<td><%=Shi.getKin()%></td>
			<td><%=Shi.getYear()%></td>
			<td><%=Shi.getMon()%></td>
			<td><%=Shi.getDay()%></td>
		</tr>
		<% n += Shi.getKin();} %>
	</table>
	合計<%=n%>円
</body>
</html>