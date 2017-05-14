package com.greenface.scamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Green Face on 5/11/2017.
 */

public class Display extends AppCompatActivity {

    DatabaseHelper helper = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
    }

    public void onClick(View view){
        if(view.getId() == R.id.S){

            EditText username = (EditText) findViewById(R.id.name);
            String user = username.getText().toString();
            EditText password = (EditText) findViewById(R.id.pass);
            String pass = password.getText().toString();

            String test = helper.searchPass(user);

            if(pass.equals(test)){
                Toast.makeText(Display.this, "Login Success!", Toast.LENGTH_SHORT).show();
            } else{
                Toast.makeText(Display.this, "Username or Password do not match!", Toast.LENGTH_SHORT).show();
            }
        }
        if(view.getId() == R.id.Signup){
            Intent intent = new Intent(Display.this, Signup.class);
            startActivity(intent);
        }
    }
}
