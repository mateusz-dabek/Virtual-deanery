package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.StudentDormitory;
import com.edu.pr.data.VirtualDeaneryRepository;

public class AssignADormViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AssignADormViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertStudentDormitory(StudentDormitory studentDormitory){ mRepository.insertStudentDormitory(studentDormitory); }

    public void setStatusApplication(int applicationNo, String status){ mRepository.setStatusApplication(applicationNo, status); }

}