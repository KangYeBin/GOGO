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
import com.example.gogo.FoodReginfoRequest;
import com.example.gogo.R;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class FoodReginfo extends Fragment {
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

        sp_buydateyear.setSelection(10);
        sp_shelflifeyear.setSelection(10);

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

                if(checkbox_freeze.isChecked())     //체크 박스가 체크 된 경우
                    lo1 = "freeze";
                if(checkbox_ref.isChecked())        //체크 박스가 체크 된 경우
                    lo2 = "ref";
                if(checkbox_rtemper.isChecked())    //체크 박스가 체크 된 경우
                    lo3 = "rtemper";

                String code_pid = UserData.getInstance().getCodepid();
                String user_pid = UserData.getInstance().getUserpid();
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
                                navController.navigate(R.id.action_nav_foodreginfo_to_nav_showfoodreginfolist);
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
                FoodReginfoRequest foodReginfoRequest = new FoodReginfoRequest(code_pid, user_pid, category, foodname, exp_start, exp_end, lo1, lo2, lo3, memo, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(foodReginfoRequest);
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

        //등록 취소를 클릭했을 때
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_showfoodreginfolist);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        //카테고리 버튼을 클릭했을 때
        v.findViewById(R.id.btn_category).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_category);
            }
        });
        return v;
    }
}