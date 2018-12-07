package login.sumit.registration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderReview
 */
@WebServlet("/OrderReview")
public class OrderReview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderReview() {
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
		
		
		// DEALING WITH ORDERS
		String submitType = request.getParameter("order1");
		
		PreparedStatement ps0;
		ps0 = con.prepareStatement("SELECT Customer.customer_id, Product.SKU, Product.Cost FROM Customer, Product WHERE Customer.customer_id = (SELECT customer_id FROM Customer WHERE Last_Login = (SELECT MAX(Last_Login) FROM Customer)) and Product.SKU = ?;");
		ps0.setString(1, submitType);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs0 = ps0.executeQuery();
		
		String customer_id = "";
		String sku = "";
		double cost = 0.00;
		
		while(rs0.next()) {		
			customer_id = rs0.getString(1);
			sku = rs0.getString(2);
			cost = Double.parseDouble(rs0.getString(3));
		}
		
		ps0.close();
		rs0.close();
		
		PreparedStatement ps1;
		ps1 = con.prepareStatement("SELECT customer_id, product_id, order_quant FROM Orders WHERE customer_id = ? and product_id = ?;");
		ps1.setString(1, customer_id);
		ps1.setString(2, sku);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs1 = ps1.executeQuery();
		
		String temp1 = "test";
		String temp2 = "test1";
		int temp4 = 0;
		
		// If the customer already ordered product
		while(rs1.next()) {
			temp1 = rs1.getString(1);
			temp2 = rs1.getString(2);
			temp4 = Integer.parseInt(rs1.getString(3));
		}
		
	
		ps1.close();
		rs1.close();
		
		//-------------------------------------------------------------------------------------------------
		// Update product order quantity
		PreparedStatement ps9;
		ps9 = con.prepareStatement("SELECT order_quant FROM Product WHERE SKU = ?;");
		ps9.setString(1, sku);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs9 = ps9.executeQuery();
		
		int quant = 0;
		
		// Get the current order quant for product
		while(rs9.next()) {
			quant = Integer.parseInt(rs9.getString(1));
		}
		
		
		ps9.close();
		rs9.close();
		
		quant++;
		PreparedStatement ps10;
		ps10 = con.prepareStatement("UPDATE Product SET order_quant = ? WHERE SKU = ?;");
		ps10.setString(1, Integer.toString(quant));
		ps10.setString(2, sku);
		
		ps10.executeUpdate();
		ps10.close();
	
	
		
		//-------------------------------------------------------------------------------------------------
		
		
		
		// Update quantity if customer has bought the product before
		if((customer_id.equals(temp1)) && (sku.equals(temp2))){
			temp4++;
			PreparedStatement ps2;
			ps2 = con.prepareStatement("UPDATE Orders SET order_quant = ? WHERE customer_id = ? and product_id = ?;");
			ps2.setString(1, Integer.toString(temp4));
			ps2.setString(2, customer_id);
			ps2.setString(3, sku);
			
			ps2.executeUpdate();
			ps2.close();
			
			PreparedStatement ps5;
			ps5 = con.prepareStatement("SELECT * FROM Orders WHERE customer_id = ? and product_id = ?;");
			ps5.setString(1, customer_id);
			ps5.setString(2, sku);
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs5 = ps5.executeQuery();
			
			// Set attributes
			while(rs5.next()) {
			request.setAttribute("customer_id", rs5.getString(1));
			request.setAttribute("product_id", rs5.getString(2));
			request.setAttribute("order_quant", rs5.getString(3));
			request.setAttribute("order_cost", rs5.getString(4));
			request.setAttribute("order_tax", rs5.getString(5));
			request.setAttribute("order_total", rs5.getString(6));
			}
			ps5.close();
			rs5.close();
			
			// ImageURL
			PreparedStatement ps6;
			ps6 = con.prepareStatement("SELECT ImageURL FROM Product WHERE SKU = ?;");
			ps6.setString(1, sku);
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs6 = ps6.executeQuery();
			
			// Set attributes
			while(rs6.next()) {
			request.setAttribute("ImageURL", rs6.getString(1));
			}
			
			ps6.close();
			rs6.close();
			con.close();
			
			// Send to order page
			request.getRequestDispatcher("order.jsp").forward(request, response);	
			
		}
		
		
		// Insert new customer order
		double tax = cost*0.07;
		double total = tax + cost;
		int i = 1;
			
		PreparedStatement ps3;
		ps3 = con.prepareStatement("INSERT INTO Orders VALUES(?,?,?,?,?,?)");
		ps3.setString(1, customer_id);
		ps3.setString(2, sku);
		ps3.setString(3, Integer.toString(i));
		ps3.setString(4, String.valueOf(cost));
		ps3.setString(5, String.valueOf(tax));
		ps3.setString(6, String.valueOf(total));
			
		ps3.executeUpdate();
		ps3.close();
		
		
		
	
		
		PreparedStatement ps4;
		ps4 = con.prepareStatement("SELECT * FROM Orders WHERE customer_id = ? and product_id = ?;");
		ps4.setString(1, customer_id);
		ps4.setString(2, sku);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs4 = ps4.executeQuery();
		
		// Set attributes
		while(rs4.next()) {
		request.setAttribute("customer_id", rs4.getString(1));
		request.setAttribute("product_id", rs4.getString(2));
		request.setAttribute("order_quant", rs4.getString(3));
		request.setAttribute("order_cost", rs4.getString(4));
		request.setAttribute("order_tax", rs4.getString(5));
		request.setAttribute("order_total", rs4.getString(6));
		}
		
		ps4.close();
		rs4.close();
		
		// ImageURL
		PreparedStatement ps7;
		ps7 = con.prepareStatement("SELECT ImageURL FROM Product WHERE SKU = ?;");
		ps7.setString(1, sku);
		// ResultSet contains the data produced by the query
		// executeQuery is for passing selected values into a ResultSet
		ResultSet rs7 = ps7.executeQuery();
					
		// Set attributes
		while(rs7.next()) {
		request.setAttribute("ImageURL", rs7.getString(1));
		}
		
		
		con.close();
	
		// Send to order page
		request.getRequestDispatcher("order.jsp").forward(request, response);

		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
