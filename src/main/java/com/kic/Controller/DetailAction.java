package com.kic.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.VO.MultiBoardVO;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class DetailAction implements Action {

    @Override
    public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String num = request.getParameter("num");
        int boardnum = 1;
        if (num != null && !num.equals(""))
            boardnum = Integer.parseInt(num);

        BoardService service = BoardService.getInstance();
        MultiBoardVO data = service.detailService(boardnum);
        request.setAttribute("data", data);
        ForwardAction forward = new ForwardAction();
        forward.setRedirect(false);
        forward.setPath("/board/detail.jsp");

        return forward;
    }

}




