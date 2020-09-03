package com.example.gadsleaderboard.UI.main;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gadsleaderboard.data.SubmitClient;
import com.example.gadsleaderboard.pojo.Leader_hours_model;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Submit_ViewModel extends ViewModel {
    MutableLiveData<Boolean> submit_livedata=new MutableLiveData<>();
    public void getResponse(String firstName, String secondName, String email,String link){
        SubmitClient.getINSTANCE().getResponse(firstName,secondName,email,link).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response){
                if (response.isSuccessful())
                    submit_livedata.setValue(true);
                else
                    submit_livedata.setValue(false);

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                submit_livedata.setValue(false);


            }
        });
    }

}
