package com.edu.pr.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.edu.pr.data.Grade;

import java.util.List;

@Dao
public interface GradeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Grade grade);

    @Query("DELETE FROM grade")
    void deleteAll();

    @Query("SELECT * FROM grade WHERE niu =:niu")
    LiveData<List<Grade>> getGradesListById(Integer niu);
}
