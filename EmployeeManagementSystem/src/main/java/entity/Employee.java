package entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Employee {
	private int empId;
	private String empName;
	private String mobNo;
	private Date dob;
	private String hobbies;
	private int isAdmin;
	private String email;
	private int projectId;
	private int addressId;

	public Employee(int empId, String empName, String mobNo, Date dob, String hobbies,
			int isAdmin, String email, int projectId, String password) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.mobNo = mobNo;
		this.dob = dob;
		this.hobbies = hobbies;
		this.isAdmin = isAdmin;
		this.email = email;
		this.projectId = projectId;
		this.password = password;
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId2, String empName2) {
		this.empId = empId2;
		this.empName = empName2;
		// TODO Auto-generated constructor stub
	}

	public Employee(String empName2) {
		// TODO Auto-generated constructor stub
		this.empName = empName2;
	}

	private String password;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getMobNO() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
}
