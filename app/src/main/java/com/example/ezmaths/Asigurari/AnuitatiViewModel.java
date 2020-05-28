package com.example.ezmaths.Asigurari;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnuitatiViewModel extends ViewModel {

        private MutableLiveData<Double> anuitateLiveData1 = new MutableLiveData<>();
        private MutableLiveData<Double> anuitateLiveData2 = new MutableLiveData<>();
        private MutableLiveData<Integer> asigType = new MutableLiveData<>();


        public void setAnuitateLiveData1 (double anuitate)
        {
            anuitateLiveData1.setValue(anuitate);
        }

        public LiveData<Double> getAnuitateLiveData1 ()
        {
            return anuitateLiveData1;
        }

        public void setAnuitateLiveData2 (double anuitate)
    {
        anuitateLiveData2.setValue(anuitate);
    }

        public LiveData<Double> getAnuitateLiveData2 ()
    {
        return anuitateLiveData2;
    }
}
