package de.manthei.drivebook;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TripTable {

	// Database table
	public static final String TABLE_TRIP = "trip";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_MILEAGE = "mileage";
	public static final String COLUMN_SUMMER = "summer";
	public static final String COLUMN_FUELID = "fuelId";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "create table if not exists " 
			+ TABLE_TRIP
			+ "(" + COLUMN_ID + " integer primary key autoincrement, " 
			+ COLUMN_MILEAGE + " decimal(10,2) not null, " 
			+ COLUMN_SUMMER + " boolean not null," 
			+ COLUMN_FUELID + " integer not null," 
			+ "foreign key " + COLUMN_FUELID + " references " 
			+ FuelTable.TABLE_FUEL + "." + FuelTable.COLUMN_ID + ");";

	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(TripTable.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion);
		onCreate(database);
	}
	
}
