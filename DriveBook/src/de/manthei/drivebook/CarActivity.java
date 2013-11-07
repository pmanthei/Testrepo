package de.manthei.drivebook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class CarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car);
		// Show the Up button in the action bar.
		setupActionBar();
		
		try {
			FileInputStream inputStream = openFileInput(CarJSONActivity.FILE_NAME);
			int size = inputStream.available();
			byte[] buffer = new byte[size];
			inputStream.read(buffer);
			inputStream.close();
			String json = new String(buffer);
			JSONObject jsonObject = new JSONObject(json);
			
			TextView manufacturer = (TextView) findViewById(R.id.textInputCarManufacturer);
			TextView model = (TextView) findViewById(R.id.textInputCarModel);
			TextView engineSize = (TextView) findViewById(R.id.textInputCarEngineSize);
			TextView power = (TextView) findViewById(R.id.textInputCarPower);
			TextView vintage = (TextView) findViewById(R.id.textInputCarVintage);
			
			manufacturer.setText(jsonObject.getString(getString(R.string.text_manufacturer)));
			model.setText(jsonObject.getString(getString(R.string.text_model)));
			engineSize.setText(jsonObject.getString(getString(R.string.text_engine_size)));
			power.setText(jsonObject.getString(getString(R.string.text_power)));
			vintage.setText(jsonObject.getString(getString(R.string.text_vintage)));
			
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "Can't open file!", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, "Can't read file!", Toast.LENGTH_SHORT).show();
		} catch (JSONException e) {
			Toast.makeText(this, "Can't create JSONObject!", Toast.LENGTH_SHORT).show();
		}
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
