package de.manthei.drivebook;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class FuelDataSource {

	private SQLiteDatabase database;
	private DriveBookDatabaseHelper driveBookDatabaseHelper;
	private String[] allColumns = {FuelTable.COLUMN_ID, FuelTable.COLUMN_MEASURE, FuelTable.COLUMN_COST,
			FuelTable.COLUMN_MILEAGE, FuelTable.COLUMN_SUMMER, FuelTable.COLUMN_DATE};
	
	public FuelDataSource(Context context) {
		driveBookDatabaseHelper = new DriveBookDatabaseHelper(context);
	}
	
	public void open() {
		database = driveBookDatabaseHelper.getWritableDatabase();
	}
	
	public void close() {
		driveBookDatabaseHelper.close();
	}
	
	public Fuel createFuel(double measure, double cost,	
			double mileage, boolean summer, Date date) {
		ContentValues values = new ContentValues();
		values.put(FuelTable.COLUMN_MEASURE, measure);
		values.put(FuelTable.COLUMN_COST, cost);
		values.put(FuelTable.COLUMN_MILEAGE, mileage);
		values.put(FuelTable.COLUMN_SUMMER, summer);
		values.put(FuelTable.COLUMN_DATE, date.getTime());
		long insertId = database.insert(FuelTable.TABLE_FUEL, null, values);
		Cursor cursor = database.query(FuelTable.TABLE_FUEL, allColumns, FuelTable.TABLE_FUEL + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();
		Fuel newFuel = cursorToFuel(cursor);
		cursor.close();
		return newFuel;
	}
	
	public void deleteFuel(Fuel fuel) {
		long id = fuel.getId();
		System.out.println("Comment deleted with id: " + id);
		database.delete(FuelTable.TABLE_FUEL, FuelTable.COLUMN_ID + " = " + id, null);
	}
	
	public List<Fuel> getAllFuels() {
		List<Fuel> fuels = new ArrayList<Fuel>();
		Cursor cursor = database.query(FuelTable.TABLE_FUEL, allColumns, null, null, null, null, null);
		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			Fuel fuel = cursorToFuel(cursor);
			fuels.add(fuel);
			cursor.moveToNext();
		}
		cursor.close();
		return fuels;
	}
	
	private Fuel cursorToFuel(Cursor cursor) {
		Fuel fuel = new Fuel();
		fuel.setId(cursor.getInt(0));
		fuel.setMeasure(cursor.getDouble(1));
		fuel.setCost(cursor.getDouble(2));
		fuel.setMileage(cursor.getDouble(3));
		fuel.setSummer(cursor.getInt(4) == 1);
		fuel.setDate(new Date(cursor.getLong(5)));
		return fuel;
	}
	
}
