package devs.mulham.raee.sample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class Note_Fragment extends Fragment {

    TextView date_Textview;
    ImageView imageView;

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static Note_Fragment newInstance() {
        return new Note_Fragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container, false);

        date_Textview = (TextView)v.findViewById(R.id.date_text);
        imageView = (ImageView) v.findViewById(R.id.save_image);
        imageView.bringToFront();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return v;
    }

}
