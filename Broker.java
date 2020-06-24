package SupplyDemand;
import java.util.ArrayList;
import java.util.List;
/**
 * A Broker who manages publish, subscribe, and unsubscribe events.  
 */
public final class Broker {

	/**
	 * A list of String to store notifications to Subscribers.
	 */
	private static List<String> notifyList = new ArrayList<String>();

	/**
	 * A list of interface of subscribers.
	 */
	private static List<ISubscriber> retailerList = new ArrayList<ISubscriber>();

	/**
	 * Method to add subscribers to a list.
	 */
	public static void addSubcsriber(String prodCat, String retailer) {
		ISubscriber subscriber = new Retailer(prodCat,retailer); //An object of retailer via interface.
		if(!checkSubscriber(subscriber)) { //Calling checkSubscriber to check if the subscriber has already subscribed the product.
		retailerList.add(subscriber); // Add the subscriber to the list if it has not subscribe the product.
		}
	}

	/**
	 * Method to check if a subscriber has already subscribed a product.
	 */
	public static boolean checkSubscriber(ISubscriber subscriber) {
		boolean flag = false; //A flag to determine the status.
		for(int i =0; i<retailerList.size();i++) {//Looking through the list of retailers
			if(retailerList.get(i).getProCat().equalsIgnoreCase(subscriber.getProCat()) && retailerList.get(i).getRetailerName().equalsIgnoreCase(subscriber.getRetailerName())) {//Find the given subscriber to check if it has already in the list.
				flag = true;//mark the flag.
				break;//exit the for loop.
			}
			else {// Cannot find the given subscriber.
				continue;//continue to find the subscriber.
			}
		}
		return flag; // Return the status current of the flag.
	}

	/**
	 * Method to remover a subscriber from the list of retailers once unsubscribe.
	 */
	public static void removeSubscriber(String prodCat, String retailer) {
		if(!retailerList.isEmpty()) {//Proceed when the list of subscribers is not empty
			for(int i = 0; i < retailerList.size(); i++) {//Iterate through the list of retailers
				if(retailerList.get(i).getRetailerName().equalsIgnoreCase(retailer) && retailerList.get(i).getProCat().equalsIgnoreCase(prodCat)) {//Find the given subscriber to check if it has already in the list.
					retailerList.remove(i);//Remove the subscriber from the list.
				}
			}	
		}
	}

	/**
	 * Method to find a given subscriber in the list of retailers.
	 */
	public static void findSubscriber(String brand, String prodCat, String producer) {
		String announce = "";//A string to store a notification.
		if(!retailerList.isEmpty()) {//Proceed when the list of subscribers is not empty
			for(ISubscriber re : retailerList) {//Iterate through the list of retailers
				if(re.getProCat().equalsIgnoreCase(prodCat)) {// Find the subscriber by their subscribed product category.
					String retailer = re.getRetailerName();//A string for name of the retailer.
					announce = retailer + " notified of " + brand + " brand " + prodCat + " from " + producer;//Make a notification.
					notifyList.add(announce);//Add the notification to the notify list.
				}
			}
		}
	}

	/**
	 * Get all notifications from the list.
	 */
	public static List<String> notifyList() {
		return notifyList; //return the list of the notifications
	}

	/**
	 * Remove all information of the subscriber list as well as the notification list.
	 */
	public static void clearAll() {
		retailerList.clear();//Delete all the data in the retailer list.
		notifyList.clear();	//Delete all the data in the notification list.
	}

}
