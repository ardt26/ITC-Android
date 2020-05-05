package com.example.intentexplicit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    public EditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        // Pake ini biar gampang dan bisa pake banyak button
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_login:
                login();
                break;
        }
    }

    private void login() {
        String password = etPassword.getText().toString();
        String username = etUsername.getText().toString();

        Data data = new Data();
        data.setName("Anjar");
        data.setNIM("123180056");

        // Buat munculin tanda error dan biar ga kosong
        if (TextUtils.isEmpty(password))
        {
            etPassword.setError("Password tidak boleh kosong");
        }

        if (password.equals("admin")){
            Intent intent = new Intent(getApplicationContext(), MasukActivity.class);
            intent.putExtra(MasukActivity.EXTRA_USER,username);
            intent.putExtra(MasukActivity.EXTRA_PARCEL,data);
            startActivity(intent);
        }
        else {
            Toast.makeText(getApplicationContext(), "SALAH WOY!!!", Toast.LENGTH_LONG).show();
        }
    }
}