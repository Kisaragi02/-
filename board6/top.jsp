<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>TOP</title>
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
<h1><a href="http://localhost:8080/board6/threadservlet?genre=other">�W���������̂P</a></h1>
	<c:forEach var="thread1" items="${thread1}">
		<p>${thread1.title}</p>
		<p>${thread1.content}</p>
		<p>${thread1.threadCreateName}</p>
	</c:forEach>
	
<h1><a href="http://localhost:8080/board6/threadservlet?genre=hobby">�W���������̂Q</a></h1></p>
	
<h1>�V�K�X���b�h�쐬</h1>
	<form name='thread_form' method='post' action='threadservlet' onSubmit="return check()">
		�^�C�g��<input type='text' name='title'><br>
		���e��<input type='text' name='threadCreateName'><br>
		�{��<input type='text' name='content'><br>
		�W������<select name="genre">
			<option value="other">other</option>
			<option value="hobby">hobby</option>
		</select><br>
		<input type="submit" value="���e">
		</form>
</body>
</html>