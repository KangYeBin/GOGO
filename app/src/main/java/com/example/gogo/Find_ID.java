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

public class Find_ID extends AppCompatActivity {

    private EditText et_name, et_email;
    private Button btn_findid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        et_name = findViewById( R.id.et_name);
        et_email = findViewById( R.id.et_email);

        //아이디 찾기 버튼을 눌렀을 때
        btn_findid = findViewById( R.id.btn_findid );
        btn_findid.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String email = et_email.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if(success) {
                                String id = jsonObject.getString("id");
                                Intent intent = new Intent(Find_ID.this, Find_IDComplete.class);
                                intent.putExtra( "id", id );
                                Find_ID.this.startActivity(intent);
                                startActivity(intent);
                            }

                            else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Find_ID.this);
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
                Find_IDRequest find_idRequest = new Find_IDRequest(name, email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Find_ID.this);
                queue.add(find_idRequest);
            }
        });
    }


    public void cancfindid(View v){
        Intent cancfindid=new Intent(Find_ID.this, Login.class);
        startActivity(cancfindid);
    }
}
