package net.cs76.lectures.activity08;

import net.cs76.lectures.activity08.R;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.Toast;

/*
 * Activity08
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Another (better?) way to implement event handlers.
 */


public class Code8 extends Activity implements OnClickListener, OnLongClickListener {

	private Button accept, cancel;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // find our button in the UI by its ID
        accept = (Button)findViewById(R.id.accept);
        
        // set listeners for the button. Since our current class
        // implements OnClickListener and OnLongClickListener interfaces
        // we can simply pass the current object ("this") into
        // the listeners. The appropriate methods will therefore
        // be called when the event fires.
        accept.setOnClickListener(this);
        accept.setOnLongClickListener(this);
        
        // find our button in the UI by its ID
        cancel = (Button)findViewById(R.id.cancel);

        // set listeners for the button
        cancel.setOnClickListener(this);
        cancel.setOnLongClickListener(this);

    }

    /* display a Toast with message text. */
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }

    /* implement an event handler that responds to click events */
	public void onClick(View v) {
		CharSequence text;

		// find out which button was pushed based on its ID
		switch(v.getId()) {
			case R.id.accept: text = "'accept' clicked!"; break;
			case R.id.cancel: text = "'cancel' clicked!"; break;
			default: text="Dunno what was pushed!";
		}

		// notify the user which button was clicked
		showMessage(text);
	}

	/* implement an event handler that responds to long click events */
	public boolean onLongClick(View v) {
		// we're only accepting LongClick events from buttons,
		// so we'll caste our View as a button to access its text.
		Button pushed = (Button)v;

		// no need to figure out which button was clicked! We can
		// ask it by way of the Button's getText() method.
		showMessage(pushed.getText() + " LongClick'd!");

		// we must return true to notify upstream processes that
		// we've handled the onLongClick event.
		return true;
	}

	

}