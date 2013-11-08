package de.manthei.drivebook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CarJSONActivity extends Activity {

	public static final String FILE_NAME = "car.json";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_car_json);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.car_json, menu);
		return true;
	}

	public void saveJSON(View view) {
		
		EditText editManufacturer = (EditText) findViewById(R.id.editManufacturer);
		EditText editModel = (EditText) findViewById(R.id.editModel);
		EditText editEngineSize = (EditText) findViewById(R.id.editEngineSize);
		EditText editPower = (EditText) findViewById(R.id.editPower);
		EditText editVintage = (EditText) findViewById(R.id.editVintage);
		
		String manufacturer = editManufacturer.getText().toString();
		String model = editModel.getText().toString();
		String engineSize = editEngineSize.getText().toString();
		String power = editPower.getText().toString();
		String vintage = editVintage.getText().toString();
		
		FileOutputStream outputStream = null;
		JSONObject carjson = new JSONObject();
		try {
			carjson.put(getString(R.string.text_manufacturer), manufacturer);
			carjson.put(getString(R.string.text_model), model);
			carjson.put(getString(R.string.text_engine_size), engineSize);
			carjson.put(getString(R.string.text_power), power);
			carjson.put(getString(R.string.text_vintage), vintage);
			outputStream = openFileOutput(FILE_NAME, MODE_PRIVATE);
			outputStream.write(carjson.toString().getBytes());
			outputStream.close();
		} catch (JSONException e) {
			Toast.makeText(this, "JSON creation failed", Toast.LENGTH_SHORT).show();
		} catch (FileNotFoundException e) {
			Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
		} catch (IOException e) {
			Toast.makeText(this, "Writer failed", Toast.LENGTH_SHORT).show();
		}
		
	}
	
}
