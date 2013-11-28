package de.manthei.drivebook;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class FuelTable {

	// Database table
	public static final String TABLE_FUEL = "fuel";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_MEASURE = "measure";
	public static final String COLUMN_COST = "cost";
	public static final String COLUMN_DATE = "date";

	// Database creation SQL statement
	private static final String DATABASE_CREATE = "create table if not exists " 
			+ TABLE_FUEL
			+ "(" + COLUMN_ID + " integer primary key autoincrement, " 
			+ COLUMN_MEASURE + " decimal(10,2) not null, " 
			+ COLUMN_COST + " decimal(10,2) not null," 
			+ COLUMN_DATE + " text not null" + ");";
	
	public static void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	public static void onUpgrade(SQLiteDatabase database, int oldVersion,
			int newVersion) {
		Log.w(FuelTable.class.getName(), "Upgrading database from version "
				+ oldVersion + " to " + newVersion);
		onCreate(database);
	}
	
}
