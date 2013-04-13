package com.danh32.Ln;

import android.util.Log;

/**
 * <p>Ln is a "Natural Log" class, meant to make Android logging easier than
 * it currently is. Inspired by RoboGuice's Ln.java and it's method signatures,
 * With a simplified implementation and stripped of it's dependency on RoboGuice's
 * injection framework, Ln is a lightweight solution to logging on Android.<p> 
 * 
 * <p>Ln is a simple facade over Android's Log class. It abstracts the need to pass a "tag"
 * parameter to every logging call, and offers {@link String#format(String, Object...)} functionality 
 * directly. {@link String#format(String, Object...)} strings are not constructed unless the statement 
 * is permited to be logged.<p>
 * 
 * <p>Ln offers automated stack trace logging as well using {@link android.util.Log#getStackTraceString(Throwable)}. 
 * The stack trace string is not constructed unless the statement is permitted to be logged.<p>
 * 
 * <p>Ln offers the normal 6 priority levels of {@link android.util.Log} via Ln.v(), Ln.d(), Ln.i(), Ln.w(), Ln.e(),
 * and Ln.wtf(). For each level, there are three method signatures that are available:</p>
 * <ul>
 * 	<li>(Throwable) -- logs a throwable only</li>
 *  <li>(String, Object...) -- logs a message only</li>
 *  <li>(Throwable, String, Object...) -- logs a throwable and a message</li>
 * </ul>
 * 
 * <p>Recommended usage:<p>
 * <p>In your {@link android.app.Application#onCreate()}, set the desired level of logging permitted by calling
 * {@link #setLogLevel(int)}<p>
 * 
 * <ul>
 * 	<li>Ln.v("User click at %d, %d", x, y);
 * 	<li>Ln.d("Server responded with %d: %s", responseCode, responseMessage);</li>
 * 	<li>Ln.e(illegalStateException);</li>
 * 	<li>Ln.wtf(illegalStateException, "UH-OH! %s", errorMsg);</li>
 * </ul>
 * @author danh32
 */
public class Ln {
	private static int LOG_LEVEL = 3;

	/**
	 * Log a Throwable at the Log.ASSERT priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void wtf(Throwable t) {
		Ln.printLn(Log.ASSERT, t, "");
	}

	/**
	 * Log a message at the Log.ASSERT priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void wtf(String message, Object... formatArgs) {
		Ln.printLn(Log.ASSERT, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.ASSERT priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void wtf(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.ASSERT, t, message, formatArgs);
	}

	/**
	 * Log a Throwable at the Log.ERROR priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void e(Throwable t) {
		Ln.printLn(Log.ERROR, t, "");
	}

	/**
	 * Log a message at the Log.ERROR priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void e(String message, Object... formatArgs) {
		Ln.printLn(Log.ERROR, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.ERROR priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void e(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.ERROR, t, message, formatArgs);
	}

	/**
	 * Log a Throwable at the Log.WARN priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void w(Throwable t) {
		Ln.printLn(Log.WARN, t, "");
	}

	/**
	 * Log a message at the Log.WARN priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void w(String message, Object... formatArgs) {
		Ln.printLn(Log.WARN, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.WARN priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void w(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.WARN, t, message, formatArgs);
	}

	/**
	 * Log a Throwable at the Log.INFO priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void i(Throwable t) {
		Ln.printLn(Log.INFO, t, "");
	}

	/**
	 * Log a message at the Log.INFO priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void i(String message, Object... formatArgs) {
		Ln.printLn(Log.INFO, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.INFO priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void i(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.INFO, t, message, formatArgs);
	}
	
	/**
	 * Log a Throwable at the Log.DEBUG priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void d(Throwable t) {
		Ln.printLn(Log.DEBUG, t, "");
	}

	/**
	 * Log a message at the Log.DEBUG priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void d(String message, Object... formatArgs) {
		Ln.printLn(Log.DEBUG, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.DEBUG priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void d(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.DEBUG, t, message, formatArgs);
	}

	/**
	 * Log a Throwable at the Log.VERBOSE priority.
	 * 
	 * @param t Throwable to be logged
	 */
	public static void v(Throwable t) {
		Ln.printLn(Log.VERBOSE, t, "");
	}

	/**
	 * Log a message at the Log.VERBOSE priority.
	 * 
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format()
	 */
	public static void v(String message, Object... formatArgs) {
		Ln.printLn(Log.VERBOSE, null, message, formatArgs);
	}

	/**
	 * Log a Throwable and a message at the Log.VERBOSE priority
	 * 
	 * @param t Throwable to be logged
	 * @param message String to be logged
	 * @param formatArgs Object arguments to String.format
	 */
	public static void v(Throwable t, String message, Object... formatArgs) {
		Ln.printLn(Log.VERBOSE, t, message, formatArgs);
	}


	/**
	 * Main log method through which all other methods pass.
	 * 
	 * @param priority int priority of the message to be logged
	 * @param t Throwable to be logged (can be null)
	 * @param msg String message to be logged (can be empty)
	 * @param formatArgs Object arguments to String.format
	 */
	private static void printLn(int priority, Throwable t, String msg, Object... formatArgs) {
		if (priority >= LOG_LEVEL) {
			final String stackTraceString = t == null? "" : "\n" + Log.getStackTraceString(t);
			Log.println(priority, getTag(), String.format(msg, formatArgs) + stackTraceString);
		}
	}

	/**
	 * Performs a bit of reflection to get the name of the calling class 
	 * @return String name of calling class
	 */
	private static String getTag() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		if (stackTraceElements.length > 6) {
			final StackTraceElement element = stackTraceElements[5];
			return element.getFileName() + ":" + element.getLineNumber();
		} else {
			return "";
		}
	}

	/**
	 * Sets the level of log statements that print at runtime (default is Log.DEBUG):
	 * 
	 * Available log levels in ascending order of priority:
	 * - Log.VERBOSE
	 * - Log.DEBUG
	 * - Log.INFO
	 * - Log.WARN
	 * - Log.ERROR
	 * - Log.ASSERT
	 *  
	 * @param logLevel level of logging to permit at runtime
	 */
	public static void setLogLevel(int logLevel) {
		LOG_LEVEL = logLevel;
	}
}