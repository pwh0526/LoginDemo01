package com.pwh.dao;

import java.sql.*;

public class LoginDao {
    public static final String CLASS_NAME="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String URL="jdbc:sqlserver://127.0.0.1;DatabaseMetaData=TestLoginDemo";
    public static final String USERNAME="sa";
    public static final String PASSWORD="123456";
    public boolean login(String username,String password) {
        boolean loginSuccess=false;
        try {
            Class.forName(CLASS_NAME);
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = " select username from TestLoginDemo..t_users where username=? and password=? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            loginSuccess= rs.next();
            String s=rs.getString(1);
            System.out.println("user "+ s +" Login Success ");
            //if(rs.isClosed())
            rs.close();
            ps.close();
            conn.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return loginSuccess;
    }

}
