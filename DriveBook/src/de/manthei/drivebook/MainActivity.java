package de.manthei.drivebook;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void calcCons(View view) {
		
		EditText editDist = (EditText) findViewById(R.id.editDist);
		EditText editFuel = (EditText) findViewById(R.id.editFuel);
		EditText editCons = (EditText) findViewById(R.id.editCons);
		
		float distance = Float.parseFloat(editDist.getText().toString());
		float fuel = Float.parseFloat(editFuel.getText().toString());
		
		float consume = (fuel / distance) * 100;
		
		editCons.setText(Float.toString(consume));
		
	}
	
}
