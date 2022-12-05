package devs.mulham.raee.sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
//import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

//import android.app.Fragment;
//import android.app.FragmentManager;
//import android.app.FragmentTransaction;

import android.text.format.DateFormat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.bottomnavigation.BottomNavigationView;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.model.CalendarEvent;
import devs.mulham.horizontalcalendar.utils.CalendarEventsPredicate;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MainActivity extends AppCompatActivity {

    private HorizontalCalendar horizontalCalendar;
    private FragmentManager fragmentManager;

    TextView date_Textview;
    Button Btn_Diary;
    Button Btn_Note;

    Diary_Fragment fragment_diary = new Diary_Fragment();
    Note_Fragment fragment_note = new Note_Fragment();
    Profile_Fragment fragment_profile = new Profile_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.매니저 생성
        fragmentManager = getSupportFragmentManager();
        //3.추가, 삭제, 교체
        fragmentManager.beginTransaction().replace(R.id.frame_layout, fragment_diary).commit();

        /* start before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* end after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        Btn_Diary = (Button)findViewById(R.id.btn_diary);
        Btn_Note = (Button)findViewById(R.id.btn_note);
        date_Textview = (TextView)findViewById(R.id.date_text);
        date_Textview.setText(DateFormat.format("yyyy년 MMM d일 EEE요일", Calendar.getInstance()));

        // 바텀 네비게이션 객체 선언
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .configure()
                .formatTopText("MMM")
                .formatMiddleText("dd")
                .formatBottomText("EEE")
                .textSize(14f, 24f, 14f)
                .showTopText(true)
                .showBottomText(true)
                .textColor(Color.LTGRAY, Color.BLACK)
                .end()
                .build();

        Btn_Diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment_diary == null)
                {
                    fragment_diary = new Diary_Fragment();
                    fragmentManager.beginTransaction().add(R.id.frame_layout, fragment_diary).commit();
                }
                fragmentManager.beginTransaction().show(fragment_diary).commit();
                fragmentManager.beginTransaction().hide(fragment_note).commit();
//                if(fragment_diary != null) { fragmentManager.beginTransaction().show(fragment_diary).commit(); }
//                if(fragment_note != null) { fragmentManager.beginTransaction().hide(fragment_note).commit(); }
            }
        });

        Btn_Note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fragment_note == null)
                {
                    fragment_note = new Note_Fragment();
                    fragmentManager.beginTransaction().add(R.id.frame_layout, fragment_note).commit();
                }

                fragmentManager.beginTransaction().hide(fragment_diary).commit();
                fragmentManager.beginTransaction().show(fragment_note).commit();
//                if(fragment_diary != null) { fragmentManager.beginTransaction().hide(fragment_diary).commit(); }
//                if(fragment_note != null) { fragmentManager.beginTransaction().show(fragment_note).commit(); }
//                if(fragmentManager.findFragmentByTag("note") != null)
//                {
//                    fragmentManager.beginTransaction().show(fragmentManager.findFragmentByTag("note")).commit();
//                }
//                else
//                {
//                    fragmentManager.beginTransaction().replace(R.id.frame_layout, new Note_Fragment(), "note").commit();
//                }
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fr;
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                switch (item.getItemId()){
                    case R.id.home:
//                        fr = new Diary_Fragment();
//                        fragmentTransaction.replace(R.id.frame_layout, fr);
//                        fragmentTransaction.commit();
                        return true;

                    case R.id.profile:
//                        fr = new Profile_Fragment();
//                        fragmentTransaction.replace(R.id.frame_layout, fr);
//                        fragmentTransaction.commit();
                        return true;

                    default:
                        return false;
                }
            }
        });

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                Toast.makeText(getApplicationContext(), DateFormat.format("EEE, MMM d, yyyy", date) + " is selected!" + position, Toast.LENGTH_SHORT).show();
                date_Textview.setText(DateFormat.format("yyyy년 MMM d일 EEE요일", date));
            }
        });
    }
}
