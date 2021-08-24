<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.html.org">
<head>
<meta charset="UTF-8">
<title>myErrorPage</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Message</td>
			<td th:text="${Message}"></td>
		</tr>
		<tr>
			<td>timestamp</td>
			<td th:text="${timestamp}"></td>
		</tr>
		<tr>
			<td>status</td>
			<td th:text="${status}"></td>
		</tr>
		<tr>
			<td>error</td>
			<td th:text="${error}"></td>
		</tr>
		<tr>
			<td>path</td>
			<td th:text="${path}"></td>
		</tr>
	</table>
</body>
</html>
