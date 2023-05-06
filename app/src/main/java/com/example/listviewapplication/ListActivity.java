package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lvNama = (ListView) findViewById(R.id.lvNama);

        //String[] nama = {"yoga", "brian", "luthfi", "suci"};
        //ArrayList<String> daftar_nama = new ArrayList<>();

        ArrayList<String> daftar_nama = getIntent().getExtras().getStringArrayList("daftar_nama");

        //daftar_nama.add("Haikal");
        //daftar_nama.add("Ihsan");
        //daftar_nama.add("Wijaya");

        if (daftar_nama.isEmpty()){
            daftar_nama.add("Data Belum Terisi");
        }

        ArrayAdapter<String> ad_nama = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, daftar_nama);

        lvNama.setAdapter(ad_nama);

    }
}