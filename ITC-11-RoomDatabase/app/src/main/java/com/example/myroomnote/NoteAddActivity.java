package com.example.myroomnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myroomnote.database.NoteDao;
import com.example.myroomnote.database.NoteDatabase;
import com.example.myroomnote.model.Note;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class NoteAddActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_ADD = 100;
    public static final int RESULT_ADD = 110;
    public static final int ALERT_DIALOG_CLOSE = 10;
    public static final String EXTRA_ADD = "EXTRA_ADD";
    EditText etTitle, etText;
    Button btnAdd;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_add);

        noteDao = NoteDatabase.getInstance(this).noteDao();

        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        btnAdd = findViewById(R.id.btn_add);
        btnAdd.setOnClickListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Add Data");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            showDialogMessage();
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                String sTitle = etTitle.getText().toString();
                String sText = etText.getText().toString();
                String sDate = getCurrentDate();

                Note note = new Note(sTitle, sText, sDate);
                noteDao.insertData(note);

//                Intent intent = new Intent();
//                intent.putExtra(EXTRA_ADD,note);
                setResult(RESULT_ADD); // setResult(RESULT_ADD, intent);
                finish();
                break;
        }
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void showDialogMessage() {
        String sTitle;
        String sMessage;

        sTitle = "Batal";
        sMessage = "Apakah anda ingin membatalkan penambahan note?";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(sTitle)
                .setMessage(sMessage)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    finish();

                })
                .setNegativeButton(android.R.string.no, (dialog, which) -> {
                    dialog.cancel();
                })
                .create()
                .show();
    }

    @Override
    public void onBackPressed() {
        showDialogMessage();
    }
}