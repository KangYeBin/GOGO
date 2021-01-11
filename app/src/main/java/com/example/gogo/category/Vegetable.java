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

public class Vegetable extends Fragment {
    View v;
    TextView tv_eggplant, tv_potato, tv_sweetpotato, tv_hotpepper, tv_perillaleaf, tv_vegetables, tv_carrot, tv_garlic, tv_whiteradish, tv_napacabbage,
            tv_mushroom, tv_chives, tv_broccoli, tv_lettuce, tv_onion, tv_cucumber, tv_springonion, tv_redpaprika, tv_paprika, tv_vegetableetc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_category_vegetable, container, false);

        tv_eggplant=v.findViewById(R.id.tv_eggplant);
        tv_potato=v.findViewById(R.id.tv_potato);
        tv_sweetpotato=v.findViewById(R.id.tv_sweetpotato);
        tv_hotpepper=v.findViewById(R.id.tv_hotpepper);
        tv_perillaleaf=v.findViewById(R.id.tv_perillaleaf);
        tv_vegetables=v.findViewById(R.id.tv_vegetables);
        tv_carrot=v.findViewById(R.id.tv_carrot);
        tv_garlic=v.findViewById(R.id.tv_garlic);
        tv_whiteradish=v.findViewById(R.id.tv_whiteradish);
        tv_napacabbage=v.findViewById(R.id.tv_napacabbage);
        tv_mushroom=v.findViewById(R.id.tv_mushroom);
        tv_chives=v.findViewById(R.id.tv_chives);
        tv_broccoli=v.findViewById(R.id.tv_broccoli);
        tv_lettuce=v.findViewById(R.id.tv_lettuce);
        tv_onion=v.findViewById(R.id.tv_onion);
        tv_cucumber=v.findViewById(R.id.tv_cucumber);
        tv_springonion=v.findViewById(R.id.tv_springonion);
        tv_redpaprika=v.findViewById(R.id.tv_redpaprika);
        tv_paprika=v.findViewById(R.id.tv_paprika);
        tv_vegetableetc=v.findViewById(R.id.tv_vegetableetc);

        v.findViewById(R.id.btn_eggplant).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_eggplant.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_potato).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_potato.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_sweetpotato).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sweetpotato.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_hotpepper).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_hotpepper.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_perillaleaf).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_perillaleaf.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_vegetables).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_vegetables.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_carrot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_carrot.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_garlic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_garlic.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_whiteradish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_whiteradish.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_napacabbage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_napacabbage.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_mushroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_mushroom.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_chives).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_chives.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_broccoli).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_broccoli.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_lettuce).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_lettuce.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_onion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_onion.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_cucumber).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_cucumber.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_springonion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_springonion.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_springonion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_springonion.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_redpaprika).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_redpaprika.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_paprika).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_paprika.getText().toString();
                String category_name ="채소";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_vegetableetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_vegetableetc.getText().toString();
                String category_name ="채소";
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
