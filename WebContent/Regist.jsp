<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="bean.ListOutBean" scope="request" />
    <%@ page import="bean.KaiinListBean" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  登録しました
  <%for(KaiinListBean kb :bean.kList){ %>
  <%=kb.getString() %><br>
  <%} %>
  <form method="post" action="index.html">
    <input type="submit" value="戻る">
  </form>
</body>
</html>