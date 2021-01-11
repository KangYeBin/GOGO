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

public class Nuts extends Fragment {
    View v;
    TextView tv_sesame, tv_jujube, tv_chestnut, tv_barley, tv_rice, tv_almond, tv_ginkgo, tv_pinenut, tv_glutinousrice, tv_redbean,
            tv_sunflowerseed, tv_unpolishedrice, tv_walnut, tv_riceetc, tv_nutetc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_category_nuts, container, false);

        tv_sesame=v.findViewById(R.id.tv_sesame);
        tv_jujube=v.findViewById(R.id.tv_jujube);
        tv_chestnut=v.findViewById(R.id.tv_chestnut);
        tv_barley=v.findViewById(R.id.tv_barley);
        tv_rice=v.findViewById(R.id.tv_rice);
        tv_almond=v.findViewById(R.id.tv_almond);
        tv_ginkgo=v.findViewById(R.id.tv_ginkgo);
        tv_pinenut=v.findViewById(R.id.tv_pinenut);
        tv_glutinousrice=v.findViewById(R.id.tv_glutinousrice);
        tv_redbean=v.findViewById(R.id.tv_redbean);
        tv_sunflowerseed=v.findViewById(R.id.tv_sunflowerseed);
        tv_unpolishedrice=v.findViewById(R.id.tv_unpolishedrice);
        tv_walnut=v.findViewById(R.id.tv_walnut);
        tv_riceetc=v.findViewById(R.id.tv_riceetc);
        tv_nutetc=v.findViewById(R.id.tv_nutetc);

        v.findViewById(R.id.btn_sesame).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sesame.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_jujube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_jujube.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_chestnut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_chestnut.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_barley).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_barley.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_rice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_rice.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_almond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_almond.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_ginkgo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_ginkgo.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_pinenut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_pinenut.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_glutinousrice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_glutinousrice.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_redbean).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_redbean.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_sunflowerseed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_sunflowerseed.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_unpolishedrice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_unpolishedrice.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_walnut).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_walnut.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_riceetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_riceetc.getText().toString();
                String category_name ="양곡/견과류";
                UserData.getInstance().setFood_name(food_name);
                UserData.getInstance().setCategory_name(category_name);
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_foodreginfo);
                navController.navigateUp();
                navController.popBackStack();
            }
        });

        v.findViewById(R.id.btn_nutetc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String food_name = tv_nutetc.getText().toString();
                String category_name ="양곡/견과류";
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
