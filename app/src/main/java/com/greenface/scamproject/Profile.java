package com.greenface.scamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by Green Face on 4/22/2017.
 */

public class Profile extends AppCompatActivity {

    private ImageButton online;
    private ImageButton friend;
    private ImageButton message;
    private ImageButton search;
    private ImageButton more;
    private Button CS146;
    private Button jenny;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        online = (ImageButton) findViewById(R.id.online);
        friend = (ImageButton) findViewById(R.id.friend);
        message = (ImageButton) findViewById(R.id.message);
        search = (ImageButton) findViewById(R.id.search);
        more = (ImageButton) findViewById(R.id.more);
        CS146 = (Button) findViewById(R.id.CS146);
        jenny = (Button) findViewById(R.id.Jenny);
    }

    public void buttonClick(View view){
        switch (view.getId()) {
            case R.id.online:
                Intent intent = new Intent(Profile.this, Online.class);
                startActivity(intent);
                break;
            case R.id.friend:
                Intent intent1 = new Intent(Profile.this, Friend.class);
                startActivity(intent1);
                break;
            case R.id.message:
                Intent intent2 = new Intent(Profile.this, Message.class);
                startActivity(intent2);
                break;
            case R.id.search:
                Intent intent3 = new Intent(Profile.this, Search.class);
                startActivity(intent3);
                break;
            case R.id.more:
                Intent intent4 = new Intent(Profile.this, More.class);
                startActivity(intent4);
                break;
            case R.id.CS146:
                Intent intent5 = new Intent(Profile.this, Class_Display.class);
                startActivity(intent5);
                break;
            case R.id.Jenny:
                Intent intent6 = new Intent(Profile.this, Profesor.class);
                startActivity(intent6);
                break;
        }
    }
}

