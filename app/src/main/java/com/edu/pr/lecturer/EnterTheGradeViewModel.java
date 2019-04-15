package com.edu.pr.lecturer;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.Course;
import com.edu.pr.data.Student;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class EnterTheGradeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public EnterTheGradeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Course> getCourseList() { return mRepository.getCourseListById(); }

    public List<Student> getStudentByFieldOfStudyList(String fieldOfStudy, String department, Integer term) { return mRepository.getStudentByFieldOfStudyList(fieldOfStudy, department, term); }

}
