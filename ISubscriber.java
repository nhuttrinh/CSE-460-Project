package SupplyDemand;

/**
 * An interface for Subscribers, who subscribe to/unsubscribe from product types and will receive notifications related to the type of the product they have subscribed to via Broker.
 */
public interface ISubscriber {

	/**
	 * Subscribe to a product type to receive notifications related to it.
	 */
	public abstract void subscribe(String prodCat, String retailer);

	/**
	 * Unsubscribe from a product type to stop receiving notifications about it.
	 */
	public abstract void unsubscribe(String prodCat, String retailer);

	/**
	 * Get name of retailer.
	 */
	public abstract String getRetailerName();

	/**
	 * Get product category that the retailer wants to subscribe/unsubscribe.
	 */
	public abstract String getProCat();

}
