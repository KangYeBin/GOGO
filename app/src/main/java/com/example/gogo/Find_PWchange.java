package com.example.gogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Find_PWchange extends AppCompatActivity {
    private EditText et_pw, et_pwcheck;
    private Button btn_changepw;
    private ImageView setImage;
    private boolean checkpw=false;
    private AlertDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pwchange);

        et_pw = findViewById( R.id.et_pw);
        et_pwcheck=findViewById(R.id.et_pwcheck);
        setImage=findViewById(R.id.img_pwcheck);

        //비밀번호 확인 마크 표시
        et_pw.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setImage.setImageResource(R.drawable.no);
                checkpw=false;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_pw.getText().toString().equals(et_pwcheck.getText().toString())) {
                    setImage.setImageResource(R.drawable.yes);
                    checkpw=true;
                } else {
                    setImage.setImageResource(R.drawable.no);
                    checkpw=false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(et_pw.getText().length()<=0) {
                    setImage.setImageResource(R.drawable.no);
                    checkpw = false;
                }
            }
        });
        //비밀번호 확인 마크 표시
        et_pwcheck.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setImage.setImageResource(R.drawable.no);
                checkpw=false;
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(et_pw.getText().toString().equals(et_pwcheck.getText().toString())) {
                    setImage.setImageResource(R.drawable.yes);
                    checkpw=true;
                } else {
                    setImage.setImageResource(R.drawable.no);
                    checkpw=false;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(et_pwcheck.getText().length()<=0) {
                    setImage.setImageResource(R.drawable.no);
                    checkpw = false;
                }
            }
        });

        btn_changepw = findViewById( R.id.btn_changepw );
        btn_changepw.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                String id = intent.getStringExtra("id");

                String password = et_pw.getText().toString();

                if(checkpw==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Find_PWchange.this);
                    dialog = builder.setMessage("비밀번호 확인")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {   //새로운 PW 설정 성공
                                Intent intent = new Intent( Find_PWchange.this, Find_PWComplete.class );
                                startActivity( intent );


                            } else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(Find_PWchange.this);
                                dialog = builder.setMessage("비밀번호를 다시 입력하세요")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText( getApplicationContext(), "실패: " + e.toString(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                };
                Find_PWchangeRequest find_pwchangeRequest = new Find_PWchangeRequest( id, password,  responseListener );
                RequestQueue queue = Volley.newRequestQueue( Find_PWchange.this );
                queue.add( find_pwchangeRequest );
            }
        });
    }

    public void cancchangepw(View v){
        Intent cancchangepw=new Intent(Find_PWchange.this, Login.class);
        startActivity(cancchangepw);
    }
}