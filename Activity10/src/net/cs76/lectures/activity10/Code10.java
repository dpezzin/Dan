package net.cs76.lectures.activity10;

import net.cs76.lectures.activity10.R;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

/*
 * Activity10
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Displaying data in a List layout with AdapterView. Code adapted from:
 * http://developer.android.com/resources/tutorials/views/hello-listview.html
 */

public class Code10 extends ListActivity implements OnItemClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // no layout is loaded! There's no setContentView().

        // add a ListView to fill the entire screen of the 
        // ListActivity, and pass into it an ArrayAdapter 
        // that manages the array of list items.
        // Can also pass it an android-created list item:
        //   android.R.layout.simple_list_item_1
        setListAdapter(new ArrayAdapter<String>(this, R.layout.custom_list_item, COLORS));

        // obtain the ListView that was created by setListAdapter()
        ListView myList = getListView();

        // allow us to filter the list with keypresses
        myList.setTextFilterEnabled(true);
        
        // implement an onClick listener for when a user taps a color
        myList.setOnItemClickListener(this);

    }

    /* display a Toast with message text. */
    private void showMessage(CharSequence text) {
    	Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();    	
    }

    /* this method is fired when an item is clicked */
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		TextView item = (TextView)v;
		showMessage(item.getText());
	}

    
    // define a list of colors that the list will display
    static final String[] COLORS = new String[] {
    	"Red",
    	"Orange",
    	"Yellow",
    	"Green",
    	"Blue",
    	"Indigo",
    	"Violet"
    };

    
}