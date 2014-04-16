package net.cs76.lectures.activity04;

import android.app.Activity;
import android.os.Bundle;
import net.cs76.lectures.activity04.R;

/*
 * Activity04
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Demonstrates layout options including layout_, gravity, 
 * and weights.
 */

public class Code4 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}