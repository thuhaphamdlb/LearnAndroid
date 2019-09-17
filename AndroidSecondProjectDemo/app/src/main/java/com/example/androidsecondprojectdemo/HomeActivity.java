package com.example.androidsecondprojectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView text_view_hello = (TextView) findViewById(R.id.text_view_hello);
        TextView text_view_email = (TextView) findViewById(R.id.text_view_email);
        TextView text_view_password = (TextView) findViewById(R.id.text_view_password);

        final Intent infor = this.getIntent();
        String email = infor.getStringExtra("email");
        String password = infor.getStringExtra("password");

        text_view_email.setText(":" + email);
        text_view_password.setText(":" + password);

        text_view_hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, infor);
                finish();
            }
        });
    }
}
