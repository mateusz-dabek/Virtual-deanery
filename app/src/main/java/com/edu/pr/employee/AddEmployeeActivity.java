package com.edu.pr.employee;

import android.arch.lifecycle.ViewModelProviders;
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
import com.edu.pr.data.Employee;

public class AddEmployeeActivity extends BaseActivity {

    private AutoCompleteTextView mNiu;
    private AutoCompleteTextView mPassword;
    private AutoCompleteTextView mFirstName;
    private AutoCompleteTextView mLastName;
    private AutoCompleteTextView mAddress;
    private AutoCompleteTextView mCityOrVillage;
    private AutoCompleteTextView mPesel;
    private AutoCompleteTextView mEmail;
    private AddEmployeeViewModel mAddEmployeeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_employee);

        mNiu = (AutoCompleteTextView) findViewById(R.id.niu_employee);
        mPassword = (AutoCompleteTextView) findViewById(R.id.password_employee);
        mFirstName = (AutoCompleteTextView) findViewById(R.id.first_name_employee);
        mLastName = (AutoCompleteTextView) findViewById(R.id.last_name_employee);
        mAddress = (AutoCompleteTextView) findViewById(R.id.address_employee);
        mCityOrVillage = (AutoCompleteTextView) findViewById(R.id.city_or_village_employee);
        mPesel = (AutoCompleteTextView) findViewById(R.id.pesel_employee);
        mEmail = (AutoCompleteTextView) findViewById(R.id.email_employee);
        mAddEmployeeViewModel = ViewModelProviders.of(this).get(AddEmployeeViewModel.class);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        final Toast toast = Toast.makeText(getBaseContext(), R.string.add_employee_toast, Toast.LENGTH_LONG);
        View view = toast.getView();
        view.getBackground().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
        TextView text = view.findViewById(android.R.id.message);
        text.setTextColor(getResources().getColor(R.color.colorPrimary));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Employee employee;
                employee = new Employee(
                        Integer.parseInt(mNiu.getText().toString()),
                        mPassword.getText().toString(),
                        mFirstName.getText().toString(),
                        mLastName.getText().toString(),
                        mAddress.getText().toString(),
                        mCityOrVillage.getText().toString(),
                        mPesel.getText().toString(),
                        mEmail.getText().toString()
                );

                mAddEmployeeViewModel.insertEmployee(employee);
                mNiu.setText("");
                mPassword.setText("");
                mFirstName.setText("");
                mLastName.setText("");
                mAddress.setText("");
                mCityOrVillage.setText("");
                mPesel.setText("");
                mEmail.setText("");
                toast.show();
            }
        });
    }
}