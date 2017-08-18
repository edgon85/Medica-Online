package com.edgon.medicahospitalaria.views.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.edgon.medicahospitalaria.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMedic extends AppCompatActivity {

    @BindView(R.id.txt_name_doctor_detail)
    TextView txtNameDoctorDetail;
    @BindView(R.id.btn_cita)
    Button btnCita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_medic);
        ButterKnife.bind(this);

        String name = getIntent().getStringExtra("name");
        String lastName = getIntent().getStringExtra("lastName");
        txtNameDoctorDetail.setText("Dr. " + name + " " + lastName);
        
        btnCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DetailMedic.this, "Cita creada", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
