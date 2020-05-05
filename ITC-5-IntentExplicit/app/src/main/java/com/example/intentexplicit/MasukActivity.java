package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MasukActivity extends AppCompatActivity {

    final static String EXTRA_USER = "extra_user";
    final static String EXTRA_PARCEL = "extra_parcel";

    TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        String username = getIntent().getStringExtra(EXTRA_USER);
        Data data = getIntent().getParcelableExtra(EXTRA_PARCEL);
        tvUsername = findViewById(R.id.tv_username);
        tvUsername.setText("Hello, " + username +
                "\n Nama Saya : " + data.getName() +
                "\n NIM Saya : " + data.getNIM());



    }
}