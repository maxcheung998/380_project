<!DOCTYPE html>
<html>
    <head>
        <title>Web Forum Registration</title>
    </head>
    <body>
        <c:if test="${param.error != null}">
            <p>Register failed. Your password and confirm password not same</p>
        </c:if>
        <h2>Web Forum Registration</h2>
        <form:form method="POST" enctype="multipart/form-data" modelAttribute="registerForm">
            <form:label path="username">Username</form:label><br/>
            <form:input type="text" path="username" /><br/><br/>
            
            <form:label path="password">Password</form:label><br/>
            <form:input type="password" path="password" /><br/><br/>
            
            <form:label path="cpassword">Confirm your password</form:label><br/>
            <form:input type="password" path="cpassword" /><br/><br/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="roles" value="ROLE_USER"/>
            <input type="submit" value="Submit" />

        </form:form>
    </body>
</html>