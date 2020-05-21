package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SettingScreen extends AppCompatActivity {
    TextView textViewSetTime, textViewContract, textViewLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        textViewSetTime = findViewById(R.id.txtview_setTime);
        textViewContract = findViewById(R.id.txtview_contract);
        textViewLogout = findViewById(R.id.txtview_Logout);

        textViewSetTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingScreen.this, SetTimeActivity.class);

                startActivity(intent);
            }
        });

        textViewContract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingScreen.this, ContractActivity.class);

                startActivity(intent);
            }
        });

        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingScreen.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
