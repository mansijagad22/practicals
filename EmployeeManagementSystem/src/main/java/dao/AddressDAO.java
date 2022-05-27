package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DbConnection;
import entity.Address;
import entity.Project;

public class AddressDAO {
	
	public AddressDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	static Connection con = DbConnection.getConnection();
	
	// to insert new prooject with default status upcoming
		public int insertNewAddress(Address address) {
			int status = 0;
			System.out.print("insert into addresses " + "(street,city, state,emp_id,pin_code) " + "values (?,?,?,?,?)");
			try {
				PreparedStatement ps = con
						.prepareStatement("insert into addresses (street,	city,	state,	emp_id,	pin_code) values (?,?,?,?,?)");
				ps.setString(1, address.getStreet());
				ps.setString(2, address.getCity());
				ps.setString(3, address.getState());
				ps.setInt(4, address.getEmpId());
				ps.setString(5, address.getPinCode());
				status = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				printSQLException(e);
			}
			System.out.printf("insert status is : ",status);
			return status;
		

		}
		public List<Address> selectAddDetailsByEmpId(int id) {
			List<Address> addressList = new ArrayList<Address>();
			try {
				PreparedStatement ps = con.prepareStatement("select * from addresses where emp_id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					int addId = rs.getInt("address_id");
					String street = rs.getString("street");
					String city = rs.getString("city");
					String state = rs.getString("state");
					String pinCode = rs.getString("pin_code");
					addressList.add(new Address(addId,street,city,state,pinCode));

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return addressList;
			
		}
		public ArrayList<String> selectStreetDetailByEmpId(int id) {
			ArrayList<String> ar = new ArrayList<String>();
			try {
				PreparedStatement ps = con.prepareStatement("select street from addresses where emp_id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String street = rs.getString("street");
					ar.add(street);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ar;
			
		}
		public ArrayList<String> selectCityDetailByEmpId(int id) {
			ArrayList<String> ar = new ArrayList<String>();
			try {
				PreparedStatement ps = con.prepareStatement("select city from addresses where emp_id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String city = rs.getString("city");
					ar.add(city);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ar;
			
		}
		public ArrayList<String> selectStateDetailByEmpId(int id) {
			ArrayList<String> ar = new ArrayList<String>();
			try {
				PreparedStatement ps = con.prepareStatement("select state from addresses where emp_id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String state = rs.getString("state");
					ar.add(state);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ar;
			
		}
		public ArrayList<String> selectPinCodeDetailByEmpId(int id) {
			ArrayList<String> ar = new ArrayList<String>();
			try {
				PreparedStatement ps = con.prepareStatement("select pin_code from addresses where emp_id = ?");
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					String pinCode = rs.getString("pin_code");
					ar.add(pinCode);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return ar;
			
		}
		public Boolean updateAddressByAddIdAndEmpId(Address a) {
			boolean rowUpdated = false;
			PreparedStatement ps;
			try {
				ps = con.prepareStatement(
						"UPDATE addresses SET street= ?,city=?,state=?,pin_code=? where emp_id=? and address_id=?");
				ps.setString(1,a.getStreet());
				ps.setString(2,a.getCity());
				ps.setString(3,a.getState());
				ps.setString(4, a.getPinCode());
				ps.setInt(5, a.getEmpId());
				ps.setInt(6, a.getAddId());
				rowUpdated = ps.executeUpdate() > 0;

			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
			return rowUpdated;

			}
		public void deleteById(int id) {
			boolean rowDeleteFromAddress = false;
			try {

				PreparedStatement ps = con.prepareStatement("delete from addresses where address_id = ?");
				ps.setInt(1, id);
				rowDeleteFromAddress = ps.executeUpdate() > 0;

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		public void deleteAddressByEmpId(int id) {
//			boolean rowDeleteFromAddress = false;
//			try {
//				PreparedStatement ps = con.prepareStatement("select * from addresses where emp_id = ?");
//				ps.setInt(1, id);
//				ResultSet rs = ps.executeQuery();
//				while(rs.next()) {
//					if(rs.getString("street")==null && rs.getString("city")==null && rs.getString("state")==null && rs.getString("pin_code")==null) {
//						PreparedStatement ps1 = con.prepareStatement("delete from addresses where address_id =?");
//						System.out.println("IN the delete address ");
//						ps1.setInt(1, rs.getInt("address_id"));
//						rowDeleteFromAddress = ps1.executeUpdate() > 0;
//					}
//				}
//				
//
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}

		private void printSQLException(SQLException e) {
			// TODO Auto-generated method stub
			
		}

}
