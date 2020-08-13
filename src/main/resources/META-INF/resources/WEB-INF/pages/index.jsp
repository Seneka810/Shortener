<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Shortener</title>
</head>
<body>
	<div align="center">
		<h1>Your login is: ${login}</h1>

		<table border="1">
			<th>Id</th>
			<th>Your links</th>
			<th>Your short links</th>
			<th>Overall count</th>
			<c:forEach items="${links}" var="l" varStatus="counter">
				<tr>
					<td><c:out value="${counter.count}" /></td>
					<td><c:out value="${l.link}" /></td>
					<td><a href="/countlink?id=${l.id}&link=${l.link}&count=${l.count}">
						<c:out value="${shortLink}/link${l.id}" /></a>
					</td>
					<td><c:out value="${l.count}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br />
		<c:url value="/addlink" var="newlink" />
		<form action="${newlink}" method="POST">
			Add new link:<br /> <input type="text" name="link"><br />
			<input type="submit" value="Add" />
		</form>

		<c:url value="/logout" var="logoutUrl" />
		<p>
			Click to logout: <a href="${logoutUrl}">LOGOUT</a>
		</p>
	</div>
</body>
</html>
