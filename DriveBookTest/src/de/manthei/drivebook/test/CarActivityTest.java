package de.manthei.drivebook.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.TextView;
import de.manthei.drivebook.CarActivity;
import de.manthei.drivebook.R;

public class CarActivityTest extends ActivityUnitTestCase<CarActivity> {

	private CarActivity carActivity;
	
	private TextView carManufacturerTest;
	private TextView carModelTest;
	private TextView carEngineSizeTest;
	private TextView carPowerTest;
	private TextView carVintageTest;
	
	public CarActivityTest() {
		super(CarActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), CarActivity.class);
		startActivity(intent, null, null);
		carActivity = getActivity();
		
		carManufacturerTest = (TextView) carActivity.findViewById(R.id.textManufacturer);		
		carModelTest = (TextView) carActivity.findViewById(R.id.textModel);		
		carEngineSizeTest = (TextView) carActivity.findViewById(R.id.textEngineSize);		
		carPowerTest = (TextView) carActivity.findViewById(R.id.textPower);		
		carVintageTest = (TextView) carActivity.findViewById(R.id.textVintage);		
	}

	@MediumTest
	public void testPreconditions() {
		assertNotNull("textManufacturerTest is null", carManufacturerTest);
		assertNotNull("textModelTest is null", carModelTest);
		assertNotNull("textEngineSizeTest is null", carEngineSizeTest);
		assertNotNull("textPowerTest is null", carPowerTest);
		assertNotNull("textVintageTest is null", carVintageTest);
	}

	@MediumTest
	public void testTextManufacturer_labelText() {
		final String expected = carActivity.getString(R.string.text_manufacturer);
		final String actual = carManufacturerTest.getText().toString();
		assertEquals(expected, actual);
	}

	@MediumTest
	public void testTextModel_labelText() {
		final String expected = carActivity.getString(R.string.text_model);
		final String actual = carModelTest.getText().toString();
		assertEquals(expected, actual);
	}

	@MediumTest
	public void testTextEngineSize_labelText() {
		final String expected = carActivity.getString(R.string.text_engine_size);
		final String actual = carEngineSizeTest.getText().toString();
		assertEquals(expected, actual);
	}

	@MediumTest
	public void testTextPower_labelText() {
		final String expected = carActivity.getString(R.string.text_power);
		final String actual = carPowerTest.getText().toString();
		assertEquals(expected, actual);
	}

	@MediumTest
	public void testTextVintage_labelText() {
		final String expected = carActivity.getString(R.string.text_vintage);
		final String actual = carVintageTest.getText().toString();
		assertEquals(expected, actual);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
