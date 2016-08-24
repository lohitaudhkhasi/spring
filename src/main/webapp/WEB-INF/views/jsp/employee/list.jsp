<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<body>
	<div class="container">
		<h1>All Users</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Employee ID</th>
					<th>EmployeeName</th>
				</tr>
			</thead>

			<c:forEach var="emp" items="${employees}">
			    <tr>
				<td>
					${emp.empId}
				</td>
					<td>${emp.empName}
				</td>
			    </tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>