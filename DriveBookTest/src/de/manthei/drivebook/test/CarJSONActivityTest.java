package de.manthei.drivebook.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.manthei.drivebook.CarJSONActivity;
import de.manthei.drivebook.MainActivity;
import de.manthei.drivebook.R;

public class CarJSONActivityTest extends ActivityUnitTestCase<CarJSONActivity> {

	private CarJSONActivity jsonActivity;
	
	private TextView textManufacturerTest;
	private TextView textModelTest;
	private TextView textEngineSizeTest;
	private TextView textCcmTest;
	private TextView textPowerTest;
	private TextView textHpTest;
	private TextView textVintageTest;
	private TextView textDevByTest;
	
	private EditText editManufacturerTest;
	private EditText editModelTest;
	private EditText editEngineSizeTest;
	private EditText editPowerTest;
	private EditText editVintageTest;
	
	private Button buttonSaveTest;
	
	public CarJSONActivityTest() {
		super(CarJSONActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), CarJSONActivity.class);
		startActivity(intent, null, null);
		jsonActivity = getActivity();
		
		textManufacturerTest = (TextView) jsonActivity.findViewById(R.id.textManufacturer);
		textModelTest = (TextView) jsonActivity.findViewById(R.id.textModel);
		textEngineSizeTest = (TextView) jsonActivity.findViewById(R.id.textEngineSize);
		textCcmTest = (TextView) jsonActivity.findViewById(R.id.textCcm);
		textPowerTest = (TextView) jsonActivity.findViewById(R.id.textPower);
		textHpTest = (TextView) jsonActivity.findViewById(R.id.textHp);
		textVintageTest = (TextView) jsonActivity.findViewById(R.id.textVintage);
		textDevByTest = (TextView) jsonActivity.findViewById(R.id.textDevBy);
		
		editManufacturerTest = (EditText) jsonActivity.findViewById(R.id.editManufacturer);
		editModelTest = (EditText) jsonActivity.findViewById(R.id.editModel);
		editEngineSizeTest = (EditText) jsonActivity.findViewById(R.id.editEngineSize);
		editPowerTest = (EditText) jsonActivity.findViewById(R.id.editPower);
		editVintageTest = (EditText) jsonActivity.findViewById(R.id.editVintage);
		
		buttonSaveTest = (Button) jsonActivity.findViewById(R.id.buttonSave);
	}

	@MediumTest
	public void testPreconditions() {
		
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
