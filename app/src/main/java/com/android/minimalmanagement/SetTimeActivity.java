package com.android.minimalmanagement;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;

import java.text.DateFormat;
import java.util.Calendar;

public class SetTimeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Button setTimebtn, setHourbtn;
    String setDate = "";
    String setTime = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_time);

        setTimebtn = findViewById(R.id.setTime_btn);
        setHourbtn = findViewById(R.id.setHour_btn);

        setTimebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment datePicker = new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(), "date picker");
            }
        });

        TextView textDate = (TextView) findViewById(R.id.text_current_date);
        if (setDate == "") textDate.setText("Current set: Not yet");
        else textDate.setText("Current set: " + setDate);

        setHourbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePickder = new TimePickerFragment();
                timePickder.show(getSupportFragmentManager(), "time picker");
            }
        });

        TextView textTime = (TextView) findViewById(R.id.text_current_time);
        if (setTime == "") textTime.setText("Current set: Not Yet");
        else textDate.setText("Current set: " + setTime);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        setDate = currentDateString;

        TextView textView = (TextView) findViewById(R.id.text_current_date);
        textView.setText("Current set: " + currentDateString);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        TextView textView = (TextView) findViewById(R.id.text_current_time);

        setTime = "" + hourOfDay + ":" + minute;

        textView.setText("Current set: " + setTime);
    }
}
