package com.example.playstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    //private ImageView profile;
    private ArrayList<Playstore> playstore = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //profile = findViewById(R.id.iv_profile);

        recyclerView = findViewById(R.id.rv_recyclerview);
        recyclerView.setHasFixedSize(true);

        playstore.addAll(PlaystoreData.getListData());
        showRecyclerView();

//        profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveIntent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(moveIntent);
//            }
//        });
    }

    private void showRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PlaystoreAdapter listHeroAdapter = new PlaystoreAdapter(playstore,this);
        recyclerView.setAdapter(listHeroAdapter);
    }
}
