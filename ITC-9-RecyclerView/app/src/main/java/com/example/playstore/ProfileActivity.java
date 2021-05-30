package com.example.playstore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivBack, ivGithub, ivFacebook, ivTwitter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivBack = findViewById(R.id.iv_back);
        ivGithub = findViewById(R.id.iv_instagram);
        ivFacebook = findViewById(R.id.iv_github);
        ivTwitter = findViewById(R.id.iv_twitter);

        ivBack.setOnClickListener(this);
        ivGithub.setOnClickListener(this);
        ivFacebook.setOnClickListener(this);
        ivTwitter.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent moveIntent = new Intent(ProfileActivity.this, MainActivity.class);
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        switch (v.getId())
        {
            case R.id.iv_back:
                startActivity(moveIntent);
                finish();
                break;
            case R.id.iv_instagram:
                intent.putExtra(SearchManager.QUERY, "https://www.instagram.com/args06/");
                startActivity(intent);
                break;
            case R.id.iv_github:
                intent.putExtra(SearchManager.QUERY, "https://github.com/ardt26/");
                startActivity(intent);
                break;
            case R.id.iv_twitter:
                intent.putExtra(SearchManager.QUERY, "https://twitter.com/args06");
                startActivity(intent);
                break;
        }
    }
}
