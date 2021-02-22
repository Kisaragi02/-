<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core �^�O���C�u����--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>�e�X���b�h�ڍ׃y�[�W</title>
<script type="text/JavaScript">

	function check() {
		if(document.thread_form.resContent.value == "") {
			alert("�{������͂��Ă�������");
			return false;
		}
	}

</script>
</head>
<body>
	<c:forEach var="thread" items="${thread}">
		<c:out value="${thread.title}"></c:out>
		<c:out value="${thread.content}"></c:out>
		<c:out value="${thread.threadCreateName}"></c:out>
		<c:out value="${thread.date}"></c:out>
		<c:out value="${thread.genre}"></c:out>


		<h1>�ԐM�𓊍e</h1>
		<form name='thread_form' method='post' action='resservlet' onSubmit="return check()">
			���e��<input type='text' name='resName'><br>
			���X<input type='text' name='resContent'><br>
			<input type="hidden" name="threadID" value="${thread.threadID}">
			<input type='submit' value='���̓��e�ŕԐM'>
		</form>
	



	<h1>�ꂷ�������</h1>
	<table border="1">
		���X�ԍ��A���e�ҁA�ԐM�A���e��<br>
		<c:forEach var="post" items="${posts}">
			<c:out value="${post.resID}"></c:out>
			<c:out value="${post.resName}"></c:out>
			<c:out value="${post.resContent}"></c:out>
			<c:out value="${post.date}"></c:out>
			<br>
		</c:forEach>
	</table>

	<p><a href="http://localhost:8080/board6/threadservlet?genre=${thread.genre}">${thread.genre}�̃X���b�h�ꗗ�y�[�W��</a></p>
	<p><a href="http://localhost:8080/board6/genreservlet">TOP�y�[�W��</a></p>
</c:forEach>
</body>
</html>
