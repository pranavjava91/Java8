package Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class AdvancedStreams {
	public static void main(String[] args) {

		List<Student> students = Arrays.asList(new Student("Rahul", "Sharma", "Hyderabad", 8.38, 19, "Civil"),
				new Student("Amit", "Verma", "Delhi", 8.4, 21, "IT"),
				new Student("Suresh", "Reddy", "Hyderabad", 7.5, 20, "Civil"),
				new Student("Kiran", "Patel", "Mumbai", 9.1, 20, "IT"),
				new Student("Arjun", "Naidu", "Bengaluru", 7.83, 20, "Civil"));

		// Find students from Hyderabad with a grade greater than 8.0

		List<Student> hyderabadGrades = students.stream().filter(s -> s.city.equals("Hyderabad") && s.grade > 8.0)
				.collect(Collectors.toList());
		System.out.println(hyderabadGrades);

		// Find the student with the highest grade

		double highestGrade = students.stream().max(Comparator.comparingDouble(s -> s.grade)).get().grade;
		System.out.println(highestGrade);

		// Count the number of students in each department

		Map<String, Long> studentDepartments = students.stream()
				.collect(Collectors.groupingBy(s -> s.department, Collectors.counting()));
		System.out.println(studentDepartments);

		// Find the average grade per department

		Map<String, Double> averageGrade = students.stream()
				.collect(Collectors.groupingBy(s -> s.department, Collectors.averagingDouble(s -> s.grade)));
		System.out.println(averageGrade);

		// List students sorted by age and then by grade

		List<Student> sortedStudents = students.stream()
				.sorted(Comparator.comparingInt((Student s) -> s.age).thenComparingDouble(s -> s.grade))
				.collect(Collectors.toList());

		System.out.println(sortedStudents);

		// Create a comma-separated list of student names

		List<String> namesList = students.stream().map(s -> s.firstName + " " + s.lastName)
				.collect(Collectors.toList());
		System.out.println(namesList);

		// Check if all students are above 18
		boolean ageCheck = students.stream().allMatch(s -> s.age > 18);
		System.out.println(ageCheck);

		// Find the department with the most students
		String popularDepartment = students.stream()
				.collect(Collectors.groupingBy(s -> s.department, Collectors.counting())).entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
		System.out.println(popularDepartment);
		
		//  Divide students into those who have grades above 8.0 and below
		Map<Boolean,List<Student>> highGrades = students.stream().collect(Collectors.partitioningBy(s->s.grade>8.0));
		System.out.println(highGrades);
		
		// Find the student with the longest full name
		
		Optional<Student> longestName = students.stream().max(Comparator.comparingInt(s->(s.firstName+s.lastName).length()));
		System.out.println(longestName.get().firstName + longestName.get().lastName);
		

	}

}
