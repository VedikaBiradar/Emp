package com.vedika.empapp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeInterfaceImp implements EmployeeInterface{


    @Override
    public void createEmployee(Employee emp) {
        Connection con=DBConnection.createDBConnection();
        String query="insert into employee values(?,?,?,?)";

        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1, emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge());
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Created Successfully");
        }
        catch(Exception e){
            e.printStackTrace();
        }


    }

    @Override
    public void showAllEmployee() {
        Connection con=DBConnection.createDBConnection();
        String query=" select * from employee";
        System.out.println("EMPLOYEE DETAILS");
        System.out.println("-----------------------------------------------------");
        System.out.format("%s\t%s\t%s\t%s\n","ID", "Name", "Salary  ","Age");
        System.out.println("-----------------------------------------------------");
    try{
            Statement stmt= con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("-----------------------------------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        Connection con=DBConnection.createDBConnection();
        String query= " select * from employee where id="+id;
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%s\t%s\t%s\t%s\n","ID", "Name", "Salary  ","Age");
                System.out.println("-----------------------------------------------------");
                System.out.format("%d\t%s\t%f\t%d\n", result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        Connection con=DBConnection.createDBConnection();
        String query="update employee set name=? where id=?";
        try{
            PreparedStatement pstm= con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int count= pstm.executeUpdate();
            if(count!=0)
                System.out.println("EMPLOYEE DETAILS UPDATED SUCESSFULLY");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee(int id) {

            Connection con = DBConnection.createDBConnection();
            String query = "DELETE FROM employee WHERE id=?";
            try {
                PreparedStatement pstm = con.prepareStatement(query);
                pstm.setInt(1, id);
                int count = pstm.executeUpdate();
                if (count != 0)
                    System.out.println("EMPLOYEE DELETED SUCCESSFULLY: " + id +"\n");
            } catch (Exception e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }

}
