package com.android.minimalmanagement;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class ListFloor extends AppCompatActivity {
    GridView gridView;

    String[] numberFloor = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    int[] floorImage = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight, R.drawable.nine,
            R.drawable.ten};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_floor);

        gridView = findViewById(R.id.grid_floor);

        MainAdapter mainAdapter = new MainAdapter(ListFloor.this, numberFloor, floorImage);
        gridView.setAdapter(mainAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListFloor.this, "Floor " + numberFloor[position] + " is selected", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ListFloor.this, OverviewActivity.class);

                startActivity(intent);
            }
        });
    }
}
