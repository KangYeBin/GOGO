package com.example.gogo.categorylist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.ListView;
import android.widget.Spinner;
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
import com.example.gogo.FoodListViewAdapter;
import com.example.gogo.FoodListViewItem;
import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONArray;
import org.json.JSONObject;

public class All extends Fragment{
    View v;
    FoodListViewAdapter adapter;
    ArrayAdapter<CharSequence> arrayAdapter;
    private Spinner sp_sort;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_categorylist, container, false);

        ListView listview ;
        // 리스트뷰 참조 및 Adapter달기
        listview = (ListView) v.findViewById(R.id.listview_food);
        // Adapter 생성
        adapter = new FoodListViewAdapter() ;
        listview.setAdapter(adapter);

        /*sp_sort=v.findViewById(R.id.sp_sort); //정렬기준 스피너
        arrayAdapter = ArrayAdapter.createFromResource(getContext(), R.array.sortstand, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        if(sp_sort != null) {
            sp_sort.setAdapter(arrayAdapter);

            sp_sort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    Toast.makeText(getActivity(),"선택",
                            Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });

        }*/

        String code_pid = UserData.getInstance().getCodepid();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ListView listview ;
                listview = (ListView) v.findViewById(R.id.listview_food);
                adapter = new FoodListViewAdapter() ;
                listview.setAdapter(adapter);

                try{
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
                    int count = 0;

                    String enroll_pid, category, foodname, exp_end;

                    //JSON 배열 길이만큼 반복문을 실행
                    while(count < jsonArray.length()){
                        //count는 배열의 인덱스를 의미
                        JSONObject object = jsonArray.getJSONObject(count);

                        enroll_pid = object.getString("enroll_pid");
                        category = object.getString("category");
                        foodname = object.getString("foodname");
                        exp_end = object.getString("exp_end");

                        adapter.addItem(enroll_pid, category, foodname, exp_end);
                        count++;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        FoodListRequest foodListRequest = new FoodListRequest(code_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(foodListRequest);


        //리스트에서 식재료 클릭
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FoodListViewItem item = (FoodListViewItem) parent.getItemAtPosition(position) ;
                String enroll_pid = item.getEnroll_pid() ;
                UserData.getInstance().setEnroll_pid(enroll_pid);

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showfoodreginfo);
            }
        });

        return v;
    }
}

