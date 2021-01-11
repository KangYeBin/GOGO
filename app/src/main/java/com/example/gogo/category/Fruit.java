package com.example.gogo.category;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.gogo.R;
import com.example.gogo.UserData;


public class Fruit extends Fragment {
    View v;
    TextView tv_persimmon, tv_tangerine, tv_strawberry, tv_lemon, tv_mango, tv_melon, tv_banana, tv_pear, tv_peach;
    TextView tv_apple, tv_watermelon, tv_orange, tv_koreanmelon, tv_cherry, tv_kiwi, tv_tomato, tv_pineapple, tv_grape, tv_fruitetc;
    String food_icon;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_category_fruit, container, false);

        tv_persimmon=v.findViewById(R.id.tv_persimmon);
        tv_tangerine=v.findViewById(R.id.tv_tangerine);
        tv_strawberry=v.findViewById(R.id.tv_strawberry);
        tv_lemon=v.findViewById(R.id.tv_lemon);
        tv_mango=v.findViewById(R.id.tv_mango);
        tv_melon=v.findViewById(R.id.tv_melon);
        tv_banana=v.findViewById(R.id.tv_banana);
        tv_pear=v.findViewById(R.id.tv_pear);
        tv_peach=v.findViewById(R.id.tv_peach);
        tv_apple=v.findViewById(R.id.tv_apple);
        tv_watermelon=v.findViewById(R.id.tv_watermelon);
        tv_orange=v.findViewById(R.id.tv_orange);
        tv_koreanmelon=v.findViewById(R.id.tv_koreanmelon);
        tv_cherry=v.findViewById(R.id.tv_cherry);
        tv_kiwi=v.findViewById(R.id.tv_kiwi);
        tv_tomato=v.findViewById(R.id.tv_tomato);
        tv_grape=v.findViewById(R.id.tv_grape);
        tv_pineapple=v.findViewById(R.id.tv_pineapple);
        tv_fruitetc=v.findViewById(R.id.tv_fruitetc);




        v.findViewById(R.id.btn_persimmon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_persimmon.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_tangerine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_tangerine.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_strawberry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_strawberry.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_lemon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_lemon.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_mango).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_mango.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_melon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_melon.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_banana).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_banana.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_pear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_pear.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_peach).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_peach.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_apple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_apple.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_watermelon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_watermelon.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_orange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_orange.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_koreanmelon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_koreanmelon.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_cherry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_cherry.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_kiwi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_kiwi.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_tomato).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_tomato.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_pineapple).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_pineapple.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_grape).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_grape.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_fruitetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_fruitetc.getText().toString();
                String category_name ="과일";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                UserData.getInstance().setFood_icon(food_icon);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        return v;
    }
}