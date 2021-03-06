package com.edu.pr.employee;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pr.BaseActivity;
import com.edu.pr.R;
import com.edu.pr.data.StudentDormitory;

public class AssignADormActivity extends BaseActivity {

    private String mAlbumNo;
    private String mApplicationNumber;
    private AutoCompleteTextView mDorm;
    private AutoCompleteTextView mRoom;
    private AssignADormViewModel mAssignADormViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_adorm);

        mAlbumNo = getIntent().getStringExtra("albumNo");
        mApplicationNumber = getIntent().getStringExtra("applicationNumber");
        mDorm = (AutoCompleteTextView) findViewById(R.id.dorm_name);
        mRoom = (AutoCompleteTextView) findViewById(R.id.room_name);
        mAssignADormViewModel = ViewModelProviders.of(this).get(AssignADormViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.assign_a_dorm, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StudentDormitory studentDormitory;
                studentDormitory = new StudentDormitory(
                        Integer.parseInt(mAlbumNo),
                        mDorm.getText().toString(),
                        mRoom.getText().toString()

                );
                mAssignADormViewModel.insertStudentDormitory(studentDormitory);
                mAssignADormViewModel.setStatusApplication(Integer.parseInt(mApplicationNumber), "zaakceptowany");
                mDorm.setText("");
                mRoom.setText("");
                toast.show();
                Intent intent = getParentActivityIntent(); //TODO finish() ???????
                startActivity(intent);
            }
        });
    }

}
