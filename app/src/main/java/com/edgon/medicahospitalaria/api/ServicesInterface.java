package com.edgon.medicahospitalaria.api;

import com.edgon.medicahospitalaria.constants.Constants;
import com.edgon.medicahospitalaria.model.MedicModel;
import com.edgon.medicahospitalaria.model.PatientModel;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by gonza on 8/15/2017.
 */

public interface ServicesInterface {


    @GET(Constants.URI_PATIENT)
    Call<List<PatientModel>> loadDataPatient();

    @POST(Constants.URI_PATIENT)
    Call<ResponseBody> sendDataPatient(@Body PatientModel patientModel);

    @GET(Constants.URI_MEDIC)
    Call<List<MedicModel>> loadDataMedic();

    @POST(Constants.URI_MEDIC)
    Call<ResponseBody> sendDataMedic(@Body MedicModel medicModel);

}
