package com.edgon.medicahospitalaria.api;


import com.edgon.medicahospitalaria.constants.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.URL_BASE);

    public static ServicesInterface createService(){
        if (retrofit == null) {
            retrofit = builder.build();
        }
        return retrofit.create(ServicesInterface.class);
    }
}
