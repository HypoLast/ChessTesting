package model.proxy;

import java.util.ArrayList;

import model.data.HistoryData;

import org.puremvc.java.multicore.patterns.proxy.Proxy;

/**
 * 
 * The proxy class provides an interface for commands and mediators to interact with the data
 * The proxy is the only class that should ever manipulate it's data directly, unless the data
 * is raw storage
 * @author Mike
 *
 */
public class HistoryProxy extends Proxy {
	
	public static final String NAME = "HistoryProxy";
	
	/**
	 * Create the proxy
	 */
	public HistoryProxy() {
		// proxies need a name, and a data class stored in them.
		// The name should be a static property of the class so that the proxy can be retrieved
		// from the facade easily later
		super(NAME, new HistoryData());
	}
	
	/**
	 * Get the history list from the data
	 * @return An ArrayList<String> of lines in the history
	 */
	public ArrayList<String> getHistoryDataList() {
		return ((HistoryData)getData()).history;
	}
	
	/**
	 * Add a string to the history
	 * @param text The string to add
	 */
	public void addHistoryText(String text) {
		((HistoryData)getData()).history.add(text);
	}
	
}
