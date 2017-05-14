package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Green Face on 4/22/2017.
 */

public class New_pass extends Activity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_pass);
        button = (Button) findViewById(R.id.NPsubmit);
    }
    public void onClick(View view) {
        if (view.getId() == R.id.NPsubmit) {
            Intent intent = new Intent(New_pass.this, Login.class);
            startActivity(intent);
        }
    }
}
