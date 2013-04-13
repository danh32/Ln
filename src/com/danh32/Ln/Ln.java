package com.danh32.Ln;

import android.util.Log;

/**
 * Ln is a "Natural Log" class, meant to make Android logging easier than
 * it currently is. Inspired by RoboGuice's Ln.java and it's method signatures,
 * With a simplified implementation and stripped of it's dependency on RoboGuice's
 * injection framework, Ln should be a lightweight solution to logging on Android. 
 * 
 * Ln is a simple facade over Android's Log class. It abstracts the need to pass a "tag"
 * parameter to every logging call, and offers String.format(...) functionality directly.
 * String.formats are not computed unless the statement is going to be logged. 
 * 
 * It offers automated stack trace logging as well. The stack trace string is not constructed 
 * unless the statement is going to be logged.
 * 
 * Recommended usage:
 * 
 * @author danh32
 */
public class Ln {
	private static int LOG_LEVEL = 3;

	public static void wtf(Throwable t) {
		printLn(Log.ASSERT, t, "");
	}

	public static void wtf(String message, Object... formatArgs) {
		printLn(Log.ASSERT, null, message, formatArgs);
	}

	public static void wtf(Throwable t, String message, Object... formatArgs) {
		printLn(Log.ASSERT, t, message, formatArgs);
	}

	public static void e(Throwable t) {
		printLn(Log.ERROR, t, "");
	}

	public static void e(String message, Object... formatArgs) {
		printLn(Log.ERROR, null, message, formatArgs);
	}

	public static void e(Throwable t, String message, Object... formatArgs) {
		printLn(Log.ERROR, t, message, formatArgs);
	}

	public static void w(Throwable t) {
		printLn(Log.WARN, t, "");
	}

	public static void w(String message, Object... formatArgs) {
		printLn(Log.WARN, null, message, formatArgs);
	}

	public static void w(Throwable t, String message, Object... formatArgs) {
		printLn(Log.WARN, t, message, formatArgs);
	}


	public static void i(Throwable t) {
		printLn(Log.INFO, t, "");
	}

	public static void i(String message, Object... formatArgs) {
		printLn(Log.INFO, null, message, formatArgs);
	}

	public static void i(Throwable t, String message, Object... formatArgs) {
		printLn(Log.INFO, t, message, formatArgs);
	}

	public static void d(Throwable t) {
		printLn(Log.DEBUG, t, "");
	}

	public static void d(String message, Object... formatArgs) {
		printLn(Log.DEBUG, null, message, formatArgs);
	}

	public static void d(Throwable t, String message, Object... formatArgs) {
		printLn(Log.DEBUG, t, message, formatArgs);
	}

	public static void v(Throwable t) {
		printLn(Log.VERBOSE, t, "");
	}

	public static void v(String message, Object... formatArgs) {
		printLn(Log.VERBOSE, null, message, formatArgs);
	}

	public static void v(Throwable t, String message, Object... formatArgs) {
		printLn(Log.VERBOSE, t, message, formatArgs);
	}


	private static void printLn(int priority, Throwable t, String msg, Object... formatArgs) {
		if (priority >= LOG_LEVEL) {
			final String stackTraceString = t == null? "" : "\n" + Log.getStackTraceString(t);
			Log.println(priority, getTag(), String.format(msg, formatArgs) + stackTraceString);
		}
	}

	private static String getTag() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if (stackTraceElements.length > 6) {
			String[] packagePieces = stackTraceElements[5].getClassName().split("\\.");
			return "Ln-"+packagePieces[packagePieces.length - 1];
		} else {
			return "Ln";
		}
	}

	/**
	 * Sets the level of log statements that print (default is Log.DEBUG):
	 * 
	 * Available Log Levels:
	 * - Log.VERBOSE
	 * - Log.DEBUG
	 * - Log.INFO
	 * - Log.WARN
	 * - Log.ERROR
	 * - Log.ASSERT
	 *  
	 * @param logLevel
	 */
	public static void setLogLevel(int logLevel) {
		LOG_LEVEL = logLevel;
	}
}