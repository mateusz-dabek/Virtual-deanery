package com.edu.pr.employee;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pr.BaseActivity;
import com.edu.pr.PasswordChangeActivity;
import com.edu.pr.R;

public class EmployeeMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.add_student:
                intent = new Intent(this, AddStudentActivity.class);
                startActivity(intent);
                break;
            case R.id.add_lecturer:
                intent = new Intent(this, AddLecturerActivity.class);
                startActivity(intent);
                break;
            case R.id.add_employee:
                intent = new Intent(this, AddEmployeeActivity.class);
                startActivity(intent);
                break;
            case R.id.add_course:
                intent = new Intent(this, AddCourseActivity.class);
                startActivity(intent);
                break;
            case R.id.add_field_of_study:
                intent = new Intent(this, AddFieldOfStudyActivity.class);
                startActivity(intent);
                break;
            case R.id.waiting_room:
                intent = new Intent(this, WaitingRoomActivity.class);
                startActivity(intent);
                break;
            case R.id.edit_student_from_employee:
                intent = new Intent(this, EditStudentDataActivity.class);
                startActivity(intent);
                break;
            case R.id.change_password_employee:
                Bundle bundle = new Bundle();
                bundle.putString("goto", "EmployeeMenuActivity");
                intent = new Intent(getApplicationContext(), PasswordChangeActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
        }
    }
}
