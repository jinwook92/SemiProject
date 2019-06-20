<%@page import="com.kic.VO.MultiBoardVO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
#aa{ width:400px;}
#result{
   margin-top:15px; 
   margin-left:30px;
   border:1px solid silver;
   width:500px;
   height:300px;
}

</style>

</head>
<script>
 function send()
 {
	  if(document.frm.title.value!="")
	    document.frm.submit();
 }

function deldata(num,fname)
	{
	    console.log(num);
	    console.log(fname);
	    //console.log("del.do?num="+num+"&fname="+fname);
		location.href="del.do?num="+num+"&fname="+fname;
		
	} 

 function view(num)
{
	 alert('hello3');
   console.log(num);
   $.ajax({
	   url:'subdetail.do'
	  ,data:"num="+num
	  ,dataType:'html' 
	  ,success:function(data)
	  {
		  console.log("success:"+data);		
		  $('#result').html(data);
	  }
	  ,error:function(e)
	  {
		  console.log('fail:'+e);
	  }
   });
  
} 



$(document).ready(function(){
	  var num=$('#test').text();
	  console.log(num);
	  $.ajax({
		   url:'subdetail.do'
		  ,data:"num="+num
		  ,dataType:'html' 
		  ,success:function(data)
		  {
			 // console.log("success:"+data);		
			  $('#result').html(data);
		  }
		  ,error:function(e)
		  {
			  console.log('fail:'+e);
		  }
	   });
	  
	  	
	 
  });
 
  
</script>

<body>
<%
  MultiBoardVO data=(MultiBoardVO)request.getAttribute("data");
%>
<table class="table table-hover" id="aa">
  <tr><td>번호</td><td id="test"><%=data.getBoardnum()%></td></tr>
  <tr><td>제목</td><td><%=data.getTitle()%></td></tr>
  <tr><td>내용</td><td><%=data.getContent() %></td></tr>
  <tr><td>파일이름</td>
  <td><a href="download.down?fname=<%=data.getFname()%>"><%=data.getFname()%></a></td></tr>
</table>
<form method="post" action="subadd.do?num=<%=data.getBoardnum()%>" name="frm">
<textarea rows="5" cols="50" name="title" id="title"></textarea>
<br>
<input type="button" onclick='send()'  value="추가">
</form>
<button onclick='deldata("<%=data.getBoardnum()%>","<%=data.getFname()%>")'>삭제</button><br>
<button onclick='view(<%=data.getBoardnum()%>)'>새로고침</button>

<div id="result"></div>

</body>
</html>