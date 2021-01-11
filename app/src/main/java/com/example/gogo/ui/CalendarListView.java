package com.example.gogo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.FoodListRequest;
import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONArray;
import org.json.JSONObject;

public class CalendarListView extends Fragment {
    View v;
    TextView today;
    CalendarListViewAdapter adapter;
    String shot_day;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_calendardatelist, container, false);

        ListView listview ;
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) v.findViewById(R.id.listview_calendar);
        // Adapter 생성
        adapter = new CalendarListViewAdapter() ;
        listview.setAdapter(adapter);
        today = v.findViewById(R.id.today);

        //해당 날짜에 등록한 식재료 띄우기
        String code_pid = UserData.getInstance().getCodepid();
        shot_day = UserData.getInstance().getShot_Day();
        Toast.makeText(getActivity(), shot_day, Toast.LENGTH_SHORT).show();

        today.setText(shot_day);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ListView listview ;
                listview = (ListView) v.findViewById(R.id.listview_calendar);
                adapter = new CalendarListViewAdapter() ;
                listview.setAdapter(adapter);

                try{
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;

                    String enroll_pid, category, foodname, exp_start, exp_end;

                    //JSON 배열 길이만큼 반복문을 실행
                    while(count < jsonArray.length()){
                        //count는 배열의 인덱스를 의미
                        JSONObject object = jsonArray.getJSONObject(count);

                        enroll_pid = object.getString("enroll_pid");
                        category = object.getString("category");
                        foodname = object.getString("foodname");
                        exp_start = object.getString("exp_start");
                        exp_end = object.getString("exp_end");

                        if(shot_day.equals(exp_end))
                            adapter.addItem(enroll_pid, category, foodname, exp_end);

                        count++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        FoodListRequest calendarListRequest = new FoodListRequest(code_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(calendarListRequest);

        //리스트에서 식재료 클릭하면 상세정보창으로
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CalendarListViewItem item = (CalendarListViewItem) parent.getItemAtPosition(position) ;
                String enroll_pid = item.getEnroll_pid() ;
                UserData.getInstance().setEnroll_pid(enroll_pid);

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showfoodreginfo);
            }
        });

        return v;
    }
}
