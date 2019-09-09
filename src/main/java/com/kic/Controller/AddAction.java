package com.kic.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kic.comm.Action;
import com.kic.comm.ForwardAction;

public class AddAction implements Action {

    @Override
    public ForwardAction execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        ForwardAction act = new ForwardAction();
        act.setRedirect(false);
        act.setPath("/board/add.jsp");

        return act;
    }

}
