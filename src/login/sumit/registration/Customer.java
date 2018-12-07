package login.sumit.registration;

public class Customer {
	private String first_name = "XXX";
	private String last_name = "XXX";
	private String phone = "0000000000";
	private String email = "XXX";
	private String address = "XXX";
	private String customer_id;
	private String password = "XXX";
	
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public String getCustomerID()
	{
		return customer_id;
	}
	
	public void setCustomerID(String customer_id)
	{
		this.customer_id = customer_id;
	}
	
	public String getFirstName()
	{
		return first_name;
	}
	
	public void setFirstName(String first_name)
	{
		this.first_name = first_name;
	}
	
	public String getLastName()
	{
		return last_name;
	}
	
	public void setLastName(String last_name)
	{
		this.last_name = last_name;
	}
	
	public String getPhone()
	{
		return phone;
	}
	
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address = address;
	}
	
}
