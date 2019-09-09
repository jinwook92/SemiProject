package com.kic.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.Service.BoardService;
import com.kic.VO.MultiSubVO;
import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class SubDetailAction implements Action {

    @Override
    public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        int num = Integer.parseInt(request.getParameter("num"));
        BoardService service = BoardService.getInstance();
        List<MultiSubVO> list = service.subDetailService(num);
        request.setAttribute("sublist", list);

        ForwardAction forward = new ForwardAction();
        forward.setRedirect(false);
        forward.setPath("/board/sub.jsp");
        return forward;
    }

}
