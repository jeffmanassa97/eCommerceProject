package login.sumit.registration;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;
import java.util.Calendar;
import java.util.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class LoginRegister
 */
@WebServlet("/LoginRegister")
public class LoginRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CustomerDAO cd = new CustomerDAO();
		String email = request.getParameter("email");
		String password = request.getParameter("password1");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String submitType = request.getParameter("submit");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		Customer c = cd.getCustomer(email, password);
		// determining what page sent us here, login or register
		if (submitType.equals("Login") && c != null && c.getEmail() != null) {
			
			Connection con;
			
			try {
				
			// Update TIMSTAMP for when customer logging in
			con = MyConnectionProvider.getCon();
			PreparedStatement ps1;
			Calendar calendar = Calendar.getInstance();
		    java.sql.Timestamp ourJavaTimestampObject = new java.sql.Timestamp(calendar.getTime().getTime());
		    ps1 = con.prepareStatement("UPDATE Customer SET Last_login = ? WHERE customer_id = ?;");
			ps1.setTimestamp(1, ourJavaTimestampObject);
			ps1.setString(2, c.getCustomerID());
			
			ps1.executeUpdate();
			
			}
			catch (Exception e) {
				System.out.println(e);
			}		
			
		    
			request.getRequestDispatcher("shop.jsp").forward(request, response);
			
			

		} else if (submitType.equals("Register")) {
			Random rand = new Random();
			int num = rand.nextInt(100000000) + 1;
			String val = Integer.toString(num);
			
			Customer cust = new Customer();
			
			// Make a new customer
			cust.setCustomerID(val);
			cust.setFirstName(firstname);
			cust.setLastName(lastname);
			cust.setEmail(email);
			cust.setAddress(address);
			cust.setPhone(phone);
			cust.setPassword(password);
			cd.insertCustomer(cust);
			
			// path, return updated response from altered request
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {
			// path, return updated response from altered request
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
