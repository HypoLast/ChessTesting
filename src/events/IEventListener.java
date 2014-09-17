package events;

/**
 * 
 * Implement this interface for a class that is being added to an EventEmitter
 * @author Mike
 *
 */
public interface IEventListener {

	/**
	 * This function gets called whenever an event emitter this class is attached to sends
	 * an event
	 * @param e The event that was dispatched
	 */
	void handleEvent(Event e);
	
}
