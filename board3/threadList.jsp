<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>�X���b�h�I���E�V�K�쐬</title></head>
<body>
	<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>
	
	<h1>�X���b�h�ꗗ</h1>
	<table border="1">
		<tr><th>�^�C�g��</th><th>�{��</th></tr>
		<c:forEach var="thread" items="${threads}" varStatus="status">
			<tr><td><a href="http://localhost:8080/board3/resservlet?threadID=${status.count}">${thread.title}</a></td><td>${thread.content}</td></tr>
		</c:forEach>
	</table>
	
	
	<h1>�V�K�X���b�h�쐬</h1>
	<form method='post' action='threadservlet'>
	�^�C�g��<input type='text' name='title'><br>
	�{��<input type='text' name='content'><br>
	<input type='submit' value='�V�K�쐬'>
	</form>
	
</body>
</html>
