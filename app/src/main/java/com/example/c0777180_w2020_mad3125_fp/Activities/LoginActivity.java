package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.c0777180_w2020_mad3125_fp.R;
import com.google.android.material.textfield.TextInputEditText;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class LoginActivity extends AppCompatActivity {

    @InjectView(R.id.txtLogin)
    TextInputEditText txtLogin;
    @InjectView(R.id.txtPassword)
    TextInputEditText txtPassword;
    @InjectView(R.id.btnLogin)
    Button btnLogin;
    @InjectView(R.id.chkRemember)
    CheckBox chkRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUser()) {
                    Intent intent = new Intent(LoginActivity.this, CustomerListActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid User Id or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public boolean validateUser() {
        if ((txtLogin.getText().toString().equals("admin@gmail.com")) && (txtPassword.getText().toString().equals("admin123"))) {
            return true;
        } else {
            return false;
        }
    }
}
