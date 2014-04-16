package com.example.flash;

import com.example.flash.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

/*
 * Flash
 * Dan Pezzin
 * Flash Computer Services
 * 
 * Interface of Flash App
 */

public class MainActivity extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // find our buttons and set onClickListeners for all
        ImageButton one = (ImageButton)findViewById(R.id.one);
        ImageButton two = (ImageButton)findViewById(R.id.two);
        ImageButton three = (ImageButton)findViewById(R.id.three);
        ImageButton four = (ImageButton)findViewById(R.id.four);
        ImageButton five = (ImageButton)findViewById(R.id.five);
        ImageButton six = (ImageButton)findViewById(R.id.six);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
    }

	public void onClick(View v) {

		// do something based on the button that was clicked
		switch(v.getId()) {
			case R.id.one:
					// create an intent indicating we want
					// to start the NewItem activity.
			    	Intent i = new Intent(this, NewItem.class);
			    	// start the activity based on the Intent
					startActivity(i);
					finish();
				break;
				
			case R.id.two:
					// create an intent indicating we want
					// to start the ThumbsUp activity.
					// Important! Make sure your activity is
					// in the AndroidManifest.xml file!
		    		Intent j = new Intent(this, ThumbsUp.class);
		    	
		    		// start the activity based on the Intent
		    		startActivity(j);
		    		finish();
		    		break;
		    		
			case R.id.three:
					// create an intent indicating we want
					// to start the ThumbsUp activity.
					// Important! Make sure your activity is
					// in the AndroidManifest.xml file!
		    		Intent k = new Intent(this, ThumbsUp.class);
		    	
		    		// start the activity based on the Intent
		    		startActivity(k);
					finish();
					break;
					
			case R.id.four:
					// create an intent indicating we want
					// to start the ThumbsUp activity.
					// Important! Make sure your activity is
					// in the AndroidManifest.xml file!
		    		Intent l = new Intent(this, ThumbsUp.class);
		    	
		    		// start the activity based on the Intent
		    		startActivity(l);
		    		finish();
		    		break;
				
			case R.id.five:
					// create an intent indicating we want
					// to start the ThumbsUp activity.
					// Important! Make sure your activity is
					// in the AndroidManifest.xml file!
		    		Intent m = new Intent("com.google.zxing.client.android.SCAN");
		    		m.putExtra("SCAN_MODE", "QR_CODE_MODE");
		    		// start the activity based on the Intent
		    		startActivityForResult(m, 0);
		    		finish();
		    		break;
				
			case R.id.six:
					// create an intent indicating we want
					// to start the ThumbsUp activity.
					// Important! Make sure your activity is
					// in the AndroidManifest.xml file!
		    		Intent n = new Intent(this, ThumbsUp.class);
		    	
		    		// start the activity based on the Intent
		    		startActivity(n);
		    		finish();
					break;
					default:
					finish();
		}
		
	};
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				String format = intent.getStringExtra("SCAN_RESULT_FORMAT");
				// Handle successful scan
			} else if (resultCode == RESULT_CANCELED) {
				// Handle cancel
}
		}
	}
}