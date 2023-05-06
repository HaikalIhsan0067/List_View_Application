package com.example.listviewapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView edNama = (TextView) findViewById(R.id.edNama);
        TextView edNama2 = (TextView) findViewById(R.id.edNama2);
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);

        ArrayList<String> daftar_nama = new ArrayList<>();

        Intent intent_list = new Intent(MainActivity.this, ListActivity.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String isian_nama = edNama.getText().toString();
                String isian_nama_2 = edNama2.getText().toString();
                //Log.i("ISIAN NAMA =", isian_nama);

                if (isian_nama.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Nama Belum Terisi", Toast.LENGTH_SHORT).show();
                }else{
                    String nama_lengkap = isian_nama.concat(" ").concat(isian_nama_2);
                    daftar_nama.add(nama_lengkap);
                    edNama.setText("");
                    edNama2.setText("");
                    intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                    startActivity(intent_list);
                }
            }
        });

        Button btnLihat = (Button) findViewById(R.id.btnLihat);
        btnLihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent_list.putStringArrayListExtra("daftar_nama", daftar_nama);
                startActivity(intent_list);
            }
        });

    }
}