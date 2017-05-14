package com.greenface.scamproject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Green Face on 5/10/2017.
 */
public class Comments extends Fragment {
    private EditText txtInput;
    private Button post;
    private ArrayAdapter<String> adapter;
    private String name = "Viet Nguyen: ";
    private String[] com = {"Denny: This is a hard class. You have to read lots of book and put lots of effort in order to pass this class!\n",
            "Tom: It's hard. You have to remember lots of time complexity of different algorithm. I pass this class with an B-\n"};
    private ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(com));
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.comments, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listV);
        adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_comment,R.id.txtitem,arrayList);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(adapter);
        txtInput = (EditText) rootView.findViewById(R.id.txtinput);
        post = (Button) rootView.findViewById(R.id.btadd);

        post.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                String newComment = txtInput.getText().toString();
                arrayList.add(name + newComment+"\n");
                txtInput.setText("");
                adapter.notifyDataSetChanged();

            }
        });
        return rootView;

    }


}
