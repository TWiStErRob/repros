package com.example;

import org.junit.Rule;
import org.junit.Test;

import android.widget.TextView;

import app.cash.paparazzi.DeviceConfig;
import app.cash.paparazzi.EnvironmentKt;
import app.cash.paparazzi.HtmlReportWriter;
import app.cash.paparazzi.Paparazzi;
import app.cash.paparazzi.SnapshotVerifier;

public class ATest {

	@Rule
	public Paparazzi paparazzi = new Paparazzi();

	@Test
	public void test() {
		TextView view = new TextView(paparazzi.getContext());

		view.setText("text");

		paparazzi.snapshot(view, null, null, null);
	}
}
