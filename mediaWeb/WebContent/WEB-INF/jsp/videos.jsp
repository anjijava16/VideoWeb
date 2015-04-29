<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.acp.apps.form.PlayListForm"%>
<%
	String songName = (String) session.getAttribute("songs");
%>
<video width="516" height="315" controls>
 <source src="<%=songName%>" type="video/mp4"></source>
</video>
