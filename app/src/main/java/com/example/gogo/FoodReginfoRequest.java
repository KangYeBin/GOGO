package com.example.gogo;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class FoodReginfoRequest extends StringRequest {

    //서버 URL 설정(php 파일 연동)
    final static private String URL = "http://computdios.dothome.co.kr/Enroll_write.php";
    private Map<String, String>map;

    public FoodReginfoRequest(String code_pid, String user_pid, String category, String foodname, String exp_start, String exp_end, String lo1, String lo2, String lo3, String memo, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("code_pid", code_pid);
        map.put("user_pid", user_pid);
        map.put("category", category);
        map.put("foodname", foodname);
        map.put("exp_start", exp_start);
        map.put("exp_end", exp_end);
        map.put("lo1", lo1);
        map.put("lo2", lo2);
        map.put("lo3", lo3);
        map.put("memo", memo);
    }

    @Override
    protected Map<String, String>getParams() throws AuthFailureError {
        return map;
    }
}