<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>スレッド選択・新規作成</title></head>
<body>
	<%--<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>--%>
	
	<h1>${genreName}のスレッド一覧</h1>
	<table border="1">
		<tr><th>スレッド番号</th><th>タイトル</th><th>投稿者</th><th>本文</th><th>スレッド作成日</th><th>ジャンル</th></tr>
		<c:forEach var="thread" items="${threads}" varStatus="status">
			<%--<tr><td><a href="http://localhost:8080/board5/resservlet?threadID=${status.count}">${thread.threadID}</td></a><td><a href="http://localhost:8080/board5/resservlet?threadID=${status.count}">${thread.title}</td></a><td>${thread.threadCreateName}</td><td>${thread.content}</td><td>${thread.date}</td><td>${thread.genre}</td></tr>--%>
			<tr><td><a href="http://localhost:8080/board5/resservlet?threadID=${thread.threadID}">${thread.threadID}</td></a><td>${thread.title}</td><td>${thread.threadCreateName}</td><td>${thread.content}</td><td>${thread.date}</td><td>${thread.genre}</td></tr>
		</c:forEach>
	</table>
	
	
	<h1>新規スレッド作成</h1>
	<form method='post' action='threadservlet'>
		タイトル<input type='text' name='title'><br>
		スレッド作成者<input type='text' name='threadCreateName'><br>
		本文<input type='text' name='content'><br>
		<input type="hidden" name="genre" value="${genre}">
		<input type='submit' value='新規作成'>
	</form>

	<p><a href="http://localhost:8080/board5/genreservlet">TOPページへ</a></p>

</body>
</html>
