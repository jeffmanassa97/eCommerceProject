package login.sumit.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection con;
		try {
			
		con = MyConnectionProvider.getCon();
		
		// DEALING WITH REVIEWS
		String submitType = request.getParameter("review1"); // SKU
		String title = request.getParameter("title"); // Review Title
		String stars = request.getParameter("stars"); // Stars
		String body = request.getParameter("review_body"); // Review Body
		
		// Get customer who has most recently logged in
		PreparedStatement ps0;
		ps0 = con.prepareStatement("SELECT Customer.customer_id, Product.SKU, Customer.first_name FROM Customer, Product WHERE Customer.customer_id = (SELECT customer_id FROM Customer WHERE Last_Login = (SELECT MAX(Last_Login) FROM Customer)) and Product.SKU = ?;");
		ps0.setString(1, submitType);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs0 = ps0.executeQuery();
		
		String customer_id = "";
		String sku = "";
		String customer_name = "";
		
		while(rs0.next()) {		
			customer_id = rs0.getString(1);
			sku = rs0.getString(2);
			customer_name = rs0.getString(3);
		}
		
		ps0.close();
		rs0.close();
		
		
		// Check if customer has already reviewed product, update their review
		PreparedStatement ps1;
		ps1 = con.prepareStatement("SELECT customer_id, product_id FROM Reviews WHERE customer_id = ? and product_id = ?;");
		ps1.setString(1, customer_id);
		ps1.setString(2, sku);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs1 = ps1.executeQuery();
		
		String temp1 = "test";
		String temp2 = "test1";
		
		// If the customer already reviewed product
		while(rs1.next()) {
			temp1 = rs1.getString(1);
			temp2 = rs1.getString(2);
		}
		
	
		ps1.close();
		rs1.close();
		
		// Update TimeStamp in Reviews
		Calendar calendar = Calendar.getInstance();
	    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
	 
	
		
		// Update review if customer had already reviewed -- one review per customer
		if((customer_id.equals(temp1)) && (sku.equals(temp2))){
			PreparedStatement ps2;
			ps2 = con.prepareStatement("UPDATE Reviews SET Title = ?, stars = ?, Time = ?, Review_body = ?  WHERE customer_id = ? and product_id = ?;");
			ps2.setString(1, title);
			ps2.setString(2, stars);
			ps2.setTimestamp(3, ourJavaTimestampObject);
			ps2.setString(4, body);
			ps2.setString(5, customer_id);
			ps2.setString(6, sku);
			
			ps2.executeUpdate();
			ps2.close();
		
			
			
			
			// Set all the reviews
			PreparedStatement ps6;
			ps6 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
			ps6.setString(1, sku);
			

			ResultSet rs6 = ps6.executeQuery();
			
			while(rs6.next()) {
			// Set attributes of reviews to send to the product page
				// First Review
				request.setAttribute("product_id1", rs6.getString(1));
				request.setAttribute("customer_id1", rs6.getString(2));
				request.setAttribute("stars1", rs6.getString(3));
				request.setAttribute("timestamp1", rs6.getString(4));
				request.setAttribute("review_body1", rs6.getString(5));
				request.setAttribute("title1", rs6.getString(6));
			
			}
			
			
			
			// Reset all product attributes for shop page
			// ----------------------------------------------------------------------------------------------
			// Is equals guitar
			if((sku.equals("111111111")) || (sku.equals("222222222")) || (sku.equals("333333333")) || (sku.equals("444444444")) || (sku.equals("555555555")) || (sku.equals("666666666")) || (sku.equals("777777777")) || (sku.equals("888888888")) || (sku.equals("999999999")) || (sku.equals("101010101"))){
				
				// Natural Join
							PreparedStatement ps8;
							ps8 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
							ps8.setString(1, sku);
							// ResultSet contains the data produced by the query
							// executeQuery is for passing selected values into a ResultSet
							ResultSet rs8 = ps8.executeQuery();
							
							while(rs8.next()) {
							// Set attributes to send to the product page
							request.setAttribute("SKU", rs8.getString(1));
							request.setAttribute("Name", rs8.getString(2));
							request.setAttribute("Cost", rs8.getString(3));
							request.setAttribute("Brand", rs8.getString(4));
							request.setAttribute("Description", rs8.getString(5));
							request.setAttribute("Count", rs8.getString(6));
							request.setAttribute("ImageURL", rs8.getString(7));
							
							request.setAttribute("Type", rs8.getString(8));
							request.setAttribute("Year", rs8.getString(9));
							request.setAttribute("String", rs8.getString(10));
							}
							
							ps8.close();
							rs8.close();
			con.close();
			
			request.setAttribute("Hertz", "Not Applicable");
			request.setAttribute("Subs", "Not Applicable");
			// Send to product page
			request.getRequestDispatcher("single.jsp").forward(request, response);	
			
			}
			else { // Amps
				// Natural Join
				PreparedStatement ps8;
				ps8 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps8.setString(1, sku);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs8 = ps8.executeQuery();
				
				while(rs8.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs8.getString(1));
				request.setAttribute("Name", rs8.getString(2));
				request.setAttribute("Cost", rs8.getString(3));
				request.setAttribute("Brand", rs8.getString(4));
				request.setAttribute("Description", rs8.getString(5));
				request.setAttribute("Count", rs8.getString(6));
				request.setAttribute("ImageURL", rs8.getString(7));
				
				request.setAttribute("Hertz", rs8.getString(8));
				request.setAttribute("Subs", rs8.getString(9));
				}
				
				ps8.close();
				rs8.close();
				con.close();
				// Send to product page
				request.getRequestDispatcher("single.jsp").forward(request, response);
			}
						
		} // end of if statement that closes UPDATE Review
		
		// ----------------------------------------------------------------------------------------------

		
		// Insert new customer review
		PreparedStatement ps3;
		ps3 = con.prepareStatement("INSERT INTO Reviews VALUES(?,?,?,?,?,?)");
		ps3.setString(1, sku);
		ps3.setString(2, customer_id);
		ps3.setString(3, stars);
		ps3.setTimestamp(4, ourJavaTimestampObject);
		ps3.setString(5, body);
		ps3.setString(6, title);
			
		ps3.executeUpdate();
		ps3.close();
		

		
		// Set all the reviews
		PreparedStatement ps6;
		ps6 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
		ps6.setString(1, sku);

		ResultSet rs6 = ps6.executeQuery();
		
		while(rs6.next()) {
		// Set attributes of reviews to send to the product page
			// First Review
			request.setAttribute("product_id1", rs6.getString(1));
			request.setAttribute("customer_id1", rs6.getString(2));
			request.setAttribute("stars1", rs6.getString(3));
			request.setAttribute("timestamp1", rs6.getString(4));
			request.setAttribute("review_body1", rs6.getString(5));
			request.setAttribute("title1", rs6.getString(6));
			// Second Review
			request.setAttribute("product_id2", rs6.getString(1));
			request.setAttribute("customer_id2", rs6.getString(2));
			request.setAttribute("stars6", rs6.getString(3));
			request.setAttribute("timestamp2", rs6.getString(4));
			request.setAttribute("review_body2", rs6.getString(5));
			request.setAttribute("title2", rs6.getString(6));
			// Third Review
			request.setAttribute("product_id3", rs6.getString(1));
			request.setAttribute("customer_id3", rs6.getString(2));
			request.setAttribute("stars3", rs6.getString(3));
			request.setAttribute("timestamp3", rs6.getString(4));
			request.setAttribute("review_body3", rs6.getString(5));
			request.setAttribute("title3", rs6.getString(6));
			// Fourth Review
			request.setAttribute("product_id4", rs6.getString(1));
			request.setAttribute("customer_id4", rs6.getString(2));
			request.setAttribute("stars4", rs6.getString(3));
			request.setAttribute("timestamp4", rs6.getString(4));
			request.setAttribute("review_body4", rs6.getString(5));
			request.setAttribute("title4", rs6.getString(6));
			// Fifth Review
			request.setAttribute("product_id5", rs6.getString(1));
			request.setAttribute("customer_id5", rs6.getString(2));
			request.setAttribute("stars5", rs6.getString(3));
			request.setAttribute("timestamp5", rs6.getString(4));
			request.setAttribute("review_body5", rs6.getString(5));
			request.setAttribute("title5", rs6.getString(6));


		}

		
		
		// Reset all product attributes for shop page
		
		// Is equals guitar
		if((sku.equals("111111111")) || (sku.equals("222222222")) || (sku.equals("333333333")) || (sku.equals("444444444")) || (sku.equals("555555555")) || (sku.equals("666666666")) || (sku.equals("777777777")) || (sku.equals("888888888")) || (sku.equals("999999999")) || (sku.equals("101010101"))){
			
			// Natural Join
						PreparedStatement ps8;
						ps8 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
						ps8.setString(1, sku);
						// ResultSet contains the data produced by the query
						// executeQuery is for passing selected values into a ResultSet
						ResultSet rs8 = ps8.executeQuery();
						
						while(rs8.next()) {
						// Set attributes to send to the product page
						request.setAttribute("SKU", rs8.getString(1));
						request.setAttribute("Name", rs8.getString(2));
						request.setAttribute("Cost", rs8.getString(3));
						request.setAttribute("Brand", rs8.getString(4));
						request.setAttribute("Description", rs8.getString(5));
						request.setAttribute("Count", rs8.getString(6));
						request.setAttribute("ImageURL", rs8.getString(7));
						
						request.setAttribute("Type", rs8.getString(8));
						request.setAttribute("Year", rs8.getString(9));
						request.setAttribute("String", rs8.getString(10));
						}
						
						ps8.close();
						rs8.close();
		con.close();
		
		request.setAttribute("Hertz", "Not Applicable");
		request.setAttribute("Subs", "Not Applicable");
		// Send to product page
		request.getRequestDispatcher("single.jsp").forward(request, response);	
		
		}
		else { // Amps
			// Natural Join
			PreparedStatement ps8;
			ps8 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
			ps8.setString(1, sku);
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs8 = ps8.executeQuery();
			
			while(rs8.next()) {
			// Set attributes to send to the product page
			request.setAttribute("SKU", rs8.getString(1));
			request.setAttribute("Name", rs8.getString(2));
			request.setAttribute("Cost", rs8.getString(3));
			request.setAttribute("Brand", rs8.getString(4));
			request.setAttribute("Description", rs8.getString(5));
			request.setAttribute("Count", rs8.getString(6));
			request.setAttribute("ImageURL", rs8.getString(7));
			
			request.setAttribute("Hertz", rs8.getString(8));
			request.setAttribute("Subs", rs8.getString(9));
			}
			
			ps8.close();
			rs8.close();
			con.close();
			// Send to product page
			request.getRequestDispatcher("single.jsp").forward(request, response);
		}

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
