package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Green Face on 5/8/2017.
 */

public class Friend extends Activity {
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friendlist);
        button = (Button) findViewById(R.id.blueface);
    }

    public void onClick(View view){
        if(view.getId() == R.id.blueface){
            Intent intent = new Intent(Friend.this, BlueFace.class);
            startActivity(intent);
        }
    }
}
