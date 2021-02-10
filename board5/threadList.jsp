<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>�X���b�h�I���E�V�K�쐬</title></head>
<body>
	<%--<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>--%>
	
	<h1>${genreName}�̃X���b�h�ꗗ</h1>
	<table border="1">
		<tr><th>�X���b�h�ԍ�</th><th>�^�C�g��</th><th>���e��</th><th>�{��</th><th>�X���b�h�쐬��</th><th>�W������</th></tr>
		<c:forEach var="thread" items="${threads}" varStatus="status">
			<%--<tr><td><a href="http://localhost:8080/board5/resservlet?threadID=${status.count}">${thread.threadID}</td></a><td><a href="http://localhost:8080/board5/resservlet?threadID=${status.count}">${thread.title}</td></a><td>${thread.threadCreateName}</td><td>${thread.content}</td><td>${thread.date}</td><td>${thread.genre}</td></tr>--%>
			<tr><td><a href="http://localhost:8080/board5/resservlet?threadID=${thread.threadID}">${thread.threadID}</td></a><td>${thread.title}</td><td>${thread.threadCreateName}</td><td>${thread.content}</td><td>${thread.date}</td><td>${thread.genre}</td></tr>
		</c:forEach>
	</table>
	
	
	<h1>�V�K�X���b�h�쐬</h1>
	<form method='post' action='threadservlet'>
		�^�C�g��<input type='text' name='title'><br>
		�X���b�h�쐬��<input type='text' name='threadCreateName'><br>
		�{��<input type='text' name='content'><br>
		<input type="hidden" name="genre" value="${genre}">
		<input type='submit' value='�V�K�쐬'>
	</form>

	<p><a href="http://localhost:8080/board5/genreservlet">TOP�y�[�W��</a></p>

</body>
</html>
