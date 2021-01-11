package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardDeleteRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Board_delete.php";
    private Map<String, String>map;

    public BoardDeleteRequest(String post_pid, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);
        map = new HashMap<>();
        map.put("post_pid", post_pid);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}