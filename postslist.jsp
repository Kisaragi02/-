<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>投稿されたコメント</title>
		<link rel="stylesheet" href="/board/css/board.css">
	</head>
	<body>
		<div id="back-clear">
			<div id="center">
				<h1 class="title">POSTED</h1>
				<form method='POST' action='savedb'>
					<div class="block1">
						<p class="p1">name</p>
						<input type='text' class="text01" name='name' maxlength="20"><br>
					</div>
					<div class="block2">
						<p class="p1">comment</p>
						<textarea name='coment' class="text02" cols="50" rows="10"></textarea><br>
					</div>
					<input type='submit' class="button" value='entry'>
				</form>

				<table border="1">
					<tr><th>ユーザー名</th><th>コメント</th></tr>
					<c:forEach var="post" items="${posts}">
						<tr><td>${post.name}</td><td>${post.coment}</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>
