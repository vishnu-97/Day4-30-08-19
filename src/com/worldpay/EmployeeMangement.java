package com.worldpay;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

public class EmployeeMangement {
	private static ArrayList<Employee> ea=new ArrayList<>();
	private static HashMap<String, ArrayList<Employee>> h=new HashMap<>();
	
	
	private static int createEno() {
		if(!ea.isEmpty())
			return ea.get(ea.size()-1).getEno()+1;
		else
			return 1;
	}
	
//	Add Employee
	static void addEmployee(Employee e) {
		e.setEno(createEno());
		ea.add(e);
		addToDepartment(e);
		System.out.println("Your Employee Id ="+e.getEno());
	}
	
//	View All Employees
	static void viewAllEmployees() {
		ListIterator<Employee> it=ea.listIterator();
		System.out.println("Employeeno   \tName \t\tSalary \tDesignation \tDepartment");
		while(it.hasNext()) {
			Employee e=it.next();
			System.out.println(e.getEno() + " \t\t" + e.getEname()+ " \t\t" + e.getSalary() + " \t" + e.getDesignation()+ " \t\t"+e.getDepartment());
		}
	}
	
//	Remove Employee
	static void removeEmployee(int id) {
		Employee e=searchEmployee(id);
		if(e!=null) {
			System.out.println(e.getEname()+" was removed");
			ea.remove(e);
		}
		else {
			System.out.println("Invalid EmployeeNo");
		}
	}

	static void clearData() {
		ea.clear();
	}
	
//	Change Salary
	static void changeSalary(int id,int sal) {
		Employee e=searchEmployee(id);
		
		if(e!=null) {
			e.setSalary(sal);
			System.out.println(e.getEname()+" salary was changed");
				
		}
		else {
			System.out.println("Invalid EmployeeNo");
		}
		
	}
	
//	Search Employee
	static Employee searchEmployee(int id) {
		ListIterator<Employee> it=ea.listIterator();
		while(it.hasNext()) {
			Employee e=it.next();
			if(e.getEno()==id) {
				return e;
			}
		}
		return null;
	}
	
//	add employee to department map
	static void addToDepartment(Employee e) {
		if(!h.containsKey(e.getDepartment())) {

			h.put(e.getDepartment(), new ArrayList<>());
			
		}
		h.get(e.getDepartment()) .add(e);
	}
//	department search
	static void viewDepartmentWise(String a) {
		System.out.println("Employeeno   \tName \t\tSalary \tDesignation \tDepartment");
		
			ListIterator<Employee> it=h.get(a).listIterator();
			while(it.hasNext()) {
				Employee e=it.next();
				System.out.println(e.getEno() + " \t\t" + e.getEname()+ " \t\t" + e.getSalary() + " \t" + e.getDesignation()+ " \t\t"+e.getDepartment());
				
			}
		
	}
}
