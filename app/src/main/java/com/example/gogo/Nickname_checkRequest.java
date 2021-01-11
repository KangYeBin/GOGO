package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Nickname_checkRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Nickname_check.php";
    private Map<String, String>map;

    public Nickname_checkRequest(String nickname, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("nickname", nickname);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}