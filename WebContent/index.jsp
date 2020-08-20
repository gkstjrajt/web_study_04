<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import = "java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
	<%
	String appPath = application.getContextPath();
	String filePath = application.getRealPath("index.jsp");
	String serverInfo = application.getServerInfo();
	%>
	웹 애플리케이션의 컨텍스트 패스명
	<br>
	<b><%=appPath%></b>
	<hr>
	웹 애플리케이션의 파일 경로명
	<br>
	<b><%=filePath%></b>
	<hr>
	컨테이너의 이름과 버전 변환
	<br>
	<b><%=serverInfo%></b>
	<br>
	<hr>
	<ul>
		<%
			Enumeration<String> names = application.getInitParameterNames();
		while (names.hasMoreElements()) {
			String param = names.nextElement();
		%>
			<li><%=param %> = <%=application.getInitParameter(param) %>
		<%
			}
		%>
	</ul>
</body>
</html>