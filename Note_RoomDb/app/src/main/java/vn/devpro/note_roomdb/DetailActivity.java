package vn.devpro.note_roomdb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import vn.devpro.note_roomdb.room.AppDatabase;
import vn.devpro.note_roomdb.room.Note;
import vn.devpro.note_roomdb.room.NoteDao;

public class DetailActivity extends AppCompatActivity {
    EditText edtTitle, edtContent;
    ImageButton btnBack, btnDelete, btnSave;

    private AppDatabase db;
    private NoteDao noteDao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        db = AppDatabase.getInstance(this);
        noteDao = db.noteDao();

        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);
        btnBack = findViewById(R.id.btnBack);
        btnDelete = findViewById(R.id.btnDelete);
        btnSave = findViewById(R.id.btnSave);

        // receive data
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int id = bundle.getInt("ID", 0);
        String title = bundle.getString("TITLE", "");
        String content = bundle.getString("CONTENT", "");

        edtTitle.setText(title);
        edtContent.setText(content);

        // Room
        boolean isInsertAction = intent.getBooleanExtra("INSERT_ACTION", false);
        if (isInsertAction) {
            btnDelete.setVisibility(View.INVISIBLE);
        } else {
            btnDelete.setVisibility(View.VISIBLE);
        }

        btnSave.setOnClickListener(v -> {
            if (isInsertAction) {
                String noteTitle = edtTitle.getText().toString();
                String noteContent = edtContent.getText().toString();
                long currentTime = System.currentTimeMillis();

                executor.execute(() -> {
                    Note note = new Note(noteTitle, noteContent,  currentTime);

                    noteDao.insert(note);

                });

            } else {
                String noteTitle = edtTitle.getText().toString();
                String noteContent = edtContent.getText().toString();

                executor.execute(() -> {
                    Note note = noteDao.getNoteById(id);

                    note.setTitle(noteTitle);
                    note.setContent(noteContent);

                    noteDao.update(note);
                });
            }

            finish();

        });

        btnBack.setOnClickListener(v -> {
           finish();
        });

        btnDelete.setOnClickListener(v -> {
            executor.execute(() -> {
                noteDao.deleteNoteById(id);

                finish();
            });
        });
    }
}