package com.edu.pr.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.edu.pr.data.FieldOfStudyCourse;

@Dao
public interface FieldOfStudyCourseDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(FieldOfStudyCourse fieldOfStudyCourse);

    @Query("DELETE FROM field_of_study_course")
    void deleteAll();

}
