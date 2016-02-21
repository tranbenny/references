// services for long-running, non-UI operations
// service has to be registered in application manifest
// create intent filters for the service 
// foreground serices: service that a user is directly aware of, f.e. music player, service information will appear in a status bar

// 3 service lifecycle methods:
// onCreate
// onStartCommand: runs when startService is called
// onDestroy




// service with lifecycle controlled and thread pool
// includes methods to create a basic foreground service and notification 
public class WorkerService extends Service {

	ExecutorService mExecutorService;
	ExecutorService mScheduledStopService;

	Notification mForegroundNotification;
	final int mNotificationId = 1;
	NotificationManager mNotificationManager;


	// steps to creating a foreground service
	// create a notification
	// set parameters: icon, initial text, and time stamp
	// add title,body text and pending intent for when notifications are clicked
	void startForegroundService() {
		int notificationIcon = R.drawable.icon_image;
		String notificationTickerText = "service starting";
		long timeStamp = System.currentTimeMillis();
		mForegroundNotification = new Notification(notifcationIcon, notificationTickerText, timeStamp);

		String notificationTitleText = "text in status bar";
		String notificationBodyText = "text in body";
		Intent myActivityIntent = new Intent(this, MyActivity.class);
		PendingIntent startMyActivityPendingIntent = PendingIntent.getActvity(this, 0, myActivityIntent, 0);

		// adds text information to notification and click event through the pending intent
		mForegroundNotification.setLatestEventInfo(this, notificationTitleText, notificationBodyText, startMyActivityPendingIntent);

		startForeground(mNotificationId, mForegroundNotification);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		// allows work to be done in a background thread 
		// puts work into a thread pool through the executors class 
		mExecutorService = Executors.newSingleThreadExecutor();

		// scheduled executor: allows you to run services later in the future
		mScheduledStopService = Executors.newSingleThreadScheduledExecutor();

		// notification manager allows you to interact with the notification
		mNotificationManager = this.getSystemService(Context.NOTIFICATION_SERVICE);

		startForegroundService();
	}

	// example notification interaction method
	// method changes the notification's icon
	void setStatusIcon(int iconId) {
		mForegroundNotification.icon = iconId;
		// parameters for notify method: id value and notification object 
		mNotificationManager.notify(mNotificationId, mForegroundNotification);
	}



	// the return type of onStartCommand indicates the behavior when a service is killed
	// START_NOT_STICKY: if service is killed, do not restart until startService is called
	// START_STICKY: service automatically restarts when resources are available, auto-restart passes null intent to onStartCommand
	// START_REDELIVER_INTENT: if service is killed before stopSelfResult called for last request, auto restarts when resources available
	// will use last intent passed as parameter
	// START_STICKY_COMPATIBILITY: provides compatibility with android 1.6 and earlier
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// run background process code here 
		serviceRunnable runnable = new servicerunnable(this);
		mExecutorService.execute(runnable);

		return Service.START_NOT_STICKY; 
		// START_NOT_STICKY: none-essential services
		// STAR_STICKY: good for services that need to remain active
		// START_REDELIVER_INTENT: request oriented services
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	// implementation of runnable class that can access the outer service class
	class serviceRunnable implements Runnable {
		
		WorkerService mService;

		public serviceRunnable(WorkerService service){
			mService = service;
		}

		public void run() {
			// run background tasks here
			delayedStopResponse delayedResponse = new delayedStopResponse(mService);
			// parameters: runnable class, integer value, time units
			// waits 5 minutes before the service response is executed
			mService.mScheduledStopService.schedule(delayedStopRequest, 5, TimeUnit.MINUTES);
		}
	}

	// implementation of runnable class for delayed request
	static class delayedStopResponse implements Runnable {

		WorkService mService;

		public delayedStopResponse(WorkerService service) {
			mService = service;
		}

		public void run() {
			// delayed response code here
			mService.stopSelf(); // self stopping service method
		}
	}

}




// example simple intent service that is started by intents 
public class Service extends IntentService {

	public Service() {
		super("Service");
	}

	@Override
	protected void onHandleIntent(Intent intent) {
		// run code for service here
	}

}

// example activity that starts the service
public class myActivity extends Activity {

	// use intent to start service 
	public void startService() {
		// one way to start service directly
		Intent serviceIntent = new Intent(this, Service.class);
		startService(serviceIntent);

		// access service through intent-filter
		// string parameter of the name of the intent-filter from manifest 
		Intent serviceIntent2 = new Intent("com.example.package.NAME_OF_INTENT_FILTER");
		startService(serviceIntent2);
	}

}