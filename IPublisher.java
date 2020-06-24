package SupplyDemand;

/**
 * An interface for Publishers, who publish new contents to Subscribers via a Broker.
 */
public interface IPublisher {

	/**
	 * Publish a message about products available to Broker
	 */
	public abstract void publish(String brand, String prodCat, String producer);

	/**
	 * Get producer name.
	 */
	public abstract String getProducerName();

	/**
	 * Get product category.
	 */
	public abstract String getProdCat();

	/**
	 * Get brand of the product.
	 */
	public abstract String getBrand();

}
