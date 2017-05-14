package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import java.io.InputStream;

/**
 * Created by Green Face on 5/8/2017.
 */

public class Message extends Activity {

    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> adapter;
    private String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        String[] friend = getResources().getStringArray(R.array.Friends);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,friend);
        autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.friendName);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                String n = arg0.getItemAtPosition(arg2).toString();
                autoCompleteTextView.setText(n);
                name = n;
            }
        });

    }
    public void onClick(View view){
        if(view.getId() == R.id.sendMessage){
            Toast.makeText(getApplicationContext(), "Sent to " + name, Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getBaseContext(), Message.class);
            startActivity(i);
        }
    }
}
