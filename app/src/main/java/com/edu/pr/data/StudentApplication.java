package com.edu.pr.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "student_application")
public class StudentApplication {

    @PrimaryKey(autoGenerate = true)
    private Integer applicationNo;
    @NonNull
    private String description;
    @NonNull
    private Integer studentAlbumNo;
    @NonNull
    private Integer distanceFromTheCheck_InPlace;
    @NonNull
    private String status;

    public StudentApplication(@NonNull String description, @NonNull Integer studentAlbumNo, @NonNull Integer distanceFromTheCheck_InPlace, @NonNull String status) {
        this.description = description;
        this.studentAlbumNo = studentAlbumNo;
        this.distanceFromTheCheck_InPlace = distanceFromTheCheck_InPlace;
        this.status = status;
    }

    public Integer getApplicationNo() { return applicationNo; }

    @NonNull
    public String getDescription() { return description; }

    @NonNull
    public Integer getStudentAlbumNo() { return studentAlbumNo; }

    @NonNull
    public Integer getDistanceFromTheCheck_InPlace() { return distanceFromTheCheck_InPlace; }

    @NonNull
    public String getStatus() { return status; }

    public void setApplicationNo(Integer applicationNo) {
        this.applicationNo = applicationNo;
    }

}
