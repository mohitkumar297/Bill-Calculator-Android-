package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);
        


        if (validateUser()){
            Intent intent = new Intent(LoginActivity.this,CustomerListActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginActivity.this,"Access Denied",Toast.LENGTH_SHORT).show();
        }
    }

    public boolean validateUser(){
        if ((txtLogin.getText().toString() == "admin@gmail.com") && (txtPassword.getText().toString() == "admin123"))  {
            return true;
        }
        else {return false;}
    }
}
