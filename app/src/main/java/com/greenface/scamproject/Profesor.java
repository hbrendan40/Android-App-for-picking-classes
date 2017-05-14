package com.greenface.scamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Green Face on 5/10/2017.
 */

public class Profesor extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.professor);
        tv = (TextView) findViewById(R.id.cs);
    }
    public void buttonClick(View view){
        Intent intent = new Intent(Profesor.this, Class_Display.class);
        startActivity(intent);
    }
}
