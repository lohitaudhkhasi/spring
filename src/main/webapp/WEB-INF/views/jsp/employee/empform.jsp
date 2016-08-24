<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<div class="container">
	<h4>Add User</h4>
	<br />

	<spring:url value="/employee/save" var="userActionUrl" />

	<form:form class="form-horizontal" method="post"
                modelAttribute="empForm" action="${userActionUrl}">

		<spring:bind path="empName">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Employee Name</label>
			<div class="col-sm-10">
				<form:input path="empName" type="text" class="form-control"
                                id="empName" placeholder="Employee Name" />
				<form:errors path="empName" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<spring:bind path="empId">
		  <div class="form-group ${status.error ? 'has-error' : ''}">
			<label class="col-sm-2 control-label">Employee Id</label>
			<div class="col-sm-10">
				<form:input path="empId" class="form-control"
                                id="empId" placeholder="Employee Id" />
				<form:errors path="empId" class="control-label" />
			</div>
		  </div>
		</spring:bind>

		<div class="form-group">
		  <div class="col-sm-offset-2 col-sm-10">
			     <button type="submit" class="btn-lg btn-primary pull-right">Add </button>
	   </div>
	</form:form>
</div>
</body>
</html>