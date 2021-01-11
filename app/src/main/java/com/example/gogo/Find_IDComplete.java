package com.example.gogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Find_IDComplete extends AppCompatActivity {

    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_idcomplete);

        textView3 = findViewById(R.id.textView3);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        textView3.setText(id);
    }

    public void gogologin(View v){
        Intent gogologin=new Intent(Find_IDComplete.this, Login.class);
        startActivity(gogologin);
    }
    public void gofindpw(View v){
        Intent gofindpw=new Intent(Find_IDComplete.this, Find_PW.class);
        startActivity(gofindpw);
    }
}
