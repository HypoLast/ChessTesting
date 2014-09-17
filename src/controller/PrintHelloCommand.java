package controller;

import main.s_Notifications;

import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;

/**
 * 
 * Command classes are conceptually transient. They shouldn't have any persistent data in
 * them and all of their functionality is stored in the execute function.
 * @author Mike
 *
 */
public class PrintHelloCommand extends SimpleCommand {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(INotification notification) {
		// send a little intro message to the user
		sendNotification(s_Notifications.ECHO_WORD, "Hello! Type stuff to get it typed back to you. Type 'history' to see all the things you've typed so far");
	}
	
}
