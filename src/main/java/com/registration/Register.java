package com.registration;
import jakarta.servlet.*;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.*;

import java.io.*;
import java.sql.*;


@MultipartConfig
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name=req.getParameter("user_name");
        String password=req.getParameter("user_password");
        String emailId=req.getParameter("user_email");
        Part part= req.getPart("image");
        String filename=part.getSubmittedFileName();
        //out.println(filename);

        try {
            Thread.sleep(2000);
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/yt","root","Ramesh@#$&2011");
            String query="insert into user(name,password,email,imageName) values(?,?,?,?)";
            PreparedStatement pstmt=con.prepareStatement(query);

            pstmt.setString(1,name);
            pstmt.setString(2,password);
            pstmt.setString(3,emailId);
            pstmt.setString(4,filename);

            pstmt.executeUpdate();

            InputStream is=part.getInputStream();
            byte []data=new byte[is.available()];

            is.read(data);
            String path=req.getRealPath("/")+"img"+ File.separator+filename;


            FileOutputStream fos=new FileOutputStream(path);

            fos.write(data);
            fos.close();


            out.println("done");

        } catch (ClassNotFoundException | SQLException e) {
            out.println("error");
            throw new RuntimeException(e);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
