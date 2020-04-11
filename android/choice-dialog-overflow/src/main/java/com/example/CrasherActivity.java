package com.example;

import android.annotation.TargetApi;
import android.app.*;
import android.content.Context;
import android.database.*;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ResourceCursorAdapter;

public class CrasherActivity extends Activity {

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(createUI());
	}
	
	private View createUI() {
		Button button = new Button(this);
		button.setText("Show Dialog");
		button.setOnClickListener(new OnClickListener() {
			@Override public void onClick(View v) {
				showDialog();
			}
		});
		return button;
	}

	private void showDialog() {
		Cursor initialData = null;
		final ResourceCursorAdapter adapter =
				new ResourceCursorAdapter(this, android.R.layout.simple_list_item_1, initialData) {
					@Override public void bindView(View view, Context context, Cursor cursor) {
						TextView item = view.findViewById(android.R.id.text1);
						item.setText(cursor.getString(cursor.getColumnIndexOrThrow("_id")));
					}
				};

		AlertDialog dialog = new AlertDialog.Builder(this)
				.setTitle("Dialog Title")
				.setSingleChoiceItems(adapter, -1, null)
				.create();
		dialog.show();

		dialog.getListView().post(new Runnable() {
			@Override public void run() {
				adapter.swapCursor(fakeData(10));
			}
		});
	}

	@TargetApi(VERSION_CODES.KITKAT)
	private Cursor fakeData(int count) {
		final MatrixCursor cursor = new MatrixCursor(new String[] {"_id"}, 0);
		for (int i = 0; i < count; ++i) {
			cursor.newRow().add("_id", i);
		}
		return cursor;
	}
}
