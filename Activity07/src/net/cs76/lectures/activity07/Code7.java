package net.cs76.lectures.activity07;

import net.cs76.lectures.activity07.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * Activity07
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Introducing event handlers to allow user interaction.
 */


public class Code7 extends Activity {

	// define an OnClickListener that is an anonymous function
    private OnClickListener respondToClick = new OnClickListener() {
    	// the onClick() method is called when the OnClickListener
    	// detects a click event.
    	public void onClick(View v) {
    		// get the current context to display a Toast (below)
    		Context context = getApplicationContext();

    		CharSequence text;

    		// figure out which button was clicked by comparing
    		// the View's ID with known IDs.
    		switch(v.getId()) {
	    		case R.id.accept: text = "accept pushed!"; break;
	    		case R.id.cancel: text = "cancel pushed!"; break;
	    		default: text="Dunno what was pushed!";
    		}

    		// show a Toast for a short amount of time, displaying
    		// which button was pushed.
    		int duration = Toast.LENGTH_SHORT;
    		Toast toast = Toast.makeText(context, text, duration);
    		toast.show();
    	}

    };
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // find our button in the UI by its ID
        Button accept = (Button)findViewById(R.id.accept);

        // tell the OnClickListener which method to call
        // when a click is detected.
        accept.setOnClickListener(respondToClick);

        
        // find our button in the UI by its ID
        Button cancel = (Button)findViewById(R.id.cancel);

        // tell the OnClickListener which method to call
        // when a click is detected.
        cancel.setOnClickListener(respondToClick);

    }

}