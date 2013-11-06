package de.manthei.drivebook;

import java.math.RoundingMode;
import java.text.DecimalFormat;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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

	public void onClick(View view) {
		
		EditText editDist = (EditText) findViewById(R.id.editDist);
		EditText editFuel = (EditText) findViewById(R.id.editFuel);
		EditText editPrice = (EditText) findViewById(R.id.editPrice);
		EditText editCons = (EditText) findViewById(R.id.editCons);
		EditText editCost = (EditText) findViewById(R.id.editCost);
		
		if (	isEmpty(editDist, this.getText(R.id.textDist).toString()) || 
				isEmpty(editFuel, this.getText(R.id.textFuel).toString()) || 
				isEmpty(editPrice, this.getText(R.id.textPrice).toString()) ) {
			return;
		}
		
		double distance = Float.parseFloat(editDist.getText().toString());
		double fuel = Float.parseFloat(editFuel.getText().toString());
		double price = Float.parseFloat(editPrice.getText().toString());
		
		if (fuel == 0 || distance == 0 || price == 0) {
			Toast.makeText(this, "Felder dürfen nicht 0 sein.", Toast.LENGTH_SHORT).show();
			return;
		}
		
		DecimalFormat format = new DecimalFormat("#.###");
		format.setRoundingMode(RoundingMode.HALF_UP);
		
		double consume = (fuel / distance) * 100;
		double cost = price / distance;
		
		editCons.setText(format.format(consume));
		editCost.setText(format.format(cost));
		
	}
	
	private boolean isEmpty(final EditText editText, final String fieldName) {
		String text = editText.getText().toString();
		if (text.isEmpty() || text.equals(".")) {
			Toast.makeText(this, fieldName + " ist leer!", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
	
}
