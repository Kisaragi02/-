<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>TOP</title>
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
<h1><a href="http://localhost:8080/board6/threadservlet?genre=other">ジャンルその１</a></h1>
	<c:forEach var="thread1" items="${thread1}">
		<p>${thread1.title}</p>
		<p>${thread1.content}</p>
		<p>${thread1.threadCreateName}</p>
	</c:forEach>
	
<h1><a href="http://localhost:8080/board6/threadservlet?genre=hobby">ジャンルその２</a></h1></p>
	
<h1>新規スレッド作成</h1>
	<form name='thread_form' method='post' action='threadservlet' onSubmit="return check()">
		タイトル<input type='text' name='title'><br>
		投稿者<input type='text' name='threadCreateName'><br>
		本文<input type='text' name='content'><br>
		ジャンル<select name="genre">
			<option value="other">other</option>
			<option value="hobby">hobby</option>
		</select><br>
		<input type="submit" value="投稿">
		</form>
</body>
</html>