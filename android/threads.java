// example dedicated threads in an an activity 
// threads not recommened for long-term acesses

// cons: thread creation/breakdown is resource intensive
// dedicated tasks are not the best choice for background tasks for responsive user experience


public class MyActivity extends Activity {

	Thread _workerThread;
	TextView _defaultTextView;
	String _defaultTextViewTempString;


	public void doWork() {
		_workerThread = new Thread(new Runnable() {
			// work that runs in a background thread
			public void run() {
				// code to run in background thread
				// updates to display current status of tasks and regurlarly updates
				updateDisplay("Fetching some info");
				updateDisplay("Fetching user info");
				updateDisplay("Done"); 
			}
		});
		_workerThread.start(); // starts run method of thread
	}


	// updates text view with string accessed from another background thread
	private void updateDisplay(String message) {
		_defaultTextViewTempString = message;
		_defaultTextView.post(new Runnable() {
			public void run() {
				_defaultTextView.setText(_defaultViewTempString);
			}
		});
	}

}