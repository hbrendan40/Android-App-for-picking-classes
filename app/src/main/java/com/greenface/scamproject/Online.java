package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Green Face on 5/8/2017.
 */

public class Online extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.online);
    }
    public void onClick(View view){
        if(view.getId() == R.id.blueface1){
            Intent intent = new Intent(Online.this, BlueFace.class);
            startActivity(intent);
        }
    }
}
