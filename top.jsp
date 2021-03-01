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
	<link rel="stylesheet" href="/board6/css/board.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.4/css/all.css">
</head>
<body>
	<div id="back-clear" class="div01">
		<div id="center">
			<h1 class="title">
				<a href="http://localhost:8080/board6/threadservlet?genre=hobby" class="thread-button">
					Genre1 Hobby
				</a>
			</h1>
			<p class="Newest">
				Newest
			</p>
			<div class="thread-top">
				<div class="top-thread">
					<c:forEach var="thread2" items="${thread2}">
						
						<div class="thread-title">
							<p class="p2">
								<span class="s2">
									Title
								</span>
							</p>
							<c:out value="${thread2.title}"></c:out>
						</div>
						
						<div class="thread-content">
							<p class="p2">
								<span class="s2">
									Content
								</span>
							</p>
							<c:out value="${thread2.content}"></c:out>
						</div>
						<div class="thread-name">
							<p class="p2">
								<span class="s2">
									Name
								</span>
							</p>
							<c:out value="${thread2.threadCreateName}"></c:out>
						</div>
					</c:forEach>
				</div>
			</div>

			<h1 class="title">
				<a href="http://localhost:8080/board6/threadservlet?genre=other" class="thread-button">
					Genre2 Other
				</a>
			</h1>
			
			<p class="Newest">
				Newest
			</p>
			<div class="thread-top">
				<div class="top-thread">
					<c:forEach var="thread1" items="${thread1}">
						
						<div class="thread-title">
							<p class="p2">
								<span class="s2">
									Title
								</span>
							</p>
							<c:out value="${thread1.title}"></c:out>
						</div>
						
						<div class="thread-content">
							<p class="p2">
								<span class="s2">
									Content
								</span></p>
							<c:out value="${thread1.content}"></c:out>
						</div>
						<div class="thread-name">
							<p class="p2">
								<span class="s2">
									Name
								</span>
							</p>
							<c:out value="${thread1.threadCreateName}"></c:out>
						</div>
					</c:forEach>
				</div>
			</div>

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
							<input type='text' class="text01" name='threadCreateName' maxlength="20"><br>
						</div>
						<div class="block03">
							<p class="p1">
								Content
							</p>
							<textarea name='content' class="text02" cols="50" rows="4" maxlength="150"></textarea><br>
						</div>
						<div class="block04">
							<p class="p1">
								other or hobby
							</p>
							<div class="genre">
								<select name="genre">
									<option value="other">other</option>
									<option value="hobby">hobby</option>
								</select><br>
							</div>
							<input type="submit" class="button" value="投稿">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>