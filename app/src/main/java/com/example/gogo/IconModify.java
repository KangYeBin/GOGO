package com.example.gogo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class IconModify extends AppCompatActivity {

    private Button btn_cancel;
    private ImageButton btn_apple, btn_peach, btn_cherry, btn_orange, btn_pear, btn_whiteradish;
    private String user_pid;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iconmodify);

        user_pid = UserData.getInstance().getUserpid();
        btn_apple=findViewById(R.id.btn_apple);
        btn_peach=findViewById(R.id.btn_peach);
        btn_cherry=findViewById(R.id.btn_cherry);
        btn_orange=findViewById(R.id.btn_orange);
        btn_pear=findViewById(R.id.btn_pear);
        btn_whiteradish=findViewById(R.id.btn_whiteradish);

        btn_apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="1";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });
        btn_peach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="2";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });
        btn_cherry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="3";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });
        btn_orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="4";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });
        btn_pear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="5";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });
        btn_whiteradish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String icon="6";
                UserData.getInstance().setIcon(icon);

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject( response );
                            boolean success = jsonObject.getBoolean( "success" );

                            if(success) {
                                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                                startActivity(intent);

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                IconModifyRequest iconModifyRequest = new IconModifyRequest( user_pid, icon, responseListener );
                RequestQueue queue = Volley.newRequestQueue( IconModify.this );
                queue.add( iconModifyRequest );
            }
        });


        //아이콘 수정 취소 버튼 클릭
        btn_cancel = findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IconModify.this, ProfileModify.class);
                startActivity(intent);
            }
        });
    }
}
