import android.support.v4.app.*;
import android.support.v7.app.*;

public class MyActivity extends AppCompatActivity {
	void f() {
		updateFragment(new Fragment()).commit();
	}
	private FragmentTransaction updateFragment(Fragment fragment) {
		return getSupportFragmentManager()
				.beginTransaction() // This transaction should be completed with a commit() call
				.replace(android.R.id.content, fragment)
				;
	}
}
