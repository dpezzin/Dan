package net.cs76.lectures.activity06;

import net.cs76.lectures.activity06.R;
import android.app.Activity;
import android.os.Bundle;

/*
 * Activity06
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Demonstrates a RelativeLayout
 * Code adapted from:
 * http://developer.android.com/resources/tutorials/views/hello-relativelayout.html
 */


public class Code6 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}