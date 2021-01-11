package com.example.gogo;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenuBar extends AppCompatActivity{

    private Button btn_modprofile,btn_logout;
    private AppBarConfiguration mAppBarConfiguration;
    private String icon;
    ImageView user_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menubar);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(R.id.nav_calendar, R.id.nav_setting, R.id.nav_board,R.id.nav_showfoodreginfolist, R.id.nav_showuserinfo)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //메뉴 헤더 설정
        View header = navigationView.getHeaderView(0);
        user_icon=header.findViewById(R.id.user_icon);
        icon= UserData.getInstance().getIcon();
        switch (icon){
            case "1":
                user_icon.setImageResource(R.drawable.apple);
                break;
            case "2":
                user_icon.setImageResource(R.drawable.peach);
                break;
            case "3":
                user_icon.setImageResource(R.drawable.cherry);
                break;
            case "4":
                user_icon.setImageResource(R.drawable.orange);
                break;
            case "5":
                user_icon.setImageResource(R.drawable.pear5);
                break;
            case "6":
                user_icon.setImageResource(R.drawable.whiteradish);
                break;
        }
        TextView show_nickname = header.findViewById(R.id.show_nickname);
        show_nickname.setText(UserData.getInstance().getNickname());
        TextView show_refname = header.findViewById(R.id.show_refname);
        show_refname.setText(UserData.getInstance().getRefname());

        //프로필 설정
        btn_modprofile = header.findViewById(R.id.btn_modprofile);
        btn_modprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MenuBar.this, ProfileModify.class );
                startActivity( intent );
            }
        });

        //로그아웃
        btn_logout = header.findViewById(R.id.btn_logout);
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MenuBar.this, Login.class );
                startActivity( intent );
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

