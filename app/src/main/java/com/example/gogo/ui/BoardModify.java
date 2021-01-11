package com.example.gogo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.BoardModifyRequest;
import com.example.gogo.R;
import com.example.gogo.ShowBoardRequest;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class BoardModify extends Fragment {
    private EditText et_title, et_content;
    private Button btn_complete;
    View v;
    @Nullable
    public static BoardModify newInstance(){
        return new BoardModify();
    }
    public BoardModify(){
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_boardmodify, container, false);

        et_title = v.findViewById( R.id.et_title);
        et_content = v.findViewById( R.id.et_content);


        //작성했던 글 불러오기
        String post_pid = UserData.getInstance().getPost_pid();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        String title = jsonObject.getString("title");
                        String contents = jsonObject.getString("contents");

                        et_title.setText(title);
                        et_content.setText(contents);

                    } else {
                        return;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ShowBoardRequest showBoardRequest = new ShowBoardRequest(post_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(showBoardRequest);

        //수정 완료
        btn_complete = v.findViewById(R.id.btn_complete);
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = et_title.getText().toString();
                String contents = et_content.getText().toString();
                String post_pid = UserData.getInstance().getPost_pid();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1) );
                            boolean success = jsonObject.getBoolean( "success" );

                            // 서버에 저장 완료
                            if(success) {
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_boardmodify_to_nav_showboard);
                                navController.navigateUp();
                                navController.popBackStack();
                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                };
                BoardModifyRequest boardModifyRequest = new BoardModifyRequest(post_pid, title, contents, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(boardModifyRequest);
            }
        });

        //수정 취소
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_boardmodify_to_nav_showboard);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        return v;
    }
}
