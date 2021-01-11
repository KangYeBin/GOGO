package com.example.gogo;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowBoardListViewAdapter extends BaseAdapter {

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<ShowBoardListViewItem> showboardListViewItemArrayList = new ArrayList<ShowBoardListViewItem>() ;

    //생성자
    public ShowBoardListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return showboardListViewItemArrayList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "activity_showboardlist" Layout을 inflate하여 convertView 참조 획득.
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.activity_showboardlist, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
//        ImageView img_commentwriter = (ImageView) convertView.findViewById(R.id.img_boardwriter);
        TextView comment_writer = (TextView) view.findViewById(R.id.tv_commentwriter) ;
        TextView comment_time = (TextView) view.findViewById(R.id.tv_commenttime) ;
        TextView comment = (TextView) view.findViewById(R.id.tv_comment);
        Button comment_delete = (Button) view.findViewById(R.id.btn_commentdelete);
        ImageView img_commentwriter = (ImageView) view.findViewById(R.id.img_commentwriter);

//      Data Set(BoardListViewItem)에서 position에 위치한 데이터 참조 획득
        final ShowBoardListViewItem showboardListViewItem = showboardListViewItemArrayList.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        //img_commentwriter.setText(showboardListViewItem.getComment_icon());
        //이미지 스트링으로 하려고 했는데 setText에 빨간줄 생겨서 다른 함수 찾는데 타입 안 맞는다고 다 빨간줄 떠서 일단 주석처리해놨어 아이콘
        comment_writer.setText(showboardListViewItem.getComment_writer());
        comment_time.setText(showboardListViewItem.getComment_time());
        comment.setText((showboardListViewItem.getComment_content()));

        String icon = showboardListViewItem.getComment_icon();
        switch (icon){
            case "1":
                img_commentwriter.setImageResource(R.drawable.apple);
                break;
            case "2":
                img_commentwriter.setImageResource(R.drawable.peach);
                break;
            case "3":
                img_commentwriter.setImageResource(R.drawable.cherry);
                break;
            case "4":
                img_commentwriter.setImageResource(R.drawable.orange);
                break;
            case "5":
                img_commentwriter.setImageResource(R.drawable.pear5);
                break;
            case "6":
                img_commentwriter.setImageResource(R.drawable.whiteradish);
                break;
        }

        //내가 쓴 댓글만 삭제 버튼이 보이도록
        String user_pid = UserData.getInstance().getUserpid();
        if(user_pid.equals(showboardListViewItem.getComment_userpid())) {
            comment_delete.setVisibility(view.VISIBLE);
        } else {
            comment_delete.setVisibility(view.GONE);
        }

        //클릭한 댓글 삭제
        comment_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String comments_pid = showboardListViewItem.getComment_pid();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                            boolean success = jsonObject.getBoolean("success");

                            if (success) {
//                                Toast.makeText(context, comments_pid, Toast.LENGTH_SHORT).show();
                                NavController navController = Navigation.findNavController((Activity) context, R.id.nav_host_fragment);
                                navController.navigate(R.id.nav_board);
                                Toast.makeText( context, "댓글 삭제 완료", Toast.LENGTH_SHORT ).show();

                                notifyDataSetChanged();
                                return;

                            } else {
                                return;
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                CommentsDeleteRequest commentsDeleteRequest = new CommentsDeleteRequest(comments_pid, responseListener);
                RequestQueue queue = Volley.newRequestQueue(context);
                queue.add(commentsDeleteRequest);
            }
        });


        return view;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {
        return showboardListViewItemArrayList.get(position) ;
    }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String comment_pid, String user_pid, String comment_writer, String comment_content, String comment_time, String img_commentwriter) {
        ShowBoardListViewItem sitem = new ShowBoardListViewItem();

        sitem.setComment_pid(comment_pid);
        sitem.setComment_userpid(user_pid);
        sitem.setComment_writer(comment_writer);
        sitem.setComment_content(comment_content);
        sitem.setComment_time(comment_time);
        sitem.setComment_icon(img_commentwriter);

        showboardListViewItemArrayList.add(sitem);
    }
}