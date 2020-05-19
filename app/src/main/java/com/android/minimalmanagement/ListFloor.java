package com.android.minimalmanagement;

import android.widget.GridView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListFloor extends AppCompatActivity {
    GridView gridView;

    String[] numberFloor = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    int[] floorImage = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
    R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_floor);

        gridView = findViewById(R.id.grid_floor);
        MainAdapter mainAdapter = new MainAdapter(ListFloor.this, numberFloor, floorImage);
        gridView.setAdapter(mainAdapter);
    }
}
