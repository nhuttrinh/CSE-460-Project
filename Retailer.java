package SupplyDemand;

/**
 * Retailer class implements ISubscriber interface.
 */
public class Retailer implements ISubscriber {

	/**
	 * Category of a product that wants to subscribe/unsubscribe.
	 */
	private String prodCat;

	/**
	 * Name of the retailer who wants to subscribe/unsubscribe.
	 */
	private String retailerName;

	/**
	 * Constructor of Retailer class.
	 */
	public Retailer() {

	}

	/**
	 * Overloaded Constructer with parameters
	 */
	public Retailer(String prodCat, String retailer) {
		this.prodCat = prodCat;//Assign the category of the product.
		this.retailerName = retailer;//Assign the retailer who's looking for the product.
	}

	/**
	 * Implement subscribe event that a retailer wants to subscribe a product.
	 */
	public void subscribe(String prodCat, String retailer) {
		Broker.addSubcsriber(prodCat,retailer);//Call Broker to add the subscriber to the list of subscription.
	}

	/**
	 * Implement unsubscribe event that a retailer wants to unsubscribe a product.
	 */
	public void unsubscribe(String prodCat, String retailer) {
		Broker.removeSubscriber(prodCat,retailer);//Call Broker to withdraw the subscriber from the list of subscription.
	}

	/**
	 * Implement getting retailer name.
	 */
	public String getRetailerName() {
		return retailerName;//Return the name of the retailer.
	}

	/**
	 * Implement gettingt product category.
	 */
	public String getProCat() {
		return prodCat;//Return the category of the product.
	}

}
