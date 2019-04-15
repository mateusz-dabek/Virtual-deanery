package com.edu.pr.employee;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.Course;
import com.edu.pr.data.LecturerCourse;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class AddLecturerViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public AddLecturerViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Course> getCourseList() {
        return mRepository.getCourseList();
    }

    public void insertLecturerCourse(LecturerCourse lecturerCourse) { mRepository.insertLecturerCourse(lecturerCourse); }
}
