package com.icicezmaths.ezmaths.Asigurari;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnuitatiViewModel extends ViewModel {

        private MutableLiveData<Double> anuitateLiveData1 = new MutableLiveData<>();
        private MutableLiveData<Double> anuitateLiveData2 = new MutableLiveData<>();
        private MutableLiveData<Integer> anuitatiLiveData1Type = new MutableLiveData<>();
        private MutableLiveData<Integer> anuitatiLiveData2Type = new MutableLiveData<>();
        private MutableLiveData<Integer> nAmanata1LiveData = new MutableLiveData<>();
        private MutableLiveData<Integer> nAmanata2LiveData = new MutableLiveData<>();


        public void setAnuitateLiveData1 (double anuitate)
        {
            anuitateLiveData1.setValue(anuitate);
        }
        public LiveData<Double> getAnuitateLiveData1 ()
        {
            return anuitateLiveData1;
        }

        public void setAnuitateLiveData1Type (int anuitateType) {
            anuitatiLiveData1Type.setValue(anuitateType);
        }
        public LiveData<Integer> getAnuitateLiveData1Type ()
        {
        return anuitatiLiveData1Type;
        }

        public void setAnuitateLiveData2 (double anuitate)
    {
        anuitateLiveData2.setValue(anuitate);
    }
        public LiveData<Double> getAnuitateLiveData2 ()
    {
        return anuitateLiveData2;
    }

        public void setAnuitateLiveData2Type (int anuitateType) {
            anuitatiLiveData2Type.setValue(anuitateType);
        }
        public LiveData<Integer> getAnuitateLiveData2Type ()
        {
            return anuitatiLiveData2Type;
        }

        public void setnAmanata1LiveData(int nAmanata){
            nAmanata1LiveData.setValue(nAmanata);
        }
        public LiveData<Integer> getnAmanata1LiveData(){
            return nAmanata1LiveData;
        }

        public void setnAmanata2LiveData(int nAmanata){
        nAmanata2LiveData.setValue(nAmanata);
    }
        public LiveData<Integer> getnAmanata2LiveData(){
        return nAmanata2LiveData;
    }

}
