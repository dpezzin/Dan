package com.example.flash;

import com.example.flash.R;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/*
 * Edit
 * Dan Pezzin
 * Flash Computer Services
 * 
 * Allows the user to change some settings for the text that
 * was displayed in the initial Activity, and save them via
 * the SharedPreferences object.
 */

public class Edit extends Activity implements OnClickListener {

	// fields for each UI element
	Button save, cancel;
	CheckBox bold;
	EditText text1, text2, text3, text4;

	// define a "file name", of sorts, in which to store the preferences
	private final String PREFS_NAME = "Code2Prefs";


	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        
        // connect to View objects
        save =   (Button)findViewById(R.id.save);
        cancel = (Button)findViewById(R.id.cancel);
        bold =   (CheckBox)findViewById(R.id.checkBox);
        text1 =   (EditText)findViewById(R.id.itemName);
        text2 =   (EditText)findViewById(R.id.clientName);
        text3 =   (EditText)findViewById(R.id.date);
        text4 =   (EditText)findViewById(R.id.time);
        
        // make sure our buttons do something
        save.setOnClickListener(this);
        cancel.setOnClickListener(this);
        
        // load saved preferences
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        // check the checkbox if the stored preference is true
        boolean boldedText = prefs.getBoolean("boldedText", false);
        bold.setChecked(boldedText);
        
        // set the EditText views to the current string
        String itemName = prefs.getString("itemName", getString(R.string.item_name));
        text1.setText(itemName);
        
        String clientName = prefs.getString("clientName", getString(R.string.client_name));
        text2.setText(clientName);
        
        String date = prefs.getString("date", getString(R.string.date));
        text3.setText(date);
        
        String time = prefs.getString("time", getString(R.string.time));
        text4.setText(time);
        
	}


	/** Save the settings to PREFS_NAME via SharedPreferences
	 * object when requested.
	 */
	private void savePrefs() {
		// get our SharedPreferences object and create an editor for it
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();

		// place our settings in the object
		editor.putBoolean("boldedText", bold.isChecked());
		editor.putString("itemName", text1.getText().toString());
		editor.putString("clientName", text2.getText().toString());
		editor.putString("date", text3.getText().toString());
		editor.putString("time", text4.getText().toString());
		
    	// we must commit the preferences or they won't be saved!
    	editor.commit();
		
	}


	/** Save the data, if requested, and quit this activity
	  */
	public void onClick(View v) {
		// save the preferences if the "Save" button was pushed
		if(v.getId() == R.id.save) savePrefs();
		
		// in either case, we'll close this activity
		finish();
	}

	
}
