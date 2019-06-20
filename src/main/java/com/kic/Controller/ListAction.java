package com.kic.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.VO.MultiBoardVO;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class ListAction implements Action {

	@Override
	public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	      BoardService service=BoardService.getInstance();
	      List<MultiBoardVO> list=service.ListService();
		   request.setAttribute("list", list);
	      ForwardAction forward=new ForwardAction();
	      forward.setRedirect(false);
	      forward.setPath("/board/list.jsp");
	      
	      
		return forward;
	}

}





