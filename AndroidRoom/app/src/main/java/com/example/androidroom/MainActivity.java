package com.example.androidroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppDatabase db;

    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String string;

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db = Room.databaseBuilder(getApplicationContext(),
                        AppDatabase.class, "database-name").build();
                User user1 = new User();
                user1.uid = 10;
                user1.firstName = "First";

                User user2 = new User();
                user2.uid = 20;
                user2.firstName = "Second";

                User user3 = new User();
                user3.uid = 30;
                user3.firstName = "Third";

                db.userDao().insertAll(user1, user2, user3);
                return null;
            }
        }.execute();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getUsers();
            }
        });
    }

    @SuppressLint("StaticFieldLeak")
    public void getUsers() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                final List<User> users = db.userDao().getAll();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "size:" + users.size(), Toast.LENGTH_LONG).show();
                        TextView tv = findViewById(R.id.textview);
                        tv.setText("size:" + users.size());

                        final LinearLayout main = findViewById(R.id.main_linear);

                        for (User user : users) {
                            TextView uidText = new TextView(MainActivity.this);
                            TextView firstNameText = new TextView(MainActivity.this);
//                            EditText editText = new EditText(MainActivity.this);
//                            Button bt = new Button(MainActivity.this);
//                            bt.setText("Edit");

                            String firstName = user.getFirstName();
                            int uid = user.getUid();

                            uidText.setText(uid);
                            firstNameText.setText(firstName);

                            LinearLayout lnlayout = new LinearLayout(MainActivity.this);
                            lnlayout.setOrientation(LinearLayout.HORIZONTAL);

                            lnlayout.addView(uidText);
                            lnlayout.addView(firstNameText);
//                            lnlayout.addView(editText);
//                            lnlayout.addView(bt);

                            main.addView(lnlayout);
                        }
                    }
                });
                return null;
            }
        }.execute();
    }
}