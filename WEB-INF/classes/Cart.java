import java.util.*;
 
public class Cart implements java.io.Serializable{

	private int orderId;
	private String brandName;
	private String model;
	private double price;
	private String userId;
	private boolean buyWarranty;
	private Date deliveryDateTime;
	private int productId;
	private int quantity;
	ArrayList<Accessory> acc;
	public Cart(){

	}
	public Cart(String brandName, String model, double price, int orderId){
		
		this.brandName = brandName;
		this.model = model;
		this.price = price;
		this.orderId = orderId;

	}

	public Cart(String brandName, String model, double price, int orderId, String userId){
		
		this.brandName = brandName;
		this.model = model;
		this.price = price;
		this.orderId = orderId;
		this.userId = userId;

	}

	public Cart(String brandName, String model, double price, int orderId, String userId, 
		boolean buyWarranty, Date deliveryDateTime){
	
	this.brandName = brandName;
	this.model = model;
	this.price = price;
	this.orderId = orderId;
	this.userId = userId;
	this.buyWarranty = buyWarranty;
	this.deliveryDateTime = deliveryDateTime;

	}

	
	public Cart(String brandName, String model, double price, int orderId, String userId, 
		boolean buyWarranty, Date deliveryDateTime, int productId, ArrayList<Accessory> acc){
	
	this.brandName = brandName;
	this.model = model;
	this.price = price;
	this.orderId = orderId;
	this.userId = userId;
	this.buyWarranty = buyWarranty;
	this.deliveryDateTime = deliveryDateTime;
	this.productId = productId;
	this.acc=acc;
	}
	public Cart(String brandName, String model, double price, int orderId, String userId, 
		boolean buyWarranty, Date deliveryDateTime, int productId){
	
	this.brandName = brandName;
	this.model = model;
	this.price = price;
	this.orderId = orderId;
	this.userId = userId;
	this.buyWarranty = buyWarranty;
	this.deliveryDateTime = deliveryDateTime;
	this.productId = productId;
	
	}
	
	public Cart(String brandName, String model,int quantity, double price, int orderId, String userId, 
		boolean buyWarranty, Date deliveryDateTime, int productId, ArrayList<Accessory> acc){
	
	this.brandName = brandName;
	this.model = model;
	this.price = price;
	this.orderId = orderId;
	this.userId = userId;
	this.buyWarranty = buyWarranty;
	this.deliveryDateTime = deliveryDateTime;
	this.productId = productId;
	this.quantity=quantity;
	this.acc=acc;
	}
	public Cart(String brandName, String model,int quantity, double price, int orderId, String userId, 
		boolean buyWarranty, Date deliveryDateTime, int productId){
	
	this.brandName = brandName;
	this.model = model;
	this.price = price;
	this.orderId = orderId;
	this.userId = userId;
	this.buyWarranty = buyWarranty;
	this.deliveryDateTime = deliveryDateTime;
	this.productId = productId;
	this.quantity=quantity;
	}
	public ArrayList<Accessory> getAccs(){
		return acc;
	}	
	public void setAccs(ArrayList<Accessory> acc ){
		this.acc = acc;
	}


	public String getBrandName(){
		return brandName;
	}	
	public void setBrandName(String brandName){
		this.brandName = brandName;
	}
	public String getModel(){
		return model;
	}
	public void setModel(String model){
		this.model = model;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price){
		this.price = price;
	}
	public int getOrderId(){
		return orderId;
	}
	public void setOrderId(int orderId){
		this.orderId = orderId;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public int getProductId(){
	return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}
	public int getQuantity(){
	return quantity;
	}
	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public Date getDeliveryDate(){
		return this.deliveryDateTime;
	}

	public void setDeliverDate(Date dt){
		this.deliveryDateTime=dt;
	}
	
	public boolean isBuyWarranty() {
		return buyWarranty;
	}

	public void setBuyWarranty(boolean buyWarranty) {
		this.buyWarranty = buyWarranty;
	}

	public String toString(){
		return brandName+" "+model+" "+price;
	}

	public static ArrayList<Cart> buildCart(int productId){

		Product cartProduct = new Product();
		String fullPath = "C:/apache-tomcat-7.0.34/webapps/csj1/xml/ProductCatalog.xml";
		SaxParserUtility parser = new SaxParserUtility(fullPath);
		ArrayList<Product> products = parser.parseDocument();

		for(Product product: products){
			if(product.getProductId() == productId){
				cartProduct = product;
				break;
			}
		}

		Cart item1 = new Cart(cartProduct.getBrandName(), cartProduct.getModel(), cartProduct.getPrice(), 1);
		
		ArrayList<Cart> cart = new ArrayList<Cart>();
		cart.add(item1);
		// cart.add(item2);
		return cart;
	}



}