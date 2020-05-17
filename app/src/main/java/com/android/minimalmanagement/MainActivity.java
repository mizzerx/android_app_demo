package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btLogin;
    TextView txtNote;
    int count = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
        txtNote = findViewById(R.id.txt_Note);

        btLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals("admin") &&
                etPassword.getText().toString().equals("admin")) {
                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, OverviewActivity.class);
                    startActivity(intent);
                } else {
                    count--;
                    Toast.makeText(getApplicationContext(), "You are not a admin / Username or password is not valid", Toast.LENGTH_SHORT).show();
                    txtNote.setText("You have " + count + " times to input username and password!");
                    if (count == 0) btLogin.setEnabled(false);
                }
            }
        });
    }
}