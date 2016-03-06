package com.demo.learnings;

import java.util.function.Supplier;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Learning5 {
	
	private static final Logger logger = Logger.getLogger(Learning5.class.getName());
	
	static{
		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		logger.addHandler(consoleHandler);
		consoleHandler.setLevel(Level.ALL);
	}
	
	//public static void logIt(Logger logger, Supplier<String> supplier) {
	public static void logIt(Supplier<String> supplier) {
		if(logger.isLoggable(Level.FINE)){
			logger.log(Level.FINE, supplier.get());
		}
	}
	
	public static void main(String[] args) {
	
		// using If statement to see if a specific log level is enabled
		if(logger.isLoggable(Level.FINE)){
			logger.log(Level.FINE, "This is the log message");
		}
		
		// using lambda to print logs
		logIt(() -> "This is the log message");
	}

}
