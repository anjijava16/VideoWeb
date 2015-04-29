<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*"%>
<%@page import="com.acp.apps.form.PlayListForm"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
	<p align="center">
		<%
			PlayListForm pForm = (PlayListForm) session.getAttribute("pSelectSongForm");
		%>
		<font color='red'>Select Song:</font><strong><font color='blue'><%=pForm.getPlayListItemName()%></font></strong>
		<br/>
		<br/>
		<video width="900" height="505" controls> <source
			src="<%=pForm.getPlayListStoreLocation()%>" type="video/mp4"></source>
		</video>
	</p>
</body>
</html>