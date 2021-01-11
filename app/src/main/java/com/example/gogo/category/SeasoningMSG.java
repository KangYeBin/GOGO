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

public class SeasoningMSG extends Fragment {
    View v;
    TextView tv_soysauce, tv_oystersauce, tv_redpepperpowder, tv_redpepperpaste, tv_soybeanpaste, tv_mix, tv_starchsyrup, tv_flour, tv_fryingpowder,
            tv_sugar, tv_salt, tv_cookingoil, tv_vinegar, tv_ssamjang, tv_fishsauce, tv_sesameoil, tv_seasoningetc, tv_msgetc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_category_seasoningmsg, container, false);

        tv_soysauce=v.findViewById(R.id.tv_soysauce);
        tv_oystersauce=v.findViewById(R.id.tv_oystersauce);
        tv_redpepperpowder=v.findViewById(R.id.tv_redpepperpowder);
        tv_redpepperpaste=v.findViewById(R.id.tv_redpepperpaste);
        tv_soybeanpaste=v.findViewById(R.id.tv_soybeanpaste);
        tv_mix=v.findViewById(R.id.tv_mix);
        tv_starchsyrup=v.findViewById(R.id.tv_starchsyrup);
        tv_flour=v.findViewById(R.id.tv_flour);
        tv_sugar=v.findViewById(R.id.tv_sugar);
        tv_fryingpowder=v.findViewById(R.id.tv_fryingpowder);
        tv_salt=v.findViewById(R.id.tv_salt);
        tv_cookingoil=v.findViewById(R.id.tv_cookingoil);
        tv_vinegar=v.findViewById(R.id.tv_vinegar);
        tv_ssamjang=v.findViewById(R.id.tv_ssamjang);
        tv_fishsauce=v.findViewById(R.id.tv_fishsauce);
        tv_sesameoil=v.findViewById(R.id.tv_sesameoil);
        tv_seasoningetc=v.findViewById(R.id.tv_seasoningetc);
        tv_msgetc=v.findViewById(R.id.tv_msgetc);

        v.findViewById(R.id.btn_soysauce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_soysauce.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_oystersauce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_oystersauce.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_redpepperpowder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_redpepperpowder.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_redpepperpaste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_redpepperpaste.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_soybeanpaste).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_soybeanpaste.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_mix).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_mix.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_starchsyrup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_starchsyrup.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_fryingpowder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_fryingpowder.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_sugar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sugar.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_salt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_salt.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_cookingoil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_cookingoil.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_vinegar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_vinegar.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_ssamjang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_ssamjang.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_fishsauce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_fishsauce.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_sesameoil).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sesameoil.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_seasoningetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_seasoningetc.getText().toString();
                String category_name ="양념/조미료";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_msgetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_msgetc.getText().toString();
                String category_name ="양념/조미료";
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
