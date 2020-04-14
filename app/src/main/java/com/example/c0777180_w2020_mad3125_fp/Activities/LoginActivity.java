package com.example.c0777180_w2020_mad3125_fp.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    public static final String PREFS_NAME = "MyPrefsFile";
    private static final String PREF_USERNAME = "username";
    private static final String PREF_PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = sharedPreferences.edit();

        String email = sharedPreferences.getString(PREF_USERNAME, null);
        String password = sharedPreferences.getString(PREF_PASSWORD, null);
        txtLogin.setText(email);
        txtPassword.setText(password);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUser()) {

                    if (chkRemember.isChecked()){
                        editor.putString(PREF_USERNAME,txtLogin.getText().toString());
                        editor.putString(PREF_PASSWORD,txtPassword.getText().toString());
                        editor.apply();
                    }

                    else{
                        editor.putString(PREF_USERNAME,"");
                        editor.putString(PREF_PASSWORD,"");
                        editor.apply();
                    }
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
