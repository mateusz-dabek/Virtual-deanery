package com.edu.pr.lecturer;

import android.arch.lifecycle.ViewModelProviders;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pr.BaseActivity;
import com.edu.pr.R;
import com.edu.pr.data.Course;
import com.edu.pr.data.Grade;
import com.edu.pr.data.Student;


public class EnterTheGradeActivity extends BaseActivity {

    private ArrayAdapter<Course> mAdapterCourse;
    private ArrayAdapter<Student> mAdapterStudent;
    private Spinner mCourse;
    private Spinner mStudent;
    private AutoCompleteTextView mGrade;
    private Button mSubmitCourse;
    private EnterTheGradeViewModel mEnterTheGradeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_the_grade);

        mCourse = (Spinner) findViewById(R.id.courses);
        mStudent = (Spinner) findViewById(R.id.students);
        mEnterTheGradeViewModel = ViewModelProviders.of(this).get(EnterTheGradeViewModel.class);
        mSubmitCourse = findViewById(R.id.submit_course);
        mGrade = findViewById(R.id.mark_for_student);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.add_grade_toast, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Grade grade;
                Student student = (Student) mStudent.getSelectedItem();
                Course course = (Course) mCourse.getSelectedItem();
                grade = new Grade(
                        student.getNiu(),
                        course.getCourseNo(),
                        Integer.parseInt(mGrade.getText().toString())
                );
                toast.show();
            }
        });

        mAdapterCourse = new ArrayAdapter<Course>(getApplicationContext(), R.layout.spinner_item, android.R.id.text1, mEnterTheGradeViewModel.getCourseList()) {
            @Override
            public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
                final View v = super.getDropDownView(position, convertView, parent);
                v.post(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView) v.findViewById(android.R.id.text1)).setSingleLine(false);
                    }
                });
                return v;
            }
        };

        mAdapterCourse.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mCourse.setAdapter(mAdapterCourse);
        mStudent.setEnabled(false);

        mSubmitCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Course course = (Course) mCourse.getSelectedItem();
                mStudent.setEnabled(true);
                mAdapterStudent = new ArrayAdapter<Student>(getApplicationContext(), R.layout.spinner_item, android.R.id.text1, mEnterTheGradeViewModel.getStudentByFieldOfStudyList(course.getFieldOfStudy(), course.getDepartment(), course.getTerm())) {
                    @Override
                    public View getDropDownView(final int position, final View convertView, final ViewGroup parent) {
                        final View v = super.getDropDownView(position, convertView, parent);
                        v.post(new Runnable() {
                            @Override
                            public void run() {
                                ((TextView) v.findViewById(android.R.id.text1)).setSingleLine(false);
                            }
                        });
                        return v;
                    }
                };
                mAdapterStudent.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                mStudent.setAdapter(mAdapterStudent);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

    }

}
