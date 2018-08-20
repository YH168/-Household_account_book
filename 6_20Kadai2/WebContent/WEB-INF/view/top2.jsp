<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>収入登録ページ</title>
</head>
<body>
	登録する収入情報について入力してください。<br>
	<form action="./result2" method="get">
	<table>
			<tr>
				<td>ID</td><td>：<input type="text" name="id"></td>
			</tr>
			<tr>
				<td>内訳</td><td>：<input type="text" name="name"></td>
			</tr>
			<tr>
				<td>金額</td><td>：<input type="text" name="kin"></td>
			</tr>
			<tr>
				<td>年</td><td>：<input type="text" name="year"></td>
			<tr>
				<td>月</td><td>：<input type="text" name="mon"></td>
			</tr>
			<tr>
				<td>日</td><td>：<input type="text" name="day"></td>
			</tr>
	</table>
		<input type="submit" value="登録">
	</form>
</body>
</html>