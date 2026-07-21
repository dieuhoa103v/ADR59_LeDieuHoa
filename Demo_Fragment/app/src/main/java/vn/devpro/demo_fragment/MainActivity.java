package vn.devpro.demo_fragment;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btn_TabA, btn_TabB, btn_TabC, btn_TabD;

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

        btn_TabA = findViewById(R.id.tab_a);
        btn_TabB = findViewById(R.id.tab_b);
        btn_TabC = findViewById(R.id.tab_c);
        btn_TabD = findViewById(R.id.tab_d);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new FragmentA(), "MY_FRAG")
                    .addToBackStack(null)
                    .commit();

            btn_TabA.setBackgroundTintList(
                    ColorStateList.valueOf(
                            ContextCompat.getColor(this, R.color.blue)
                    )
            );
        }

            btn_TabA.setOnClickListener(v -> {
                replace(new FragmentA());
                updateButton(btn_TabA);
            });

            btn_TabB.setOnClickListener(v -> {
                replace(new FragmentB());
                updateButton(btn_TabB);
            });

            btn_TabC.setOnClickListener(v -> {
                replace(new FragmentC());
                updateButton(btn_TabC);
            });

            btn_TabD.setOnClickListener(v -> {
                replace(new FragmentD());
                updateButton(btn_TabD);
            });

    }

    private void replace(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment, "MY_FRAG")
                .addToBackStack(null)
                .commit();
    }

    private void updateButton(Button button) {
        Button[] buttons = {btn_TabA, btn_TabB, btn_TabC, btn_TabC};

        for (Button btn: buttons) {
            if (btn == button) {
                btn.setBackgroundTintList(
                        ColorStateList.valueOf(
                                ContextCompat.getColor(this, R.color.blue)
                        )
                );
            } else {
                btn.setBackgroundTintList(
                        ColorStateList.valueOf(
                                ContextCompat.getColor(this, R.color.grey)
                        )
                );
            }
        }
    }
}