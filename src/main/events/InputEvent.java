package main.events;

import events.Event;

/**
 * 
 * Custom Event class for console input events
 * @author Mike
 *
 */
public class InputEvent extends Event {
	/**
	 * Event types
	 */
	public static final String TEXT_RECIEVED = "TEXT_RECIEVED";
	public static final String IO_ERROR = "IO_ERROR";
	
	/**
	 * added field for additional information
	 */
	protected String body;
	
	/**
	 * Constructor with no name
	 */
	public InputEvent() {
		super();
	}
	
	/**
	 * Constructor with a name
	 * @param name Event name
	 */
	public InputEvent(String name) {
		super(name);
	}

	/**
	 * Constructor with name and body
	 * @param name Event name
	 * @param body Event body
	 */
	public InputEvent(String name, String body) {
		super(name);
		this.body = body;
	}
	
	/**
	 * Get the body of the event
	 * @return The string that was sent with the event
	 */
	public String getBody() {
		return body;
	}
}
