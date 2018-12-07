package login.sumit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductDAO {
	static Connection con;

	public Product getProduct(String SKU) {
		
		Product prod = new Product();
		Guitars g = new Guitars();
		Amps a = new Amps();
		
		
		try {
			
			con = MyConnectionProvider.getCon();
			
			// Product
			PreparedStatement ps1;
			ps1 = con.prepareStatement("SELECT * FROM Product WHERE SKU=?");
			ps1.setString(1, SKU);
			
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs1 = ps1.executeQuery();
			
			// Cursor moves forward one row at a time until last row, then returns false
			while(rs1.next()) {
				prod.setSKU(rs1.getString(1));
				prod.setName(rs1.getString(2));
				prod.setCost(rs1.getString(3));
				prod.setBrand(rs1.getString(4));
				prod.setDescription(rs1.getString(5));
				prod.setCount(rs1.getString(6));
				prod.setImageURL(rs1.getString(7));	
			}
			
			ps1.close();
			rs1.close();
			
			// Guitar
			PreparedStatement ps2;
			ps2 = con.prepareStatement("SELECT * FROM Guitar WHERE SKU=?");
			ps2.setString(1, SKU);
			
			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()) {
			g.setSKU(rs2.getString(1));
			g.setType(rs2.getString(2));
			g.setYear(rs2.getString(3));
			g.setStrings(rs2.getString(4));
			}
			
			ps2.close();
			rs2.close();
			
			// Amps
			PreparedStatement ps3;
			ps3 = con.prepareStatement("SELECT * FROM Amps WHERE SKU=?");
			ps3.setString(1, SKU);
			
			ResultSet rs3 = ps3.executeQuery();
			
			while(rs3.next()) {
			a.setSKU(rs3.getString(1));
			a.setHertz(rs3.getString(2));
			a.setSubs(rs3.getString(3));
			}
			
			ps3.close();
			rs3.close();
			
			// Close the database connection
			con.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return prod;
	}
	
}
