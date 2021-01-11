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

public class Fish extends Fragment {
    View v;
    TextView tv_driedfish, tv_crab, tv_laver, tv_anchovy, tv_octopus, tv_shrimp, tv_fish, tv_squid, tv_clam, tv_seaweed, tv_sashimi, tv_fishetc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_category_fish, container, false);

        tv_driedfish = v.findViewById(R.id.tv_driedfish);
        tv_crab = v.findViewById(R.id.tv_crab);
        tv_laver = v.findViewById(R.id.tv_laver);
        tv_anchovy = v.findViewById(R.id.tv_anchovy);
        tv_octopus = v.findViewById(R.id.tv_octopus);
        tv_shrimp = v.findViewById(R.id.tv_shrimp);
        tv_fish = v.findViewById(R.id.tv_fish);
        tv_squid = v.findViewById(R.id.tv_squid);
        tv_clam = v.findViewById(R.id.tv_clam);
        tv_seaweed = v.findViewById(R.id.tv_seaweed);
        tv_sashimi = v.findViewById(R.id.tv_sashimi);
        tv_fishetc = v.findViewById(R.id.tv_fishetc);

        v.findViewById(R.id.btn_driedfish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_driedfish.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_crab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_crab.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_laver).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_laver.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_anchovy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_anchovy.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_octopus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_octopus.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_shrimp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_shrimp.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_fish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_fish.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_squid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_squid.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_clam).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_clam.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_seaweed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_seaweed.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_sashimi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sashimi.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });
        v.findViewById(R.id.btn_fishetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_fishetc.getText().toString();
                String category_name ="수산물";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });



        return v;
    }
}
