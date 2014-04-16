package net.cs76.lectures.intents03;

import net.cs76.lectures.intents03.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/*
 * Intents03
 * Dan Armendariz
 * Computer Science E-76
 * 
 * Demonstrating showing an image resource. 
 */

public class Code3 extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // connect the ImageView to an object
        ImageView img = (ImageView)findViewById(R.id.image);
        
        // set the image in the ImageView
        img.setImageResource(R.drawable.img_1998);

    }
}