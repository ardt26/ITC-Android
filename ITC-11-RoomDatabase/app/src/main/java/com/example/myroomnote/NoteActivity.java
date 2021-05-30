package com.example.myroomnote;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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

public class NoteActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_NOTE = "EXTRA_NOTE";
    public static final int REQUEST_EDIT = 200;
    public static final int RESULT_EDIT = 210;
    public static final int RESULT_DELETE = 220;
    public static final int ALERT_DIALOG_CLOSE = 10;
    public static final int ALERT_DIALOG_DELETE = 20;

    EditText etTitle, etText;
    Button btnSave;

    private Note note;
    private NoteDao noteDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        note = getIntent().getParcelableExtra(EXTRA_NOTE);
        noteDao = NoteDatabase.getInstance(this).noteDao();

        etTitle = findViewById(R.id.et_title);
        etText = findViewById(R.id.et_text);
        btnSave = findViewById(R.id.btn_save);
        btnSave.setOnClickListener(this);

        etTitle.setText(note.getTitle());
        etText.setText(note.getText());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit Data");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_save:
                String sTitle = etTitle.getText().toString();
                String sText = etText.getText().toString();
                String sDate = getCurrentDate();

                Note updateNote = new Note(note.getId(), sTitle, sText, sDate);
                noteDao.updateData(updateNote);

                setResult(RESULT_EDIT);
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_delete) {
            showDialogMessage(ALERT_DIALOG_DELETE);
        } else if (item.getItemId() == android.R.id.home) {
            showDialogMessage(ALERT_DIALOG_CLOSE);
        }
        return super.onOptionsItemSelected(item);
    }

    private String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }

    private void showDialogMessage(int type) {
        String sTitle;
        String sMessage;
        boolean isDialogClose = (type == ALERT_DIALOG_CLOSE);

        if (isDialogClose) {
            sTitle = "Batal";
            sMessage = "Apakah anda ingin membatalkan perubahan pada form?";
        } else {
            sTitle = "Hapus";
            sMessage = "Apakah anda yakin ingin menghapus node?";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle(sTitle)
                .setMessage(sMessage)
                .setCancelable(false)
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    if (isDialogClose) {
                        finish();
                    } else {
                        noteDao.deleteData(note);
                        setResult(RESULT_DELETE);
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, (dialog, which) -> {
                    dialog.cancel();
                })
                .create()
                .show();
    }

    @Override
    public void onBackPressed() {
        showDialogMessage(ALERT_DIALOG_CLOSE);
    }
}