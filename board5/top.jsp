<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>TOP</title></head>
<body>
<h1><a href="http://localhost:8080/board5/threadservlet?genre=other">ジャンルその１</a></h1></p>
	<%--<c:forEach var="thread1" items="${thread1}">
		スレッドの一部↓<br>
		<p>${thread1.title}</p>
		<p>${thread1.content}</p>
	</c:forEach>--%>
<%--
<h1><a href="http://localhost:8080/board5/threadservlet?genre=hobby">ジャンルその２</a></h1></p>
	<%--<c:forEach var="thread2" items="${thread2}">
		スレッドの一部→<tr><td>${thread2.title}</td><td>${thread2.content}</td></tr>
	</c:forEach>--%>
--%>
<h1>新規スレッド作成</h1>
	<form method='post' action='threadservlet'>
		タイトル<input type='text' name='title'><br>
		スレッド作成者<input type='text' name='threadCreateName'><br>
		本文<input type='text' name='content'><br>
		ジャンル<select name="genre">
			<option value="other">other</option>
			<option value="hobby">hobby</option>
		</select><br>
	<input type='submit' value='新規作成'>
	</form>
</body>
</html>