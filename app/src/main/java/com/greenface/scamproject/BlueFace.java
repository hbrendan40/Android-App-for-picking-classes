package com.greenface.scamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Green Face on 5/9/2017.
 */

public class BlueFace  extends AppCompatActivity {

    private ImageButton online;
    private ImageButton friend;
    private ImageButton message;
    private ImageButton search;
    private ImageButton more;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blueface);
        online = (ImageButton) findViewById(R.id.online);
        friend = (ImageButton) findViewById(R.id.friend);
        message = (ImageButton) findViewById(R.id.message);
        search = (ImageButton) findViewById(R.id.search);
        more = (ImageButton) findViewById(R.id.more);
    }

    public void buttonClick(View view){
        switch (view.getId()) {
            case R.id.online:
                Intent intent = new Intent(BlueFace.this, Online.class);
                startActivity(intent);
                break;
            case R.id.friend:
                Intent intent1 = new Intent(BlueFace.this, Friend.class);
                startActivity(intent1);
                break;
            case R.id.message:
                Intent intent2 = new Intent(BlueFace.this, Message.class);
                startActivity(intent2);
                break;
            case R.id.search:
                Intent intent3 = new Intent(BlueFace.this, Search.class);
                startActivity(intent3);
                break;
            case R.id.more:
                Intent intent4 = new Intent(BlueFace.this, More.class);
                startActivity(intent4);
                break;
        }
    }
}
