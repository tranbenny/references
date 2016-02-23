// basic example that checks the projects api level

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activty_main);

		// checks if project runs android 5.0 or higher
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			// can use material design api's here
		} else {
			// features without material design
		}
	}


}