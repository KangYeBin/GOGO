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
import com.example.gogo.BoardWriteRequest;
import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class BoardWrite extends Fragment {
    private EditText et_title, et_content;
    private Button btn_complete;

    View v;
    @Nullable
    public static BoardWrite newInstance(){
        return new BoardWrite();
    }
    public BoardWrite(){
    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_boardwrite, container, false);

        et_title = v.findViewById( R.id.et_title);
        et_content = v.findViewById( R.id.et_content);

        btn_complete = v.findViewById(R.id.btn_complete);
        btn_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_pid = UserData.getInstance().getUserpid();
                String title = et_title.getText().toString();
                String contents = et_content.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1) );
                            boolean success = jsonObject.getBoolean( "success" );

                            // 서버에 저장 완료
                            if(success) {
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_boardwrite_to_nav_board);
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
                BoardWriteRequest boardWriteRequest = new BoardWriteRequest ( user_pid, title, contents, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add( boardWriteRequest );

            }
        });
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_boardwrite_to_nav_board);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        return v;
    }
}