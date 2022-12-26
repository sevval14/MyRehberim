package com.example.loginscreen;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MarmarisAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<com.example.loginscreen.Activity> activis;

    public MarmarisAdapter(Activity activity, List<com.example.loginscreen.Activity> activis){
        mInflater = (LayoutInflater)  activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.activis = activis;

    }

    @Override
    public int getCount() {
        return activis.size();
    }

    @Override
    public Object getItem(int i) {
        return activis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView;

        rowView = mInflater.inflate(R.layout.layout, null);

        TextView textView=
                (TextView)  rowView.findViewById(R.id.textList);

        ImageView imageView=
                (ImageView) rowView.findViewById(R.id.picList);


        com.example.loginscreen.Activity activi =activis.get(i);

        textView.setText(activi.getType());
        imageView.setImageResource(activi.getPicId());

        return rowView;
    }


}

