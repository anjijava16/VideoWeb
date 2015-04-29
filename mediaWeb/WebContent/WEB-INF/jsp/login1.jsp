

<form action="login.action">
<p align="right">
<%if(request.getAttribute("fail")!=null){%>
<font color='red'><%=request.getAttribute("fail") %></font>
<%} %>
<br/>
UserName: <input type="text" name="userName"/><br/>
Password: <input type="password" name="password"><br/>
<input type="submit" value="ClickMe">
</p>
</form>
