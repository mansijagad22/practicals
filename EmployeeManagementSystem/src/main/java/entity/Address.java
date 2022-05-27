package entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Address {
	@JsonInclude(Include.ALWAYS)
	private int addId;
	@JsonInclude(Include.ALWAYS)
	private String street;
	@JsonInclude(Include.ALWAYS)
	private String city;
	@JsonInclude(Include.ALWAYS)
	private String state;
	@JsonInclude(Include.ALWAYS)
	private int empId;
	@JsonInclude(Include.ALWAYS)
	private String pinCode;
	
	public Address() {
		super();
	}
	public Address(int addId, String street, String city, String state, int empId, String pinCode) {
		super();
		this.addId = addId;
		this.street = street;
		this.city = city;
		this.state = state;
		this.empId = empId;
		this.pinCode = pinCode;
	}
	public Address(int addId2, String street2, String city2, String state2, String pinCode2) {
		// TODO Auto-generated constructor stub
		this.addId = addId2;
		this.street = street2;
		this.city = city2;
		this.state = state2;
		this.pinCode = pinCode2;
	}

	public int getAddId() {
		return addId;
	}
	
	public void setAddId(int addId) {
		this.addId = addId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
}
