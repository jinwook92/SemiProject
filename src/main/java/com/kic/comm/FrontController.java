package com.kic.comm;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns={"*.do"}
        ,initParams={@WebInitParam(name="init"
        		, value="C:/class_data/jsp_class/multiBoard/WebContent/WEB-INF/prop.properties")}
		)
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
    
      Hashtable<String, Action> ht=new Hashtable<>();
	public void init(ServletConfig config) throws ServletException {
         String param=config.getInitParameter("init");
         Properties prop=new Properties();
          try{
             prop.load(new FileReader(param));
             Enumeration enu=prop.keys();
             while(enu.hasMoreElements())
             {
            	   String key=(String)enu.nextElement();
            	   String value=(String)prop.get(key);
            	 
            	 Class c=Class.forName(value);   
                 Action act=(Action)c.newInstance();            	   
                 ht.put(key, act);
             }
         } catch(FileNotFoundException e)
         {
        	 System.out.println(e);
         }catch(IOException e)
         {
        	 System.out.println(e);
         }catch(ClassNotFoundException e)
          {
        	 System.out.println(e);
          }catch(Exception e)
          {
        	  System.out.println(e);
          }

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 // http://localhost:8080/app/hello.do
		
		   String path=request.getServletPath();
		  Action act=ht.get(path);
		 ForwardAction forward=  act.execute(request, response);
		 if(forward != null)
		 {
		  if(forward.isRedirect())
			     response.sendRedirect(forward.getPath());
		   else
		   {
			   RequestDispatcher disp=request.getRequestDispatcher(forward.getPath());
			   disp.forward(request, response);
		   }
		 }
	}
	
	

}
