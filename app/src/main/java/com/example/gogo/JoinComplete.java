package com.example.gogo;

import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

public class JoinComplete extends AppCompatActivity {
    private TextView userrefcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joincomplete);
        userrefcode = findViewById( R.id.userrefcode);

        Intent intent = getIntent();
        String refcode = intent.getStringExtra("code_pid");
        userrefcode.setText(refcode);
    }

    public void gologin(View v){
        Intent gologin = new Intent(JoinComplete.this, Login.class);
        startActivity(gologin);
    }
}
