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
<%
	List<PlayListForm> listOfRoles = (List) session
			.getAttribute("listOfSongs");
%>
<body>
      <p align="right">
		<%
			for (int i = 0; i < listOfRoles.size(); i++) {
		%>
		<%
			PlayListForm pForm = (PlayListForm) listOfRoles.get(i);
		%>
<%-- 		<%=pForm.getId()%>
		<%=pForm.getPlayListItemName()%>
 --%>		<video width="416" height="255" controls> <source
				src="<%=pForm.getPlayListStoreLocation()%>" type="video/mp4"></source> </video>
		<br/>
				
		<%
			}
		%>
		</p>
</body>
</html>