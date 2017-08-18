package com.edgon.medicahospitalaria.login.patient;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.api.ServiceGenerator;
import com.edgon.medicahospitalaria.api.ServicesInterface;
import com.edgon.medicahospitalaria.model.MedicModel;
import com.edgon.medicahospitalaria.model.PatientModel;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CreateAcountActivity extends AppCompatActivity {


    @BindView(R.id.textImputProfesionalId)
    TextInputLayout textInputLayoutProfessionalID;
    @BindView(R.id.text_input_profesion)
    TextInputLayout textInputLayoutProfesion;
    @BindView(R.id.text_input_address)
    TextInputLayout textInputLayoutAddress;
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
    @BindView(R.id.spinner)
    Spinner spinner;
    @BindView(R.id.edt_profesional_id)
    TextInputEditText edtProfesionalId;
    @BindView(R.id.edt_address)
    TextInputEditText edtAddress;
    @BindView(R.id.edt_gender)
    TextInputEditText edtGender;
    @BindView(R.id.edt_last_name)
    TextInputEditText edtLastName;
    @BindView(R.id.textImputApellido)
    TextInputLayout textImputApellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acount);
        ButterKnife.bind(this);

        // loadDataSingleton();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                switch (position) {
                    case 0:
                        textInputLayoutProfessionalID.setVisibility(View.GONE);
                        textInputLayoutProfesion.setVisibility(View.GONE);
                        textInputLayoutAddress.setVisibility(View.GONE);
                        textImputApellido.setVisibility(View.GONE);

                        btnJoinUsCrateAcount.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.e("MyLog", "Click patient");
                                String name = edtName.getText().toString();
                                String email = edtEmail.getText().toString();
                                String pass1 = edtPassword.getText().toString();
                                String pass2 = edtConfirmPassword.getText().toString();

                                if (!pass1.equals(pass2)) {
                                    Toast.makeText(CreateAcountActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                                } else {
                                    createAccountPatient(email, name, pass1);
                                    finish();
                                }

                            }
                        });
                        break;
                    case 1:
                        textInputLayoutProfessionalID.setVisibility(View.VISIBLE);
                        textInputLayoutProfesion.setVisibility(View.VISIBLE);
                        textInputLayoutAddress.setVisibility(View.VISIBLE);
                        textImputApellido.setVisibility(View.VISIBLE);

                        btnJoinUsCrateAcount.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.e("MyLog", "Click Medic");
                                createAccountMedic();
                                finish();
                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void createAccountMedic() {
        ServicesInterface servicesInterface =
                ServiceGenerator.createService();

        MedicModel medicModel = new MedicModel();
        medicModel.setName(edtName.getText().toString());
        medicModel.setLastName(edtLastName.getText().toString());
        medicModel.setEmail(edtEmail.getText().toString());
        medicModel.setPhone("234565");
        medicModel.setGender(edtGender.getText().toString());
        medicModel.setAge(23);
        medicModel.setProfessionalId(edtProfesionalId.getText().toString());


        medicModel.setPassword(edtPassword.getText().toString());

        servicesInterface.sendDataMedic(medicModel).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("MyLog medic-->", response.code() + "");
                try {
                    Log.e("MyLog medic <-->", response.body().string() + "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MyLog","Error -- "+t);
            }
        });
    }

    private void createAccountPatient(String email, String name, String password) {

       /* String email = edtEmail.getText().toString();
        String name = edtName.getText().toString();
        String pass1 = edtPassword.getText().toString();
        String pass2 = edtConfirmPassword.getText().toString();

        if (pass1 == pass2){
            String password = pass1;
        }else{

        }*/

        ServicesInterface servicesInterface =
                ServiceGenerator.createService();

        PatientModel patientModel = new PatientModel();
        patientModel.setName(name);
        patientModel.setEmail(email);
        patientModel.setPassword(password);
        patientModel.setLastName("--");
        patientModel.setAdress("Ciudad de Mexico");
        patientModel.setAge(45);
        patientModel.setPhone("5551751789");
        patientModel.setGender("Mujer");
        patientModel.setPostalCode("98475");


        Log.e("MyLogObject", patientModel.toString());

        servicesInterface.sendDataPatient(patientModel).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                Log.e("MyLog-->", response.code() + "");
                try {
                    Log.e("MyLog <-->", response.body().string() + "");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MyLog", "Error: " + t);
            }
        });
    }
}
