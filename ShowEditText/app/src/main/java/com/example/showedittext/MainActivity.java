package com.example.showedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edt = findViewById(R.id.editText);
                String text = edt.getText().toString();
//                TextView tv = findViewById(R.id.textResult);
//                tv.setText(tv.getText().toString() + text + "\n");
                TextView tv = new TextView(MainActivity.this);
                tv.setText(text);
                LinearLayout main = findViewById(R.id.main_linear);
                main.addView(tv);
            }
        });
    }
}
