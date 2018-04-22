package com.pwh.service;

import com.pwh.dao.LoginDao;

public class LoginService {
    public boolean login( String username,String password){
        boolean b=new LoginDao().login(username,password);
        return b;
    }
}
