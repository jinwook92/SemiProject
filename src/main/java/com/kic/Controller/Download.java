package com.kic.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.iio.ios.IosDescriptor;

import oracle.net.aso.e;

/**
 * Servlet implementation class Download
 */
@WebServlet("/download.down")
public class Download extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doReq(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		 doReq(request,response);
	}
	
	private void doReq(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	 	 String file=request.getParameter("fname");
	     String folder = request.getServletContext().getRealPath("/upload");
	    
		 String filePath = folder + "/" + file;
		 FileInputStream fin=null;
		  try{
			    File f= new File(filePath);
		         byte b[] = new byte[100];
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition", "attachment;filename="+f.getName());
				response.setContentLength((int) f.length());
		    	
				if (f.isFile()) // 파일이 있을경우
				{
					
					fin= new FileInputStream(f);
					ServletOutputStream out= response.getOutputStream();
						
					int readNum = -1;
					while ( (readNum =fin.read(b)) != -1) {
						out.write(b, 0, readNum);
					}
					     out.close();
	           } //if
		  }catch(Exception e)
		  {
			  System.out.println("e 에러"+e);
		  }finally{
			  if(fin!=null) try{fin.close();} catch(IOException e){}
		  }
		}

}
