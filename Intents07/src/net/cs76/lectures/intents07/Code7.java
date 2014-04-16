package net.cs76.lectures.intents07;

import net.cs76.lectures.intents07.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * Intents07
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Using Intents to start Activities from other applications. 
 */

public class Code7 extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // find all buttons in the layout
        Button url   = (Button)findViewById(R.id.url);
        Button tel   = (Button)findViewById(R.id.tel);
        Button map   = (Button)findViewById(R.id.map);
        Button stvw  = (Button)findViewById(R.id.stview);
        Button sms   = (Button)findViewById(R.id.sms);
        Button email = (Button)findViewById(R.id.email);

        // set event handlers for each button
        url.setOnClickListener(this);
        tel.setOnClickListener(this);
        map.setOnClickListener(this);
        stvw.setOnClickListener(this);
        sms.setOnClickListener(this);
        email.setOnClickListener(this);
        
    }
    
    /* display a Toast with message text. */
    private void showMessage(CharSequence text) {
		Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
		toast.show();    	
    }
    
    /* implement an even handler when a button is pushed */
    public void onClick(View v) {

    	// create an Intent object (we'll fill with data soon)
    	Intent data = new Intent();
    	
    	// switch, dependent on button that was pushed
    	switch(v.getId()) {

    		case R.id.url: 
    			// activities require an action to perform and data to act on
    			data.setAction(Intent.ACTION_VIEW);
    			data.setData(Uri.parse("http://www.cs76.net"));
    			break;

    		case R.id.tel: 
    			data.setAction(Intent.ACTION_DIAL);
    			data.setData(Uri.parse("tel:(234) 567-8901"));
    			break;

    		case R.id.map: 
    			data.setAction(Intent.ACTION_VIEW);
    			data.setData(Uri.parse("geo:0,0?q=el+paso,+tx"));
    			break;

    		case R.id.stview:
    			data.setAction(Intent.ACTION_VIEW);
    			/* Query fields for the URI:
    			 * cbll=latitude,longitude
    			 * cbp= street view window details
    			 * See: http://mapki.com/index.php?title=Google_Map_Parameters
    			 */
    			data.setData(Uri.parse("google.streetview:cbll=42.379069,-71.116564&cbp=12,60,,0,-1.21&mz=18"));
    			break;

    		case R.id.sms:
    			data.setAction(Intent.ACTION_VIEW);
    			data.setData(Uri.parse("sms:(234) 567-8901"));
    			data.putExtra(Intent.EXTRA_TEXT, "Hello from "+getResources().getString(R.string.app_name));
    			break;


    		case R.id.email:
    		default:
    			data.setAction(Intent.ACTION_SEND);
    			data.setType("text/plain");
    			data.putExtra(Intent.EXTRA_EMAIL, new String[] {"danallan@mit.edu"});
    			data.putExtra(Intent.EXTRA_SUBJECT, "Hello!");
    			data.putExtra(Intent.EXTRA_TEXT, "Message body.\n--Dan");
    			break;
    	}
    	
		// try to open the activity
    	try {
    		startActivity(data); 
    	} catch (ActivityNotFoundException e) {
    		// do something if the activity appropriate for that intent/URI is not found
    		showMessage("Activity not found!");
    		return;
    	}

    	// Alternatively, if we wanted to force the
    	// user to pick an app to use for the intent:
		//startActivity(Intent.createChooser(data, "Send mail..."));
   
    	// OR, if you want to force a specific Activity from a specific
    	// package, specify the ComponentName:
    	// http://developer.android.com/reference/android/content/ComponentName.html
    	// setComponent();
    	
    }
}