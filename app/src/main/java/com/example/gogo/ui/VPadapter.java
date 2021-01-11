package com.example.gogo.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gogo.category.Etc;
import com.example.gogo.category.Fish;
import com.example.gogo.category.Fruit;
import com.example.gogo.category.MeatEgg;
import com.example.gogo.category.Milk;
import com.example.gogo.category.Nuts;
import com.example.gogo.category.Sauce;
import com.example.gogo.category.SeasoningMSG;
import com.example.gogo.category.Vegetable;

import java.util.ArrayList;

public class VPadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext=new ArrayList<String>();

    public VPadapter(FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new Fruit());
        items.add(new Vegetable());
        items.add(new MeatEgg());
        items.add(new Fish());
        items.add(new Milk());
        items.add(new Nuts());
        items.add(new Sauce());
        items.add(new SeasoningMSG());
        items.add(new Etc());

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
