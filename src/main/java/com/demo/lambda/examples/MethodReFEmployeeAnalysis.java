package com.demo.lambda.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.demo.lambda.examples.Employee.Gender;

public class MethodReFEmployeeAnalysis {
	
	public static boolean IsMaleEmployee(Employee emp){
		System.out.println("IsMaleEmployee method invoked");
		return emp.getGender().equals(Gender.MALE);
	}
	
	public static Map<Employee, Double> getEmployeeScores(List<Employee> empList, Function<Integer, Double> function){
		HashMap<Employee, Double> scoreMap = new HashMap<>();
		empList.forEach(e -> scoreMap.put(e, (function.apply(e.getAge()) * 10.23)));
		return scoreMap;
	}
	
	
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
	
	public static <T,R> List<R> getEmpDetails(List<T> empList, Function<T, R> function){
		List<R> nameList = new ArrayList<>();
		empList.forEach(x -> nameList.add(function.apply(x)));
		return nameList;
	}
	
	

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee(1, "Harry", "Jones", 25, Gender.MALE),
				new Employee(2, "Ravi", "Bernard", 28, Gender.MALE),
				new Employee(3, "Santhosh", "Kumar", 31, Gender.MALE),
				new Employee(4, "Helon", "Grace", 32, Gender.FEMALE),
				new Employee(5, "Mary", "Anning", 29, Gender.FEMALE)
				);
		
		System.out.println("*************** Reference To Static Method ********************");
		//Predicate<Employee> maleGenderPredicate = e -> e.getGender().equals(Employee.Gender.MALE);
		Predicate<Employee> maleGenderPredicate = MethodReFEmployeeAnalysis::IsMaleEmployee;
		System.out.println("This line should be invoked before IsMaleEmployee");
		System.out.println("Male Employees \n " + filterEmployees(empList, maleGenderPredicate));
		
		System.out.println("***************************************************************");
		
		System.out.println("*************** Reference To instance method ********************");
		MethodReFEmployeeAnalysis empAnalysis = new MethodReFEmployeeAnalysis();
		//Function<Employee, Integer> serialIdFunction = (e -> empAnalysis.getEmployeeSerialId(e));
		Function<Employee, Integer> serialIdFunction = empAnalysis::getEmployeeSerialId;
		
		System.out.println("Serial Id " + serialIdFunction.apply(empList.get(2)));
		System.out.println("Serial Id " + serialIdFunction.apply(empList.get(4)));
		
		System.out.println("***************************************************************");
		
		System.out.println("*************** Reference To instance method using class name ********************");
		
		System.out.println("Employee First names : " + getEmpDetails(empList, Employee::getFirstName));
		System.out.println("Employee Last names : " + getEmpDetails(empList, Employee::getLastName));
		System.out.println("Employee Ids : " + getEmpDetails(empList, Employee::getId));
		
		System.out.println("***************************************************************");
		
		System.out.println("*************** Reference To constructor method ********************");
		Supplier<List<Employee>> empployeeList = ArrayList::new;
		System.out.println(empployeeList.get().size());
		
		//Map<Employee, Double> employeeScores = getEmployeeScores(empList, Double::new);
		//employeeScores.forEach((k, v) -> System.out.println("EmpName: " + k.getFirstName() + " Score " + v.doubleValue() )); ;
		
		System.out.println("***************************************************************");
		
		/*Consumer<Employee> empFullDetails = System.out::println;
		empList.forEach(empFullDetails);*/
	}

}
