package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.Course;
import com.edu.pr.data.FieldOfStudy;
import com.edu.pr.data.FieldOfStudyCourse;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class AddFieldOfStudyViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddFieldOfStudyViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public void insertFieldOfStudy(FieldOfStudy fieldOfStudy){ mRepository.insertFieldOfStudy(fieldOfStudy); }

    public void insertFieldOfStudyCourse(FieldOfStudy fieldOfStudy){
        List<Course> courses = mRepository.getCourseList();
        for(Course c: courses){
            if(c.getDepartment().equals(fieldOfStudy.getDepartment()) && c.getFieldOfStudy().equals(fieldOfStudy.getFieldOfStudyName())){
                mRepository.insertFieldOfStudyCourse(new FieldOfStudyCourse(fieldOfStudy.getFieldOfStudyNo(), c.getCourseNo()));
            }
        }
    }

}
