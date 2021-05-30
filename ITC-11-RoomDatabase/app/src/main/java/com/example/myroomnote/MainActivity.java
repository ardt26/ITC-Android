package com.example.myroomnote;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myroomnote.adapter.NoteAdapter;
import com.example.myroomnote.database.NoteDao;
import com.example.myroomnote.database.NoteDatabase;
import com.example.myroomnote.model.Note;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fabAdd;
    private RecyclerView rvNotes;
    private NoteDao noteDao;
    private final ArrayList<Note> listNotes = new ArrayList<>();
    private final NoteAdapter noteAdapter = new NoteAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteDao = NoteDatabase.getInstance(this).noteDao();

        fabAdd = findViewById(R.id.fab_add);

        rvNotes = findViewById(R.id.rv_notes);
        rvNotes.setHasFixedSize(true);
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        rvNotes.setAdapter(noteAdapter);
        loadData();

        fabAdd.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab_add:
                Intent intent = new Intent(this, NoteAddActivity.class);
                startActivityForResult(intent, NoteAddActivity.REQUEST_ADD);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NoteAddActivity.REQUEST_ADD) {
            if (resultCode == NoteAddActivity.RESULT_ADD) {
                loadData();
                showSnackBar("Data Berhasil Ditambahkan");
            }
        } else if (requestCode == NoteActivity.REQUEST_EDIT){
            if (resultCode == NoteActivity.RESULT_EDIT) {
                loadData();
                showSnackBar("Data Berhasil Diedit");
            } else if (resultCode == NoteActivity.RESULT_DELETE){
                loadData();
                showSnackBar("Data Berhasil Dihapus");
            }
        }
    }

    void loadData() {
        List<Note> data = noteDao.getAllData();
        listNotes.clear();
        listNotes.addAll(data);
        noteAdapter.setListNotes(listNotes);
        if (data.size() == 0){
            showSnackBar("Data Kosong");
        }
    }

    private void showSnackBar(String message){
        Snackbar.make(rvNotes, message, Snackbar.LENGTH_INDEFINITE).show();
    }
}