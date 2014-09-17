package view.mediator;

import main.s_Notifications;

import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.mediator.Mediator;

/**
 * 
 * Mediators provide an interface between IO classes and the MVC system.
 * This mediator cares about the ECHO_WORD notification and uses the System class
 * to display the notification body to the screen.
 * @author Mike
 */
public class ConsoleOutputMediator extends Mediator {

	public static final String NAME = "ConsoleOutputMediator";
	
	/**
	 * Construct the mediator
	 */
	public ConsoleOutputMediator () {
		// mediators always need a name so that they can be retrieved by commands if needed. If you are using
		// a static IO class instead of an instanced object the viewComponent can be null
		super(NAME, null);
	}
	
	/**
	 * listNotificationInterests should return an array of notification names that this mediator wants to have
	 * forwarded to it
	 */
	@Override
	public String[] listNotificationInterests() {
		return new String[]{s_Notifications.ECHO_WORD};
	}
	
	/**
	 * handleNotification gets called when a notification listed in this mediators notification interests gets
	 * sent.
	 * @param notification The notification that was sent which triggered this function
	 */
	@Override
	public void handleNotification(INotification notification) {
		System.out.println(notification.getBody());
	}
	
}
