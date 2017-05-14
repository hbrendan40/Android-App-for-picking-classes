package com.greenface.scamproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Green Face on 3/31/2017.
 */

public class ForgotPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);
    }

    public void onClickButton(View view){
        switch (view.getId()){
            case R.id.RPsend:
                break;
            case R.id.RPsubmit:
                Intent intent = new Intent(ForgotPass.this,New_pass.class);
                startActivity(intent);
        }
    }
}
