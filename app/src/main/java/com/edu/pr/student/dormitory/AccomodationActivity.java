package com.edu.pr.student.dormitory;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.edu.pr.BaseActivity;
import com.edu.pr.R;

public class AccomodationActivity extends BaseActivity {

    private TextView mWhichDorm;
    private TextView mWhichRoom;
    private AccomodationViewModel mAccomodationViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accomodation);

        mWhichDorm = (TextView) findViewById(R.id.which_dorm);
        mWhichRoom = (TextView) findViewById(R.id.which_room);
        mAccomodationViewModel = ViewModelProviders.of(this).get(AccomodationViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        int albumNo = mAccomodationViewModel.getAlbumNo();
        mWhichDorm.setText(mAccomodationViewModel.getDorm(albumNo));
        mWhichRoom.setText(mAccomodationViewModel.getRoom(albumNo));
    }

}
