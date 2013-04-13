#Ln
Ln is a "Natural Log" class, meant to make Android logging easier than it currently is. Inspired by RoboGuice's Ln.java and it's method signatures. With a simplified implementation and stripped of it's dependency on RoboGuice's injection framework, Ln is a lightweight solution to logging on Android.

##Features:
- No need to pass a "tag" parameter to every log call, Ln computes it for you
- String.format() functionality built into every call
- Log Throwables at any level

##Recommended Usage:
In your android.app.Application subclass's onCreate():

	onCreate() {
		super.onCreate();
		if (BuildConfig.DEBUG) {
			Ln.setLogLevel(Log.VERBOSE);
		} else {
			Ln.setLogLevel(Log.ERROR);
		}
	}
	

In your code:
- Ln.v("User click at %d, %d", x, y);
- Ln.d("Server responded with %d: %s", responseCode, responseMessage);
- Ln.e(illegalStateException);
- Ln.wtf(illegalStateException, "UH-OH! %s", errorMsg);