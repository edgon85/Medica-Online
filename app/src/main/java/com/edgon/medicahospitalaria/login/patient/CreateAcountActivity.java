package com.edgon.medicahospitalaria.login.patient;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.api.ServiceGenerator;
import com.edgon.medicahospitalaria.api.ServicesInterface;
import com.edgon.medicahospitalaria.model.PatientModel;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAcountActivity extends AppCompatActivity {


    @BindView(R.id.btn_join_us_crate_acount)
    Button btnJoinUsCrateAcount;
    @BindView(R.id.edt_email_create_acount)
    TextInputEditText edtEmail;
    @BindView(R.id.name)
    TextInputEditText edtName;
    @BindView(R.id.edt_password_create_acount)
    TextInputEditText edtPassword;
    @BindView(R.id.edt_confirm_password_create_acount)
    TextInputEditText edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acount);
        ButterKnife.bind(this);

       // loadDataSingleton();

    }

    private void loadDataSingleton(){
      /*  ServicesInterface servicesInterface = ServiceGenerator.createService();

        servicesInterface.loadData().enqueue(new Callback<PatientModel>() {
            @Override
            public void onResponse(Call<PatientModel> call, Response<PatientModel> response) {
                Log.e("MyLog",response.body().getName());
            }

            @Override
            public void onFailure(Call<PatientModel> call, Throwable t) {

            }
        });*/
    }

    @OnClick(R.id.btn_join_us_crate_acount)
    public void onViewClicked() {

        ServicesInterface servicesInterface =
                ServiceGenerator.createService();

        PatientModel patientModel = new PatientModel();
        patientModel.setName("Jorge");
        patientModel.setLastName("Lopez");
        patientModel.setGender("H");
        patientModel.setAge(30);
        patientModel.setPhone("55123324");
        patientModel.setAdress("Estado de Mexico");
        patientModel.setPostalCode(3928);
        patientModel.setEmail("yorch@mail.com");
        patientModel.setPassword2("123456");
        patientModel.setPassword1("123456");

        Log.e("MyLogObject",patientModel.toString());

        servicesInterface.sendData(patientModel).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("MyLog-->",response.code()+"");
                try {
                    Log.e("MyLog <-->",response.body().string()+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MyLog","Error: " + t);
            }
        });
    }
}
