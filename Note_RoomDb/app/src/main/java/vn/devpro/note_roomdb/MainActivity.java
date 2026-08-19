package vn.devpro.note_roomdb;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import vn.devpro.note_roomdb.room.AppDatabase;
import vn.devpro.note_roomdb.room.Note;
import vn.devpro.note_roomdb.room.NoteDao;

public class MainActivity extends AppCompatActivity {

    private ActivityResultLauncher<Intent> launcher;

    private AppDatabase db;
    private NoteDao noteDao;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    RecyclerView recyclerView;
    ImageButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnAdd = findViewById(R.id.btnAdd);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        NoteAdapter adapter = new NoteAdapter(note -> {
            Intent intent = new Intent(this, DetailActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("ID", note.getId());
            bundle.putString("TITLE", note.getTitle());
            bundle.putString("CONTENT", note.getContent());
            intent.putExtras(bundle);

            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);

        // Room
        db = AppDatabase.getInstance(this);
        noteDao = db.noteDao();

        executor.execute(() -> {

            long currentTime = System.currentTimeMillis();
            noteDao.insert(new Note("Ghi chú 1", "Nội dung ghi chú đầu tiên", currentTime));
            noteDao.insert(new Note("Our Father", "Our Father, who art in heaven, hallowed be thy name; thy kingdom come; thy will be done on earth as it is in heaven. Give us this day our daily bread; and forgive us our trespasses as we forgive those who trespass against us; and lead us not into temptation, but deliver us from evil. Amen.", currentTime + 2000));
            noteDao.insert(new Note("Đoạn văn diễn dịch", " Lão Hạc là một nhân vật có số phận vô cùng bất hạnh. Ông sớm mất vợ, người con trai duy nhất vì phẫn chí mà phải bỏ đi đồn điền cao su. Sống cô độc tuổi già, đến con chó vàng - người bạn duy nhất - ông cũng đành phải bán đi trong đau đớn. Cuối cùng, lão chọn cái chết dữ dội để bảo toàn mảnh vườn cho con.", currentTime + 3000));
            noteDao.insert(new Note("Ghi chú 2", "Nội dung ghi chú thứ hai", currentTime + 1000));
            noteDao.insert(new Note("Đoạn văn quy nạp", "Viên quản ngục sống giữa chốn ngục tù tăm tối nhưng vẫn giữ được tâm hồn yêu cái đẹp. Ông hết lòng trân trọng tài năng của Huấn Cao và bất chấp hiểm nguy để đối xử tử tế với người tử tù. Những hành động ấy chứng minh ông là một bông hoa mọc lên từ bùn nhơ, giữ trọn nhân cách thanh cao.", currentTime + 3000));
        });


        noteDao.getAllNotes().observe(this, note -> {
            adapter.setNotes(note);
        });

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("INSERT_ACTION", true);
            startActivity(intent);
        });

    }
}