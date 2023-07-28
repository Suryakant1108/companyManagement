package com.company;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws IOException {
        getConnection();
        System.out.println("Welcome to company management");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println("Press 1 to ADD employees");
            System.out.println("Press 2 to delete employees");
            System.out.println("Press 3 to display employees");
            System.out.println("Press 4 to update employees");
            System.out.println("Press 5 to exit employees");
            int choice = Integer.parseInt(br.readLine());
            if(choice == 1){
                System.out.println("Enter employees name:");
                String name=br.readLine();
                System.out.println("Enter employees phone number:");
                String number=br.readLine();
                System.out.println("Enter employees city:");
                String city=br.readLine();

                employees emp = new employees(name,number,city);
                boolean ans = EmployeeDao.insertEmployeeToDB(emp);
                if(ans){
                    System.out.println("Employess details is added successfully");
                }else{
                    System.out.println("Something went wrong");
                }
//                System.out.println(emp);
            }else if(choice == 2){
                System.out.println("Enter employeeId to delete the employees data");
                int employId = Integer.parseInt(br.readLine());
                boolean ans = EmployeeDao.deleteEmployees(employId);
                if(ans){
                    System.out.println("Employess details deleted successfully");
                }else{
                    System.out.println("Something went wrong");
                }

            }else if(choice == 3){
                EmployeeDao.showAllDetail();

            }else if (choice == 4) {
                System.out.println("Update the details of the employees");
                boolean ans = EmployeeDao.update();
                if(ans){
                    System.out.println("Update successfully");
                }else{
                    System.out.println("Something went wrong");
                }
            }else if (choice == 5){
                break;
            }else{

            }
        }
        System.out.println("Thank for using my application");
    }
    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","");
            Class.forName(driver);
            System.out.println("Database Connected");
            return conn;

        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}