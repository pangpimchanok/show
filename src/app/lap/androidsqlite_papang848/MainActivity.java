package app.lap.androidsqlite_papang848;

//import java.security.PublicKey;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private Button btn_insert, btn_show;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// MyDB848 myDB848 = new MyDB848(this);
		// myDB848.getWritableDatabase();
		btn_insert = (Button) findViewById(R.id.btn_insert);
		btn_show = (Button) findViewById(R.id.btn_show);

		btn_insert.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(v==btn_insert){
					Intent add = new Intent(MainActivity.this,AddActivity.class);
					startActivity(add);

				}

			}
		});
		btn_show.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if(v==btn_show) {
					Intent show = new Intent(MainActivity.this,ShowActivity.class);
					startActivity(show);
				}

			}
		});
	}

}
