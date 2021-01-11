package com.example.gogo.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.FoodReginfoModifyRequest;
import com.example.gogo.R;
import com.example.gogo.ShowFoodReginfoRequest;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class FoodReginfoMod extends Fragment {
    View v;
    EditText et_memo;
    TextView tv_kind;
    Button btn_category;
    CheckBox checkbox_freeze, checkbox_ref, checkbox_rtemper;
    Spinner sp_buydateyear, sp_buydatemonth, sp_buydateday, sp_shelflifeyear, sp_shelflifemonth, sp_shelflifeday;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_foodreginfo, container, false);

        tv_kind=v.findViewById(R.id.tv_kind);
        btn_category=v.findViewById(R.id.btn_category);

        String food_name = UserData.getInstance().getFood_name();
        String category_name= UserData.getInstance().getCategory_name();

        tv_kind.setText(food_name);
        btn_category.setText(category_name);
        et_memo=v.findViewById(R.id.et_memo);
        checkbox_freeze=v.findViewById(R.id.checkbox_freeze);
        checkbox_ref=v.findViewById(R.id.checkbox_ref);
        checkbox_rtemper=v.findViewById(R.id.checkbox_rtemper);
        sp_buydateyear=v.findViewById(R.id.sp_buydateyear);
        sp_buydatemonth=v.findViewById(R.id.sp_buydatemonth);
        sp_buydateday=v.findViewById(R.id.sp_buydateday);
        sp_shelflifeyear=v.findViewById(R.id.sp_shelflifeyear);
        sp_shelflifemonth=v.findViewById(R.id.sp_shelflifemonth);
        sp_shelflifeday=v.findViewById(R.id.sp_shelflifeday);

        btn_category.setEnabled(false);

        //식재료 정보 불러오기
        String enroll_pid = UserData.getInstance().getEnroll_pid();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    boolean success = jsonObject.getBoolean("success");

                    String category, foodname, exp_start, exp_end, lo1, lo2, lo3, memo;
                    String[] start, end;

                    if (success) {
                        category = jsonObject.getString("category");
                        foodname = jsonObject.getString("foodname");
                        exp_start = jsonObject.getString("exp_start");
                        exp_end = jsonObject.getString("exp_end");
                        lo1 = jsonObject.getString("lo1");
                        lo2 = jsonObject.getString("lo2");
                        lo3 = jsonObject.getString("lo3");
                        memo = jsonObject.getString("memo");

                        btn_category.setText(category);
                        tv_kind.setText(foodname);

                        start = exp_start.split("-");
                        start[1] = start[1].replace("0", "");
                        start[2] = start[2].replace("0", "");
                        sp_buydateyear.setSelection(Integer.parseInt(start[0])-2010);
                        sp_buydatemonth.setSelection(Integer.parseInt(start[1])-1);
                        sp_buydateday.setSelection(Integer.parseInt(start[2])-1);

                        end = exp_end.split("-");
                        end[1] = end[1].replace("0", "");
                        end[2] = end[2].replace("0", "");
                        sp_shelflifeyear.setSelection(Integer.parseInt(end[0])-2010);
                        sp_shelflifemonth.setSelection(Integer.parseInt(end[1])-1);
                        sp_shelflifeday.setSelection(Integer.parseInt(end[2])-1);

                        if (lo1.equals("freeze"))
                            checkbox_freeze.setChecked(true);
                        if (lo2.equals("ref"))
                            checkbox_ref.setChecked(true);
                        if (lo3.equals("rtemper"))
                            checkbox_rtemper.setChecked(true);
                        et_memo.setText(memo);

                        return;
                    } else {
                        return;
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };
        ShowFoodReginfoRequest showFoodReginfoRequest = new ShowFoodReginfoRequest(enroll_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(showFoodReginfoRequest);

        //등록 버튼을 클릭했을 때
        v.findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String lo1 = "0";
                String lo2 = "0";
                String lo3 = "0";
                String buydateyear = sp_buydateyear.getSelectedItem().toString();
                String buydatemonth = sp_buydatemonth.getSelectedItem().toString();
                String buydateday = sp_buydateday.getSelectedItem().toString();
                String shelflifeyear = sp_shelflifeyear.getSelectedItem().toString();
                String shelflifemonth = sp_shelflifemonth.getSelectedItem().toString();
                String shelflifeday = sp_shelflifeday.getSelectedItem().toString();

                if(checkbox_freeze.isChecked()) {    //체크 박스가 체크 된 경우
                    lo1 = "freeze";
                }
                if(checkbox_ref.isChecked()) {    //체크 박스가 체크 된 경우
                    lo2 = "ref";
                }
                if(checkbox_rtemper.isChecked()) {    //체크 박스가 체크 된 경우
                    lo3 = "rtemper";
                }

                String enroll_pid = UserData.getInstance().getEnroll_pid();
                String category = btn_category.getText().toString();
                String foodname = tv_kind.getText().toString();
                String exp_start = buydateyear+"-"+buydatemonth+"-"+buydateday;
                String exp_end = shelflifeyear+"-"+shelflifemonth+"-"+shelflifeday;
                String memo = et_memo.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
                                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                navController.navigate(R.id.action_nav_foodreginfomod_to_nav_showfoodreginfo);
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

                FoodReginfoModifyRequest foodReginfoModifyRequest
                        = new FoodReginfoModifyRequest(enroll_pid, category, foodname, exp_start, exp_end, lo1, lo2, lo3, memo, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(foodReginfoModifyRequest);
            }
        });

        //등록 취소를 클릭했을 때
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_foodreginfomod_to_nav_showfoodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        //유통기한 기준 버튼를 클릭했을 때
        v.findViewById(R.id.check_shelflife).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_expstandard);
            }
        });

        return v;
    }
}