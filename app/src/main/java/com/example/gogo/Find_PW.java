package com.example.gogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Find_PW extends AppCompatActivity {
    private EditText et_id, et_name, et_email;
    private Button btn_findpw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        et_id = findViewById( R.id.et_id);
        et_name = findViewById( R.id.et_name);
        et_email = findViewById( R.id.et_email );

        //비밀번호 찾기 버튼을 눌렀을 경우
        btn_findpw = findViewById( R.id.btn_findpw );
        btn_findpw.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_id.getText().toString();
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//DB에 있는 정보일 경우
                                String id = jsonObject.getString( "id" );
                                Intent intent = new Intent( Find_PW.this, Find_PWchange.class );
                                intent.putExtra( "id", id );
                                startActivity( intent );

                            } else {//DB에 없는 정보일 경우
                                AlertDialog.Builder builder = new AlertDialog.Builder(Find_PW.this);
                                builder.setTitle("").setMessage("해당하는 사용자가 없습니다.");

                                AlertDialog alertDialog = builder.create();
                                alertDialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText( getApplicationContext(), "실패: " + e.toString(), Toast.LENGTH_SHORT ).show();
                        }
                    }
                };
                Find_PWRequest find_pwRequest = new Find_PWRequest( id, name, email,  responseListener );
                RequestQueue queue = Volley.newRequestQueue( Find_PW.this );
                queue.add( find_pwRequest );
            }
        });
    }

    public void cancfindpw(View v){
        Intent cancfindpw=new Intent(Find_PW.this, Login.class);
        startActivity(cancfindpw);
    }
}
