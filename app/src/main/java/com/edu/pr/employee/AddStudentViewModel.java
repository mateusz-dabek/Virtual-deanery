package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.FieldOfStudy;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class AddStudentViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddStudentViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<FieldOfStudy> getFieldOfStudyList() { return mRepository.getFieldOfStudyList(); }

}
