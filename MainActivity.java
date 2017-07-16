package com.example.shivani.exlog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.id.input;

public class MainActivity extends AppCompatActivity {

    private String item_data="heya";
    private String cost_data="";
    private String h=" ";
    private String entireLog="";
    List<String> items_list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int clickCounter= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, items_list);

        ListView listView = (ListView) findViewById(R.id.logList);
        listView.setAdapter(adapter);
    }

    public void addNew(View v){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        builder.setTitle("Item");
        final EditText item = new EditText(this);
        final EditText cost = new EditText(this);



        builder.setTitle("Enter Cost");
        builder.setView(cost);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                cost_data = cost.getText().toString();
                h=h+" "+cost_data;
               /* TextView t = (TextView) findViewById(R.id.listView);
                t.setText("\n"+h);*/

            }
        });
        builder.show();

        entireLog=entireLog+"\n"+h;



        builder.setTitle("Item");
        builder.setView(item);
        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                item_data = item.getText().toString();
                items_list.add(item_data+clickCounter++);
                adapter.notifyDataSetChanged();

            }
        });
        builder.show();



    }
}
