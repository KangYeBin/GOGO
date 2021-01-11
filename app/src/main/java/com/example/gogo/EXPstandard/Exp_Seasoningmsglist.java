package com.example.gogo.EXPstandard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.gogo.R;

public class Exp_Seasoningmsglist extends Fragment {
    View v;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_exp_seasoningmsg, container, false);

        TextView tv1 = (TextView) v.findViewById(R.id.tv_cookingoil_exp);
        TextView tv2 = (TextView) v.findViewById(R.id.tv_cookingoil_exp_explain);

        return v;
    }

}
