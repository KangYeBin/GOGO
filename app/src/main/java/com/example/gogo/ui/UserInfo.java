package com.example.gogo.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.Code_checkRequest;
import com.example.gogo.Code_createRequest;
import com.example.gogo.Email_checkRequest;
import com.example.gogo.Join;
import com.example.gogo.Login;
import com.example.gogo.MenuBar;
import com.example.gogo.Nickname_checkRequest;
import com.example.gogo.ProfileModify;
import com.example.gogo.R;
import com.example.gogo.ShowUserInfoRequest;
import com.example.gogo.UserData;
import com.example.gogo.UserInfoRequest;
import com.example.gogo.UserWithdrawRequest;
import com.google.android.material.navigation.NavigationView;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfo extends Fragment {
    private AlertDialog dialog;
    private TextView tv_showID, tv_showname;
    private Button btn_checknick, btn_checkemail, btn_refcode;
    private EditText et_pw, et_pwcheck, et_nickname, et_email, et_refcode;
    private ImageView setImage;
    private boolean checkpw=false;
    private boolean checknick=true;
    private boolean checkemail=true;
    private boolean checkcode=true;

    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_userinfo, container, false);

        tv_showID = v.findViewById(R.id.tv_showID);
        tv_showname = v.findViewById(R.id.tv_showname);
        et_pw = v.findViewById(R.id.et_pw);
        et_pwcheck = v.findViewById(R.id.et_pwcheck);
        et_nickname = v.findViewById(R.id.et_nickname);
        et_email = v.findViewById(R.id.et_email);
        et_refcode = v.findViewById(R.id.et_refcode);
        setImage=v.findViewById(R.id.img_pwcheck);

        et_nickname.setEnabled(false);//닉네임값을 바꿀 수 없도록 함
        et_email.setEnabled(false);//이메일값을 바꿀 수 없도록 함

        //회원정보 화면에 띄우기
        String user_pid = UserData.getInstance().getUserpid();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        String id = jsonObject.getString("id");
                        String name = jsonObject.getString("name");
                        String nickname = jsonObject.getString("nickname");
                        String email = jsonObject.getString("email");
                        String code_pid = jsonObject.getString("code_pid");

                        tv_showID.setText(id);
                        tv_showname.setText(name);
                        et_nickname.setText(nickname);
                        et_email.setText(email);
                        et_refcode.setText(code_pid);

                    } else {
                        return;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        ShowUserInfoRequest showUserInfoRequest = new ShowUserInfoRequest(user_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(showUserInfoRequest);

        //닉네임 변경 버튼
        btn_checknick =v.findViewById(R.id.btn_checknick);
        btn_checknick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nickname = et_nickname.getText().toString();
                et_nickname.setEnabled(true);//닉네임값 변경 가능하게 함
                checknick=false;
                if(checknick){
                    return;//검증 완료
                }
                btn_checknick.setText("중복");
                //닉네임 값을 입력하지 않았다면
                if(nickname.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("사용할 수 있는 닉네임입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                checknick = true;//검증완료
                                et_nickname.setEnabled(false);//닉네임값을 바꿀 수 없도록 함
                                et_nickname.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checknick.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 닉네임이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(Nickname_checkRequest);

                UserData.getInstance().setNickname(nickname);
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
                View header = navigationView.getHeaderView(0);
                TextView show_nickname = header.findViewById(R.id.show_nickname);
                show_nickname.setText(UserData.getInstance().getNickname());
            }
        });

        //냉장고 코드 변경 버튼
        btn_refcode =v.findViewById(R.id.btn_refcode);
        btn_refcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String code_pid = et_refcode.getText().toString();
                et_refcode.setEnabled(true);//코드값 변경 가능하게 함
                btn_refcode.setText("중복");
                //냉장고 코드를 입력하지 않았다면`
                if(code_pid.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage("냉장고 코드를 입력해주세요")
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
                            if(success){//데이터베이스에 저장되어있는 코드라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("사용할 수 있는 냉장고 코드입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                et_refcode.setEnabled(false);//냉장고 코드값을 바꿀 수 없도록 함
                                et_refcode.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_refcode.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//데이터베이스에 저장되어있지 않는 코드라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("냉장고 코드를 다시 입력해주세요.")
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
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(code_checkRequest);

                UserData.getInstance().setCode_pid(code_pid);
                NavigationView navigationView = getActivity().findViewById(R.id.nav_view);
            }
        });



        //이메일 중복 확인 버튼
        btn_checkemail =v.findViewById(R.id.btn_checkemail);
        btn_checkemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = et_email.getText().toString();
                et_email.setEnabled(true);//이메일값을 변경 가능하게 함
                checkemail=false;
                if(checkemail){
                    return;//검증 완료
                }
                btn_checkemail.setText("중복");
                //이메일 값을 입력하지 않았다면
                if(email.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("사용할 수 있는 이메일입니다.")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                checknick = true;//검증완료
                                et_email.setEnabled(false);//이메일값을 바꿀 수 없도록 함
                                et_email.setBackgroundColor(getResources().getColor(R.color.colorGray));
                                btn_checkemail.setBackgroundColor(getResources().getColor(R.color.maingreen));
                                return;
                            }else{//사용할 수 없는 이메일이라면
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                Email_checkRequest Email_checkRequest = new Email_checkRequest(email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(Email_checkRequest);
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


        //수정 완료 버튼을 눌렀을 때
        v.findViewById(R.id.btn_modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_pid = UserData.getInstance().getUserpid();
                String password = et_pw.getText().toString();
                String pwcheck=et_pwcheck.getText().toString();
                String nickname = et_nickname.getText().toString();
                String email = et_email.getText().toString();

                //한칸이라도 빠뜨렸을 경우
                if(password.equals("")||pwcheck.equals("")||nickname.equals("")||email.equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage("빈칸을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }
                //닉네임 중복체크를 했는지 확인함
                if(!checknick){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage("닉네임 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                //이메일 중복체크를 했는지 확인함
                if(!checkemail){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage("이메일 중복을 확인해주세요.")
                            .setNegativeButton("OK", null)
                            .create();
                    dialog.show();
                    return;
                }

                if(checkpw==false){
                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    dialog = builder.setMessage("비밀번호를 확인해주세요.")
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
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("회원정보 수정 완료")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();

                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_userinfo_to_nav_showuserinfo);
                                navController.navigateUp();
                                navController.popBackStack();//navController 스택에서 해당 프래그먼트 pop
                                navController.popBackStack();//navController 스택에서 CheckPW 프래그먼트 pop
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("실패")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();

                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                UserInfoRequest userInfoRequest = new UserInfoRequest(user_pid, password, nickname, email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(userInfoRequest);
            }
        });

        //취소 눌렀을 경우
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showuserinfo);
                navController.navigateUp();
                navController.popBackStack();//navController 스택에서 해당 프래그먼트 pop
                navController.popBackStack();//navController 스택에서 CheckPW 프래그먼트 pop
            }
        });

        //회원탈퇴
        v.findViewById(R.id.withdraw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_pid = UserData.getInstance().getUserpid();
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                                builder.setMessage("탈퇴하시겠습니까?");
                                builder.setNegativeButton("예",
                                        new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            Intent intent = new Intent( getActivity(), Login.class );
                                            startActivity( intent );
                                        }
                                });
                                builder.setPositiveButton("아니오",
                                        new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                            } });
                                builder.show();

                            } else {
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                UserWithdrawRequest userWithdrqwRequest = new UserWithdrawRequest(user_pid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(userWithdrqwRequest);
            }
        });

        return v;
    }
}