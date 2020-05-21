package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OverviewActivity extends AppCompatActivity {
    ImageView imgSetting;
    TextView txtListFloor, textViewFloor;
    GridView gridRoom;

    String[] numberRoom = {"1", "2", "3", "4", "5"};

    int[] imgRoom = {R.drawable.r_1, R.drawable.r_2, R.drawable.r_3,
    R.drawable.r_4, R.drawable.r_5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overview);

        imgSetting = findViewById(R.id.img_Setting);
        txtListFloor = findViewById(R.id.txt_listFloor);
        gridRoom = findViewById(R.id.grid_room);

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

        OverViewAdapter overViewAdapter = new OverViewAdapter(OverviewActivity.this, imgRoom);
        gridRoom.setAdapter(overViewAdapter);

        gridRoom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(OverviewActivity.this, "Room " + numberRoom[position] + " is selected", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(OverviewActivity.this, RoomInfo.class);
                intent.putExtra("roomNumber", numberRoom[position]);

                startActivity(intent);
            }
        });
    }
}
