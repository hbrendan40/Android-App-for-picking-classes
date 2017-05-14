package com.greenface.scamproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Green Face on 5/8/2017.
 */

public class Search extends Activity {
    private AutoCompleteTextView autoCompleteTextView;
    private ArrayAdapter<String> adapter;
    private String TCclass = "";
    private String Pro = "";
    private String name ="";
    private String[] classes;
    private String[] professor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seaching);
        RadioButton c = (RadioButton) findViewById(R.id.radioClass);
        RadioButton p = (RadioButton) findViewById(R.id.radioPro);
        Button button = (Button) findViewById(R.id.button);
        classes = getResources().getStringArray(R.array.ClassName);
        professor = getResources().getStringArray(R.array.ProfessorName);
    }

    public void onClick(View view) {
        boolean check = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radioClass:
                if (check) {
                    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, classes);
                    autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
                    autoCompleteTextView.setAdapter(adapter);
                    autoCompleteTextView.setThreshold(1);
                    autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            String cla = arg0.getItemAtPosition(arg2).toString();
                            autoCompleteTextView.setText(cla);
                            TCclass = cla;
                            Pro = "";
                        }
                    });
                    autoCompleteTextView.setEnabled(true);
                } else{
                    autoCompleteTextView.setEnabled(false);
                }
                break;
            case R.id.radioPro:
                if (check) {
                    adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, professor);
                    autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
                    autoCompleteTextView.setAdapter(adapter);
                    autoCompleteTextView.setThreshold(1);
                    autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                            String pro = arg0.getItemAtPosition(arg2).toString();
                            autoCompleteTextView.setText(pro);
                            Pro = pro;
                            TCclass ="";
                        }
                    });
                } else{
                    autoCompleteTextView.setEnabled(false);
                }
                break;
        }
    }

    public void onclickButton(View view){
        if(view.getId() == R.id.button){
            if(TCclass.equalsIgnoreCase("CS146")){
                TCclass="";
                Intent intent = new Intent(Search.this, Prolist.class);
                startActivity(intent);
            } else if(Pro.equalsIgnoreCase("Jenny Lam")) {
                Pro="";
                Intent intent = new Intent(Search.this, Profesor.class);
                startActivity(intent);
            } else{
                Toast.makeText(getApplicationContext(), "Name does not match!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
