package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {
    ImageView imgSetting;
    TextView txtListFloor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        imgSetting = findViewById(R.id.img_Setting);
        txtListFloor = findViewById(R.id.txt_listFloor);

        imgSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, SettingScreen.class);
                startActivity(intent);
            }
        });

        txtListFloor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OverviewActivity.this, ListFloor.class);
                startActivity(intent);
            }
        });

    }
}
