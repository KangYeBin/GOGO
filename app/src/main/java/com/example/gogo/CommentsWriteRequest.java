package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CommentsWriteRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Comments_write.php";
    private Map<String, String>map;


    public CommentsWriteRequest(String post_pid, String user_pid, String comments, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("post_pid", post_pid);
        map.put("user_pid", user_pid);
        map.put("comments", comments);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}