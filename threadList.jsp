<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>New Thread</title>
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
	<link rel="stylesheet" href="/board6/css/board.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
</head>
<body>
	<div id="back-clear" class="div01">
		<div id="center">
			<h1 class="title">${genreName} Thread List</h1>
			<table class="list-thread">
				<tr>
					<th class="table-no">
						No.
					</th>
					<th class="table-title">
						Title
					</th>
					<th class="table-name">
						Name
					</th>
					<th class="table-content">
						Content
					</th>
					<th class="table-date">
						Date
					</th>
					<th class="table-genre">
						Genre
					</th>
				</tr>
				<tbody>
					<c:forEach var="thread" items="${threads}" varStatus="status">
						<tr>
							<td class="thread-td">
								<a href="http://localhost:8080/board6/resservlet?threadID=${thread.threadID}"><c:out value="${thread.threadID}"></c:out></a>
							</td>
						
							<td class="thread-td">
								<a href="http://localhost:8080/board6/resservlet?threadID=${thread.threadID}"><c:out value="${thread.title}"></c:out></a>
							</td>
						
							<td>
								<c:out value="${thread.threadCreateName}"></c:out>
							</td>
						
							<td>
								<c:out value="${thread.content}"></c:out>
							</td>
						
							<td>
								<c:out value="${thread.date}"></c:out>
							</td>
						
							<td>
								<c:out value="${thread.genre}"></c:out>
								<br>
							</td>
						</tr>
					</c:forEach>
				</tbody>
				
			</table>
			
			<div>
				<h1 class="title">New Thread</h1>
				<div class="option">
					<form name='thread_form' method='post' action='threadservlet' onSubmit="return check()">
						<div class="block01">
							<p class="p1">
								Title
							</p>
							<textarea name='title' class="text02" cols="25" rows="2" maxlength="50"></textarea>
							<br>
						</div>
						<div class="block02">
							<p class="p1">
								Name
							</p>
							<input type='text' class="text01" name='threadCreateName' maxlength="20">
							<br>
						</div>
						<div class="block03">
							<p class="p1">
								Content
							</p>
							<textarea name='content' class="text02" cols="50" rows="4" maxlength="150"></textarea><br>
						</div>
						<input type="hidden" name="genre" value="${genre}">
						<input type='submit' class="button" value='Create!'>
					</form>
				</div>
			</div>
			<div id="page-jump">
				<a href="http://localhost:8080/board6/genreservlet">
				</a>
			</div>
			<div id="page-top">
				<a href="#">
				</a>
			</div>
		</div>
	</div>
</body>
</html>
