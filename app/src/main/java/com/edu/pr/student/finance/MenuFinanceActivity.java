package com.edu.pr.student.finance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.edu.pr.BaseActivity;
import com.edu.pr.R;

public class MenuFinanceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_finance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onClick(View view) {
        Intent intent;
        switch(view.getId()){
            case R.id.payments:
                intent = new Intent(this, PaymentActivity.class);
                startActivity(intent);
                break;
            case R.id.benefits:
                intent = new Intent(this, BenefitActivity.class);
                startActivity(intent);
                break;
        }
    }
}
