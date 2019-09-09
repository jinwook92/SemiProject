package com.kic.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class SubDelAction implements Action {

    @Override
    public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String n = request.getParameter("num");
        String n2 = request.getParameter("refno");
        ForwardAction forward = new ForwardAction();


        if (n == null || n == "" || n.equals("") || n2 == null || n2 == "" || n2.equals("")) {
            forward.setRedirect(true);
            forward.setPath("list.do");
        } else {
            try {
                int num = Integer.parseInt(n);
                int refno = Integer.parseInt(n2);
                BoardService service = BoardService.getInstance();
                service.subDel(num);
                forward.setRedirect(true);
                forward.setPath("detail.do?num=" + refno);

            } catch (Exception e) {
                forward.setRedirect(true);
                forward.setPath("list.do");
            }
        }


        return forward;
    }

}
