package com.edu.pr.data.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.edu.pr.data.Lecturer;

@Dao
public interface LecturerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Lecturer lecturer);

    @Query("DELETE FROM lecturer")
    void deleteAll();

    @Query("SELECT password FROM lecturer where niu = :niu")
    String getLecturerPassword(Integer niu);

    @Query("UPDATE lecturer SET niu = :niu, password = :newPassword WHERE niu = :niu")
    void changePasswordLecturer(Integer niu, String newPassword);

}