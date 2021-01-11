package com.example.gogo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gogo.R;

import java.util.ArrayList;

public class CalendarListViewAdapter extends BaseAdapter {

    // Adapter에 추가된 데이터를 저장하기 위한 ArrayList
    private ArrayList<CalendarListViewItem> calendarListViewItemArrayList = new ArrayList<CalendarListViewItem>() ;

    // ListViewAdapter의 생성자
    public CalendarListViewAdapter() {

    }

    // Adapter에 사용되는 데이터의 개수를 리턴. : 필수 구현
    @Override
    public int getCount() {
        return calendarListViewItemArrayList.size() ;
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        // "dialog_calendarlist" Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_calendarlist, parent, false);
        }

        // 화면에 표시될 View(Layout이 inflate된)으로부터 위젯에 대한 참조 획득
        TextView food_name = (TextView) convertView.findViewById(R.id.tv_foodname) ;
        TextView food_exp = (TextView) convertView.findViewById(R.id.tv_foodexp) ;
        ImageView image_icon=convertView.findViewById(R.id.food_icon);

        // Data Set(CalendarListViewItem)에서 position에 위치한 데이터 참조 획득
        CalendarListViewItem calendarListViewItem = calendarListViewItemArrayList.get(position);

        String food_icon= calendarListViewItem.getCategory();

        switch (food_icon){
            case "과일":
                image_icon.setImageResource(R.drawable.fruitlist);
                break;
            case "채소":
                image_icon.setImageResource(R.drawable.vegetablelist);
                break;
            case "정육/계란":
                image_icon.setImageResource(R.drawable.meategglist);
                break;
            case "수산물":
                image_icon.setImageResource(R.drawable.fishlist);
                break;
            case "유제품":
                image_icon.setImageResource(R.drawable.milk);
                break;
            case "양곡/견과류":
                image_icon.setImageResource(R.drawable.rice2);
                break;
            case "소스":
                image_icon.setImageResource(R.drawable.soysauce);
                break;
            case "양념/조미료":
                image_icon.setImageResource(R.drawable.seasoninglist);
                break;
            case "기타":
                image_icon.setImageResource(R.drawable.sidedish);
                break;
        }

        // 아이템 내 각 위젯에 데이터 반영
        food_name.setText(calendarListViewItem.getFood_name());
        food_exp.setText(calendarListViewItem.getFood_exp());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position) {
        return position ;
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public Object getItem(int position) {  return calendarListViewItemArrayList.get(position) ; }

    // 아이템 데이터 추가를 위한 함수. 개발자가 원하는대로 작성 가능.
    public void addItem(String enroll_pid, String category, String food_name, String food_exp) {
        CalendarListViewItem item = new CalendarListViewItem();
        item.setEnroll_pid(enroll_pid);
        item.setCategory(category);
        item.setFood_name(food_name);
        item.setFood_exp(food_exp);

        calendarListViewItemArrayList.add(item);
    }
}

