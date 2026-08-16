package vn.devpro.counter_demo;

import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    private static final String PREFS_NAME = "counter_prefs";
    private static final String KEY_COUNT = "count";

    private final MutableLiveData<Integer> count = new MutableLiveData<>(0);

    public LiveData<Integer> getCount() {
        return count;
    }

    // TODO 1: Load count từ SharedPreferences và set vào LiveData
        public void loadCount(SharedPreferences prefs) {
            // code here:
            int saveCount = prefs.getInt(KEY_COUNT, 0);
            count.setValue(saveCount);
        }

    // TODO 2: Tăng count lên 1 và lưu vào SharedPreferences
    public void increment(SharedPreferences prefs) {
        // code here:
            if (count.getValue() != null) {
                int newCount = count.getValue() + 1;
                count.setValue(newCount);
                saveCount(prefs, newCount);
            }
    }

    // TODO 3: Giảm count xuống 1 và lưu vào SharedPreferences, không giảm quá 0
    public void decrement(SharedPreferences prefs) {
        // ...
        if (count.getValue() != null) {
            int newCount = Math.max(0, count.getValue() - 1);
            count.setValue(newCount);
            saveCount(prefs, newCount);
        }
    }

    // TODO 4: Reset to 0 and save it
    public void reset(SharedPreferences prefs) {
        count.setValue(0);
        saveCount(prefs, 0);
    }

    // Helper method để lưu count vào SharedPreferences
    private void saveCount(SharedPreferences prefs, int value) {
        prefs.edit().putInt(KEY_COUNT, value).apply();
    }
}
