package de.manthei.drivebook.test;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import de.manthei.drivebook.MainActivity;
import de.manthei.drivebook.R;

public class MainActivityTest extends ActivityUnitTestCase<MainActivity> {

	private MainActivity activity;
	
	private TextView textDistTest;
	private TextView textKmTest;
	private TextView textFuelTest;
	private TextView textLiterTest;
	private TextView textPriceTest;
	private TextView textEuroTest;
	private TextView textConsTest;
	private TextView textLPerKmTest;
	private TextView textCostTest;
	private TextView textEuroPerKmTest;
	private TextView textDevTest;
	
	private EditText editDistTest;
	private EditText editFuelTest;
	private EditText editPriceTest;
	private EditText editConsTest;
	private EditText editCostTest;
	
	private Button buttonCalcTest;	
	
	public MainActivityTest() {
		super(MainActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		Intent intent = new Intent(getInstrumentation().getTargetContext(), MainActivity.class);
		startActivity(intent, null, null);
		activity = getActivity();

		textDistTest = (TextView) activity.findViewById(R.id.textDist);
		textKmTest = (TextView) activity.findViewById(R.id.textKm);
		textFuelTest = (TextView) activity.findViewById(R.id.textFuel);
		textLiterTest = (TextView) activity.findViewById(R.id.textLiter);
		textPriceTest = (TextView) activity.findViewById(R.id.textPrice);
		textEuroTest = (TextView) activity.findViewById(R.id.textEuro);
		textConsTest = (TextView) activity.findViewById(R.id.textCons);
		textLPerKmTest = (TextView) activity.findViewById(R.id.textLPerKm);
		textCostTest = (TextView) activity.findViewById(R.id.textCost);
		textEuroPerKmTest = (TextView) activity.findViewById(R.id.textEuroPerKm);
		textDevTest = (TextView) activity.findViewById(R.id.textDev);
		
		editDistTest = (EditText) activity.findViewById(R.id.editDist);
		editFuelTest = (EditText) activity.findViewById(R.id.editFuel);
		editPriceTest = (EditText) activity.findViewById(R.id.editPrice);
		editConsTest = (EditText) activity.findViewById(R.id.editCons);
		editCostTest = (EditText) activity.findViewById(R.id.editCost);
		
		buttonCalcTest = (Button) activity.findViewById(R.id.buttonCalc);	
	}

	@MediumTest
	public void testPreconditions() {
		assertNotNull("activity is null", activity);
		assertNotNull("textDistTest is null", textDistTest);
		assertNotNull("textKmTest is null", textKmTest);
		assertNotNull("textFuelTest is null", textFuelTest);
		assertNotNull("textLiterTest is null", textLiterTest);
		assertNotNull("textPriceTest is null", textPriceTest);
		assertNotNull("textEuroTest is null", textEuroTest);
		assertNotNull("textConsTest is null", textConsTest);
		assertNotNull("textLPerKmTest is null", textLPerKmTest);
		assertNotNull("textCostTest is null", textCostTest);
		assertNotNull("textEuroPerKmTest is null", textEuroPerKmTest);
		assertNotNull("textDevTest is null", textDevTest);
		assertNotNull("editDistTest is null", editDistTest);
		assertNotNull("editFuelTest is null", editFuelTest);
		assertNotNull("editPriceTest is null", editPriceTest);
		assertNotNull("editConsTest is null", editConsTest);
		assertNotNull("editCostTest is null", editCostTest);
		assertNotNull("buttonCalcTest is null", buttonCalcTest);
	}
	@MediumTest
	public void testTextDist_labelText() {
		final String expected = activity.getString(R.string.text_dist);
		final String actual = textDistTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextKm_labelText() {
		final String expected = activity.getString(R.string.text_km);
		final String actual = textKmTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextFuel_labelText() {
		final String expected = activity.getString(R.string.text_fuel);
		final String actual = textFuelTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextLiter_labelText() {
		final String expected = activity.getString(R.string.text_liter);
		final String actual = textLiterTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextPrice_labelText() {
		final String expected = activity.getString(R.string.text_price);
		final String actual = textPriceTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextEuro_labelText() {
		final String expected = activity.getString(R.string.text_euro);
		final String actual = textEuroTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextCons_labelText() {
		final String expected = activity.getString(R.string.text_cons);
		final String actual = textConsTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextLPerKm_labelText() {
		final String expected = activity.getString(R.string.text_lperkm);
		final String actual = textLPerKmTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextCost_labelText() {
		final String expected = activity.getString(R.string.text_cost);
		final String actual = textCostTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextEuroPerKm_labelText() {
		final String expected = activity.getString(R.string.text_europerkm);
		final String actual = textEuroPerKmTest.getText().toString();
		assertEquals(expected, actual);
	}
	@MediumTest
	public void testTextDev_labelText() {
		final String expected = activity.getString(R.string.dev_by);
		final String actual = textDevTest.getText().toString();
		assertEquals(expected, actual);
	}
	
	@MediumTest
	public void testOnClick(){
		editDistTest.setText("100.00");
		editFuelTest.setText("10.00");
		editPriceTest.setText("10.00");
		buttonCalcTest.performClick();
		final String cons = editConsTest.getText().toString();
		final String cost = editCostTest.getText().toString();
		assertEquals("Cons failed", "10", cons);
		assertEquals("Cost failed", "0,1", cost);
	}
	
	@MediumTest
	public void testOnClickDistEmpty(){
		editDistTest.setText("");
		editFuelTest.setText("10.00");
		editPriceTest.setText("10.00");
		buttonCalcTest.performClick();
		final String cons = editConsTest.getText().toString();
		final String cost = editCostTest.getText().toString();
		assertEquals("Cons failed", "", cons);
		assertEquals("Cost failed", "", cost);
	}
	
	@MediumTest
	public void testOnClickFuelEmpty(){
		editDistTest.setText("100.00");
		editFuelTest.setText("");
		editPriceTest.setText("10.00");
		buttonCalcTest.performClick();
		final String cons = editConsTest.getText().toString();
		final String cost = editCostTest.getText().toString();
		assertEquals("Cons failed", "", cons);
		assertEquals("Cost failed", "", cost);
	}
	
	@MediumTest
	public void testOnClickPriceEmpty(){
		editDistTest.setText("100.00");
		editFuelTest.setText("10.00");
		editPriceTest.setText("");
		buttonCalcTest.performClick();
		final String cons = editConsTest.getText().toString();
		final String cost = editCostTest.getText().toString();
		assertEquals("Cons failed", "", cons);
		assertEquals("Cost failed", "", cost);
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
