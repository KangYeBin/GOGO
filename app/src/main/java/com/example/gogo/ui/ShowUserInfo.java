package com.example.gogo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.R;
import com.example.gogo.ShowUserInfoRequest;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowUserInfo extends Fragment {
    TextView tv_showID, tv_showname, tv_shownick, tv_showemail, tv_refcode;
    View v;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_showuserinfo, container, false);

        tv_showID = v.findViewById(R.id.tv_showID);
        tv_showname = v.findViewById(R.id.tv_showname);
        tv_shownick = v.findViewById(R.id.tv_shownick);
        tv_showemail = v.findViewById(R.id.et_email);
        tv_refcode = v.findViewById(R.id.et_refcode);

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
                        String refcode = jsonObject.getString("code_pid");

                        tv_showID.setText(id);
                        tv_showname.setText(name);
                        tv_shownick.setText(nickname);
                        tv_showemail.setText(email);
                        tv_refcode.setText(refcode);

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

        //회원정보 수정 버튼 클릭
        v.findViewById(R.id.btn_modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_checkpw);
            }
        });

        //회원정보 수정 취소 버튼 클릭
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_showuserinfo_to_nav_checkpw); //mobile_navigation.xml의 액션
                navController.navigateUp();
                navController.popBackStack();//navController 스택에서 해당 프래그먼트 pop
            }
        });
        return v;
    }
}
