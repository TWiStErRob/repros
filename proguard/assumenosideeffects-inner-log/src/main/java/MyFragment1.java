import java.io.File;

import org.slf4j.*;

import android.content.*;
import android.os.*;

public class MyFragment1 extends android.support.v4.app.Fragment  {
	static final Logger LOG = LoggerFactory.getLogger(MyFragment1.class);

	@Override public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		new Thread(new Runnable() {
			public void run() {
				System.out.println("sout");
				LOG.info("log");
			}
		}).start();
	}
}
