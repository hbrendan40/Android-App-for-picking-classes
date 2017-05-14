package com.greenface.scamproject;

/**
 * Created by Green Face on 4/22/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 *
 */

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final EditText ed = (EditText) findViewById(R.id.edtPass);

        CheckBox c = (CheckBox) findViewById(R.id.checkBox);

        ed.setTransformationMethod(new PasswordTransformationMethod());
        c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (!isChecked) {
                    ed.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    ed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }

            }
        });
    }

    public void onClickButton(View view){
        switch (view.getId()){
            case R.id.bForgotPass:
                Intent intent = new Intent(Login.this,ForgotPass.class);
                startActivity(intent);
                break;
            case R.id.bLogin:
                TextView name = (TextView) findViewById(R.id.edtName);
                String username = name.getText().toString();
                TextView pass = (TextView) findViewById(R.id.edtPass);
                String password = pass.getText().toString();
                if(username.equals("vietnguyen") && password.equals("viet101")) {
                    Intent intent2 = new Intent(Login.this, Profile.class);
                    startActivity(intent2);
                } else{
                    Toast.makeText(Login.this, "Username or Password do not match!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bSignup:
                Intent intent3 = new Intent(Login.this,Signup.class);
                startActivity(intent3);
                break;
        }
    }
}