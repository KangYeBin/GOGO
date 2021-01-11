package com.example.gogo.ui;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.BoardListViewAdapter;
import com.example.gogo.BoardListViewItem;
import com.example.gogo.BoardSearchRequest;

import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONArray;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.net.URL;


public class Board extends Fragment {
    View v;
    BoardListViewAdapter adapter, adapter1;
    private EditText et_search;
    private ListView listview ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_board, container, false);
        et_search = v.findViewById(R.id.et_search);

        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) v.findViewById(R.id.listview1);

        BackgroundTask backgroundTask = new BackgroundTask();
        backgroundTask.execute();

        //리스트에서 게시글 클릭
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BoardListViewItem item = (BoardListViewItem) parent.getItemAtPosition(position) ;
                String post_pid = item.getPost_pid() ;
                UserData.getInstance().setPost_pid(post_pid);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showboard);
            }
        });

        //글쓰기 버튼 클릭
        v.findViewById(R.id.fab_write).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_boardwrite);
            }
        });

        //검색 버튼 클릭
        v.findViewById(R.id.btn_search).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //adapter1은 검색후 나오는 리스트뷰
                adapter1 = new BoardListViewAdapter() ;
                listview.setAdapter(adapter1);
                //검색 키워드
                String search = et_search.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try{
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            JSONArray jsonArray = jsonObject.getJSONArray("response");
                            int count = (jsonArray.length() - 1);

                            String title, nickname, date_time, post_pid, rep_count;

                            //JSON 배열 길이만큼 반복문을 실행
                            while(count >= 0){
                                //count는 배열의 인덱스를 의미
                                JSONObject object = jsonArray.getJSONObject(count);

                                title = object.getString("title");
                                nickname = object.getString("nickname");
                                date_time = object.getString("date_time");
                                post_pid = object.getString("post_pid");
                                rep_count = object.getString("rep_count");

                                adapter1.addItem(title, nickname, date_time, post_pid, rep_count);
                                count--;
                                adapter1.notifyDataSetChanged();
                            }
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                };
                BoardSearchRequest boardSearchRequest = new BoardSearchRequest(search, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(boardSearchRequest);
            }
        });

        return v;
    }

    //모든 게시판 글을 가져오기 위한 쓰레드
    private class BackgroundTask extends AsyncTask<Void, Void, String> {
        String target;

        @Override
        protected void onPreExecute() {
            //파싱으로 가져올 웹페이지
            target = "http://computdios.dothome.co.kr/Board_list.php";
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
            listview = (ListView) v.findViewById(R.id.listview1);
            adapter = new BoardListViewAdapter() ;
            listview.setAdapter(adapter);
            try{
                JSONObject jsonObject = new JSONObject(result.substring(result.indexOf("{"), result.lastIndexOf("}") + 1));
                JSONArray jsonArray = jsonObject.getJSONArray("response");
                int count = (jsonArray.length() - 1);

                String title, nickname, date_time, post_pid, rep_count;

                //JSON 배열 길이만큼 반복문을 실행
                while(count >= 0){
                    //count는 배열의 인덱스를 의미
                    JSONObject object = jsonArray.getJSONObject(count);

                    title = object.getString("title");
                    nickname = object.getString("nickname");
                    date_time = object.getString("date_time");
                    post_pid = object.getString("post_pid");
                    rep_count = object.getString("rep_count");

                    adapter.addItem(title, nickname, date_time, post_pid, rep_count);
                    count--;
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}