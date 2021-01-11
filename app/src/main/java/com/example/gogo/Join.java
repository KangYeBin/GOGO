package com.example.gogo;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Join extends AppCompatActivity {

    private EditText et_id, et_pw, et_name, et_email, et_nickname, et_pwcheck, et_ref;
    private Button btn_register, btn_checkID, btn_checknick, btn_checkemail, btn_checkref;
    private String id, password, name, nickname, email, pwcheck, code_pid, refcode;
    private ImageView setImage;
    private AlertDialog dialog;
    private boolean checkpw=false;
    private boolean checkid=false;
    private boolean checknick=false;
    private boolean checkemail=false;
    private boolean checkref=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_join);

        //아이디값 찾아주기
        et_id = findViewById( R.id.et_id);
        et_pw = findViewById( R.id.et_pw);
        et_pwcheck=findViewById(R.id.et_pwcheck);
        et_name = findViewById( R.id.et_name);
        et_email = findViewById( R.id.et_email);
        et_nickname = findViewById( R.id.et_nickname);
        et_ref = findViewById(R.id.et_ref);
        setImage=findViewById(R.id.img_pwcheck);

        btn_checkID =findViewById(R.id.btn_checkID);
        btn_checkID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = et_id.getText().toString();
                if(checkid){
                    return;//검증 완료
                }
                //ID 값을 입력하지 않았다면
                if(id.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("아이디를 입력해주세요")
                            .setPositiveButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//사용할 수 있는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("사용할 수 있는 아이디입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_id.setEnabled(false);//아이디값을 바꿀 수 없도록 함
                                checkid = true;//검증완료
                                et_id.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checkID.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 아이디라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("아이디를 다시 입력해주세요.")
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
                ID_checkRequest ID_checkRequest = new ID_checkRequest(id, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(ID_checkRequest);
            }
        });

        btn_checknick =findViewById(R.id.btn_checknick);
        btn_checknick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nickname = et_nickname.getText().toString();
                if(checknick){
                    return;//검증 완료
                }
                //닉네임 값을 입력하지 않았다면
                if(nickname.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
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
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("사용할 수 있는 닉네임입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_nickname.setEnabled(false);//닉네임값을 바꿀 수 없도록 함
                                checknick = true;//검증완료
                                et_nickname.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checknick.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 닉네임이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
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
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(Nickname_checkRequest);
            }
        });
        //이메일 중복체크 버튼 누를때
        btn_checkemail =findViewById(R.id.btn_checkemail);
        btn_checkemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = et_email.getText().toString();
                if(checkemail){
                    return;//검증 완료
                }
                //닉네임 값을 입력하지 않았다면
                if(email.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("이메일을 입력해주세요")
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
                            if(success){//사용할 수 있는 이메일이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("사용할 수 있는 이메일입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_email.setEnabled(false);//이메일값을 바꿀 수 없도록 함
                                checkemail = true;//검증완료
                                et_email.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checkemail.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 이메일이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("이메일을 다시 설정해주세요.")
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
                Email_checkRequest email_checkRequest = new Email_checkRequest(email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(email_checkRequest);
            }
        });

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

        //냉장고 코드가 이미 존재하는 코드인지 확인
        btn_checkref =findViewById(R.id.btn_checkref);
        btn_checkref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                code_pid = et_ref.getText().toString();
                if(checkref){
                    return;//검증 완료
                }
                Response.Listener<String> responseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//사용할 수 있는 코드라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("연결할 수 있는 코드입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_ref.setEnabled(false);//코드값 바꿀 수 없도록 함
                                checkref = true;//검증완료
                                et_ref.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checkref.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 코드라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("코드를 다시 입력해주세요.")
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
                Code_checkRequest code_checkRequest = new Code_checkRequest(code_pid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(code_checkRequest);
            }
        });

        //회원가입 버튼 클릭 시 수행
        btn_register = findViewById( R.id.btn_register);
        btn_register.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = et_id.getText().toString();
                password = et_pw.getText().toString();
                pwcheck=et_pwcheck.getText().toString();
                name = et_name.getText().toString();
                email = et_email.getText().toString();
                nickname = et_nickname.getText().toString();
                code_pid = et_ref.getText().toString();

                //회원가입 시 모든 editText가 비어있으면 넘어가지 않도록 함
                //ID 중복체크를 했는지 확인함
                if(!checkid){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("아이디 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                //닉네임 중복체크를 했는지 확인함
                if(!checknick){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("닉네임 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                //이메일 중복체크를 했는지 확인함
                if(!checkemail){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("이메일 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                //한칸이라도 빠뜨렸을 경우
                if(id.equals("")||password.equals("")||pwcheck.equals("")||name.equals("")||nickname.equals("")||email.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("빈칸을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                //냉장고코드 난수 생성
                if(code_pid.equals("")) {
                        int code[] = new int[6];
                        for (int i = 0; i < 6; i++) {
                            code[i] = (int) (Math.random() * 10);
                        }
                        int num;
                        num=(code[0]*100000+code[1]*10000+code[2]*1000+code[3]*100+code[4]*10+code[5]);
                        refcode=Integer.toString(num);
                        code_pid = refcode;
                }

                //난수를 데이터베이스에 저장
                Response.Listener<String> responseListener = new Response.Listener<String>(){
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){//중복되지 않는 코드라면
                                return;

                            }else{//사용할 수 없는 코드라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                                dialog = builder.setMessage("코드를 확인해주세요.")
                                        .setNegativeButton("OK", null)
                                        .create();
                                dialog.show();
                                return;
                            }
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };//Response.Listener 완료
                //Volley 라이브러리를 이용해서 실제 서버와 통신을 구현하는 부분
                Code_createRequest code_createRequest = new Code_createRequest(code_pid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Join.this);
                queue.add(code_createRequest);

                if(checkpw==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(Join.this);
                    dialog = builder.setMessage("비밀번호를 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                Response.Listener<String> responseListener2 = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success");

                            //회원가입 성공시
                            if (success) {
                                Intent intent = new Intent(Join.this, JoinComplete.class);
                                intent.putExtra( "code_pid", code_pid );
                                startActivity(intent);

                                //회원가입 실패시
                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                //서버로 Volley를 이용해서 요청
                JoinRequest joinRequest = new JoinRequest(id, password, name, email, nickname, code_pid, responseListener2);
                RequestQueue queue2 = Volley.newRequestQueue(Join.this);
                queue2.add(joinRequest);
            }
        });

    }
    public void ConClick(View view) {
        Intent intent = new Intent( Join.this, Login.class );
        startActivity( intent );
    }
}