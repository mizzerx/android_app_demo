package com.android.minimalmanagement;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    EditText etUsername, etPassword;
    Button btLogin;
    TextView txtNote;
    int count = 5;
    ImageView imgShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btLogin = findViewById(R.id.bt_login);
        txtNote = findViewById(R.id.txt_Note);
        imgShow = findViewById(R.id.img_ShowHide);

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
                    etUsername.setText("");
                    etPassword.setText("");
                    if (count == 0) btLogin.setEnabled(false);
                }
            }
        });

        imgShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgShow.getTag().equals("Hide")) {
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_show);
                    imgShow.setTag("Show");
                    imgShow.setImageDrawable(drawable);
                } else {
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    Drawable drawable = getResources().getDrawable(R.drawable.ic_hide);
                    imgShow.setTag("Hide");
                    imgShow.setImageDrawable(drawable);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        etPassword.setText("");
    }
}
