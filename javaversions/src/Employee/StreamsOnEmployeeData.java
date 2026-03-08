package Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamsOnEmployeeData {

	public static void main(String[] args) {
		Employee employee1 = new Employee("SRK", "ECE", 31, "Male");
		Employee employee2 = new Employee("Salman", "CS", 44, "Male");
		Employee employee3 = new Employee("Katrina", "ECE", 21, "Female");
		Employee employee4 = new Employee("Kareena", "CS", 34, "Female");
		Employee employee5 = new Employee("Hrithik", "EEE", 30, "Male");
		Employee employee6 = new Employee("Aish", "EEE", 25, "Female");

		List<Employee> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee5);
		employees.add(employee6);
		
		//Find the names of all EmployeeDtos in the CS department, sorted by age in descending order.
		
		List<String> names = employees.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed()).map(e->e.getName()).collect(Collectors.toList());
		System.out.println(names);
		
		// Group Employees by department and count how many Employees are in each department.
		
		Map<String,Long> employeeMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));
		System.out.println(employeeMap);
		
		// Find the youngest female Employee.
		
		Optional<Employee> youngestEmployee = employees.stream().filter(e->e.getGender().equals("Female")).
										sorted(Comparator.comparingInt(Employee::getAge)).limit(1).findFirst();
		System.out.println(youngestEmployee.get().getName());
		
		// Create a map of department -> list of Employee names.
		
		Map<String,List<String>> departmentMap = employees.stream().collect(Collectors.groupingBy
				(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(departmentMap);
		
		// Find the average age of Employees in each department.
		
		Double averageAge = employees.stream().collect(Collectors.averagingDouble(Employee::getAge));
		System.out.println(averageAge);
		
		//Get a list of unique departments Employees belong to.
		
		List<String> departments = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()))
								.entrySet().stream().map(e->e.getKey()).collect(Collectors.toList());
		System.out.println(departments);
		
		//Partition Employees into male and female groups, then list their names.
		
		Map<Boolean, List<Employee>> employeePartition = employees.stream().collect(Collectors.partitioningBy(e->e.getGender().equals("Male")));
		System.out.println(employeePartition);
		
		//Group employees by department, then within each department find the oldest employee
		
		Map<String, Optional<Employee>> departmentAgeMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(Employee::getAge))));
		System.out.println(departmentAgeMap);
		
		// Build a map of gender with average age of employees sorted by average age descending
		
		Map<String, Double> genderAgeMap = employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
		System.out.println(genderAgeMap);
		
		//For each department, find the youngest employee, but instead of returning the employee object, return only their name in uppercase.
		
		Map<String, String> youngestByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, 
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingInt(Employee::getAge)),e->e.get().getName())));
		System.out.println(youngestByDepartment);
	}

}
