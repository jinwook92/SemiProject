package com.kic.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class SubAddAction implements Action {

    @Override
    public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        request.setCharacterEncoding("utf-8");
        int num = Integer.parseInt(request.getParameter("num"));
        String title = request.getParameter("title");
        BoardService service = BoardService.getInstance();
        service.subAdd(num, title);
        ForwardAction forward = new ForwardAction();
        forward.setRedirect(true);
        forward.setPath("detail.do?num=" + num);

        return forward;
    }

}
