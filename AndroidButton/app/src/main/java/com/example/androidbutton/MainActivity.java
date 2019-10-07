package com.example.androidbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String name = "Submit 2";
        final Button bt = (Button) findViewById(R.id.button);
        bt.setText(name); //submit 2
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bt.setText(getResources().getString(R.string.submit3));
                Toast.makeText(MainActivity.this,"Bạn đã bấm rồi đó", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
