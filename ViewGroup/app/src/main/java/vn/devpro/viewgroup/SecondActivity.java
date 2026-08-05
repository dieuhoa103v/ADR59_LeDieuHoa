package vn.devpro.viewgroup;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.viewgroup.adapters.UserAdapterRCV;
import vn.devpro.viewgroup.models.User;

public class SecondActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycleView);

        configRecycleView();
    }

    private void configRecycleView() {
        List<User> users = new ArrayList<>();
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));

        UserAdapterRCV adapter = new UserAdapterRCV(users);
        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(
//                this, LinearLayoutManager.HORIZONTAL, false));

        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}