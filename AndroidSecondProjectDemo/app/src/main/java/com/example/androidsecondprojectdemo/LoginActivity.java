package com.example.androidsecondprojectdemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_login = (Button) findViewById(R.id.button_login);
        final EditText edit_text_email = (EditText) findViewById(R.id.edit_text_email);
        final EditText edit_text_password = (EditText) findViewById(R.id.edit_text_password);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edit_text_email.getText().toString();
                String password = edit_text_password.getText().toString();

                Intent loginIntent = new Intent(view.getContext(), HomeActivity.class);
                loginIntent.putExtra("email", email);
                loginIntent.putExtra("password", password);
                startActivityForResult(loginIntent,0);
            }
        });
    }

}
