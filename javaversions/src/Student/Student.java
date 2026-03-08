package Student;

public class Student {

	String firstName, lastName, city, department;
	double grade;
	int age;

	public Student(String firstName, String lastName, String city, double grade, int age, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.grade = grade;
		this.age = age;
		this.department = department;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + " (" + city + ", " + grade + ", " + age + ", " + department + ")";
	}

}
