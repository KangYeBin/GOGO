package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class UserInfoRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Userinfo.php";
    private Map<String, String>map;

    public UserInfoRequest(String user_pid, String password, String nickname, String email, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("user_pid", user_pid);
        map.put("password", password);
        map.put("nickname", nickname);
        map.put("email", email);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}