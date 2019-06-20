package com.kic.Controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;


public class DelAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String n=request.getParameter("num");
		String fname=request.getParameter("fname");
		ForwardAction forward=new ForwardAction();
		System.out.println(n);
		
		if(n==null || n=="" || n.equals(""))
		{
			forward.setRedirect(true);	
			forward.setPath("list.do");
		}else
		{
			try{
			  int num=Integer.parseInt(n);	
			 BoardService service=BoardService.getInstance();
			  service.delService(num);
			 String path=request.getServletContext().getRealPath("/upload"); 
			 String filepath=path+"/"+fname; 
			 
			 File f=new File(filepath);
			   f.delete();
			   
			  forward.setRedirect(true);
			 forward.setPath("list.do");
			  
			}catch(NumberFormatException e)
			{
				forward.setRedirect(true);
				forward.setPath("list.do");
			}catch(Exception e)
			{
				forward.setRedirect(true);
				forward.setPath("list.do");
			}
			
		}
		
		
		return forward;
	}

}
