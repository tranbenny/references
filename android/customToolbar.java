/*
applies custom toolbar with popup menu onto an activity 

*/


public class MainActivity extends AppCompatActivity {

	Toolbar toolbar; // toolbar for setting toolbar onto the activity

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// sets custom toolbar to activity as an action bar 
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		// sets title attributes
		// other methods: setLogo(), setNavigationIcon(), etc. 
		getSupportActionBar().setTitle("Welcome !");
		toobar.setSubtitle("Folks");

		// compatibility checks with elevation check
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			toolbar.setElevation(10f);
		}


		// standalone toolbar instead of as an action bar 
		toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.inflatMenu(R.menu.menu_main);
		toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(Menu menu) {
				// handle click event code here
				return false;
			}
		});
	}

	// applies menu.xml file to show the options onto the toolbar and popup menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}


	// handles the clicking of options menu 
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		// when the discard option is clicked, sets message to delete
		switch (item.getItemId()) {
			case R.id.discard:
				String message = "delete";
				break;
		}




	}







}