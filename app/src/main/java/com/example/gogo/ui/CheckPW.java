package com.example.gogo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.CheckPWRequest;
import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class CheckPW extends Fragment {
    private AlertDialog dialog;
    private EditText et_pw;
    View v;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_checkpw, container, false);
        et_pw = v.findViewById(R.id.et_pw);

        //비밀번호 입력 후 확인 클릭
        v.findViewById(R.id.btn_checkpw).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_pid = UserData.getInstance().getUserpid();
                String password = et_pw.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            //비밀번호가 맞으면 회원정보 수정하는 화면으로
                            if (success) {
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_checkpw_to_nav_userinfo);
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                dialog = builder.setMessage("비밀번호를 다시 입력해주세요")
                                        .setPositiveButton("OK", null)
                                        .create();
                                dialog.show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                CheckPWRequest profileModifyRequest = new CheckPWRequest(user_pid, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(profileModifyRequest);

            }
        });

        //취소 클릭
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showuserinfo);
                navController.navigateUp();
                navController.popBackStack();//navController 스택에서 해당 프래그먼트 pop
            }
        });
        return v;
    }
}