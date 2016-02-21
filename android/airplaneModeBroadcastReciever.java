// example broadcast reciever that notifies a service when the phone switches to airplane mode
// need to create a receiver tag in the manifest file with an intent filter for airplane mode actions


public class ServiceBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// gets the intent that the receiver got
		String broadcastAction = intent.getAction();
		boolean state = intent.getBooleanExtra("state", false);

		// starts a new intent and puts the state of airplane mode to the intent to the service
		Intent serviceIntent = new Intent(context, ExampleService.class);
		serviceIntent.putExtra("broadcastaction", broadcastAction);
		serviceIntent.putExtra("state", state);

		context.startService(serviceIntent);
	}

}