<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head><title>TOP</title></head>
<body>
<h1><a href="http://localhost:8080/board5/threadservlet?genre=other">�W���������̂P</a></h1></p>
	<%--<c:forEach var="thread1" items="${thread1}">
		�X���b�h�̈ꕔ��<br>
		<p>${thread1.title}</p>
		<p>${thread1.content}</p>
	</c:forEach>--%>
<%--
<h1><a href="http://localhost:8080/board5/threadservlet?genre=hobby">�W���������̂Q</a></h1></p>
	<%--<c:forEach var="thread2" items="${thread2}">
		�X���b�h�̈ꕔ��<tr><td>${thread2.title}</td><td>${thread2.content}</td></tr>
	</c:forEach>--%>
--%>
<h1>�V�K�X���b�h�쐬</h1>
	<form method='post' action='threadservlet'>
		�^�C�g��<input type='text' name='title'><br>
		�X���b�h�쐬��<input type='text' name='threadCreateName'><br>
		�{��<input type='text' name='content'><br>
		�W������<select name="genre">
			<option value="other">other</option>
			<option value="hobby">hobby</option>
		</select><br>
	<input type='submit' value='�V�K�쐬'>
	</form>
</body>
</html>