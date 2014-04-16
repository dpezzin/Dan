package net.cs76.lectures.activity09;

import net.cs76.lectures.activity09.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/*
 * Activity09
 * Dan Armendariz
 * Computer Science E-76
 * 
 * A better dialog and accessing data from the text box.
 */


public class Code9 extends Activity implements OnClickListener {

	private Button accept, cancel;
	private EditText numberStudents;

	// define some nice names for our Dialog IDs
	static final int DIALOG_CANCEL_ID = 0;
	static final int DIALOG_ACCEPT_ID = 1;
	

	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // find our button in the UI by its ID and assign a listener
        accept = (Button)findViewById(R.id.accept);
        accept.setOnClickListener(this);
        
        // find our button in the UI by its ID and assign a listener
        cancel = (Button)findViewById(R.id.cancel);
        cancel.setOnClickListener(this);

        // find our text field by its ID
        numberStudents = (EditText)findViewById(R.id.numberStudents);
    }
      
    /* onCreateDialog function that gets called by the system the first
     * time a dialog is requested.
     */
    protected Dialog onCreateDialog(int id) {
    	// we must return a dialog, so create one in memory
    	AlertDialog dialog = null;

    	// specifically, we'll build an "AlertDialog";
    	// the most common type of dialog.
    	AlertDialog.Builder builder = new AlertDialog.Builder(this);

    	// build different dialogs based on the dialog ID passed to us
    	switch(id) {

    	// in this case, we're building a 'cancel' dialog
    	case DIALOG_CANCEL_ID:
    		// build a dialog with a "Are you sure" message and two buttons:
    		// 'yes' will kill the app
    		// 'no' will close the dialog
    		builder.setMessage("Are you sure you want to cancel?")
    			   .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int id) {
    					   Code9.this.finish();
    				   }
    			   })
    			   .setNegativeButton("No", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int id) {
    					   dialog.cancel();
    				   }
    			   });
    		// generate the dialog object from the options
    		// passed to the builder
    		dialog = builder.create();
    		break;

    	// we're asked to build a 'accept' dialog
    	case DIALOG_ACCEPT_ID:
    		// we've accepted some text, so might as well display it
    		// with an option to close the dialog.
    		builder.setMessage("You've entered the text: '"+numberStudents.getText()+"'")
    			   .setCancelable(false) // disallow user to hit the 'back' button
    			   .setNeutralButton("Cool!", new DialogInterface.OnClickListener() {
    				   public void onClick(DialogInterface dialog, int id) {
    					   dialog.dismiss();
    				   }
    			   });
    		// generate the dialog object from the options
    		// passed to the builder
    		dialog = builder.create();
    		break;
  
    	// unknown id, so don't build a dialog
    	default: dialog = null;
    	}

    	return dialog;
    }

    /* onPrepareDialog is called by the system every time
     * a dialog is requested.
     */
    protected void onPrepareDialog(int id, Dialog dialog) {
    	if(id == DIALOG_ACCEPT_ID) {
    		((AlertDialog) dialog).setMessage("You've entered the text: '"+numberStudents.getText()+"'");
    	}
    }
    
	public void onClick(View v) {
		switch(v.getId()) {
			case R.id.accept: showDialog(DIALOG_ACCEPT_ID); break;
			case R.id.cancel: showDialog(DIALOG_CANCEL_ID); break;
		}
	}

	

}