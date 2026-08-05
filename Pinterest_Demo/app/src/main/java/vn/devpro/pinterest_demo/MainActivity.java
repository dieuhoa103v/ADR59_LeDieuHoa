package vn.devpro.pinterest_demo;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.devpro.pinterest_demo.adapters.HintAdapter;
import vn.devpro.pinterest_demo.adapters.RelatedImgAdapter;
import vn.devpro.pinterest_demo.adapters.SavedImgAdapter;
import vn.devpro.pinterest_demo.models.Hint;
import vn.devpro.pinterest_demo.models.Image_Info;

public class MainActivity extends AppCompatActivity {
    RecyclerView hintRCV, savedImgRCV, relatedRCV;

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

        hintRCV = findViewById(R.id.hintRCV);
        savedImgRCV = findViewById(R.id.savedImgRCV);
        relatedRCV = findViewById(R.id.relatedImgRCV);

        configHintRecycleView();

        configSavedImageRecycleView();

        configRelatedImageRecycleView();

    }

    private void configRelatedImageRecycleView() {
        List<Image_Info> relatedImages = new ArrayList<>();
        relatedImages.add(new Image_Info(R.drawable.img_1, R.drawable.avatar_2, "Tom Suit", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_18, R.drawable.avatar_8, "Jerry Addict", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_21, R.drawable.avatar_3, "Frog Chairman", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_22, R.drawable.avatar_2, "Tom Suit", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_2, R.drawable.avatar_3, "Frog Chairman", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_3, R.drawable.avatar_4, "Iced Bear", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_20, R.drawable.avatar_4, "Iced Bear", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_6, R.drawable.avatar_7, "Nobi Kul", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_16, R.drawable.avatar_7, "Nobi Kul", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_9, R.drawable.avatar_6, "Perry Agent", false, false));
        relatedImages.add(new Image_Info(R.drawable.img_17, R.drawable.avatar_8, "Jerry Addict", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_10, R.drawable.avatar_3, "Frog Chairman", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_13, R.drawable.avatar_1, "Thomas Shelby", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_19, R.drawable.avatar_1, "Thomas Shelby", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_14, R.drawable.avatar_7, "Nobi Kul", true, false));
        relatedImages.add(new Image_Info(R.drawable.img_15, R.drawable.avatar_8, "Jerry Addict", false, false));

        RelatedImgAdapter adapter = new RelatedImgAdapter(relatedImages);

        relatedRCV.setLayoutManager(new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        ));
        relatedRCV.setAdapter(adapter);

        RelatedImgAdapter.OnClickItemListener listener = (image, avatar, name, isFavorite, isSaved) -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("IMAGE", image);
            intent.putExtra("AVATAR", avatar);
            intent.putExtra("NAME", name);
            intent.putExtra("IS_FAVORITE", isFavorite);
            intent.putExtra("IS_SAVED", isSaved);

            startActivity(intent);
        };

        adapter.setListener(listener);
    }

    private void configSavedImageRecycleView() {
        List<Image_Info> savedImages = new ArrayList<>();
        savedImages.add(new Image_Info(R.drawable.img, R.drawable.avatar_1, "Thomas Shelby", true, true));
        savedImages.add(new Image_Info(R.drawable.img_4, R.drawable.avatar_5, "Jerry Marine", false, true));
        savedImages.add(new Image_Info(R.drawable.img_23, R.drawable.avatar_5, "Jerry Marine", false, true));
        savedImages.add(new Image_Info(R.drawable.img_7, R.drawable.avatar_7, "Nobi Kul", true, true));
        savedImages.add(new Image_Info(R.drawable.img_24, R.drawable.avatar_7, "Nobi Kul", true, true));
        savedImages.add(new Image_Info(R.drawable.img_8, R.drawable.avatar_5, "Jerry Marine", false, true));
        savedImages.add(new Image_Info(R.drawable.img_5, R.drawable.avatar_6, "Perry Agent", true, true));
        savedImages.add(new Image_Info(R.drawable.img_11, R.drawable.avatar_4, "Iced Bear", false, true));
        savedImages.add(new Image_Info(R.drawable.img_25, R.drawable.avatar_4, "Iced Bear", false, true));
        savedImages.add(new Image_Info(R.drawable.img_26, R.drawable.avatar_4, "Iced Bear", false, true));
        savedImages.add(new Image_Info(R.drawable.img_12, R.drawable.avatar_2, "Tom Suit", true, true));

        SavedImgAdapter adapter = new SavedImgAdapter(savedImages);

        savedImgRCV.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false
        ));
        savedImgRCV.setAdapter(adapter);

        SavedImgAdapter.OnClickItemListener listener = (image, avatar, name, isFavorite, isSaved) -> {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("IMAGE", image);
            intent.putExtra("AVATAR", avatar);
            intent.putExtra("NAME", name);
            intent.putExtra("IS_FAVORITE", isFavorite);
            intent.putExtra("IS_SAVED", isSaved);

            startActivity(intent);
        };

        adapter.setListener(listener);
    }

    private void configHintRecycleView() {
        List<Hint> hints = new ArrayList<>();
        hints.add(new Hint("All", false));
        hints.add(new Hint("Astronauts", false));
        hints.add(new Hint("NASA", true));
        hints.add(new Hint("Mars Rover", false));
        hints.add(new Hint("Deep Space", false));
        hints.add(new Hint("Spacecraft", false));
        hints.add(new Hint("Astrophotography", false));

        HintAdapter adapter = new HintAdapter(hints);

        hintRCV.setLayoutManager(new LinearLayoutManager(
                this, LinearLayoutManager.HORIZONTAL, false
        ));
        hintRCV.setAdapter(adapter);
    }

}