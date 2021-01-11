package com.example.gogo.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gogo.faq.FAQ_community;
import com.example.gogo.faq.FAQ_etc;
import com.example.gogo.faq.FAQ_reginfo;
import com.example.gogo.faq.FAQ_userinfo;

import java.util.ArrayList;

public class FAQvplistadapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> items;
    private ArrayList<String> itext=new ArrayList<String>();

    public FAQvplistadapter(FragmentManager fm) {
        super(fm);
        items=new ArrayList<Fragment>();
        items.add(new FAQ_userinfo());
        items.add(new FAQ_reginfo());
        items.add(new FAQ_community());
        items.add(new FAQ_etc());

        itext.add("회원정보");
        itext.add("등록정보");
        itext.add("게시판");
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
