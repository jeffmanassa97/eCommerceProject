package login.sumit.registration;

public class Orders {

	private String SKU;
	private String order_quant;
	private String order_cost;
	private String order_tax;
	private String customer_id;
	
	
	public String getSKU()
	{
		return SKU;
	}
	
	public void setSKU(String SKU)
	{
		this.SKU = SKU;
	}
	
	public String getOrderQuant()
	{
		return order_quant;
	}
	
	public void setOrderQuant(String order_quant)
	{
		this.order_quant = order_quant;
	}
	
	public String getOrderCost()
	{
		return order_cost;
	}
	
	public void setOrderCost(String order_cost)
	{
		this.order_cost = order_cost;
	}
	
	public String getOrderTax()
	{
		return order_tax;
	}
	
	public void setOrderTax(String order_tax)
	{
		this.order_tax = order_tax;
	}
	
	public String getCustomerID()
	{
		return customer_id;
	}
	
	public void setCustomerID(String customer_id)
	{
		this.customer_id = customer_id;
	}
}
