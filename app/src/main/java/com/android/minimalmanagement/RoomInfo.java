package com.android.minimalmanagement;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class RoomInfo extends AppCompatActivity {
    TextView textRoomInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_info);

        textRoomInfo = findViewById(R.id.text_room_info);

        Intent intent = getIntent();
        String roomNumber = intent.getStringExtra("roomNumber");

        textRoomInfo.setText("Room 0" + roomNumber + " - ID: P0" + roomNumber + "CTMD");
    }
}
