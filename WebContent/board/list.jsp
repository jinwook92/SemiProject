<%@page import="com.kic.VO.MultiBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script>
  $(document).ready(function(){
	   $('#add').click(function(){
		     location.href="add.do";
	   });
	  
	  
	  
  });
  


</script>
</head>
<body>
<%
   List<MultiBoardVO> list=(List<MultiBoardVO>) request.getAttribute("list");
%>
<table>
<thead>
<tr><th>번호</th><th>제목</th></tr>
</thead>
<tbody>
 <%
    for(int i=0; i<list.size(); i++)
    {
    	MultiBoardVO data=list.get(i);
    	%>
      <tr><td><%=data.getBoardnum()%></td><td><a href="detail.do?num=<%=data.getBoardnum()%>"><%=data.getTitle()%></a></td></tr>	
   <% 
    }
 
 %>
</tbody>
</table>
<button id="add">추가</button>


</body>
</html>