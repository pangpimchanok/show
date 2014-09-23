package app.lap.androidsqlite_papang848;

import javax.security.auth.PrivateCredentialPermission;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {
	private Button btn_add;
	private EditText edt_name, edt_tel;
	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_add.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SaveData();
				
				
			}
		});
	}

			private void SaveData() {
				edt_name = (EditText) findViewById(R.id.txt_name);
				edt_tel = (EditText) findViewById(R.id.txt_tel);
				MyDB848 myDB848 = new MyDB848(this);
				
				long saveStatus = myDB848.InsertData(edt_name.getText().toString(),
						edt_tel.getText().toString());
				
				
				if(saveStatus <= 0){
					Log.d("Error Save","Error!");
					
		}
		Toast.makeText(getApplicationContext(), "Add Data Successfull", 
				Toast.LENGTH_SHORT).show();
		
	}

}
