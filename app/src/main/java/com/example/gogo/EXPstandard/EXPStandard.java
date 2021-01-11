package com.example.gogo.EXPstandard;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.viewpager.widget.ViewPager;

import com.example.gogo.R;

import com.google.android.material.tabs.TabLayout;

public class EXPStandard extends Fragment {
    View v;
    private TabLayout tabLayout;
    Stand_vpadapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.activity_expstandardtab, container, false);
        tabLayout = v.findViewById(R.id.sliding_tabs);
        ViewPager vp= v.findViewById(R.id.viewPager);
        adapter=new Stand_vpadapter(getChildFragmentManager());
        vp.setAdapter(adapter);
        tabLayout.setupWithViewPager(vp);

        return v;
    }
}
