package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.edu.pr.data.StudentApplication;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class WaitingRoomViewModel extends AndroidViewModel {

    private LiveData<List<StudentApplication>> mStudentApplications;
    private VirtualDeaneryRepository mRepository;

    public WaitingRoomViewModel(Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
        mStudentApplications = mRepository.getStudentApplicationsByStatusWaiting();
    }

    public LiveData<List<StudentApplication>> getStudentApplicationsByStatusWaiting() { return mStudentApplications; }

    public void setStatusApplication(int applicationNo, String status){ mRepository.setStatusApplication(applicationNo, status); }

}
