package com.demo.lambda.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.demo.lambda.examples.Employee.Gender;


public class FunctionalEmployeeAnalysis {
	
	public static List<Employee> filterEmployees(List<Employee> empList, Predicate<Employee> predicate){
		List<Employee> maleEmpList = new ArrayList<>();
		for (Employee employee : empList) {
			if(predicate.test(employee)){
				maleEmpList.add(employee);
			}
		}
		return maleEmpList;
	}
	
	public static void printEmployee(List<Employee> empList, Consumer<Employee> consumer){
		for (Employee employee : empList) {
			consumer.accept(employee);
		}
	}
	
	public Integer getEmployeeSerialId(Employee employee){
		return employee.getId() + 1000;
	}

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(
				new Employee(1, "Harry", "Jones", 25, Gender.MALE),
				new Employee(2, "Ravi", "Bernard", 28, Gender.MALE),
				new Employee(3, "Santhosh", "Kumar", 31, Gender.MALE),
				new Employee(4, "Helon", "Grace", 32, Gender.FEMALE),
				new Employee(5, "Mary", "Anning", 29, Gender.FEMALE)
				);
		/***************** Predicate Example ****************/
		
		Predicate<Employee> maleGenderPredicate = e -> e.getGender().equals(Employee.Gender.MALE);
		System.out.println("Male Employees \n " + filterEmployees(empList, maleGenderPredicate));
		
		Predicate<Employee> agePredicate = e -> e.getAge() > 30;
		System.out.println("Age Above 30 Employees \n " + filterEmployees(empList, agePredicate));
		
		/*************** Function Example ***********************/
		FunctionalEmployeeAnalysis empAnalysis = new FunctionalEmployeeAnalysis();
		Function<Employee, Integer> serialIdFunction = (e -> empAnalysis.getEmployeeSerialId(e));
		
		System.out.println("Serial Id " + serialIdFunction.apply(empList.get(2)));
		System.out.println("Serial Id " + serialIdFunction.apply(empList.get(4)));
		
		/********** Consumer Demo **************/
		Consumer<Employee> empFullDetails = e -> {
			System.out.println("Full Employee details : " + e.toString());
		};
		
		Consumer<Employee> empNames = e -> {
			System.out.format("\n First Name : %s , Last Name : %s ", e.getFirstName() , e.getLastName() );
		};
		
		printEmployee(empList, empFullDetails);
		printEmployee(empList, empNames);
		
	}

}
