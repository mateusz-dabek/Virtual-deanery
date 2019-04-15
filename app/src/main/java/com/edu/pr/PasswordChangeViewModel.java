package com.edu.pr;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.VirtualDeaneryRepository;

public class PasswordChangeViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public PasswordChangeViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public boolean checkCurrentPassword(String currentPassword){
        Boolean passOK = false;
        String passFromDB = mRepository.getPassword();
        try {
            passOK = passFromDB.equals(currentPassword);
        } catch (Exception e) {
            passOK = false;
        }
        return passOK;
    }

    public Integer getNiu() {
        return mRepository.getNiu();
    }
}
