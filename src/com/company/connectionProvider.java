package com.company;
import java.sql.Connection;
import java.sql.DriverManager;


public class connectionProvider {
    static Connection conn;

    public static Connection createConnection(){
        try{
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
