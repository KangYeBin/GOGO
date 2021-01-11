package com.example.gogo.ui;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.BoardDeleteRequest;
import com.example.gogo.CommentsWriteRequest;
import com.example.gogo.R;
import com.example.gogo.MenuBar;
import com.example.gogo.ShowBoardListViewAdapter;
import com.example.gogo.ShowBoardRequest;
import com.example.gogo.UserData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ShowBoard extends Fragment {
    TextView tv_postwriter, tv_board_writetime, tv_showtitle, tv_showcontent, tv_comment_count;
    EditText et_comment;
    ImageView img_boardwriter;
    Button btn_boardmodify, btn_boarddelete;
    View v;
    MenuBar activity;

    ShowBoardListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_showboard, container, false);

        ListView listview ;
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) v.findViewById(R.id.listview_comment);
        // Adapter 생성
        adapter = new ShowBoardListViewAdapter() ;
        listview.setAdapter(adapter);

        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute();

        tv_postwriter = v.findViewById(R.id.tv_postwriter);
        tv_showtitle = v.findViewById(R.id.tv_showtitle);
        tv_showcontent = v.findViewById(R.id.tv_showcontent);
        tv_board_writetime = v.findViewById(R.id.tv_board_writetime);
        tv_comment_count = v.findViewById(R.id.tv_comment_count);
        img_boardwriter = v.findViewById(R.id.img_boardwriter);
        btn_boardmodify = v.findViewById(R.id.btn_boardmodify);
        btn_boarddelete = v.findViewById(R.id.btn_boarddelete);

        //선택한 글을 화면에 띄우기
        String post_pid = UserData.getInstance().getPost_pid();

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    boolean success = jsonObject.getBoolean("success");

                    if (success) {
                        String user_pid = jsonObject.getString("user_pid");
                        String nickname = jsonObject.getString("nickname");
                        String title = jsonObject.getString("title");
                        String contents = jsonObject.getString("contents");
                        String date_time = jsonObject.getString("date_time");
                        String rep_count = jsonObject.getString("rep_count");
                        String icon = jsonObject.getString("icon");

                        tv_postwriter.setText(nickname);
                        tv_showtitle.setText(title);
                        tv_showcontent.setText(contents);
                        tv_board_writetime.setText(date_time);
                        tv_comment_count.setText(rep_count);

                        switch (icon){
                            case "1":
                                img_boardwriter.setImageResource(R.drawable.apple);
                                break;
                            case "2":
                                img_boardwriter.setImageResource(R.drawable.peach);
                                break;
                            case "3":
                                img_boardwriter.setImageResource(R.drawable.cherry);
                                break;
                            case "4":
                                img_boardwriter.setImageResource(R.drawable.orange);
                                break;
                            case "5":
                                img_boardwriter.setImageResource(R.drawable.pear5);
                                break;
                            case "6":
                                img_boardwriter.setImageResource(R.drawable.whiteradish);
                                break;
                        }

                        //내가 쓴 글만 수정 버튼이 보이도록
                        if(user_pid.equals(UserData.getInstance().getUserpid())) {
                            btn_boardmodify.setVisibility(v.VISIBLE);
                        } else {
                            btn_boardmodify.setVisibility(v.GONE);
                        }
                        //내가 쓴 글만 삭제 버튼이 보이도록
                        if(user_pid.equals(UserData.getInstance().getUserpid())) {
                            btn_boarddelete.setVisibility(v.VISIBLE);
                        } else {
                            btn_boarddelete.setVisibility(v.GONE);
                        }


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

        //글 수정하기
        btn_boardmodify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_boardmodify);
            }
        });


        //글 삭제하기
        btn_boarddelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String post_pid = UserData.getInstance().getPost_pid();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_showboard_to_nav_board);
                                navController.navigateUp();
                                navController.popBackStack();
                                return;
                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                BoardDeleteRequest boardDeleteRequest = new BoardDeleteRequest(post_pid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(boardDeleteRequest);
            }
        });

        //댓글 등록
        et_comment = v.findViewById( R.id.et_comment);
        v.findViewById(R.id.btn_commentwrite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String post_pid = UserData.getInstance().getPost_pid();
                String user_pid = UserData.getInstance().getUserpid();
                String comments = et_comment.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                String comments_pid = jsonObject.getString("comments_pid");
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.nav_showboard);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                CommentsWriteRequest commentsWriteRequest = new CommentsWriteRequest(post_pid, user_pid, comments, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(commentsWriteRequest);
                et_comment.setText("");
            }
        });

        adapter.notifyDataSetChanged();
        listview.setAdapter(adapter);

        return v;
    }
        //모든 댓글을 가져오기 위한 쓰레드
    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            //파싱으로 가져올 웹페이지
            target = "http://computdios.dothome.co.kr/Comments_read.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try{
                URL url = new URL(target);//URL 객체 생성

                //URL을 이용해서 웹페이지에 연결하는 부분
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

                //바이트단위 입력스트림 생성 소스는 httpURLConnection
                InputStream inputStream = httpURLConnection.getInputStream();

                //웹페이지 출력물을 버퍼로 받음 버퍼로 하면 속도가 더 빨라짐
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String temp;

                //문자열 처리를 더 빠르게 하기 위해 StringBuilder클래스를 사용함
                StringBuilder stringBuilder = new StringBuilder();

                //한줄씩 읽어서 stringBuilder에 저장함
                while((temp = bufferedReader.readLine()) != null){
                    stringBuilder.append(temp + "\n");//stringBuilder에 넣어줌
                }

                //사용했던 것도 다 닫아줌
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return stringBuilder.toString().trim();//공백을 제거

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            ListView listview ;
            listview = (ListView) v.findViewById(R.id.listview_comment);
            adapter = new ShowBoardListViewAdapter() ;
            listview.setAdapter(adapter);

            try {
                JSONObject jsonObject = new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = 0;

                String post_pid, comments_pid, user_pid, nickname, comments, date_time, icon;
                String mypost_pid = UserData.getInstance().getPost_pid();

                //JSON 배열 길이만큼 반복문을 실행
                while(count < jsonArray.length()){
                    //count는 배열의 인덱스를 의미
                    JSONObject object = jsonArray.getJSONObject(count);

                    comments_pid = object.getString("comments_pid");
                    post_pid = object.getString("post_pid");
                    user_pid = object.getString("user_pid");
                    nickname = object.getString("nickname");
                    comments = object.getString("comments");
                    date_time = object.getString("date_time");
                    icon = object.getString("icon");

                    if (post_pid.equals(mypost_pid))
                    {
                        adapter.addItem(comments_pid, user_pid, nickname, comments, date_time, icon);
                    }
                    count++;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}