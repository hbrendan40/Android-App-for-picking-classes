package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

public class TakenClass extends Activity {

    private AutoCompleteTextView autoCompleteTextView1;
    private AutoCompleteTextView autoCompleteTextView2;
    private ArrayAdapter<String> adapter1;
    private ArrayAdapter<String> adapter2;


    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taken_class);
        Button button = (Button) findViewById(R.id.TCadd);
        String[] classes = getResources().getStringArray(R.array.ClassName);
        String[] professor = getResources().getStringArray(R.array.ProfessorName);
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,classes);
        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,professor);
        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.TCclass);
        autoCompleteTextView2 = (AutoCompleteTextView) findViewById(R.id.TCpro);
        autoCompleteTextView1.setAdapter(adapter1);
        autoCompleteTextView2.setAdapter(adapter2);
        autoCompleteTextView1.setThreshold(1);
        autoCompleteTextView2.setThreshold(1);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                String result = null;
                InputStream is = null;
                autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        String classes = arg0.getItemAtPosition(arg2).toString();
                        autoCompleteTextView1.setText(classes);
                        // Do Whatever you want to do ;)
                    }
                });
                String TCclass= autoCompleteTextView1.getText().toString();
                EditText editText = (EditText)findViewById(R.id.TCtime);
                String TCtime = editText.getText().toString();
                autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                            long arg3) {
                        String pro = arg0.getItemAtPosition(arg2).toString();
                        autoCompleteTextView2.setText(pro);
                        // Do Whatever you want to do ;)
                    }
                });
                String TCpro= autoCompleteTextView2.getText().toString();
                EditText editText1 = (EditText)findViewById(R.id.TCrate);
                String TCrate = editText1.getText().toString();
                EditText editText2 = (EditText)findViewById(R.id.TCcomment);
                String TCcomment = editText2.getText().toString();


                ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                nameValuePairs.add(new BasicNameValuePair("class_name",TCclass));
                nameValuePairs.add(new BasicNameValuePair("time",TCtime));
                nameValuePairs.add(new BasicNameValuePair("professor",TCpro));
                nameValuePairs.add(new BasicNameValuePair("rate",TCrate));
                nameValuePairs.add(new BasicNameValuePair("comment",TCcomment));
                StrictMode.setThreadPolicy(policy);
                //http post
                try{
                    HttpClient httpclient = new DefaultHttpClient();
                    HttpPost httppost = new HttpPost("http://10.0.2.2/Data/takenclass.php");
                    httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                    HttpResponse response = httpclient.execute(httppost);
                    HttpEntity entity = response.getEntity();
                    is = entity.getContent();
                    Log.e("log_tag", "connection success ");
                    Toast.makeText(getApplicationContext(), "pass", Toast.LENGTH_SHORT).show();
                }
                catch(Exception e)
                {
                    Log.e("log_tag", "Error in http connection "+e.toString());
                    Toast.makeText(getApplicationContext(), "Connection fail",Toast.LENGTH_SHORT).show();

                }
                //convert response to string
                try{
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                    StringBuilder sb = new StringBuilder();
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        sb.append(line + "\n");
                        Intent i = new Intent(getBaseContext(), TakenClass.class);
                        startActivity(i);
                    }
                    is.close();
                    result=sb.toString();
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                }
                catch(Exception e)
                {
                    Log.e("log_tag", "Error converting result "+e.toString());
                }
                try{
                    JSONObject json_data = new JSONObject(result);
                    CharSequence w= (CharSequence) json_data.get("re");
                    Toast.makeText(getApplicationContext(), w, Toast.LENGTH_SHORT).show();
                }
                catch(JSONException e)
                {
                    Log.e("log_tag", "Error parsing data "+e.toString());
                    Toast.makeText(getApplicationContext(), "JsonArray fail", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onClickButton(View view){
        Intent intent = new Intent(TakenClass.this, Login.class);
        startActivity(intent);
    }
}

