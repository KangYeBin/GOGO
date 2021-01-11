package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Find_IDRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Find_ID.php";
    private Map<String, String>map;

    public Find_IDRequest(String name, String email, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("name", name);
        map.put("email", email);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}