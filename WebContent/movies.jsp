 <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.dao.MovieDao"%>
<%@page import="com.dao.*" %>
<%@page import="com.entity.*" %>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	
	<c:forEach items="${movies}" var="movie">
    	
    	<c:out value="${movie.name}"></c:out><br/>   
	</c:forEach>

</body>
</html>