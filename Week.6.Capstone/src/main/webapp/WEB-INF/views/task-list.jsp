<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task List</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootswatch/4.3.1/sketchy/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-N8DsABZCqc1XWbg/bAlIDk7AS/yNzT5fcKzg/TwfmTuUqZhGquVmpb5VvfmLcMzp"
	crossorigin="anonymous">
</head>
<body>

	<table class="table">
		<tr>
			<th>Task Due Date</th>
			<th>Task Completion</th>
			<th>Task Description</th>
			<th>Mark Task as Complete</th>
			<th>Delete Task</th>
		</tr>
		<c:forEach var="t" items="${user.tasks}">
			<tr>
				<td>${t.dueDate}</td>
				<td>${t.isCompleted()}</td>
				<td>${t.task}</td>
				<td><a class="btn btn-primary" href="/mark-complete?id=${t.id}">Complete</a></td>
				<td><a class="btn btn-secondary" href="/delete-task?id=${t.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<h3>Add Task</h3>
	<form action="/add-task?id=${user.id}" method="post">
	<input type="hidden" name="id" value="${user.id}">
		Task: <input type="text" name="task"> 
		Due Date: <input type="text" name="dueDate"> 
		<input type="submit" value="Add task">
	</form>
	<br>
	<a class="btn btn-primary" href="/">Go Home</a>
</body>
</html>