package vn.devpro.pinterest_demo;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {
    ImageView userImage, userAvatar;
    TextView userName;
    RadioButton favoriteBtn, saveBtn;

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

        int image = getIntent().getIntExtra("IMAGE", R.drawable.error);
        int avatar = getIntent().getIntExtra("AVATAR", R.drawable.error);
        String name = getIntent().getStringExtra("NAME");
        boolean isFavorite = getIntent().getBooleanExtra("IS_FAVORITE", false);
        boolean isSaved = getIntent().getBooleanExtra("IS_SAVED", false);

        userImage = findViewById(R.id.image);
        userAvatar = findViewById(R.id.avatar);
        userName = findViewById(R.id.name);
        favoriteBtn = findViewById(R.id.favoriteBtn);
        saveBtn = findViewById(R.id.saveBtn);

        userImage.setImageResource(image);
        userAvatar.setImageResource(avatar);
        userName.setText(name);
        favoriteBtn.setChecked(isFavorite);
        saveBtn.setChecked(isSaved);
    }
}