<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>�X���b�h�I���E�V�K�쐬</title>
<script type="text/JavaScript">

	function check() {
		if(document.thread_form.title.value == "" && document.thread_form.content.value == "") {
			alert("�^�C�g���Ɩ{������͂��Ă�������");
			return false;
		}
		else if(document.thread_form.content.value == "") {
			alert("�{������͂��Ă�������");
			return false;
		}
		else if(document.thread_form.title.value == "") {
			alert("�^�C�g������͂��Ă�������");
			return false;
		}
	}

</script>
</head>
<body>
	<%--<c:forEach var="thread" items="${threads}" varStatus="status"></c:forEach>--%>
	
	<h1>${genreName}�̃X���b�h�ꗗ</h1>
	<table border="1">
		<tr><th>�X���b�h�ԍ�</th><th>�^�C�g��</th><th>���e��</th><th>�{��</th><th>�X���b�h�쐬��</th><th>�W������</th></tr>
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
	
	
	<h1>�V�K�X���b�h�쐬</h1>
	<form name='thread_form' method='post' action='threadservlet' onSubmit="return check()">
		�^�C�g��<input type='text' name='title'><br>
		�X���b�h�쐬��<input type='text' name='threadCreateName'><br>
		�{��<input type='text' name='content'><br>
		<input type="hidden" name="genre" value="${genre}">
		<input type='submit' value='�V�K�쐬'>
	</form>

	<p><a href="http://localhost:8080/board6/genreservlet">TOP�y�[�W��</a></p>

</body>
</html>
