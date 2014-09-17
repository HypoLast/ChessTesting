package view.component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.events.InputEvent;
import events.EventEmitter;

/**
 * 
 * Console input component. This is an asynchronous event emitter that waits
 * for input from the command line then sends an event with the data that was received.
 * Note that the component class doesn't depend on any part of the MVC structure
 * @author Mike
 *
 */
public class ConsoleInputComponent extends EventEmitter implements Runnable {

	private BufferedReader mReader;
	private boolean mIsRunning = false;
	
	/**
	 * Construct. This doesn't do anything other than initialize the input buffer
	 */
	public ConsoleInputComponent() {
		mReader = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Begin the input loop. It will only be broken when stop() is called or an error happens
	 */
	@Override
	public void run() {
		mIsRunning = true;
		while (mIsRunning) {
			try {
				String inputString = mReader.readLine();
				dispatchEvent(new InputEvent(InputEvent.TEXT_RECIEVED, inputString));
			} catch (IOException e) {
				dispatchEvent(new InputEvent(InputEvent.IO_ERROR));
				mIsRunning = false;
			}
		}
	}
	
	/**
	 * Stop the asynchronous process from running
	 */
	public void stop() {
		mIsRunning = false;
	}
	
}
