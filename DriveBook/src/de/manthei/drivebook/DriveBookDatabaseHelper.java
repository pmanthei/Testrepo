package de.manthei.drivebook;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DriveBookDatabaseHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "todotable.db";
	private static final int DATABASE_VERSION = 1;
	
	public DriveBookDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		FuelTable.onCreate(arg0);
		TripTable.onCreate(arg0);
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		FuelTable.onUpgrade(arg0, arg1, arg2);
		TripTable.onUpgrade(arg0, arg1, arg2);
	}

}
