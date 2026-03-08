package Employee;

public class Employee {
	String name;
	String department;
	int age;
	String gender;
	
	public Employee(String name, String department,int age, String gender) {
		this.name = name;
		this.department = department;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getGender() {
		return gender;
	}
	
	@Override
	public String toString() {
		return name + " "  + " (" + department + ", " + age + ", " + gender + ")";
	}
	
	

}
