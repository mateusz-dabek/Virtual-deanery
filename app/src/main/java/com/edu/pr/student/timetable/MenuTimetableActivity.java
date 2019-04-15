package com.edu.pr.student.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pr.BaseActivity;
import com.edu.pr.R;

public class MenuTimetableActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.grades:
                intent = new Intent(this, GradesActivity.class);
                startActivity(intent);
                break;
            case R.id.timetable:
                intent = new Intent(this, TimetableActivity.class);
                startActivity(intent);
                break;
            case R.id.syllabus:
                intent = new Intent(this, SyllabusActivity.class);
                startActivity(intent);
                break;
        }
    }

}
