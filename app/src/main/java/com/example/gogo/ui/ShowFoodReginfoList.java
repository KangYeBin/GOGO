package com.example.gogo.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.R;
import com.example.gogo.ShowFoodPastDeleteRequest;
import com.example.gogo.UserData;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

public class ShowFoodReginfoList extends Fragment implements View.OnClickListener {
    View v;
    private AlertDialog dialog;
    VPlistadapter listadapter;
    private TabLayout tabLayout;
    private Animation fab_open, fab_close;
    private Boolean isFabOpen = false;
    private FloatingActionButton fab_foodreg, fab_foodregdelete, fab_foodregadd;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_showfoodreginfolist, container, false);

        fab_open = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(getActivity(), R.anim.fab_close);

        fab_foodreg = (FloatingActionButton) v.findViewById(R.id.fab_foodreg);
        fab_foodregdelete = (FloatingActionButton) v.findViewById(R.id.fab_foodregdelete);
        fab_foodregadd = (FloatingActionButton) v.findViewById(R.id.fab_foodregadd);

        fab_foodreg.setOnClickListener(this); //switch 문으로 onClickListener 대체
        fab_foodregdelete.setOnClickListener(this);
        fab_foodregadd.setOnClickListener(this);

        UserData.getInstance().setCategory_name("카테고리");
        UserData.getInstance().setFood_name("식재료 이름");

        tabLayout = v.findViewById(R.id.sliding_tabslist);
        ViewPager vp= v.findViewById(R.id.viewPager);
        listadapter=new VPlistadapter(getChildFragmentManager());
        vp.setAdapter(listadapter);
        tabLayout.setupWithViewPager(vp);

        return v;
    }
    public void anim() { //플로팅 버튼 애니메이션

        if (isFabOpen) { //닫음
            fab_foodregdelete.startAnimation(fab_close);
            fab_foodregadd.startAnimation(fab_close);
            fab_foodregdelete.setClickable(false);
            fab_foodregadd.setClickable(false);
            isFabOpen = false;
        } else { //열기
            fab_foodregdelete.startAnimation(fab_open);
            fab_foodregadd.startAnimation(fab_open);
            fab_foodregdelete.setClickable(true);
            fab_foodregadd.setClickable(true);
            isFabOpen = true;
        }
    }

    //플로팅버튼 기능
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.fab_foodreg:      //플로팅 버튼
                anim();
                break;

            case R.id.fab_foodregdelete:    //유통기한이 지난 것들 삭제
                anim();


                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setMessage("유통기한이 지난 것을 전부 삭제하시겠습니까?");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String user_pid = UserData.getInstance().getUserpid();
                        Response.Listener<String> responseListener = new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                                    boolean success = jsonObject.getBoolean("success");
                                    if(success) {
                                        NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                                        navController.navigate(R.id.nav_showfoodreginfolist);
                                    }
                                    else {
                                        return;
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        };
                        ShowFoodPastDeleteRequest showFoodPastDeleteRequest = new ShowFoodPastDeleteRequest(user_pid, responseListener);
                        RequestQueue queue = Volley.newRequestQueue(getActivity());
                        queue.add(showFoodPastDeleteRequest);
                    }
                });
                builder.setNegativeButton("CANCEL", null);
                dialog = builder.create();
                dialog.show();
                break;

            case R.id.fab_foodregadd:       //등록 버튼
                anim();
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_showfoodreginfolist_to_nav_foodreginfo);
                break;
        }
    }
}