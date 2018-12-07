package login.sumit.registration;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class ProductPage
 */
@WebServlet("/ProductPage")
public class ProductPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPage() {
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
		
		String submitType = request.getParameter("submit");
		
		if (submitType.equals("p1")) {
			
			String SKU = "111111111";
			// Natural Join
			PreparedStatement ps1;
			ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
			ps1.setString(1, SKU);
			// ResultSet contains the data produced by the query
			// executeQuery is for passing selected values into a ResultSet
			ResultSet rs1 = ps1.executeQuery();
			
			while(rs1.next()) {
			// Set attributes to send to the product page
			request.setAttribute("SKU", rs1.getString(1));
			request.setAttribute("Name", rs1.getString(2));
			request.setAttribute("Cost", rs1.getString(3));
			request.setAttribute("Brand", rs1.getString(4));
			request.setAttribute("Description", rs1.getString(5));
			request.setAttribute("Count", rs1.getString(6));
			request.setAttribute("ImageURL", rs1.getString(7));
			
			request.setAttribute("Type", rs1.getString(8));
			request.setAttribute("Year", rs1.getString(9));
			request.setAttribute("String", rs1.getString(10));
			}
			
			ps1.close();
			rs1.close();
			
			// Set all the reviews
			PreparedStatement ps2;
			ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
			ps2.setString(1, SKU);

			ResultSet rs2 = ps2.executeQuery();
			
			while(rs2.next()) {
				// Set attributes of reviews to send to the product page
					// First Review
					request.setAttribute("product_id1", rs2.getString(1));
					request.setAttribute("customer_id1", rs2.getString(2));
					request.setAttribute("stars1", rs2.getString(3));
					request.setAttribute("timestamp1", rs2.getString(4));
					request.setAttribute("review_body1", rs2.getString(5));
					request.setAttribute("title1", rs2.getString(6));
					

				}
				
			PreparedStatement ps3;
			ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

			ResultSet rs3 = ps3.executeQuery();
				
			while(rs3.next()) {
				// Set attributes of reviews to send to the product page
					// First Review
					request.setAttribute("best_name", rs3.getString(1));
					request.setAttribute("best_description", rs3.getString(2));
					request.setAttribute("best_cost", rs3.getString(3));
					request.setAttribute("best_imageurl", rs3.getString(4));
				}
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				
				
				
				request.getRequestDispatcher("single.jsp").forward(request, response);
			}
	else if (submitType.equals("p2")) {
				
				String SKU = "222222222";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
								



							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p3")) {
				
				String SKU = "333333333";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));


							}
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p4")) {
				
				String SKU = "444444444";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
								



							}
							
							
				
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p5")) {
				
				String SKU = "555555555";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
								



							}
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
							
							
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p6")) {
				
				String SKU = "666666666";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
								



							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
							
							
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p7")) {
				
				String SKU = "777777777";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
							}
							
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
							
							
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p8")) {
				
				String SKU = "888888888";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));

							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
							
							
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p9")) {
				
				String SKU = "999999999";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));

							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p10")) {
				
				String SKU = "101010101";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Guitar WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Type", rs1.getString(8));
				request.setAttribute("Year", rs1.getString(9));
				request.setAttribute("String", rs1.getString(10));
				}
				
				ps1.close();
				rs1.close();
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));

							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				
				con.close();
				
				request.setAttribute("Hertz", "Not Applicable");
				request.setAttribute("Subs", "Not Applicable");
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	//AMPS
	else if (submitType.equals("p11")) {
				
				String SKU = "121212121";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Hertz", rs1.getString(8));
				request.setAttribute("Subs", rs1.getString(9));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));

							}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				con.close();
				
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p12")) {
				
				String SKU = "131313131";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Hertz", rs1.getString(8));
				request.setAttribute("Subs", rs1.getString(9));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
								


							}
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				con.close();
				
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p13")) {
				
				String SKU = "141414141";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Hertz", rs1.getString(8));
				request.setAttribute("Subs", rs1.getString(9));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
							}
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				con.close();
				
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p14")) {
				
				String SKU = "151515151";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Hertz", rs1.getString(8));
				request.setAttribute("Subs", rs1.getString(9));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));

							}
							
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
				
				
				
				
				con.close();
				
				request.getRequestDispatcher("single.jsp").forward(request, response);
	}
	else if (submitType.equals("p15")) {
				
				String SKU = "161616161";
				// Natural Join
				PreparedStatement ps1;
				ps1 = con.prepareStatement("SELECT * FROM Product NATURAL JOIN Amps WHERE Product.SKU = ?;");
				ps1.setString(1, SKU);
				// ResultSet contains the data produced by the query
				// executeQuery is for passing selected values into a ResultSet
				ResultSet rs1 = ps1.executeQuery();
				
				while(rs1.next()) {
				// Set attributes to send to the product page
				request.setAttribute("SKU", rs1.getString(1));
				request.setAttribute("Name", rs1.getString(2));
				request.setAttribute("Cost", rs1.getString(3));
				request.setAttribute("Brand", rs1.getString(4));
				request.setAttribute("Description", rs1.getString(5));
				request.setAttribute("Count", rs1.getString(6));
				request.setAttribute("ImageURL", rs1.getString(7));
				
				request.setAttribute("Hertz", rs1.getString(8));
				request.setAttribute("Subs", rs1.getString(9));
				}
				
				ps1.close();
				rs1.close();
				
				
				// Set all the reviews
							PreparedStatement ps2;
							ps2 = con.prepareStatement("SELECT * FROM Reviews WHERE product_id = ?;");
							ps2.setString(1, SKU);

							ResultSet rs2 = ps2.executeQuery();
							
							while(rs2.next()) {
							// Set attributes of reviews to send to the product page
								// First Review
								request.setAttribute("product_id1", rs2.getString(1));
								request.setAttribute("customer_id1", rs2.getString(2));
								request.setAttribute("stars1", rs2.getString(3));
								request.setAttribute("timestamp1", rs2.getString(4));
								request.setAttribute("review_body1", rs2.getString(5));
								request.setAttribute("title1", rs2.getString(6));
						}
							
							PreparedStatement ps3;
							ps3 = con.prepareStatement("SELECT Name, Description, Cost, ImageURL FROM Product WHERE SKU =(SELECT SKU FROM Product WHERE Product.order_quant = (SELECT MAX(Product.order_quant) FROM Product));");

							ResultSet rs3 = ps3.executeQuery();
								
							while(rs3.next()) {
								// Set attributes of reviews to send to the product page
									// First Review
									request.setAttribute("best_name", rs3.getString(1));
									request.setAttribute("best_description", rs3.getString(2));
									request.setAttribute("best_cost", rs3.getString(3));
									request.setAttribute("best_imageurl", rs3.getString(4));
								}
			
			
			
			
			con.close();
			
			request.getRequestDispatcher("single.jsp").forward(request, response);
}
	
	}
	catch (Exception e) {
		System.out.println(e);
	}		
	
		
		
	}
}

