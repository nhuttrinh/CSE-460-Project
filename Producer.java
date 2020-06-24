package SupplyDemand;

/**
 * Producer class implements IPublisher interface.
 */
public class Producer implements IPublisher {

	/**
	 * Category of a product want to be published.
	 */
	private String prodCat;

	/**
	 * Brand of a product want to be published.
	 */
	private String brand;

	/**
	 * Name of producer who wants to publish.
	 */
	private String producerName;

	/**
	 * Constructor of Producer class.
	 */
	public Producer() {

	}

	/**
	 * Overloaded Constructer with parameters
	 */
	public Producer(String brand, String prodCat, String producer) {
		this.brand = brand;//Assign the brand of the product.
		this.prodCat = prodCat;//Assign the category of the product.
		this.producerName = producer;//Assign the producer of the product.
	}

	/**
	 * Implement the publish event that Producer could publish a message about products available to Broker
	 */
	public void publish(String brand, String prodCat, String producer) {
		Broker.findSubscriber(brand, prodCat, producer);//Call Broker to find the subscribers who are looking for notifications.
	}

	/**
	 * Implement getting producer name.
	 */
	public String getProducerName() {
		return this.producerName; //Return the name of producer.
	}

	/**
	 * Implement getting product category.
	 */
	public String getProdCat() {
		return this.prodCat;//Return the category of the product.
	}

	/**
	 * Implement getting brand of the product.
	 */
	public String getBrand() {
		return this.brand;//Return the brand of the product.
	}

}
