<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>各スレッド詳細ページ</title></head>
<body>
	<c:forEach var="thread" items="${thread}">
		<h1>${thread.title}</h1>
		<p>${thread.content}</p>	

		<h1>返信を投稿</h1>
		<form method='post' action='resservlet'>
			レス<input type='text' name='resContent'><br>
			<input type="hidden" name="threadID" value="${thread.threadID}">
			<input type='submit' value='この内容で返信'>
		</form>
	</c:forEach>

	<h1>れすいちらん</h1>
	<table border="1">
		<tr><th>レス番号</th><th>返信</th></tr>
		<c:forEach var="post" items="${posts}">
			<tr><td>${post.resID}</td><td>${post.resContent}</td></tr>
		</c:forEach>
	</table>

	<p><a href="http://localhost:8080/board3/threadservlet">全スレッド一覧ページへ</a></p>
</body>
</html>
