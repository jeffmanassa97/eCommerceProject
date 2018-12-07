package login.sumit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;



public class CustomerDAO {

	static Connection con;
	static PreparedStatement ps;
	// Inserting Customer into the database
	
	public int insertCustomer(Customer c) {
		int status = 0;
		
		Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		
		try {
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("INSERT INTO Customer VALUES(?,?,?,?,?,?,?,?)");
			// Setting the columns of the table
			ps.setString(1, c.getCustomerID());
			ps.setString(2, c.getFirstName());
			ps.setString(3, c.getLastName());
			ps.setString(4, c.getPassword());
			ps.setString(5, c.getPhone());
			ps.setString(6, c.getEmail());
			ps.setString(7, c.getAddress());
			ps.setTimestamp(8, ourJavaTimestampObject);

			// Execute the preparedStatement - returns 1 if there was a statement, 0 if not
			// executeUpdate is for updating database with INSERT UPDATE or DELETE
			status = ps.executeUpdate();
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return status;
	}
	
	
	// Purpose of this is to store the customer in an object, and find the name associated with the customer
	
	public Customer getCustomer(String email, String pass) {
		Customer c = new Customer();
		int num = 0;
		try {
			
			con = MyConnectionProvider.getCon();
			ps = con.prepareStatement("SELECT * FROM customer WHERE email=? AND Password=?");
			ps.setString(1, email);
			ps.setString(2, pass);
			
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs = ps.executeQuery();
			
			// Cursor moves forward one row at a time until last row, then returns false
			while(rs.next()) {
		
				
				c.setCustomerID(rs.getString(1));
				c.setFirstName(rs.getString(2));
				c.setLastName(rs.getString(3));
				c.setPassword(rs.getString(4));
				c.setPhone(rs.getString(5));
				c.setEmail(rs.getString(6));
				c.setAddress(rs.getString(7));
				
				num++;
			}
			
			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(num > 0)
			return c;
		else
			return null;
	}
}
