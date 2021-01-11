package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ProfileModifyRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/ProfileModify.php";
    private Map<String, String>map;

    public ProfileModifyRequest(String icon, String nickname, String user_pid, String code_pid, String ref_name, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("icon", icon);
        map.put("nickname", nickname);
        map.put("user_pid", user_pid);
        map.put("code_pid", code_pid);
        map.put("ref_name", ref_name);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}