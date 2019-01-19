<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/header.jspf"%>	

<%@ include file="common/navigation.jspf"%>	

	<div class="container">
		<form:form method="post" commandName="todo">
		
		<form:hidden path="id"/>

		
			<fieldset class="form-group">
				<form:label path="desc">Description</form:label>
				<form:input path="desc" type="text" class="form-control"
					required="required"/>
				<form:errors path="desc" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="targetDate">Target date</form:label>
				<form:input path="targetDate" type="text" class="form-control"
					required="required"/>
				<form:errors path="targetDate" cssClass="text-warning" />
			</fieldset>
			
			
			<button type="submit" class="btn btn-success">Submit</button>
		</form:form>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

    <script>
        $('#targetDate').datepicker({
            format : 'dd/mm/yyyy'
        });
    </script>

</body>
</html>