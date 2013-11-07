package de.manthei.drivebook.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.manthei.drivebook.CarJSONActivity;
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
		assertNotNull("textManufacturerTest is null", textManufacturerTest);
		assertNotNull("textModelTest is null", textModelTest);
		assertNotNull("textEngineSizeTest is null", textEngineSizeTest);
		assertNotNull("textCcmTest is null", textCcmTest);
		assertNotNull("textPowerTest is null", textPowerTest);
		assertNotNull("textHpTest is null", textHpTest);
		assertNotNull("textVintageTest is null", textVintageTest);
		assertNotNull("textDevByTest is null", textDevByTest);
		
		assertNotNull("editManufacturerTest is null", editManufacturerTest);
		assertNotNull("editModelTest is null", editModelTest);
		assertNotNull("editEngineSizeTest is null", editEngineSizeTest);
		assertNotNull("editPowerTest is null", editPowerTest);
		assertNotNull("editVintageTest is null", editVintageTest);
		
		assertNotNull("buttonSaveTest is null", buttonSaveTest);
	}
	
	@MediumTest
	public void testTextManufacturer_labelText() {
		final String expected = jsonActivity.getString(R.string.text_manufacturer);
		final String actual = textManufacturerTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextModel_labelText() {
		final String expected = jsonActivity.getString(R.string.text_model);
		final String actual = textModelTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextEngineSize_labelText() {
		final String expected = jsonActivity.getString(R.string.text_engine_size);
		final String actual = textEngineSizeTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextCcm_labelText() {
		final String expected = jsonActivity.getString(R.string.text_ccm);
		final String actual = textCcmTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextPower_labelText() {
		final String expected = jsonActivity.getString(R.string.text_power);
		final String actual = textPowerTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextHp_labelText() {
		final String expected = jsonActivity.getString(R.string.text_hp);
		final String actual = textHpTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextVintage_labelText() {
		final String expected = jsonActivity.getString(R.string.text_vintage);
		final String actual = textVintageTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testTextDevBy_labelText() {
		final String expected = jsonActivity.getString(R.string.dev_by);
		final String actual = textDevByTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
