<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>�e�X���b�h�ڍ׃y�[�W</title></head>
<body>
	<c:forEach var="thread" items="${thread}">
		<h1>${thread.title}</h1>
		<p>${thread.content}</p>
		<p>${thread.threadCreateName}</p>
		<p>${thread.date}</p>
		<p>${thread.genre}</p>

		<h1>�ԐM�𓊍e</h1>
		<form method='post' action='resservlet'>
			���e��<input type='text' name='resName'><br>
			���X<input type='text' name='resContent'><br>
			<input type="hidden" name="threadID" value="${thread.threadID}">
			<input type='submit' value='���̓��e�ŕԐM'>
		</form>
	



	<h1>�ꂷ�������</h1>
	<table border="1">
		<tr><th>���X�ԍ�</th><th>���e��</th><th>�ԐM</th><th>���e��</th></tr>
		<c:forEach var="post" items="${posts}">
			<tr><td>${post.resID}</td><td>${post.resName}</td><td>${post.resContent}</td><td>${post.date}</td></tr>
		</c:forEach>
	</table>

	<p><a href="http://localhost:8080/board5/threadservlet?genre=${thread.genre}">${thread.genre}�̃X���b�h�ꗗ�y�[�W��</a></p>
	<p><a href="http://localhost:8080/board5/genreservlet">TOP�y�[�W��</a></p>
</c:forEach>
</body>
</html>
