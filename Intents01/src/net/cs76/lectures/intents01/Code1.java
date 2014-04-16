package net.cs76.lectures.intents01;

import net.cs76.lectures.intents01.R;
import android.app.Activity;
import android.os.Bundle;

/*
 * Intents01
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Demonstrating simple resource types. 
 * Compare this code and layout to that of Activity03,
 * on which this project is based.
 */

public class Code1 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.main);

    }
}