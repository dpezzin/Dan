package net.cs76.lectures.intents04;

import net.cs76.lectures.intents04.R;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/*
 * Intents04
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Demonstrates playing a simple sound file resource, with
 * support for pausing, restarting, and responding to a
 * completed sound event. 
 */


public class Code4 extends Activity implements OnClickListener, OnCompletionListener {

	MediaPlayer player;
	Button vroom;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // connect the button to an object
        vroom = (Button)findViewById(R.id.button);
        vroom.setOnClickListener(this);
	}

    // Consider why this instantiation is here and not in onCreate()!
    public void onResume() {
    	super.onResume();

    	// instantiate a MediaPlayer instance
		player = MediaPlayer.create(getApplicationContext(), R.raw.ferrari250);
		player.setLooping(false);
		player.setOnCompletionListener(this);
    }

    /* We should always release the MediaPlayer object when not in use. See:
     * http://developer.android.com/reference/android/media/MediaPlayer.html#release()
     */
    public void onPause() {
    	super.onPause();
    	
    	// release the MediaPlayer resource
    	player.release();
    	player = null;
    }
    
    // when the button is clicked we want to hear a sound
	public void onClick(View v) {

		// play or pause the sound, as appropriate
		if(player.isPlaying()) {
			player.pause();
			
			// reset button text
			vroom.setText(R.string.play);
		} else {
			vroom.setText(R.string.pause);
			player.start();
		}
	}
	
	// reset button text when the sound is done playing
	public void onCompletion(MediaPlayer mp) {
		vroom.setText(R.string.play);
	}
}