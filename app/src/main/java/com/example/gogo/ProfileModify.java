package com.example.gogo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileModify extends AppCompatActivity {

    private AlertDialog dialog;
    private EditText et_nickname, et_refname;
    private Button btn_mcheck, btn_cancel, btn_checknick, btn_iconmod;
    private boolean mchecknick=true;
    private String icon;
    private ImageView image_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilemodify);
        image_icon=findViewById(R.id.image_icon);
        et_nickname = findViewById(R.id.et_nickname);
        et_refname = findViewById(R.id.et_refname);
        et_nickname.setText(UserData.getInstance().getNickname());
        et_refname.setText(UserData.getInstance().getRefname());
        et_nickname.setEnabled(false);//닉네임값을 바꿀 수 없도록 함

        //아이콘 수정 버튼 클릭
        btn_iconmod = findViewById(R.id.btn_iconmod);
        btn_iconmod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileModify.this, IconModify.class);
                startActivity(intent);
            }
        });

        icon= UserData.getInstance().getIcon();

        switch (icon){
            case "1":
                image_icon.setImageResource(R.drawable.apple);
                break;
            case "2":
                image_icon.setImageResource(R.drawable.peach);
                break;
            case "3":
                image_icon.setImageResource(R.drawable.cherry);
                break;
            case "4":
                image_icon.setImageResource(R.drawable.orange);
                break;
            case "5":
                image_icon.setImageResource(R.drawable.pear5);
                break;
            case "6":
                image_icon.setImageResource(R.drawable.whiteradish);
                break;
        }

        btn_checknick =findViewById(R.id.btn_checknick);
        btn_checknick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = et_nickname.getText().toString();
                et_nickname.setEnabled(true);//닉네임값 변경 가능하게 함
                mchecknick=false;
                if(mchecknick){
                    return;//검증 완료
                }
                btn_checknick.setText("중복");
                //닉네임 값을 입력하지 않았다면
                if(nickname.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                    dialog = builder.setMessage("닉네임을 입력해주세요")
                            .setPositiveButton("OK", null)
                            .create();
                    dialog.show();
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//사용할 수 있는 닉네임이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                                dialog = builder.setMessage("사용할 수 있는 닉네임입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_nickname.setEnabled(false);//닉네임값을 바꿀 수 없도록 함
                                mchecknick = true;//검증완료
                                et_nickname.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checknick.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 닉네임이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                                dialog = builder.setMessage("닉네임을 다시 설정해주세요.")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                            }

                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };//Response.Listener 완료
                //Volley 라이브러리를 이용해서 실제 서버와 통신을 구현하는 부분
                Nickname_checkRequest Nickname_checkRequest = new Nickname_checkRequest(nickname, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfileModify.this);
                queue.add(Nickname_checkRequest);
            }
        });


        //수정 완료 버튼을 눌렀을 때
        btn_mcheck = findViewById(R.id.btn_mcheck);
        btn_mcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_pid = UserData.getInstance().getUserpid();
                String icon = UserData.getInstance().getIcon();
                String nickname = et_nickname.getText().toString();
                String code_pid = UserData.getInstance().getCodepid();
                String ref_name = et_refname.getText().toString();

                if(!mchecknick){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                    dialog = builder.setMessage("닉네임 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                if(nickname.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                    dialog = builder.setMessage("빈칸을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileModify.this);
                                dialog = builder.setMessage("프로필 변경 완료")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();

                                Intent intent = new Intent(ProfileModify.this, MenuBar.class);
                                ProfileModify.this.startActivity(intent);
                                startActivity(intent);
                            } else {
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                ProfileModifyRequest profileModifyRequest = new ProfileModifyRequest(icon, nickname, user_pid, code_pid, ref_name, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ProfileModify.this);
                queue.add(profileModifyRequest);

                UserData.getInstance().setNickname(nickname);
                UserData.getInstance().setRefname(ref_name);
            }
        });

        //취소 버튼 클릭
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileModify.this, MenuBar.class);
                startActivity(intent);
            }
        });
    }
}
