package model.data;

import java.util.ArrayList;

/**
 * 
 * Data class for the History Proxy.
 * Data classes are simply storage classes, all persistent data in
 * the program ends up in this part of the model
 * @author Mike
 *
 */
public class HistoryData {
	
	/**
	 * List of all lines that have been entered so far
	 */
	public ArrayList<String> history = new ArrayList<String>();
	
}
