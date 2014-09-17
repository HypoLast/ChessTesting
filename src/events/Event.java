package events;

public class Event {
	
	protected String name = "";
	
	/**
	 * Construct a new generic event without a name
	 */
	public Event() {};
	
	/**
	 * Construct a new generic event
	 * @param name The event name
	 */
	public Event(String name) {
		this.name = name;
	}
	
	/**
	 * Retrieve the event name
	 * @return The name of the event
	 */
	public String getName() {
		return name;
	}
	
}
