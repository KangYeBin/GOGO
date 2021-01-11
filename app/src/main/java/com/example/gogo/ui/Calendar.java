package com.example.gogo.ui;

import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.gogo.CalendarDotRequest;
import com.example.gogo.Join;
import com.example.gogo.UserData;
import com.example.gogo.R;
import com.example.gogo.decorators.EventDecorator;
import com.example.gogo.decorators.OneDayDecorator;
import com.example.gogo.decorators.SaturdayDecorator;
import com.example.gogo.decorators.SundayDecorator;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class Calendar extends Fragment {
    View v;
    private String[] result;
    ArrayList<String> calendarDotArrayList;

    private final OneDayDecorator oneDayDecorator = new OneDayDecorator();
    MaterialCalendarView materialCalendarView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_calendar, container, false);

        materialCalendarView = v.findViewById(R.id.calendarView);
        materialCalendarView.state().edit()
                .setFirstDayOfWeek(java.util.Calendar.SUNDAY)
                .setMinimumDate(CalendarDay.from(2012, 0, 1)) // 달력의 시작
                .setMaximumDate(CalendarDay.from(2030, 11, 31)) // 달력의 끝
                .setCalendarDisplayMode(CalendarMode.MONTHS)
                .commit();
        materialCalendarView.addDecorators(
                new SundayDecorator(),
                new SaturdayDecorator(),
                oneDayDecorator);

        //구입날짜에 점 찍기
        calendarDotArrayList = new ArrayList<>() ;

        String code_pid = UserData.getInstance().getCodepid();
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try{
                    JSONObject jsonObject = new JSONObject(response.substring(response.indexOf("{"), response.lastIndexOf("}") + 1));
                    JSONArray jsonArray = jsonObject.getJSONArray("response");
//                    Log.e("데이터 확인","response"+response);

                    int count = 0;

                    String exp_end;

                    //JSON 배열 길이만큼 반복문을 실행
                    while(count < jsonArray.length()){
                        //count는 배열의 인덱스를 의미
                        JSONObject object = jsonArray.getJSONObject(count);
                        exp_end = object.getString("exp_end");
                        calendarDotArrayList.add(exp_end);

                        count++;
                    }
                    result = calendarDotArrayList.toArray(new String[calendarDotArrayList.size()]);
                    //{"2011-02-15", "2020-01-01" ...}

                    class ApiSimulator extends AsyncTask<Void, Void, List<CalendarDay>> {

                        private String[] Time_Result;

                        ApiSimulator(String[] Time_Result) {
                            this.Time_Result = Time_Result;
                        }

                        @Override
                        protected List<CalendarDay> doInBackground(@NonNull Void... voids) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            java.util.Calendar calendar = java.util.Calendar.getInstance();
                            ArrayList<CalendarDay> dates = new ArrayList<>();

                            /*특정날짜 달력에 점표시해주는곳*/
                            /*월은 0이 1월 년,일은 그대로*/
                            //string 문자열인 Time_Result 을 받아와서 ,를 기준으로 짜르고 string을 int 로 변환
                            for (int i = 0; i < Time_Result.length; i++) {
                                //이부분에서 day를 선언하면 초기 값에 오늘 날짜 데이터 들어간다.
                                //오늘 날짜 데이터를 첫 번째 인자로 넣기 때문에 데이터가 하나씩 밀려 마지막 데이터는 표시되지 않고, 오늘 날짜 데이터가 표시 됨.
                                // day선언 주석처리

                                //                CalendarDay day = CalendarDay.from(calendar);
                                //                Log.e("데이터 확인","day"+day);
                                String[] time = Time_Result[i].split("-");

                                int year = Integer.parseInt(time[0]);
                                int month = Integer.parseInt(time[1]);
                                int dayy = Integer.parseInt(time[2]);

                                //선언문을 아래와 같은 위치에 선언
                                //먼저 .set 으로 데이터를 설정한 다음 CalendarDay day = CalendarDay.from(calendar); 선언해주면 첫 번째 인자로 새로 정렬한 데이터를 넣어 줌.
                                calendar.set(year, month - 1, dayy);

                                CalendarDay day = CalendarDay.from(calendar);
                                dates.add(day);
                            }
                            return dates;
                        }

                        @Override
                        protected void onPostExecute(@NonNull List<CalendarDay> calendarDays) {
                            super.onPostExecute(calendarDays);

                            if (false) { return; }

                            materialCalendarView.addDecorator(new EventDecorator(Color.RED, calendarDays));
                        }
                    }
                    new ApiSimulator(result).executeOnExecutor(Executors.newSingleThreadExecutor());

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        };
        CalendarDotRequest calendarDotRequest = new CalendarDotRequest(code_pid, responseListener);
        RequestQueue queue = Volley.newRequestQueue(getActivity());
        queue.add(calendarDotRequest);

        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                int Year = date.getYear();
                int Month = date.getMonth() + 1;
                int Day = date.getDay();
                String month = String.format("%02d", Month);
                String day = String.format("%02d", Day);

                Log.i("Year test", Year + "");
                Log.i("Month test", Month + "");
                Log.i("Day test", Day + "");

                String shot_Day = Year + "-" + month + "-" + day;
                UserData.getInstance().setShot_Day(shot_Day);

                Log.i("shot_Day test", shot_Day + "");
                materialCalendarView.clearSelection();

                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.nav_calendarlist);
            }
        });

        UserData.getInstance().setCategory_name("카테고리");
        UserData.getInstance().setFood_name("식재료 이름");


        v.findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view){
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_nav_calendar_to_nav_foodreginfo);
            }
        });
        return v;
    }
}