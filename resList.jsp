<%@ page pageEncoding="Windows-31J"
	contentType="text/html;charset=Windows-31J" %>

<%--JSTL 1.1.2 core タグライブラリ--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>各スレッド詳細ページ</title>
	<script type="text/JavaScript">

		function check() {
			if(document.thread_form.resContent.value == "") {
				alert("本文を入力してください");
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
			<div class="thread">
				<div class="in-thread">
					<c:forEach var="thread" items="${thread}">
						<div class="thread-title">
							<p class="p2">
								<span class="s2">
									Title
								</span>
							</p>
							<c:out value="${thread.title}"></c:out>
						</div>
						
						<div class="thread-content">
							<p class="p2">
								<span class="s2">
									Content
								</span>
							</p>
							<c:out value="${thread.content}"></c:out>
						</div>
						<div class="thread-name">
							<p class="p2">
								<span class="s2">
									Name
								</span>
							</p>
							<c:out value="${thread.threadCreateName}"></c:out>
						</div>
						<div class="date-genre">
							<c:out value="${thread.date}"></c:out>
							<c:out value="${thread.genre}"></c:out>
						</div>
					</div>
				</div>

				<h1 class="title">Reply List</h1>
				<table class="rep">
					<tr>
						<th class="table-no">
							No.
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
					</tr>
					<tbody>
						<c:forEach var="post" items="${posts}">
							<tr>
								<td>									<c:out value="${post.resID}"></c:out>
								</td>
								<td>
									<c:out value="${post.resName}"></c:out>
								</td>
								<td>
									<c:out value="${post.resContent}"></c:out>
								</td>
								<td>
									<c:out value="${post.date}"></c:out>
									<br>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
					
				<div>
					<h1 class="title">
						Reply
					</h1>
					<div class="option">
						<form name='thread_form' method='post' action='resservlet' onSubmit="return check()">
							<div class="block01">
								<p class="p1">
									投稿者
								</p>
								<input type='text' class="text01" name='resName' maxlength="20"><br>
							</div>
							<div class="block02">
								<p class="p1">
									レス
								</p>
								<textarea name='resContent' class="text02" cols="50" rows="4" maxlength="150"></textarea><br>
							</div>
							<input type="hidden" name="threadID" value="${thread.threadID}">
							<input type='submit' class="button" value='この内容で返信'>
						</form>
					</div>
				</div>
				
				<div id="page-thread">
					<a href="http://localhost:8080/board6/threadservlet?genre=${thread.genre}">
					</a>
				</div>
				<div id="page-jump">
					<a href="http://localhost:8080/board6/genreservlet">
					</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>
