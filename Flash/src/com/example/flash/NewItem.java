package com.example.flash;

import com.example.flash.R;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/*
 * New Item
 * Dan Pezzin
 * Flash Computer Services
 * 
 * Demonstrates saving and restoring data between
 * multiple Activities in the same application via
 * the SharedPreferences object.
 */

public class NewItem extends Activity implements OnClickListener {

	// define a "file name", of sorts, in which to store the preferences
	private final String PREFS_NAME = "Code2Prefs";

	// declare the textview that will show our text
	TextView display1;
	TextView display2;
	TextView display3;
	TextView display4;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newitem);
        
        // connect to the UI object
        display1 = (TextView)findViewById(R.id.textView1);
        display2 = (TextView)findViewById(R.id.textView2);
        display3 = (TextView)findViewById(R.id.textView3);
        display4 = (TextView)findViewById(R.id.textView4);
        
        // make sure to start the Edit activity when a user
        // clicks on the "Edit" button
        Button edit = (Button)findViewById(R.id.edit);
        edit.setOnClickListener(this);
    }


	/** Restore our preferences.
	  * Why might we want to restore onResume(), 
	  * rather than onCreate()?
	  */
	public void onResume() {
		// as with all overridden activity methods, we should call the 
		// same method on the parent or risk a crash.
		super.onResume();
		
		// get our SharedPreferences object
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // load data from it or use some defaults if values don't (yet?) exist
        boolean boldedText = prefs.getBoolean("boldedText", false);
        String itemName = prefs.getString("itemName", getString(R.string.item_name));
        String clientName = prefs.getString("clientName", getString(R.string.client_name));
        String date = prefs.getString("date", getString(R.string.date));
        String time = prefs.getString("time", getString(R.string.time));
        
        // we'll set the TextViews to bold, but only if the boldedText setting is true
        if(boldedText)
        	display1.setTypeface(Typeface.DEFAULT_BOLD);
        else
        	display1.setTypeface(Typeface.DEFAULT);
        
        if(boldedText)
        	display2.setTypeface(Typeface.DEFAULT_BOLD);
        else
        	display2.setTypeface(Typeface.DEFAULT);
        
        if(boldedText)
        	display3.setTypeface(Typeface.DEFAULT_BOLD);
        else
        	display3.setTypeface(Typeface.DEFAULT);
        
        if(boldedText)
        	display4.setTypeface(Typeface.DEFAULT_BOLD);
        else
        	display4.setTypeface(Typeface.DEFAULT);

        // change the text of the TextView to the saved value
        display1.setText(itemName);
        display2.setText(clientName);
        display3.setText(date);
        display4.setText(time);
	}

	/** Open the "Edit" activity on request.
	 */
	public void onClick(View v) {
    	Intent i = new Intent(this, Edit.class);
		startActivity(i);
	}
	
	
}