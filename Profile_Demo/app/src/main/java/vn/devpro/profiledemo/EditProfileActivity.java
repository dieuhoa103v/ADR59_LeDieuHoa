package vn.devpro.profiledemo;

import static vn.devpro.profiledemo.ProfileActivity.KEY_EMAIL;
import static vn.devpro.profiledemo.ProfileActivity.KEY_NAME;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

import vn.devpro.profiledemo.models.User;

public class EditProfileActivity extends AppCompatActivity {

    ImageButton backBtn;
    Spinner spinnerGender;

    EditText edtName, edtEmail, edtGender, edtPhoneNumber, edtAddress;

    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_edit_profile);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(v -> {
            finish();
        });

        spinnerGender = findViewById(R.id.spinnerGender);

        ArrayList<String> genderOptions = new ArrayList<>(
                Arrays.asList(
                        "Male",
                        "Female",
                        "Other",
                        "Prefer not to say"
                )
        );

        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(
                this,
                R.layout.spinner_item,
                genderOptions
        );

        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerGender.setAdapter(genderAdapter);

        // Data Transfer
        edtName = findViewById(R.id.edtName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        edtAddress = findViewById(R.id.edtAddress);

        Intent intent = getIntent();
        User user = (User) intent.getParcelableExtra("USER");
        String name = user.getName();
        String email = user.getEmail();
        String gender = user.getGender();
        String phoneNumber = user.getPhoneNumber();
        String address = user.getAddress();

        edtName.setText(name);
        edtEmail.setText(email);
        edtPhoneNumber.setText(phoneNumber);
        edtAddress.setText(address);

        int position = genderOptions.indexOf(gender);
        if (position >= 0) {
            spinnerGender.setSelection(position);
        }

        saveBtn = findViewById(R.id.save);
        saveBtn.setOnClickListener(v -> {
            String userName = edtName.getText().toString();
            String userEmail = edtEmail.getText().toString();

            Intent backIntent = new Intent();
            backIntent.putExtra(KEY_NAME, userName);
            backIntent.putExtra(KEY_EMAIL, userEmail);

            setResult(RESULT_OK, backIntent);
            finish();
        });
    }
}