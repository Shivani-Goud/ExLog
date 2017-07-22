package com.example.shivani.app2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by shivani on 22/7/17.
 */

public class ListViewAdapter extends BaseAdapter {
    public ArrayList<HashMap<String, String>> list;
    Activity activity;
    TextView c1, c2;


    public ListViewAdapter(Activity a, ArrayList<HashMap<String, String>> l) {
        this.activity = a;
        this.list = l;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();
        if(view==null){
            view =  inflater.inflate(R.layout.list_item,null);

            c1 = (TextView) view.findViewById(R.id.name);
            c2= (TextView) view.findViewById(R.id.cost);
        }
        HashMap<String,String> map =list.get(i);
        c1.setText(map.get("name"));
        c2.setText(map.get("cost"));

        return view;
    }
}
