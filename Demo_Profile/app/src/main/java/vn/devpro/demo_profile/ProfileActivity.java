package vn.devpro.demo_profile;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.imageview.ShapeableImageView;

import vn.devpro.demo_profile.models.User;

public class ProfileActivity extends AppCompatActivity {

    public static final String KEY_NAME = "KEY_NAME";
    public static final String KEY_EMAIL = "KEY_EMAIL";

    LinearLayout editProfile;
    TextView tvName, tvEmail;
    ImageButton avatarBtn;

    ShapeableImageView avatar;

    private ActivityResultLauncher<Intent> launcher;
    private ActivityResultLauncher<String> permissionLauncher;
    private ActivityResultLauncher<String> pickImageLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // launcher
        ActivityResultContracts.StartActivityForResult contracts = new ActivityResultContracts.StartActivityForResult();
        launcher = registerForActivityResult(contracts, result -> {
            if (result.getResultCode() == RESULT_OK) {
                Intent intent = result.getData();
                String name = intent.getStringExtra(KEY_NAME);
                String email = intent.getStringExtra(KEY_EMAIL);
                tvName.setText(name);
                tvEmail.setText(email);
            }
        });

        permissionLauncher = registerForActivityResult(
                new ActivityResultContracts.RequestPermission(), isGranted -> {
                    String message = isGranted ? "Granted" : "Denied";
                    Toast.makeText(this, "Gallery: " + message, Toast.LENGTH_SHORT).show();
                }
        );

        // Data Transfer
        editProfile = findViewById(R.id.editProfile);
        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        avatarBtn = findViewById(R.id.avatarBtn);
        avatar = findViewById(R.id.avatar);

        editProfile.setOnClickListener(v -> {
            String name = tvName.getText().toString();
            String email = tvEmail.getText().toString();
            sendWithLauncher(name, email);
        });

        setUpContracts();

        avatarBtn.setOnClickListener(v -> {
            pickImageLauncher.launch("image/*");
        });
    }

    private void setUpContracts() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            permissionLauncher.launch(Manifest.permission.READ_MEDIA_IMAGES);
        } else {
            permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE);
        }

        pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(), uri -> {
                    if (uri != null) {
                        avatar.setImageURI(uri);
                    }
                }
        );
    }

    private void sendWithLauncher(String name, String email) {
        Intent intent = new Intent(this, EditProfileActivity.class);

        User user = new User(
                name,
                email,
                "Male",
                "+84 703543187",
                "No 147 - Mai Dich Street"
        );

        intent.putExtra("USER", user);
        launcher.launch(intent);
    }
}