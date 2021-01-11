package com.example.gogo.ui;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.R;
import com.example.gogo.ShowFoodReginfoDeleteRequest;
import com.example.gogo.ShowFoodReginfoRequest;
import com.example.gogo.UserData;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowFoodReginfo extends Fragment {
    private AlertDialog dialog;
    View v;
    EditText et_memo;
    TextView tv_kind;
    Button btn_category, check_shelflife;
    CheckBox checkbox_freeze, checkbox_ref, checkbox_rtemper;
    Spinner sp_buydateyear, sp_buydatemonth, sp_buydateday, sp_shelflifeyear, sp_shelflifemonth, sp_shelflifeday;
    String enroll_pid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_showfoodreginfo, container, false);

        tv_kind=v.findViewById(R.id.tv_kind);
        btn_category=v.findViewById(R.id.btn_category);
        check_shelflife=v.findViewById(R.id.check_shelflife);
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
        checkbox_freeze.setEnabled(false);
        checkbox_ref.setEnabled(false);
        checkbox_rtemper.setEnabled(false);
        sp_buydateyear.setEnabled(false);
        sp_buydatemonth.setEnabled(false);
        sp_buydateday.setEnabled(false);
        sp_shelflifeyear.setEnabled(false);
        sp_shelflifemonth.setEnabled(false);
        sp_shelflifeday.setEnabled(false);
        check_shelflife.setEnabled(false);
        et_memo.setEnabled(false);//값을 바꿀 수 없도록 함

        //식재료 정보 불러오기
        enroll_pid = UserData.getInstance().getEnroll_pid();
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

        //수정 눌렀을 경우
        v.findViewById(R.id.btn_registermod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfomod);
            }
        });

        //취소 눌렀을 경우
        v.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_showfoodreginfo_to_nav_showfoodreginfolist);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        //삭제 눌렀을 경우
        v.findViewById(R.id.btn_registerdel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("삭제하시겠습니까?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                                    boolean success = jsonObject.getBoolean("success");

                                    if (success) {
                                        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                        navController.navigate(R.id.action_nav_showfoodreginfo_to_nav_showfoodreginfolist);
                                        navController.navigateUp();
                                        navController.popBackStack();
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        ShowFoodReginfoDeleteRequest showFoodReginfoDeleteRequest = new ShowFoodReginfoDeleteRequest(enroll_pid, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getActivity());
                        queue.add(showFoodReginfoDeleteRequest);
                    }
                });
                builder.setNegativeButton("CANCEL", null);
                dialog = builder.create();
                dialog.show();
            }
        });
        return v;
    }
}