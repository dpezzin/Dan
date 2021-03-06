package com.example.flash;

import com.example.flash.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * ThumbsUp.java
 * A second activity.
 */

public class ThumbsUp extends Activity implements OnClickListener {

	// As with the Activities we've seen thus far, the system
	// calls the onCreate() method when an Activity starts up.
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// call the parent's onCreate() method.
        super.onCreate(savedInstanceState);
        
        // set the ContentView to a layout we designed
        // for this activity.
        setContentView(R.layout.thumbsup);
        
        // Retrieve the button and set an onClickListener
        Button ok = (Button)findViewById(R.id.OK);
        ok.setOnClickListener(this);

    }

	// When a button is clicked, we'll run the finished()
	// method which ends this activity.
	public void onClick(View v) {
		finish();
	}

}
