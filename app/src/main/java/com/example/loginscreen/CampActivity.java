package com.example.loginscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.storage.FirebaseStorage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CampActivity extends AppCompatActivity {
    final List<Activity> activis= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camp);

        activis.add(new Activity("Yeşil Vadi Doğa Parkı Kamp Alanı",R.mipmap.yesil));
        activis.add(new Activity("Kamp Lotus",R.mipmap.lotu));
        activis.add(new Activity("Gebekse Koyu Kamp Alanı",R.mipmap.gebekse));
        activis.add(new Activity("Sarıgerme Plajı Kamp Alanı",R.mipmap.yesil));
        activis.add(new Activity("Kızılbük Koyu Kamp Alanı",R.mipmap.camp));



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
    public void commentClick(View view){

        if(view.getId() == R.id.comment){
            Intent intent = new Intent(CampActivity.this,UsersComment.class);
            startActivity(intent);
        }
    }


}