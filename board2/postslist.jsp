<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>���e���ꂽ�R�����g</title></head>
<body>
	
	<h1>���e���ꂽ�R�����g</h1>
	<form method='POST' action='savedb'>
		���[�U�[��<input type='text' name='name'><br>
		�R�����g<input type='text' name='comment'><br>
		<input type='submit' value='�o�^'>
	</form>

	<table border="1">
		<tr><th>���[�U�[��</th><th>�R�����g</th></tr>
		<c:forEach var="post" items="${posts}">
			<tr><td>${post.name}</td><td>${post.comment}</td></tr>
		</c:forEach>
	</table>
	
</body>
</html>
