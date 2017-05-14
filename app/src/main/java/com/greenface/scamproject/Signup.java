package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;   // <--need this to show alerrt dialog



import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Green Face on 4/22/2017.
 */


public class Signup extends Activity {

    EditText editText, editText1, editText2, editText3, editText4, editText5, editText6;
    boolean mark=false;
    CheckBox checkBox1;


    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox3);
        editText = (EditText) findViewById(R.id.Sfirstname);
        editText1 = (EditText) findViewById(R.id.Slastname);
        editText2 = (EditText) findViewById(R.id.Semail);
        editText3 = (EditText) findViewById(R.id.Sid);
        editText4 = (EditText) findViewById(R.id.Susername);
        editText5 = (EditText) findViewById(R.id.Spassword);
        editText6 = (EditText) findViewById(R.id.Srepassword);


        Button button = (Button) findViewById(R.id.bSingupNext);
        button.setOnClickListener(new View.OnClickListener()


        {


//this takes all the input in textbox and run it through the database to store, so what u neeed to do is check for string before this method is called

            public void onClick(View view) {

                String Sfirstname = editText.getText().toString();
                String Slastname = editText1.getText().toString();
                String Semail = editText2.getText().toString();
                String Sid = editText3.getText().toString();
                String Susername = editText4.getText().toString();
                String Spassword = editText5.getText().toString();
                String Srepassword = editText6.getText().toString();

                String result = null;
                InputStream is = null;

                checkcheckBox();

                if (!validate(Semail)) {
                    dialoge();
                } else if(!validatePass(Spassword,Srepassword)){
                    dialoge3();
                }else if (mark==false)
                    dialoge2();


                else {


                    ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                    nameValuePairs.add(new BasicNameValuePair("first_name", Sfirstname));
                    nameValuePairs.add(new BasicNameValuePair("last_name", Slastname));
                    nameValuePairs.add(new BasicNameValuePair("email", Semail));
                    nameValuePairs.add(new BasicNameValuePair("id", Sid));
                    nameValuePairs.add(new BasicNameValuePair("username", Susername));
                    nameValuePairs.add(new BasicNameValuePair("password", Spassword));
                    StrictMode.setThreadPolicy(policy);
                    //http post
                    try{
                        HttpClient httpclient = new DefaultHttpClient();
                        HttpPost httppost = new HttpPost("http://10.0.2.2/Data/insert.php");
                        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                        HttpResponse response = httpclient.execute(httppost);
                        HttpEntity entity = response.getEntity();
                        is = entity.getContent();
                    }
                    catch(Exception e)
                    {
                        Log.e("log_tag", "Error in http connection "+e.toString());
                        Toast.makeText(getApplicationContext(), "Connection fail",Toast.LENGTH_SHORT).show();

                    }


                    //convert response to string
                    try {
                        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
                        StringBuilder sb = new StringBuilder();
                        String line = null;
                        while ((line = reader.readLine()) != null) {
                            sb.append(line + "\n");

                            Intent i = new Intent(getBaseContext(), Signup.class);
                            startActivity(i);

                        }
                        is.close();
                        result = sb.toString();
                        if (result.contains("Information has been saved!")) {
                            Intent intent1 = new Intent(Signup.this, TakenClass.class);
                            startActivity(intent1);
                        }
                    } catch (Exception e) {
                        Log.e("log_tag", "Error converting result " + e.toString());
                    }
                    try {
                        JSONObject json_data = new JSONObject(result);
                        CharSequence w = (CharSequence) json_data.get("re");
                        Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        Log.e("log_tag", "Error parsing data " + e.toString());
                        Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
                    }
                }
            }


        });
    }


    public boolean validate(String email) {
        boolean valid = true;
        if (email.contains("@sjsu.edu")) {
            return valid;
        }
        else {
            editText2.setError("enter a valid email");
            valid = false;
            return valid;
        }
    }
    public void checkcheckBox(){
        if (checkBox1.isChecked()) {
            checkBox1.setChecked(false);
            mark=true;
        }
        else
            mark=false;


    }

    public boolean validatePass(String pass1, String pass2) {
        boolean valid = true;
        if (pass1.equals(pass2)) {
            return valid;
        }
        else {
            editText6.setError("Check the password again!");
            valid = false;
            return valid;
        }
    }


    public void dialoge() {


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("SJSU Students only");
        alertBuilder.setMessage("Please enter a SJSU email");
        alertBuilder.create().show();

    }

    public void dialoge2() {      // <--still working on it


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Terms and Conditions");
        alertBuilder.setMessage("Please accept terms and conditions");
        alertBuilder.create().show();

    }


    public void dialoge3() {


        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(this);
        alertBuilder.setTitle("Password do not match!");
        alertBuilder.setMessage("Please enter password again");
        alertBuilder.create().show();

    }
    public void selectBox(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId()){
            case R.id.checkBox3:
                if (checked)
                    mark=true;
                else
                    mark=false;




        }
    }


    // this is to look at terms and condition view so ignore this
    public void onClickButton(View view){

        switch (view.getId()){
            case R.id.bTemrsConditon:

                Intent intent = new Intent(Signup.this, TermsConditon.class);
                startActivity(intent);
                break;
//            case R.id.bSingupNext:
//                Intent intent1 = new Intent(Signup.this, TakenClass.class);
//                startActivity(intent1);
        }
    }
}