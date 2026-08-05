package vn.devpro.viewgroup;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vn.devpro.viewgroup.adapters.UserAdapter;
import vn.devpro.viewgroup.models.User;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button deleteBtn;

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

        listView = findViewById(R.id.listView);

//        configSimpleList();

//        configSimpleCheckedList();

//        configSimpleMultiChoiceList();

//        configSimpleListActive();
        
//        configCustomList();
    }

//    private void configCustomList() {
//        List<User> users = new ArrayList<>();
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//        users.add(new User(R.drawable.avatar, "Nguyen Van A", "nguyenvana@gmail.com"));
//
//        UserAdapter adapter = new UserAdapter(users, (position, view) ->
//                User user = users.get(position);
//                boolean isChecked = listView.isItemChecked(position);
//        Log.d("MainActivity", "Clicked user: " + user.getName());
//        if (isChecked) {
//            selectedItems.add(user);
//            view.setBackGroundColor(Color.parseColor())
//        }
//        );
//        listView.setAdapter(adapter);
//        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
//    }

    private void configSimpleListActive() {
        String[] data = {
                "Nguyen Van A",
                "Nguyen Van E",
                "Nguyen Van F",
                "Nguyen Van G",
                "Nguyen Van H",
                "Nguyen Van I",
        };

        List<String> itemData = new ArrayList<>(Arrays.asList(data));
        itemData.add("Nguyen Van B");
        itemData.add("Nguyen Van C");
        itemData.add("Nguyen Van D");

        List<String> selectedItems = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_activated_1,
                itemData
        );

        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = adapter.getItem(position);
            boolean isChecked = listView.isItemChecked(position);
            if (isChecked) {
                selectedItems.add(item);
            } else {
                selectedItems.remove(item);
            }
        });

        deleteBtn = findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(v -> {
            itemData.removeAll(selectedItems);
            selectedItems.clear();
            adapter.notifyDataSetChanged();
            listView.clearChoices();
        });
    }

    private void configSimpleMultiChoiceList() {
        String[] data = {
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
        };

        List<String> selectedItems = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                data
        );

        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);
    }

    private void configSimpleCheckedList() {
        String[] data = {
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
                "Nguyen Van A",
        };

        List<String> selectedItems = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_checked,
                data
        );

        listView.setChoiceMode(listView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            String item = adapter.getItem(position);
            boolean isChecked = listView.isItemChecked(position);
            if (isChecked) {
                selectedItems.add(item);
            } else {
                selectedItems.remove(item);
            }
            Log.d("MainActivity", "Selected Items: " + selectedItems.toString());
        });
    }

//    private void configSimpleList() {
//        String[] dsSinhVien = {
//                "Nguyen Van A",
//                "Nguyen Van B",
//                "Nguyen Van C",
//                "Nguyen Van D",
//                "Nguyen Van E",
//        };
//        ArrayList<String> data = new ArrayList<>(Arrays.asList(dsSinhVien));
//
//        String[][] data2 = {
//                {"Nguyen Van A", "0123456789"},
//                {"Nguyen Van A", "0123456789"},
//                {"Nguyen Van A", "0123456789"},
//                {"Nguyen Van A", "0123456789"},
//                {"Nguyen Van A", "0123456789"},
//                {"Nguyen Van A", "0123456789"},
//        };
//        ArrayList<String[]> listData = new ArrayList<>(Arrays.asList(data2));
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_list_item_2,
//                android.R.id.text1,
//                data2
//        ) {
//            @Override
//            public View getView(int position, View convertView, ViewGroup parent) {
//                View view = super.getView(position, convertView, parent);
//
//                TextView text1 = view.findViewById(android.R.id.text1);
//                TextView text2 = view.findViewById(android.R.id.text1);
//
//                String[] item = getItem(position);
//                if (item != null) {
//                    text1.setText(item[position]);
//                    text2.setText(item[position]);
//                };
//            };
//        };
//
//        listView.setAdapter(adapter);
//    }
}