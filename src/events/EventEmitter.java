package events;

import java.util.ArrayList;

/**
 * 
 * Generic event emitter to be extended for specific implementations
 * @author Mike
 *
 */
public class EventEmitter {
	
	// the list of listeners
	private ArrayList<IEventListener> mListeners = new ArrayList<IEventListener>();
	
	/**
	 * Register an IEventListener to this emitter
	 * @param listener The listener to listen for events from this emitter
	 */
	public void addEventListener(IEventListener listener) {
		if (!mListeners.contains(listener)) {
			mListeners.add(listener);
		}
	}
	
	/**
	 * Remove a listening IEventListener from this emitter
	 * @param listener The listener that should no longer recieve events from this emitter
	 */
	public void removeEventListener(IEventListener listener) {
		if (mListeners.contains(listener)) {
			mListeners.remove(listener);
		}
	}
	
	/**
	 * Send an event to all listeners that have been added to this emitter
	 * @param e The event to send out
	 */
	public void dispatchEvent(Event e) {
		for (IEventListener listener : mListeners) {
			listener.handleEvent(e);
		}
	}
	
}
