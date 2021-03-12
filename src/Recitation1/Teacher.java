package Recitation1;

public class Teacher {
	boolean tenure;
	String name;
	String department;
	
	public Teacher() {
		this.tenure = true;
		this.name = "John";
		this.department = "Math";
	}
	
	public String getName() {
		return name;
	}
	public boolean getTenure() {
		return tenure;
	}
	public String getDepartment() {
		return department;
	}
	
}
