<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>WebForum</title>
    </head>
    <body>

        <security:authorize access="hasAnyRole('USER','ADMIN')">
            
            <c:url var="logoutUrl" value="/logout" />
            <form action="${logoutUrl}" method="post">
                <a href="<c:url value ="/" />"><button type="button">Home</button></a>&nbsp&nbsp
                <input type="submit" value="Log out" />
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <br>
        </security:authorize>
        
        <security:authorize access="!hasAnyRole('USER','ADMIN')">
            <a href="<c:url value ="/login" />"><button type="button">Login</button></a>
            <a href="<c:url value ="/register" />"><button type="button">Register</button></a>
       </security:authorize>
            <security:authorize access="hasRole('ADMIN')">
                Admin Control&nbsp&nbsp
            <a href="<c:url value ="/poll/addpoll" />"><button type="button">Create a Poll</button></a>&nbsp&nbsp
            <a href="<c:url value ="/user/list" />"><button type="button">User management</button></a>&nbsp&nbsp
       </security:authorize>
            
            

        
        
    <body>