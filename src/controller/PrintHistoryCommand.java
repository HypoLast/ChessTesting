package controller;

import main.Chess;
import main.s_Notifications;
import model.proxy.HistoryProxy;

import org.puremvc.java.multicore.interfaces.INotification;
import org.puremvc.java.multicore.patterns.command.SimpleCommand;
import org.puremvc.java.multicore.patterns.facade.Facade;

/**
 * 
 * Command classes are conceptually transient. They shouldn't have any persistent data in
 * them and all of their functionality is stored in the execute function.
 * @author Mike
 *
 */
public class PrintHistoryCommand extends SimpleCommand {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(INotification notification) {
		// iterate through all the strings in the history
		// first get the facade core we have registered, retrieve the history proxy by name, then get the
		// history list from the data
		for (String s : ((HistoryProxy)(Facade.getInstance(Chess.FACADE_INSTANCE_NAME).retrieveProxy(
				HistoryProxy.NAME))).getHistoryDataList()) {
			sendNotification(s_Notifications.ECHO_WORD, s); // write the lines out
		}
	}
	
}
