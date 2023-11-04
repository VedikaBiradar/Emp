package com.vedika.empapp;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    static Connection con;
    public static Connection createDBConnection(){

       try {
           //Load Driver
           Class.forName("com.mysql.cj.jdbc.Driver");

           //get Connection
           String url="jdbc:mysql://localhost:3306/employeedb?useSSL=false";
           String username="root";
           String pass="Careers@123";
          con= DriverManager.getConnection(url, username, pass);


       }catch(Exception e){
           e.printStackTrace();
       }
        return con;
    }
}
