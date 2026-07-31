package vn.devpro.image_view;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton backBtn;
    ImageButton nextBtn;
    TextView textCount;

    int currentIndex = 0;

    int[] images = {R.drawable.img, R.drawable.img_1, R.drawable.img_2};

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

        imageView = findViewById(R.id.imageView);
        backBtn = findViewById(R.id.backBtn);
        nextBtn = findViewById(R.id.nextBtn);
        textCount = findViewById(R.id.textCount);

        updateUI();

        backBtn.setOnClickListener(v -> {
            currentIndex--;
            updateUI();
        });

        nextBtn.setOnClickListener(v -> {
            currentIndex++;
            updateUI();
        });
    }

    private void updateUI() {
        imageView.setImageResource(images[currentIndex]);

        textCount.setText((currentIndex + 1) + " / " + images.length);

        if (currentIndex == 0) {
            backBtn.setVisibility(View.INVISIBLE);
        } else {
            backBtn.setVisibility(View.VISIBLE);
        }

        if (currentIndex == (images.length - 1)) {
            nextBtn.setVisibility(View.INVISIBLE);
        } else {
            nextBtn.setVisibility(View.VISIBLE);
        }

    }
}