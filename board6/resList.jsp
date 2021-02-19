<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>各スレッド詳細ページ</title>
<script type="text/JavaScript">

	function check() {
		if(document.thread_form.resContent.value == "") {
			alert("本文を入力してください");
			return false;
		}
	}

</script>
</head>
<body>
	<c:forEach var="thread" items="${thread}">
		<h1>${thread.title}</h1>
		<p>${thread.content}</p>
		<p>${thread.threadCreateName}</p>
		<p>${thread.date}</p>
		<p>${thread.genre}</p>

		<h1>返信を投稿</h1>
		<form name='thread_form' method='post' action='resservlet' onSubmit="return check()">
			投稿者<input type='text' name='resName'><br>
			レス<input type='text' name='resContent'><br>
			<input type="hidden" name="threadID" value="${thread.threadID}">
			<input type='submit' value='この内容で返信'>
		</form>
	



	<h1>れすいちらん</h1>
	<table border="1">
		<tr><th>レス番号</th><th>投稿者</th><th>返信</th><th>投稿日</th></tr>
		<c:forEach var="post" items="${posts}">
			<tr><td>${post.resID}</td><td>${post.resName}</td><td>${post.resContent}</td><td>${post.date}</td></tr>
		</c:forEach>
	</table>

	<p><a href="http://localhost:8080/board6/threadservlet?genre=${thread.genre}">${thread.genre}のスレッド一覧ページへ</a></p>
	<p><a href="http://localhost:8080/board6/genreservlet">TOPページへ</a></p>
</c:forEach>
</body>
</html>
