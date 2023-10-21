package com.example.lib.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;

public class VirtualTableOpenHelper extends SQLiteOpenHelper {
	public static final String DATABASE_NAME = "test";

	private final @NonNull String moduleName;
	private final @NonNull String moduleArgs;

	public VirtualTableOpenHelper(
			@NonNull Context context,
			@NonNull String moduleName,
			@NonNull String moduleArgs
	) {
		super(context, DATABASE_NAME, null, 1);
		this.moduleName = moduleName;
		this.moduleArgs = moduleArgs;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// https://www.sqlite.org/lang_createvtab.html
		db.execSQL("CREATE VIRTUAL TABLE Search USING " + moduleName + " (" + moduleArgs + ");");
	}

	@Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		throw new UnsupportedOperationException(
				"Cannot upgrade " + db + " from " + oldVersion + " to " + newVersion + ".");
	}
}
