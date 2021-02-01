<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>投稿されたコメント</title></head>
<body>
	
	<h1>投稿されたコメント</h1>
	<form method='POST' action='savedb'>
		ユーザー名<input type='text' name='name'><br>
		コメント<input type='text' name='comment'><br>
		<input type='submit' value='登録'>
	</form>

	<table border="1">
		<tr><th>ユーザー名</th><th>コメント</th></tr>
		<c:forEach var="post" items="${posts}">
			<tr><td>${post.name}</td><td>${post.comment}</td></tr>
		</c:forEach>
	</table>
	
</body>
</html>
