<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>スレッド選択・新規作成</title></head>
<body>
	<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>
	
	<h1>スレッド一覧</h1>
	<table border="1">
		<tr><th>タイトル</th><th>本文</th></tr>
		<c:forEach var="thread" items="${threads}" varStatus="status">
			<tr><td><a href="http://localhost:8080/board3/resservlet?threadID=${status.count}">${thread.title}</a></td><td>${thread.content}</td></tr>
		</c:forEach>
	</table>
	
	
	<h1>新規スレッド作成</h1>
	<form method='post' action='threadservlet'>
	タイトル<input type='text' name='title'><br>
	本文<input type='text' name='content'><br>
	<input type='submit' value='新規作成'>
	</form>
	
</body>
</html>
