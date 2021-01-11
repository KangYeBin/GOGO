package com.example.gogo.EXPstandard;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import java.util.ArrayList;

public class Stand_vpadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext=new ArrayList<String>();

    public Stand_vpadapter(FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new Exp_Fruitlist());
        items.add(new Exp_Vegetablelist());
        items.add(new Exp_MeatEgglist());
        items.add(new Exp_Fishlist());
        items.add(new Exp_Seasoningmsglist());
        items.add(new Exp_ETClist());

        itext.add("과일");
        itext.add("채소");
        itext.add("정육/계란");
        itext.add("수산물");
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
