package com.example.gogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Find_PWComplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwcomplete);
    }
    public void gogologin2(View v){
        Intent gogologin2=new Intent(Find_PWComplete.this, Login.class);
        startActivity(gogologin2);
    }
}
