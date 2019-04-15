package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.Employee;
import com.edu.pr.data.VirtualDeaneryRepository;

public class AddEmployeeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddEmployeeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertEmployee(Employee employee){
        mRepository.insertEmployee(employee);
    }
}