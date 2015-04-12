package org.csitan.thirkha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lenovo on 4/12/15.
 */
public class LogIn extends ActionBarActivity{

    public LogIn() {
        super();
    }
    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in);

        btn=(Button) findViewById(R.id.button2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intt = new Intent(getBaseContext(), Form.class);
                finish();
                startActivity(intt);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
