package com.example.thuy_androidtodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
    EditText edt;
    Button btAdd;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        edt = findViewById(R.id.edt_add);
        btAdd = findViewById(R.id.bt_addTask);

        final String input = edt.getText().toString();

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertTask(input);
            }
        });

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name").build();
    }

    void insertTask(String input) {
        final Todo todo = new Todo();
        todo.task = input;

        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                db.todoDao().insert(todo);
                Log.i("tag","insert successful");
                return null;
            }
        }.execute();
    }
}
