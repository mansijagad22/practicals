package dao;

import java.sql.SQLException;

import org.apache.commons.lang3.RandomStringUtils;

import entity.Employee;

public class MailService {

	
	private EmployeeDAO empDao;
	public String resetCustomerPassword(String email) throws SQLException {
	    Employee emp = empDao.findByEmail(email);
	     
	    String randomPassword = RandomStringUtils.randomAlphanumeric(10);
	     
	    emp.setPassword(randomPassword);
	    empDao.updateEmpPassword(emp.getEmpId(),emp.getPassword());
	     
	    return randomPassword;
	}
}
