<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*" %>
<%@page import="com.acp.apps.form.PlayListForm"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
List<PlayListForm> userDetails=(List)session.getAttribute("listOfDisplaySongs");
%> 
<body>
<form action="selectVideo.action" method="post">
<table>
<tr>
		<td><spring:message code="select.song"></spring:message></td>
				
				<td>
					<select style="width:145px;" name="songId" id="songId">
						<option value="-1">Please Select</option>
						<%
						for(PlayListForm pForm:userDetails){ %>

						<option value="<%=pForm.getId()%>"><%=pForm.getPlayListItemName()%></option>

						<%}
						%>
					</select>
					</td>
				</tr>	
	</table>
	<input type="submit" name="SUBMIT"/>				
</form>
</body>
</html>