package main;

import model.proxy.HistoryProxy;

import org.puremvc.java.multicore.patterns.facade.Facade;

import view.mediator.ConsoleInputMediator;
import view.mediator.ConsoleOutputMediator;
import controller.PrintHelloCommand;
import controller.PrintHistoryCommand;
import controller.RecordHistoryCommand;

public class Chess {
	
	public static final String FACADE_INSTANCE_NAME = "FACADE_INSTANCE_NAME";
	
	public static void main(String[] args) {
		// getting an instance of a facade that doesn't exist creates it
		Facade facade = Facade.getInstance(FACADE_INSTANCE_NAME);
		
		// register the commands that will handle the logic of the program
		facade.registerCommand(s_Notifications.SAY_HELLO, new PrintHelloCommand());
		facade.registerCommand(s_Notifications.SHOW_HISTORY, new PrintHistoryCommand());
		facade.registerCommand(s_Notifications.RECORD_HISTORY, new RecordHistoryCommand());
		
		// register the proxy to manage persistent data
		facade.registerProxy(new HistoryProxy());
		
		// register the mediators for I/O
		facade.registerMediator(new ConsoleInputMediator());
		facade.registerMediator(new ConsoleOutputMediator());
		
		// send a notification to output the initial prompt
		facade.sendNotification(s_Notifications.SAY_HELLO);

	}
}
