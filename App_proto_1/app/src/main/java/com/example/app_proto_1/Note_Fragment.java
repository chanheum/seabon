package com.example.app_proto_1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Note_Fragment extends Fragment {
    public Button Btn_Diary;
    public Button Btn_Note;

    // 각각의 Fragment마다 Instance를 반환해 줄 메소드를 생성합니다.
    public static Note_Fragment newInstance() {
        return new Note_Fragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_note, container, false);

        Btn_Diary = (Button)v.findViewById(R.id.btn_diary);
        Btn_Note = (Button)v.findViewById(R.id.btn_note);

        Btn_Diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).replaceFragment(Diary_Fragment.newInstance());
            }
        });

        Btn_Note.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 ((MainActivity)getActivity()).replaceFragment(Note_Fragment.newInstance());
            }
        });
        return v;
    }

}
