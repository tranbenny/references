// example implementation of accessing shared preference variables in an async task

public class ExampleTask extends AsyncTask<Void, Void, Void> {

	public ExampleTask(Context context) {
		// shared preferences object to access all key,value pairs in settings activity of app
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
		// get the string value for key "preference_key"
		// 2 parameters: key, default value
		String pref = sharedPref.getString("preference_key", "");
		boolean booleanPref = sharedPref.getBoolean("preference_key", false);
	}
}