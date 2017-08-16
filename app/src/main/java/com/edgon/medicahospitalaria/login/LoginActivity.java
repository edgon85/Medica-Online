package com.edgon.medicahospitalaria.login;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.edgon.medicahospitalaria.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.logo)
    ImageView imgLogo;
    @BindView(R.id.username)
    TextInputEditText edtUsername;
    @BindView(R.id.password)
    TextInputEditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.txt_create_acount)
    TextView txtCreateAcount;
    @BindView(R.id.progeressbar_login)
    ProgressBar progeressbarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.txt_create_acount)
    public void onViewClicked() {
    }
}
