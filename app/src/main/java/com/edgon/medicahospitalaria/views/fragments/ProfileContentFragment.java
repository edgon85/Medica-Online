package com.edgon.medicahospitalaria.views.fragments;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.api.ServiceGenerator;
import com.edgon.medicahospitalaria.api.ServicesInterface;
import com.edgon.medicahospitalaria.login.patient.CreateAcountActivity;
import com.edgon.medicahospitalaria.model.PatientModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileContentFragment extends Fragment {

    @BindView(R.id.username)
    TextInputEditText txtUsername;
    @BindView(R.id.password)
    TextInputEditText txtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.progeressbar_login)
    ProgressBar progeressbarLogin;
    Unbinder unbinder;
    private TextView txtCreateAcount;

   // PatientModel patientModel;

    public ProfileContentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_profile, container, false);

        txtCreateAcount = (TextView) view.findViewById(R.id.txt_create_acount);

        txtCreateAcount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CreateAcountActivity.class);
                getActivity().startActivity(intent);
            }
        });

        unbinder = ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        loginUser();
    }

    private void loginUser() {
        final String user = txtUsername.getText().toString();
        final String pass = txtPassword.getText().toString();
        String email;

        ServicesInterface servicesInterface = ServiceGenerator.createService();
        servicesInterface.loadDataPatient().enqueue(new Callback<List<PatientModel>>() {
            @Override
            public void onResponse(Call<List<PatientModel>> call, Response<List<PatientModel>> response) {
                Log.e("MyLog", response.body().toString());

                List<PatientModel> modelList = response.body();

                for (int i = 0; i < modelList.size(); i++) {
                   // Log.e("MyLog", modelList.get(i).getEmail() + "");


                    if (modelList.get(i).getEmail().equals(user) && modelList.get(i).getPassword().equals(pass)) {
                        Toast.makeText(getContext(), "Usuario logeado", Toast.LENGTH_SHORT).show();

                        ProfileFragment profileFragment = new ProfileFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.container,profileFragment)
                                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                                .addToBackStack(null)
                                .commit();

                        SharedPreferences preferences = getActivity().getPreferences(getContext().MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putInt("id",modelList.get(i).getId());
                        editor.commit();
                        break;

                        //Toast.makeText(getContext(), "Usuario logeado", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getContext(), "Usuario o contraseña incorrecoto", Toast.LENGTH_SHORT).show();
                    }






                    Log.e("MyLog__>", user);
                    Log.e("MyLog__>", pass);
                    Log.e("MyLog__>", modelList.get(i).getEmail());
                    Log.e("MyLog__>", modelList.get(i).getPassword());
                }
            }

            @Override
            public void onFailure(Call<List<PatientModel>> call, Throwable t) {

            }
        });
    }
}
