package org.csitan.thirkha;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by lenovo on 4/11/15.
 */
public class Form extends ActionBarActivity {


    TextView tx1, tx2, tx3, tx4, tx5, tx6, tx7, tx8;
    Button btn;
    private ResourceDetail rs1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.from);

/*
        tx1 =(TextView) findViewById(R.id.editText);
        tx2 =(TextView) findViewById(R.id.editText2);
        tx3 =(TextView) findViewById(R.id.editText3);
        tx4 =(TextView) findViewById(R.id.editText4);
        tx5 =(TextView) findViewById(R.id.editText5);
        tx6 =(TextView) findViewById(R.id.editText6);
        tx7 =(TextView) findViewById(R.id.editText7);
        tx8 = (TextView) findViewById(R.id.editText8);

       // double lat = getIntent().getDoubleExtra(MapsActivity.KEY_LAT, 0);
       // double lng = getIntent().getDoubleExtra(MapsActivity.KEY_LNG, 0);
/*
        final ResourceDetail rs1 = new ResourceDetail(tx1.getText().toString(),
                                                tx2.getText().toString(),
                                                tx3.getText().toString(),
                                                tx4.getText().toString(),
                                                tx5.getText().toString(),
                                                tx6.getText().toString(),
                                                tx7.getText().toString(),
                                                tx8.getText().toString(),
                                                lat, lng
                );
*/
         btn = (Button) findViewById(R.id.button);

         btn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                finish();
             }
         });

    }
}
