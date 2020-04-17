package com.example.c0777180_w2020_mad3125_fp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MobileFragment extends Fragment {

    private TextView kumar;
    private EditText mohit;
    private Button btnme;

    View view;
    public MobileFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.mobile_fragment,container,false);

        kumar = view.findViewById(R.id.kumar);
        mohit = view.findViewById(R.id.mohit);
        btnme = view.findViewById(R.id.btnme);

        btnme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kumar.setText(mohit.getText().toString());
            }
        });

        return view;
    }
}
