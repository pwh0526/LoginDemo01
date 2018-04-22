package com.pwh.servlet;

import com.pwh.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println(username );
        System.out.println(password );
        boolean b= new LoginService().login(username,password);

        if(b){
            //System.out.printf("");
            resp.getOutputStream().write("登陆成功".getBytes());
        }
        else{
            resp.getOutputStream().write("登陆失败".getBytes());
        }
       // super.service(req, resp);
    }
}
