package com.example.androidliststudent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements StudentAdapter.OnItemClicked {

    RecyclerView recyclerViewStudents;
    Button buttonAdd, buttonDelete;
    List<Student> students;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewStudents = findViewById(R.id.recycler_student);
        recyclerViewStudents.setLayoutManager(new LinearLayoutManager(this));

        students = new ArrayList<Student>();
        Student ha = new Student("Ha", 19,"Earth");
        Student cung = new Student("Cung", 20,"Sun");
        Student co = new Student("Co", 21,"Jupiter");
        Student thieu = new Student("Thieu", 22,"Venus");
        Student thuy = new Student("Thuy", 23,"Moon");
        students.add(ha);
        students.add(cung);
        students.add(co);
        students.add(thieu);
        students.add(thuy);

        final StudentAdapter studentAdapter = new StudentAdapter(this,students);
        recyclerViewStudents.setAdapter(studentAdapter);
        studentAdapter.setOnClick(MainActivity.this);
//        wait(6);
        buttonAdd = findViewById(R.id.button_add);
        buttonDelete = findViewById(R.id.button_delete);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student("Anonymous",20,"Mars"));
                studentAdapter.notifyDataSetChanged();
            }
        });

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.remove(students.size()-1);
                studentAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, StudentDetailActivity.class);
        detailIntent.putExtra("name", students.get(position).getName());
        String age = String.valueOf(students.get(position).getAge());
        detailIntent.putExtra("age", age);
        detailIntent.putExtra("galaxy", students.get(position).getGalaxy());
        startActivityForResult(detailIntent,0);
    }
}