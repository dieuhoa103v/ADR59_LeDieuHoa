package vn.devpro.viewdemo;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import eightbitlab.com.blurview.BlurTarget;
import eightbitlab.com.blurview.BlurView;

public class MainActivity extends AppCompatActivity {

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

        float radius = 20f;

        BlurTarget target = findViewById(R.id.target);
        BlurView blurView = findViewById(R.id.blurView);

        blurView.setupWith(target)
                .setBlurRadius(radius);

        blurView.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        blurView.setClipToOutline(true);

        EditText passwordField = findViewById(R.id.editTextTextPassword);
        ImageButton togglePassBtn = findViewById(R.id.passwordToggle);
        Button loginBtn = findViewById(R.id.loginBtn);

        togglePassBtn.setOnClickListener(v -> {
            int type = passwordField.getInputType();
            if (type == InputType.TYPE_CLASS_TEXT) {
                passwordField.setInputType(129);
                togglePassBtn.setImageResource(R.drawable.show_resizable_icon);
            } else {
                passwordField.setInputType(InputType.TYPE_CLASS_TEXT);
                togglePassBtn.setImageResource(R.drawable.hide_resizable_icon);
            }

            passwordField.setSelection(passwordField.getText().length());
        });

        loginBtn.setOnClickListener(v -> {
            String inputPass = passwordField.getText().toString();
            String correctPass = "qwertyuiop";

            if (inputPass.equals(correctPass)) {
                passwordField.setBackgroundResource(R.drawable.field_bg);
                passwordField.setTextColor(ContextCompat.getColor(this, R.color.bronze));
            } else {
                togglePassBtn.setVisibility(View.GONE);
                passwordField.setBackgroundResource(R.drawable.error_bg);
                passwordField.setTextColor(ContextCompat.getColor(
                        this, com.google.android.material.R.color.design_default_color_error));
                passwordField.setError("Wrong password");
            }
        });

        passwordField.addTextChangedListener(new TextWatcher() {
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}

            @Override public void onTextChanged(CharSequence s, int start, int before, int count) {
                passwordField.setBackgroundResource(R.drawable.field_bg);
                passwordField.setTextColor(
                        ContextCompat.getColor(MainActivity.this, R.color.bronze)
                );
                passwordField.setError(null);
                togglePassBtn.setVisibility(View.VISIBLE);
            }
        });
    }
}