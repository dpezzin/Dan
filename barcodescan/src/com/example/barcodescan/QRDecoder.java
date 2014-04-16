package com.example.palani;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.androidtest.RGBLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
public class QRDecoder extends Activity implements OnClickListener {
    public static class Global
    {
        public static String text=null;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Bitmap bMap = BitmapFactory.decodeFile("/sdcard/myqrcode.png");
        TextView textv = (TextView) findViewById(R.id.mytext);
        View webbutton=findViewById(R.id.webbutton);
        LuminanceSource source = new RGBLuminanceSource(bMap); 
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
        Reader reader = new MultiFormatReader();
        try {
             Result result = reader.decode(bitmap);
             Global.text = result.getText(); 
                byte[] rawBytes = result.getRawBytes(); 
                BarcodeFormat format = result.getBarcodeFormat(); 
                ResultPoint[] points = result.getResultPoints();
                textv.setText(Global.text);
                webbutton.setOnClickListener(this);
        } catch (NotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ChecksumException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FormatException e) {
            // TODO Auto-generated catch block
    e.printStackTrace();


        }   
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse(Global.text); 
        Intent intent = new Intent(Intent.ACTION_VIEW, uri); 
        startActivity(intent);

    }

}