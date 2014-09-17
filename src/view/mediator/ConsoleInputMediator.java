package view.mediator;

import main.s_Notifications;
import main.events.InputEvent;

import org.puremvc.java.multicore.patterns.mediator.Mediator;

import events.Event;
import events.IEventListener;
import view.component.ConsoleInputComponent;

/**
 * 
 * Mediators provide an interface between IO classes and the MVC system.
 * This mediator listens for events from the InputComponent and turns those
 * events into notifications that can be handled by the rest of the system
 * @author Mike
 *
 */
public class ConsoleInputMediator extends Mediator implements IEventListener {

	public static final String NAME = "ConsoleInputMediator";
	
	/**
	 * Create the mediator and set up its view component
	 */
	public ConsoleInputMediator() {
		super();
		ConsoleInputComponent component = new ConsoleInputComponent();
		// init can be used instead of super if you need to
		init(NAME, component);
		component.addEventListener(this);
	};
	
	/**
	 * When this gets registered start up the ConsoleInputComponent
	 */
	@Override
	public void onRegister() {
		new Thread((ConsoleInputComponent)viewComponent).start();
	}

	/**
	 * When we get an event forward it to the correct handle function
	 */
	@Override
	public void handleEvent(Event e) {
		switch (e.getName()) {
			case InputEvent.TEXT_RECIEVED: handleText(((InputEvent)e).getBody()); break;
			case InputEvent.IO_ERROR: handleError(); break;
		}
	}
	
	/**
	 * Send the appropriate notifications based on the input
	 * Switchboarding is the extent of computation that should live in a mediator
	 * anything more sophsticated should be handled in a command
	 * @param text The text string that came with the InputEvent
	 */
	private void handleText(String text) {
		if ("history".equals(text)) {
			sendNotification(s_Notifications.SHOW_HISTORY);
		} else {
			sendNotification(s_Notifications.ECHO_WORD, text);
			sendNotification(s_Notifications.RECORD_HISTORY, text);
		}
	}
	
	/**
	 * Die on error
	 */
	private void handleError() {
		System.out.println("IO Error occurred");
		System.exit(0);
	}
	
}
