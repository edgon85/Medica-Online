package com.edgon.medicahospitalaria.api;

import com.edgon.medicahospitalaria.constants.Constants;
import com.edgon.medicahospitalaria.model.PatientModel;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by gonza on 8/15/2017.
 */

public interface ServicesInterface {


    //@GET(Constants.URI)
    //Call<PatientModel> loadData();

    @POST(Constants.URI)
    Call<ResponseBody> sendData(@Body PatientModel patientModel);

}
