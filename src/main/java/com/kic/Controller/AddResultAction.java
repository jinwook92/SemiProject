package com.kic.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddResultAction  implements Action{

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int fileSize= 50*1024*1024;
		String uploadPath = request.getServletContext().getRealPath("/upload");
		 MultipartRequest req
		  =new MultipartRequest(request,uploadPath,fileSize,"utf-8",new DefaultFileRenamePolicy());
		
		String title=req.getParameter("title");
		String content=req.getParameter("content");
		String fname=req.getFilesystemName("fname");
		
		
		
		BoardService service=BoardService.getInstance();
		service.AddService(title, content,fname);
		ForwardAction forward=new ForwardAction();
		forward.setRedirect(true);
		forward.setPath("list.do");
		
		return forward;
	}

}







