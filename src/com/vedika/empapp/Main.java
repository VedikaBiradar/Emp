package com.vedika.empapp;


import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    int id;
    String name;
    EmployeeInterface ei=new EmployeeInterfaceImp();
    System.out.println("Welcome to Employee Management App");
    Scanner sc=new Scanner(System.in);
    do{
      System.out.println("1. Create Emplyee\n" +
                          "2. Show All Emplyee\n" +
              "3. Show Empoyee Based on ID\n"+
              "4. Update Emplyee\n"+
              "5. Delete Employee\n");
      System.out.println("Enter your choice");
      int ch=sc.nextInt();
      switch(ch){
        case 1:
          Employee emp=new Employee();
          System.out.println("Enter id");
           id=sc.nextInt();
          System.out.println("Enter name");
          name=sc.next();
          System.out.println("Enter salary");
          int salary=sc.nextInt();
          System.out.println("Enter age");
          int age=sc.nextInt();
          emp.setId(id);
          emp.setName(name);
          emp.setSalary(salary);
          emp.setAge(age);
          ei.createEmployee(emp);
          break;
        case 2:
          ei.showAllEmployee();
          break;
        case 3:
          System.out.println("ENTER EMPLOYEE ID");
          int empid=sc.nextInt();
          ei.showEmployeeBasedOnID(empid);
          break;
        case 4:
          System.out.println("ENTER EMPLOYEE ID TO UPDATE NAME");

          id=sc.nextInt();
          System.out.println("ENTER THE NEW NAME FOR EMPLOYEE ID"+id + "\n");
          name=sc.next();
          ei.updateEmployee(id,name);
          break;
        case 5:
          System.out.println("ENTER EMPLOYEE ID TO DELETE ");
          id=sc.nextInt();
          ei.deleteEmployee(id);
          break;
        case 6:
          System.out.println("THANK YOU FOR USING OUR APP!");
          System.exit(0);
          break;
        default:
          System.out.println("ENTER VALID CHOICE");

      }
    }while(true);


  }
}
