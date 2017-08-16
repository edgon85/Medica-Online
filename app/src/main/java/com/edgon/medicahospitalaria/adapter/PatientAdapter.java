package com.edgon.medicahospitalaria.adapter;


import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.model.PatientModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PatientAdapter extends
        RecyclerView.Adapter<PatientAdapter.PatientViewHolder>{


    List<PatientModel> patientModelList = new ArrayList<>();

    public PatientAdapter(List<PatientModel> patientModelList) {
        this.patientModelList = patientModelList;
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_profile,parent,false);

        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        PatientModel patient = patientModelList.get(position);
        holder.edtName.getText();
    }

    @Override
    public int getItemCount() {
        return patientModelList.size();
    }

    public class PatientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.edt_email_create_acount)
        TextInputEditText edtEmail;
        @BindView(R.id.name)
        TextInputEditText edtName;
        @BindView(R.id.edt_password_create_acount)
        TextInputEditText edtPassword;
        @BindView(R.id.edt_confirm_password_create_acount)
        TextInputEditText edtConfirmPassword;
        Context context;


        public PatientViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
