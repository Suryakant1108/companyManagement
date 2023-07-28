package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDao {
    public static boolean insertEmployeeToDB(employees emp){
        boolean flag = false;
        try {
            Connection conn = connectionProvider.createConnection();
            String query ="insert into company(name,number,city)values(?,?,?)";
            //PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(query);
            // set the values of parameter
            pstmt.setString(1,emp.getEmployeesName());
            pstmt.setString(2,emp.getEmployeesPhone());
            pstmt.setString(3,emp.getEmployeestCity());

            //execute
            pstmt.executeUpdate();
            flag=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean deleteEmployees(int employId) {
        boolean flag = false;
        try {
            Connection conn = connectionProvider.createConnection();
            String query ="delete from company where id=?";
            //PreparedStatement
            PreparedStatement pstmt = conn.prepareStatement(query);
            // set the values of parameter
            pstmt.setInt(1,employId);

            //execute
            pstmt.executeUpdate();
            flag=true;

        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    public static void showAllDetail() {

        try {
            Connection conn = connectionProvider.createConnection();
            String query ="select * FROM company";
            Statement stmt = conn.createStatement();
            ResultSet set = stmt.executeQuery(query);
            //execute
           while(set.next()){
               int id = set.getInt(1);
               String name = set.getString(2);
               String number = set.getString(3);
               String city = set.getString(4);
               System.out.println("ID : "+id);
               System.out.println("Name : "+name);
               System.out.println("Phone number : "+number);
               System.out.println("City : "+city);
               System.out.println("++++++++++++++++++++++++++++++++++++++++++");

           }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static boolean update() {
        boolean flag = false;
        try {
            Connection conn = connectionProvider.createConnection();
            String query ="UPDATE `company` SET `name`= ? ,`number`= ? ,`city`= ?  WHERE `id` = ? ";
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Id which you want to update the data of the employees");
            int id = Integer.parseInt(br.readLine());

            System.out.println("Enter the new Name of the employees");
            String name = br.readLine();
            System.out.println("Enter new number : ");
            String number = br.readLine();
            System.out.println("Enter new city : ");
            String city = br.readLine();

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,name);
            pst.setString(2,number);
            pst.setString(3,city);
            pst.setInt(4,id);

            pst.executeUpdate();
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}

