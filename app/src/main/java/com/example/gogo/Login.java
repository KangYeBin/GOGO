package com.example.gogo;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Login extends AppCompatActivity {
    private long backKeyPressedTime = 0;
    private EditText et_id, et_pw;
    private Button btn_login, btn_join;
    private Toast toast;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView(R.layout.activity_login);

        et_id = findViewById( R.id.et_id);
        et_pw = findViewById( R.id.et_pw );

        btn_join = findViewById( R.id.btn_join );
        btn_join.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Login.this, Join.class );
                startActivity( intent );
            }
        });

        //로그인 버튼 클릭
        btn_login = findViewById( R.id.btn_login );
        btn_login.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = et_id.getText().toString();
                String password = et_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {//로그인 성공시
                                String nickname = jsonObject.getString( "nickname" );
                                String user_pid = jsonObject.getString( "user_pid" );
                                String code_pid = jsonObject.getString( "code_pid" );
                                String icon = jsonObject.getString("icon");

                                UserData.getInstance().setUserpid(user_pid);
                                UserData.getInstance().setNickname(nickname);
                                UserData.getInstance().setIcon(icon);
                                UserData.getInstance().setCode_pid(code_pid);

                            } else {//로그인 실패시
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                dialog = builder.setMessage("아이디 혹은 비밀번호를 확인해주세요.")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                LoginRequest loginRequest = new LoginRequest( id, password, responseListener );
                RequestQueue queue = Volley.newRequestQueue( Login.this );
                queue.add( loginRequest );


                //냉장고 이름 가져오기
                String code_pid = UserData.getInstance().getCodepid();
                Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent( Login.this, MenuBar.class );

                                String ref_name = jsonObject.getString( "ref_name" );
                                UserData.getInstance().setRefname(ref_name);

                                finish();//액티비티 종료 -> 캘린더 화면에서 뒤로가기 누르면 종료는 가능,,
                                startActivity( intent );

                                return;
                            }
                            else {//로그인 실패시
                                AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                                dialog = builder.setMessage("아이디 혹은 비밀번호를 확인해주세요.")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(), "로그인 실패: " + e.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                LoginRef_nameRequest loginRef_nameRequest = new LoginRef_nameRequest(code_pid, responseListener2);
                RequestQueue queue2 = Volley.newRequestQueue(Login.this);
                queue2.add(loginRef_nameRequest);
            }
        });
    }

    //Find ID 뷰로 이동
    public void FIDonClick(View view) {
        Intent intent = new Intent( Login.this, Find_ID.class );
        startActivity( intent );
    }
    //Find PW 뷰로 이동
    public void FPWonClick(View view) {
        Intent intent = new Intent( Login.this, Find_PW.class );
        startActivity( intent );
    }

    @Override
    public void onBackPressed() {
        // 기존 뒤로가기 버튼의 기능을 막기위해 주석처리 또는 삭제

        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지났으면 Toast Show
        // 2000 milliseconds = 2 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
            toast.cancel();
        }
    }
}