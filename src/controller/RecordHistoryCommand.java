package controller;

import main.Chess;
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
public class RecordHistoryCommand extends SimpleCommand {
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(INotification notification) {
		// grab the facade core we have registered, retrieve the history proxy, and tell it to insert
		// the new text
		((HistoryProxy)(Facade.getInstance(Chess.FACADE_INSTANCE_NAME).retrieveProxy(
				HistoryProxy.NAME))).addHistoryText((String)(notification.getBody()));
	}
	
}
