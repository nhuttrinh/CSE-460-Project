package SupplyDemand;
import java.util.List;

/**
 * This class would be the point of interaction of the system - it accepts input and provides aggregated output.
 */
public class SupplyDemand {

	/**
	 * An object of Producer via Ipublisher interface.
	 */
	private IPublisher publisher = new Producer();

	/**
	 * An object of Retailer via ISubscriber interface.
	 */
	private ISubscriber retailer = new Retailer();

	/**
	 * Class constructor.
	 */
	public SupplyDemand() {

	}

	/**
	 * This method accepts a single command and carry out the instruction given.
	 */
	public void processInput(String command) {
		
		String[] line = command.split(",");//Split every component of the input and store them in an array.
		
		switch(line[0]) {//Choose the first element of array to determine which function to operate.
		
		case "publish": //if it is publish
			if(line.length != 4) {//with the combination other than 4 elements.
				break; //out of the switch.
			}
			else{ //with the combination of exact 4 elements.
			publisher.publish(line[3].trim(), line[2].trim(), line[1].trim());	//Calling publish to publish the product via Broker.
			break;}
			
		case "subscribe": //if it is subscribe
			if(line.length != 3) {//with the combination other than 3 elements.
				break;//out of the switch
			}
			else { //with the combination of exact 3 elements.
			retailer.subscribe(line[2].trim(),line[1].trim());//Calling subscribe to subscribe the product via Broker.
			break;//out of the switch
			}
			
		case "unsubscribe": //if it is unsubscribe
			if(line.length != 3) {//with the combination other than 3 elements.
				break;//out of the switch
			}
			else {
			retailer.unsubscribe(line[2].trim(),line[1].trim());//Calling unsubscribe to unsubscribe the product via Broker.
			break;//out of the switch
			}
		}
	}

	/**
	 * After each round of execution, this method would be called to fetch all output lines, if there are any. The lines must be ordered by the time they are received.
	 */
	public List<String> getAggregatedOutput() {
		return Broker.notifyList(); //Calling the Broker to release the all notifications
	}

	/**
	 * Finally, this method would be called to clear all saved information in the system, so that information from previous round would not be carried to next round. After calling this method the system should be effectively starting anew.
	 */
	public void reset() {
		Broker.clearAll();//Calling Broker to delete all the current data.
	}

}
