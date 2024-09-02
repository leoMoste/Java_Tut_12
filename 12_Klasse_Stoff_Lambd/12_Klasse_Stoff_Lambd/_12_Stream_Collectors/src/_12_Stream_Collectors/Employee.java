package _12_Stream_Collectors;

public class Employee {

	private String name;
	private String country;
	private String dept;
	private int salaryInUSD;
	private int graduationYear;
	
	
	public Employee(String name, String country, String dept, int salaryInUSD, int graduationYear) {
		this.name = name;
		this.country = country;
		this.dept = dept;
		this.salaryInUSD = salaryInUSD;
		this.graduationYear = graduationYear;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", country=" + country + ", dept=" + dept + ", salaryInUSD=" + salaryInUSD
				+ ", graduationYear=" + graduationYear + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getDept() {
		return dept;
	}


	public void setDept(String dept) {
		this.dept = dept;
	}


	public int getSalaryInUSD() {
		return salaryInUSD;
	}


	public void setSalaryInUSD(int salaryInUSD) {
		this.salaryInUSD = salaryInUSD;
	}


	public int getGraduationYear() {
		return graduationYear;
	}


	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}
	
	
	
	
	
}
