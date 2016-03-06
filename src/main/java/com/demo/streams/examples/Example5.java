package com.demo.streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import com.demo.lambda.examples.Employee;
import com.demo.lambda.examples.Employee.Gender;

public class Example5 {
	
	public static int getAverageEmployeeAge(List<Employee> empList){
		int sum = 0;
		for (Employee employee : empList) {
			sum += employee.getAge();
		}
		return sum / empList.size();
	}

	public static void main(String[] args) {

		List<Employee> empList = Arrays.asList(
				new Employee(1, "Harry", "Jones", 25, Gender.MALE),
				new Employee(2, "Ravi", "Bernard", 28, Gender.MALE),
				new Employee(3, "Santhosh", "Kumar", 31, Gender.MALE),
				new Employee(4, "Helon", "Grace", 32, Gender.FEMALE),
				new Employee(5, "Mary", "Anning", 29, Gender.FEMALE)
				);
		
		System.out.println("Average employee age : " + getAverageEmployeeAge(empList));

		// lambda way
		OptionalDouble average = empList.stream()
								.mapToInt(e -> e.getAge())
								.average();
		
		System.out.println("Average employee age : " + (int)average.getAsDouble());
		
	}

}
