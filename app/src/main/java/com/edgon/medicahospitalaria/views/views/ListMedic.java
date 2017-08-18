package com.edgon.medicahospitalaria.views.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.adapter.MedicAdapter;
import com.edgon.medicahospitalaria.api.ServiceGenerator;
import com.edgon.medicahospitalaria.api.ServicesInterface;
import com.edgon.medicahospitalaria.model.MedicModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListMedic extends AppCompatActivity {

    private List<MedicModel> medicModelList = new ArrayList<>();
    private MedicModel medicModel;
    private RecyclerView recyclerViewMedic;
    private MedicAdapter medicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_medic);
        showToolBar("Medicos",true);
        loadSingleton();
    }

    private void inicializarAdapter(List<MedicModel> list) {
        recyclerViewMedic = (RecyclerView) findViewById(R.id.recycler_list_medic);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMedic.setLayoutManager(linearLayoutManager);
        medicAdapter = new MedicAdapter(list);
        recyclerViewMedic.setAdapter(medicAdapter);
    }

    private void loadSingleton() {
        ServicesInterface servicesInterface =
                ServiceGenerator.createService();

        servicesInterface.loadDataMedic().enqueue(new Callback<List<MedicModel>>() {
            @Override
            public void onResponse(Call<List<MedicModel>> call, Response<List<MedicModel>> response) {
                inicializarAdapter(response.body());
                Log.e("Mylog", response.body() + "");
            }

            @Override
            public void onFailure(Call<List<MedicModel>> call, Throwable t) {
                Log.e("MyLog", "Error" + t);
            }
        });
    }

    private void showToolBar(String title, boolean upButton) {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
