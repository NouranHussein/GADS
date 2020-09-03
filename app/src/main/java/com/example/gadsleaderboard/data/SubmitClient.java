package com.example.gadsleaderboard.data;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SubmitClient {

    private static final String  baseURL="https://docs.google.com/forms/d/e/";
private static SubmitClient INSTANCE;
private  submit_api api;
public SubmitClient(){
   Retrofit retrofit=new Retrofit.Builder().baseUrl(baseURL).
    addConverterFactory(GsonConverterFactory.create()).build();
   api=retrofit.create(submit_api.class);

}
    public synchronized static SubmitClient getINSTANCE() {
        if(INSTANCE==null){
            INSTANCE=new SubmitClient();
        }
        return INSTANCE;
    }
    public Call<ResponseBody> getResponse(String firstName, String secondName, String email,String link){
    return api.RESPONSE_BODY_CALL(firstName,secondName,email,link);
    }
}
