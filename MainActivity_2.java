package com.example.shivani.app2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private String item_data="heya";
    private String cost_data="";
    private String entireLog="";
    int totalCost= 0;
    private ArrayList<HashMap<String, String>> list;
    private ListViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView=(ListView)findViewById(R.id.logList);
        HashMap<String,String> temp=new HashMap<String, String>();

        list=new ArrayList<HashMap<String,String>>();

        adapter =new ListViewAdapter(this, list);
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
                totalCost=totalCost+Integer.parseInt(cost_data);
               /* TextView t = (TextView) findViewById(R.id.listView);
                t.setText("\n"+h);*/

                entireLog = entireLog+"\n"+item_data+"  -  "+ cost_data;
                HashMap<String,String> temp=new HashMap<String, String>();
                temp.put("name",item_data);
                temp.put("cost",cost_data);
                list.add(temp);
                adapter.notifyDataSetChanged();

                TextView costUpdateView = (TextView) findViewById(R.id.amount_text_view);
                costUpdateView.setText(""+totalCost);


            }
        });
        builder.show();

        builder.setTitle("Item");
        builder.setView(item);
        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                item_data = item.getText().toString();
//                items_list.add(item_data+clickCounter++);
/*
                adapter.notifyDataSetChanged();
*/



            }
        });
        builder.show();





    }
}
