package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class marmarisActivity extends AppCompatActivity {
    final List<Activity> activis= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marmaris);


        activis.add(new Activity("YAMAÇ PARAŞÜTÜ",R.mipmap.yamac));
        activis.add(new Activity("MARMARİS KALESİ",R.mipmap.marmariskalesi));
        activis.add(new Activity("MARMARİS DALIŞ",R.mipmap.marmarisdalis));
        activis.add(new Activity("BÜYÜK ÇARŞI",R.mipmap.bigpazaar));
        activis.add(new Activity("İNCE KUM",R.mipmap.incekum));

        final ListView listView=(ListView) findViewById(R.id.listview);
        ActivityAdapter adapter = new ActivityAdapter(this,activis);
        listView.setAdapter(adapter);

    }
    public void buttonClick(View view){
        Intent intent =null;

        if(view.getId() == R.id.howGo){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:36.854439,28.268810"));
            startActivity(intent);
        }
    }
}