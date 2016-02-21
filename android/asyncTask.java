// example of an asynctask implementation
// async task recommended for thread/UI responsiveness

// choice of AsyncTask execution behavior: 
// in main activity thread call:
// asyncworker.executeOnExecutor(AsyncTask.SERIAL_EXECUTOR); sequentially
// asyncworkier.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR); in parallel
/*
Phases of Async Task:
- onPreExecute: retrieve info from UI on main thread
- doBackground: runs on background thread
- publishProgress/onProgressUpdate: allows from background thread to pass information to foreground thread
- onPostExecute: runs when doBackground finishes 

3 parameters: parameter type to execute method, parameter for passing information from 
doInBackground to publishProgress, return type of doInBackground

*/


// parameters: takes in a TextView class from UI thread
// doInBackground returns a String
// return type of doInBackground method
public AsyncTaskWorker extends AsyncTask<TextView, String, Boolean> {

	TextView mTextView;

	// parameter = array of textViews
	protected Boolean doInBackground(TextView... textViews) {
		// run background thread code here 
		if (textViews.length > 0) {
			mTextView = textViews[0];
		}
		String exampleProperty = "example";
		publishProgress("Done"); // runs the onProgressUpdate function
		return true;
	}

	protected void onPostExecute(Boolean aBoolean) {
		if (aBoolean == true) {
			mTextView.setText("done loading");
		} else {
			mTextView.setText("error loading data");
		}
	}

	protected void onProgressUpdate(String... values) {
		mTextview.setText(values[0]);
	}

}