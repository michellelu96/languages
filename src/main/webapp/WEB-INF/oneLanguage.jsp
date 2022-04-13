<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${language.name }</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="row justify-content-md-center">
		<h1 class="col-md-auto">Expense Details</h1>
		<div class="col offset-6">
			<a href="/languages">Go Back</a>
			<form action="/languages/delete/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete"> <input
					type="submit" value="Delete" class="btn btn-link">
			</form>
		</div>
	</div>
	<p>
		Language Name:
		<c:out value="${language.name }" />
	</p>
	<p>
		Creator Name:
		<c:out value="${language.creatorName }" />
	</p>
	<p>
		Version:
		<c:out value="${language.version}" />
	</p>
</body>
</html>