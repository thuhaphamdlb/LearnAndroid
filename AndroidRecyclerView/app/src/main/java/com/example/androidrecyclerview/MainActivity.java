package com.example.androidrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerViewUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewUser = findViewById(R.id.recycler_users);
        recyclerViewUser.setLayoutManager((new LinearLayoutManager(this)));

        final UserAdapter userAdapter = new UserAdapter();
        recyclerViewUser.setAdapter(userAdapter);

        User user1 = new User("Hoa", 10);
        User user2 = new User("Nam", 9);
        User user3 = new User("Lan", 8);

        final List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userAdapter.users = users;
        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_SHORT).show();
                users.add(new User("Ha",8));
                userAdapter.notifyDataSetChanged();
            }
        });
        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Update",Toast.LENGTH_SHORT).show();
                users.get(0).name = "Đổi";
                userAdapter.notifyDataSetChanged();
            }
        });
    }

}
