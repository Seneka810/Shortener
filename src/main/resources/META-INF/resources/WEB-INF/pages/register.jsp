<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Shortener</title>
</head>
<body>
	<div align="center">
		<c:url value="/newcustomer" var="regUrl" />

		<form action="${regUrl}" method="POST">
			Login:<br /> <input type="text" name="login" value="${login}"><br />
			Password:<br /> <input type="password" name="password"><br />
			<input type="submit" value="Confirm" />

			<c:if test="${exists ne null}">
				<p>User already exists!</p>
			</c:if>
		</form>
	</div>
</body>
</html>
