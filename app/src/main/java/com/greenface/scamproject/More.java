package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Green Face on 5/8/2017.
 */

public class More extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more);
    }
    public void onClick(View view){
        Intent intent = new Intent(More.this, Login.class);
        startActivity(intent);
    }
}
