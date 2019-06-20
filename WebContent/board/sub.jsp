<%@page import="com.kic.VO.MultiSubVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
    table#sub{
         border-collapse: collapse;
          width:400px;
    }
     
     #sub td{ border-bottom:1px solid silver;
          height: 80px;
     }
  
</style>
<script>
  function del(data,ref)
  {
	  console.log(ref);
	  location.href="delsub.do?num="+data+"&refno="+ref;  
	  
  }
</script>


</head>
<body>



<table id="sub">
<%
     List<MultiSubVO> list=(List<MultiSubVO>) request.getAttribute("sublist");
%>
  <%
    for(int i=0; i<list.size(); i++)
    {
    	MultiSubVO data=list.get(i);
    	%>
    	<tr><td><%=data.getTitle()%></td>
    	<td><input type="button" value="삭제" 
    	onclick="del(<%=data.getSubno()%>,<%=data.getRefno()%>)"></td></tr>
     <% 	
    }
  %>
  </table>
</body>
</html>