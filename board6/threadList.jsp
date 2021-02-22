<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>スレッド選択・新規作成</title>
<script type="text/JavaScript">

	function check() {
		if(document.thread_form.title.value == "" && document.thread_form.content.value == "") {
			alert("タイトルと本文を入力してください");
			return false;
		}
		else if(document.thread_form.content.value == "") {
			alert("本文を入力してください");
			return false;
		}
		else if(document.thread_form.title.value == "") {
			alert("タイトルを入力してください");
			return false;
		}
	}

</script>
</head>
<body>
	<%--<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>--%>
	
	<h1>${genreName}のスレッド一覧</h1>
	<table border="1">
		<tr><th>スレッド番号</th><th>タイトル</th><th>投稿者</th><th>本文</th><th>スレッド作成日</th><th>ジャンル</th></tr>
		<c:forEach var="thread" items="${threads}" varStatus="status">
			<a href="http://localhost:8080/board6/resservlet?threadID=${thread.threadID}"><c:out value="${thread.threadID}"></c:out></a>
			<a href="http://localhost:8080/board6/resservlet?threadID=${thread.threadID}"><c:out value="${thread.title}"></c:out></a>
			<c:out value="${thread.threadCreateName}"></c:out>
			<c:out value="${thread.content}"></c:out>
			<c:out value="${thread.date}"></c:out>
			<c:out value="${thread.genre}"></c:out>
			<br>
		</c:forEach>
	</table>
	
	
	<h1>新規スレッド作成</h1>
	<form name='thread_form' method='post' action='threadservlet' onSubmit="return check()">
		タイトル<input type='text' name='title'><br>
		スレッド作成者<input type='text' name='threadCreateName'><br>
		本文<input type='text' name='content'><br>
		<input type="hidden" name="genre" value="${genre}">
		<input type='submit' value='新規作成'>
	</form>

	<p><a href="http://localhost:8080/board6/genreservlet">TOPページへ</a></p>

</body>
</html>
