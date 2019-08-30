package com.worldpay;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		Scanner in =new Scanner(System.in );
		do {
			System.out.println("\n\nPlease Enter"
					+ "\n1.Add Employee"
					+ "\n2.View All Employees"
					+ "\n3.Remove Employee"
					+ "\n4.Clear Data"
					+ "\n5.Change Salary"
					+ "\n6.Search Employee"
					+ "\n7.View Depart"
					+ "\n8.Exit");
			int o=in.nextInt();
			switch(o) {
			case 1:{
				in.nextLine();
				System.out.print("Name=");
				String n=in.nextLine();
				System.out.print("Salary="); 
				int s=in.nextInt();
				in.nextLine();
				
				System.out.print("Designation="); 
				String des=in.nextLine();
				System.out.print("Department="); 
				String dep=in.nextLine();
				EmployeeMangement.addEmployee(new Employee(n, s, des, dep));
				break;
			}
			case 2:{
				EmployeeMangement.viewAllEmployees();
				break;
			}
			case 3:{
				System.out.print("EmployeeNo="); 
				int id=in.nextInt();
				EmployeeMangement.removeEmployee(id);
				break;
			}
			case 4:{
				EmployeeMangement.clearData();
				break;
			}	
			case 5:{
				System.out.print("EmployeeNo="); 
				int id=in.nextInt();
				System.out.print("Salary="); 
				int sal=in.nextInt();
				EmployeeMangement.changeSalary(id, sal);;
				break;
			}
			case 6:{
				System.out.print("EmployeeNo="); 
				int id=in.nextInt();
				Employee e=EmployeeMangement.searchEmployee(id);
				if(e!=null)
				System.out.println(e);
				break;
			}
			case 7:{
//				System.out.print("Department="); 
//				in.nextLine();
//				
//				String dep=in.nextLine();
				EmployeeMangement.viewDepartmentWise();
				break;
			}
			case 8:{
				in.close();
				System.exit(0);
			}
			}	
		}while(true);
	}

}
