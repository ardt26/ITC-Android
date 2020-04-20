package com.example.itc_4_itccafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTambahMakanan, btnKurangMakanan, btnTambahMinuman, btnKurangMinuman, btnReset, btnBuy;
    TextView tvJumlahMakanan, tvJumlahMinuman, tvHarga, tvPurchased;

    int JumlahMakanan = 0, JumlahMinuman = 0;
    final int HargaMakanan = 15000, HargaMinuman = 32000;
    int TotalHarga = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahMakanan = findViewById(R.id.btn_tambahMakanan);
        btnKurangMakanan = findViewById(R.id.btn_kurangMakanan);
        btnTambahMinuman = findViewById(R.id.btn_tambahMinuman);
        btnKurangMinuman = findViewById(R.id.btn_kurangMinuman);
        btnReset = findViewById(R.id.btn_reset);
        btnBuy = findViewById(R.id.btn_buy);

        tvJumlahMakanan = findViewById(R.id.tv_jumlahMakanan);
        tvJumlahMinuman = findViewById(R.id.tv_jumlahMinuman);
        tvHarga = findViewById(R.id.tv_harga);
        tvPurchased = findViewById(R.id.tv_purchased);

        tvPurchased.setText("");

        btnTambahMakanan.setOnClickListener(this);
        btnTambahMinuman.setOnClickListener(this);
        btnKurangMakanan.setOnClickListener(this);
        btnKurangMinuman.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahMakanan:
                TambahMenu(R.id.btn_tambahMakanan);
                break;
            case R.id.btn_kurangMakanan:
                KurangMenu(R.id.btn_kurangMakanan);
                break;
            case R.id.btn_tambahMinuman:
                TambahMenu(R.id.btn_tambahMinuman);
                break;
            case R.id.btn_kurangMinuman:
                KurangMenu(R.id.btn_kurangMinuman);
                break;
            case R.id.btn_buy:
                tvPurchased.setText("Purchased");
                break;
            case R.id.btn_reset:
                Reset();
                break;
        }
    }

    void TambahMenu(int asal){
        if (asal == R.id.btn_tambahMakanan){
            if (JumlahMakanan < 10){
                JumlahMakanan++;
                TotalHarga += HargaMakanan;
                tvJumlahMakanan.setText(""+JumlahMakanan);
                tvHarga.setText("Rp "+TotalHarga);
                tvPurchased.setText("");
            }
        } else if (asal == R.id.btn_tambahMinuman){
            if (JumlahMinuman < 10){
                JumlahMinuman++;
                TotalHarga += HargaMinuman;
                tvJumlahMinuman.setText(""+JumlahMinuman);
                tvHarga.setText("Rp "+TotalHarga);
                tvPurchased.setText("");
            }
        }
    }

    void KurangMenu(int asal){
        if (asal == R.id.btn_kurangMakanan){
            if (JumlahMakanan > 0){
                JumlahMakanan--;
                TotalHarga -= HargaMakanan;
                tvJumlahMakanan.setText(""+JumlahMakanan);
                tvHarga.setText("Rp "+TotalHarga);
                tvPurchased.setText("");
            }
        } else if (asal == R.id.btn_kurangMinuman){
            if (JumlahMinuman > 0){
                JumlahMinuman--;
                TotalHarga -= HargaMinuman;
                tvJumlahMinuman.setText(""+JumlahMinuman);
                tvHarga.setText("Rp "+TotalHarga);
                tvPurchased.setText("");
            }
        }

    }

    void Reset(){
        JumlahMinuman = 0;
        JumlahMakanan = 0;
        TotalHarga = 0;
        tvJumlahMakanan.setText("0");
        tvJumlahMinuman.setText("0");
        tvHarga.setText("Rp 0");
        tvPurchased.setText("");
    }
}
