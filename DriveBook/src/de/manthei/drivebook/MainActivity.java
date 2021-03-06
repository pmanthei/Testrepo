package de.manthei.drivebook;

import java.io.File;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private File jsonFile;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		jsonFile = new File(getFilesDir(), CarJSONActivity.FILE_NAME);
		startActivityWhenFileExists(CarJSONActivity.class);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_car:
			startActivityWhenFileExists(CarActivity.class);
			break;
		case R.id.menu_overview:
			Intent intent = new Intent(this, null);
			startActivity(intent);
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClick(View view) {
		
		EditText editDist = (EditText) findViewById(R.id.editDist);
		EditText editFuel = (EditText) findViewById(R.id.editFuel);
		EditText editPrice = (EditText) findViewById(R.id.editPrice);
		EditText editCons = (EditText) findViewById(R.id.editCons);
		EditText editCost = (EditText) findViewById(R.id.editCost);
		
		if (	isEmpty(editDist, this.getText(R.string.text_dist).toString()) || 
				isEmpty(editFuel, this.getText(R.string.text_fuel).toString()) || 
				isEmpty(editPrice, this.getText(R.string.text_price).toString()) ) {
			return;
		}
		
		CarConsume carConsume = new CarConsume(Float.parseFloat(editDist.getText().toString()), 
				Float.parseFloat(editFuel.getText().toString()), 
				Float.parseFloat(editPrice.getText().toString()));
		
		DecimalFormat format = new DecimalFormat("#.###");
		format.setRoundingMode(RoundingMode.HALF_UP);
		
		editCons.setText(format.format(carConsume.getConsume()));
		editCost.setText(format.format(carConsume.getCost()));
		
		FuelDataSource dataSource = new FuelDataSource(this);
		dataSource.open();
		dataSource.createFuel(Double.parseDouble(editFuel.getText().toString()), 
				Double.parseDouble(editPrice.getText().toString()), 
				Double.parseDouble(editDist.getText().toString()), 
				false, Calendar.getInstance().getTime());
		dataSource.close();
	}
	
	private boolean isEmpty(final EditText editText, final String fieldName) {
		String text = editText.getText().toString();
		if (text.isEmpty() || text.equals(".")) {
			Toast.makeText(this, fieldName + " ist leer!", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
	
	private void startActivityWhenFileExists(Class<?> cls) {
		if (!jsonFile.exists()) {
			Intent intent = new Intent(this, cls);
			startActivity(intent);
		}		
	}
	
}
