import android.os.AsyncTask;

class C {
	public static void f(String param) {
		class CustomInternalTask extends AsyncTask<Void, Void, Void> {
			@Override protected Void doInBackground(Void... params) {
				return null;
			}
		}
		new CustomInternalTask().execute();
	}
}
