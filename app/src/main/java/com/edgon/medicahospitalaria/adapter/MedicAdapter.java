package com.edgon.medicahospitalaria.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edgon.medicahospitalaria.R;
import com.edgon.medicahospitalaria.model.MedicModel;
import com.edgon.medicahospitalaria.views.views.DetailMedic;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MedicAdapter extends
        RecyclerView.Adapter<MedicAdapter.PatientViewHolder> {


    List<MedicModel> medicList = new ArrayList<>();

    public MedicAdapter(List<MedicModel> medicModelsModelList) {
        this.medicList = medicModelsModelList;
    }

    @Override
    public PatientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_detail_medic, parent, false);

        return new PatientViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PatientViewHolder holder, int position) {
        MedicModel medicModel = medicList.get(position);
//        holder.txtNameCardview.setText(medicModel.getName());



        if (medicModel.getGender().equals("Hombre")){
            holder.txtNameCardview.setText("Dr. "+medicModel.getName());
            Picasso.with(holder.context)
                    .load(R.drawable.doctor)
                    .into(holder.imgPhoto);
        }else {
            holder.txtNameCardview.setText("Dra. "+medicModel.getName());
            Picasso.with(holder.context)
                    .load(R.drawable.doctora)
                    .into(holder.imgPhoto);
        }
        holder.txtPhoneCardview.setText(medicModel.getPhone());

    }

    @Override
    public int getItemCount() {
        return medicList.size();
    }

    public class PatientViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.image)
        ImageView imgPhoto;
        @BindView(R.id.txt_name_cardview)
        TextView txtNameCardview;
        @BindView(R.id.txt_phone_cardview)
        TextView txtPhoneCardview;
        @BindView(R.id.card_view)
        CardView cardView;

        Context context;

        public PatientViewHolder(View itemView) {
            super(itemView);
            context = itemView.getContext();
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            MedicModel medicModel = medicList.get(position);
            Intent intent = new Intent(context, DetailMedic.class);
            intent.putExtra("name",medicModel.getName());
            intent.putExtra("lastName",medicModel.getLastName());
            intent.putExtra("lastName",medicModel.getLastName());
            intent.putExtra("lastName",medicModel.getLastName());
            intent.putExtra("lastName",medicModel.getLastName());
            intent.putExtra("lastName",medicModel.getLastName());
            context.startActivity(intent);

        }
    }
}
