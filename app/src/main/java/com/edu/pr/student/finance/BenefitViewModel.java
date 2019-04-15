package com.edu.pr.student.finance;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.edu.pr.data.Benefit;
import com.edu.pr.data.VirtualDeaneryRepository;

import java.util.List;

public class BenefitViewModel extends AndroidViewModel {

    private VirtualDeaneryRepository mRepository;

    public BenefitViewModel(@NonNull Application application) {
        super(application);
        mRepository = new VirtualDeaneryRepository(application);
    }

    public List<Benefit> getBenefits(){
        return mRepository.getBenefits();
    }
}
