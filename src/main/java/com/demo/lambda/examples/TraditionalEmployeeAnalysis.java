package com.demo.lambda.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.lambda.examples.Employee.Gender;

public class TraditionalEmployeeAnalysis {
	
	/*interface Condition<T>{
		public boolean check(T t);
	}*/
	
	//public static List<Employee> getAllMaleEmployees(List<Employee> empList, Condition condition){

	public static List<Employee> getAllMaleEmployees(List<Employee> empList){
		List<Employee> maleEmpList = new ArrayList<>();
		for (Employee employee : empList) {
			if(employee.getGender().equals(Employee.Gender.MALE)){
				maleEmpList.add(employee);
			}
		}
		return maleEmpList;
	}
	
	public static List<Employee> getEmployeesAgeAbove30(List<Employee> empList){
		List<Employee> above30EmpList = new ArrayList<>();
		for (Employee employee : empList) {
			if(employee.getAge() > 30){
				above30EmpList.add(employee);
			}
		}
		return above30EmpList;
	}
	
	//firstName starting with H >> if(employee.getFirstName().startsWith("H")){
	
	//even numbered employee Ids >> if(employee.getId()%2==0){
	
	public static List<Employee> getEmployeesFirstNameStartingWithH(List<Employee> empList){
		List<Employee> above30EmpList = new ArrayList<>();
		for (Employee employee : empList) {
			if(employee.getFirstName().startsWith("H")){
				above30EmpList.add(employee);
			}
		}
		return above30EmpList;
	}

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(
				new Employee(1, "Harry", "Jones", 25, Gender.MALE),
				new Employee(2, "Ravi", "Bernard", 28, Gender.MALE),
				new Employee(3, "Santhosh", "Kumar", 31, Gender.MALE),
				new Employee(4, "Helon", "Grace", 32, Gender.FEMALE),
				new Employee(5, "Mary", "Anning", 29, Gender.FEMALE)
				);
		
		System.out.println(getAllMaleEmployees(empList));
		System.out.println(getEmployeesAgeAbove30(empList));
	}

}
