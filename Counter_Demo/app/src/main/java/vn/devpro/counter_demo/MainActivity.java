package vn.devpro.counter_demo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CounterViewModel viewModel;
    private SharedPreferences prefs;
    private TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCount = findViewById(R.id.tvCount);
        Button btnIncrement = findViewById(R.id.btnIncrement);
        Button btnDecrement = findViewById(R.id.btnDecrement);
        Button btnReset = findViewById(R.id.btnReset);

        // TODO 5: Khởi tạo SharedPreferences
         prefs = getSharedPreferences("counter_prefs", Context.MODE_PRIVATE);

        // TODO 6: Create ViewModel
         viewModel = new ViewModelProvider(this).get(CounterViewModel.class);

        // TODO 7: Load giá trị count đã lưu trước đó vào viewmodel
         viewModel.loadCount(prefs);

        // TODO 8: Observe LiveData và update count lên TextView
         viewModel.getCount().observe(this, count -> {
             tvCount.setText(String.valueOf(count));
         });

        // TODO 9: Xử lý click cho các nút tăng, giảm, reset -> gọi viewmodel để xử lý logic
         btnIncrement.setOnClickListener(v -> viewModel.increment(prefs));
         btnDecrement.setOnClickListener(v -> viewModel.decrement(prefs));
         btnReset.setOnClickListener(v -> viewModel.reset(prefs));

        // TODO 10: thực hiện thay đổi giá trị count, sau đó tắt app hoàn toàn và mở lại để
        // xác nhận giá trị count đã lưu trước đó vẫn được lưu
        // -> ngon
    }
}