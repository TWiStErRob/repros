package com.example.lib.test;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThrows;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.test.platform.app.InstrumentationRegistry;

@SuppressWarnings({
		"NewClassNamingConvention", // For nested classes.
		"RedundantSuppression", // False positive, NewClassNamingConvention for nested classes.
		"JUnitTestCaseWithNoTests", // False positive, nested classes have tests.
})
@RunWith(Enclosed.class)
public class SQLiteTest {

	private static abstract class DatabaseTest {
		@Before public void setUp() {
			// Ensure that the database doesn't exist in case the APK was previously installed.
			getContext().deleteDatabase(VirtualTableOpenHelper.DATABASE_NAME);
		}
	}

	public static class FTS3 extends DatabaseTest {
		private static void test(@NonNull String moduleArgs) {
			SQLiteTest.test("FTS3", moduleArgs);
		}

		//@formatter:off
		@Test public void testDefault() { test("content"); }
		@Test public void testSimple() { test("tokenize=simple, content"); }
		@Test public void testPorter() { test("tokenize=porter, content"); }
		@Test public void testIcu() { test("tokenize=icu, content"); }
		@Test public void testUnicode61() { test("tokenize=unicode61, content"); }
		@Test public void testUnicode61Diacritics0() { test("tokenize=unicode61 'remove_diacritics=0', content"); }
		@Test public void testUnicode61Diacritics1() { test("tokenize=unicode61 'remove_diacritics=1', content"); }
		@Test public void testUnicode61Diacritics2() { test("tokenize=unicode61 'remove_diacritics=2', content"); }
		//@formatter:on

		@Test public void testInvalid() {
			SQLiteException ex = assertThrows(SQLiteException.class, () ->
					test("tokenize=invalid, content")
			);
			assertThat(ex.getMessage(), containsString("unknown tokenizer: invalid"));
		}
	}

	public static class FTS4 extends DatabaseTest {
		private static void test(@NonNull String moduleArgs) {
			SQLiteTest.test("FTS4", moduleArgs);
		}

		//@formatter:off
		@Test public void testDefault() { test("content"); }
		@Test public void testSimple() { test("tokenize=simple, content"); }
		@Test public void testPorter() { test("tokenize=porter, content"); }
		@Test public void testIcu() { test("tokenize=icu, content"); }
		@Test public void testUnicode61() { test("tokenize=unicode61, content"); }
		@Test public void testUnicode61Diacritics0() { test("tokenize=unicode61 'remove_diacritics=0', content"); }
		@Test public void testUnicode61Diacritics1() { test("tokenize=unicode61 'remove_diacritics=1', content"); }
		@Test public void testUnicode61Diacritics2() { test("tokenize=unicode61 'remove_diacritics=2', content"); }
		//@formatter:on

		@Test public void testInvalid() {
			SQLiteException ex = assertThrows(SQLiteException.class, () ->
					test("tokenize=invalid, content")
			);
			assertThat(ex.getMessage(), containsString("unknown tokenizer: invalid"));
		}
	}

	@Ignore("FTS5 is not available on Android by default.")
	public static class FTS5 extends DatabaseTest {
		private static void test(@NonNull String moduleArgs) {
			SQLiteTest.test("FTS5", moduleArgs);
		}

		//@formatter:off
		@Test public void testDefault() { test( "content"); }
		@Test public void testAscii() { test( "tokenize='ascii', content"); }
		@Test public void testPorter() { test( "tokenize='porter', content"); }
		@Test public void testPorterUnicode61Diacritics2() { test( "tokenize='porter unicode61 remove_diacritics 2', content"); }
		@Test public void testUnicode61() { test( "tokenize='unicode61', content"); }
		@Test public void testUnicode61Diacritics0() { test( "tokenize='unicode61 remove_diacritics 0', content"); }
		@Test public void testUnicode61Diacritics1() { test( "tokenize='unicode61 remove_diacritics 1', content"); }
		@Test public void testUnicode61Diacritics2() { test( "tokenize='unicode61 remove_diacritics 2', content"); }
		@Test public void testTrigram() { test( "tokenize='trigram', content"); }
		//@formatter:on

		@Test public void testInvalid() {
			SQLiteException ex = assertThrows(SQLiteException.class, () ->
					test("tokenize=invalid, content")
			);
			// Cannot assert, because FTS5 is not available on Android by default.
			//assertThat(ex.getMessage(), containsString("unknown tokenizer: invalid"));
		}
	}

	private static void test(@NonNull String moduleName, @NonNull String moduleArgs) {
		VirtualTableOpenHelper helper = new VirtualTableOpenHelper(
				getContext(),
				moduleName,
				moduleArgs
		);
		test(helper);
	}

	private static void test(@NonNull SQLiteOpenHelper helper) {
		try {
			helper.getWritableDatabase().close();
		} finally {
			helper.close();
		}
	}

	private static @NonNull Context getContext() {
		return InstrumentationRegistry.getInstrumentation().getTargetContext();
	}
}
