import java.io.File;

import org.slf4j.*;

import android.content.*;
import android.os.*;

public class MyFragment2 extends android.support.v4.app.Fragment  {
	private static final Logger LOG = LoggerFactory.getLogger(MyFragment2.class);

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
