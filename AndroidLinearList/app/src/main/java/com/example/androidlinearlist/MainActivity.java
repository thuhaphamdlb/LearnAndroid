package com.example.androidlinearlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] className = new String[]{"Ai","La","Hoc","Sinh","PN"};
        ViewGroup.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f);
        LinearLayout mainLayout = findViewById(R.id.main_linear);

        for (int i = 0; i < className.length; i++) {
            TextView tv = new TextView(MainActivity.this);
            tv.setLayoutParams(params);
            tv.setText("" + className[i]);

            Button bt = new Button(MainActivity.this);
            bt.setText("+");

            LinearLayout lnlayout = new LinearLayout(MainActivity.this);
            lnlayout.setOrientation(LinearLayout.HORIZONTAL);
            lnlayout.addView(tv);
            lnlayout.addView(bt);
            mainLayout.addView(lnlayout);
        }
    }
}