package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class BoardModifyRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Board_modify.php";
    private Map<String, String>map;

    public BoardModifyRequest(String post_pid, String title, String contents, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("post_pid", post_pid);
        map.put("title", title);
        map.put("contents", contents);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}