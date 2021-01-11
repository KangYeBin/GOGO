package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class FoodListRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Enroll_reginfo.php";
    private Map<String, String>map;


    public FoodListRequest(String code_pid, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("code_pid", code_pid);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}