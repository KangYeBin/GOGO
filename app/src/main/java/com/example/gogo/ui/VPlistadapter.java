package com.example.gogo.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gogo.categorylist.All;
import com.example.gogo.categorylist.Etc;
import com.example.gogo.categorylist.Fish;
import com.example.gogo.categorylist.Fruit;
import com.example.gogo.categorylist.MeatEgg;
import com.example.gogo.categorylist.Milk;
import com.example.gogo.categorylist.Nuts;
import com.example.gogo.categorylist.Sauce;
import com.example.gogo.categorylist.SeasoningMSG;
import com.example.gogo.categorylist.Vegetable;

import java.util.ArrayList;

public class VPlistadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext=new ArrayList<String>();

    public VPlistadapter(FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new All());
        items.add(new Fruit());
        items.add(new Vegetable());
        items.add(new MeatEgg());
        items.add(new Fish());
        items.add(new Milk());
        items.add(new Nuts());
        items.add(new Sauce());
        items.add(new SeasoningMSG());
        items.add(new Etc());

        itext.add("전체");
        itext.add("과일");
        itext.add("채소");
        itext.add("정육/계란");
        itext.add("수산물");
        itext.add("유제품");
        itext.add("양곡/견과류");
        itext.add("소스");
        itext.add("양념/조미료");
        itext.add("기타");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return itext.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }
}
