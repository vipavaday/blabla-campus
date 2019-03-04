package com.example.cedriclingom.blablacampus.fragments.main;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.cedriclingom.blablacampus.R;
import com.example.cedriclingom.blablacampus.security.utils.AuthFragment;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class RideFormFragment extends AuthFragment {

    private TextInputEditText rideDate;
    private TextInputEditText rideHour;
    private Button submitBtn;

    @Override
    public int getTitle() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rides_form, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rideHour =  getView().findViewById(R.id.ride_hour_text);
        rideHour.setOnClickListener(this::getTimePicker);
        rideHour.setOnFocusChangeListener((v, hasFocus) -> { if(hasFocus){ getTimePicker(v); } });

        rideDate =  getView().findViewById(R.id.ride_date_text);
        rideDate.setOnClickListener(this::getDatePicker);
        rideDate.setOnFocusChangeListener((v, hasFocus) -> { if(hasFocus){ getDatePicker(v); } });

        submitBtn = getView().findViewById(R.id.ride_submit_btn);
    }

    private void getDatePicker(View v){

        Calendar mcurrentTime = Calendar.getInstance();
        int year = mcurrentTime.get(Calendar.YEAR);
        int month = mcurrentTime.get(Calendar.MONTH);
        int day =  mcurrentTime.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog mDatePicker = new DatePickerDialog(getContext(), R.style.TimePickerTheme,
                (datePicker, selectedYear, selectedMonth, selectedDay) -> {
                    rideDate.setText( selectedDay + "/" + (selectedMonth+1)+ "/"+ selectedYear);
                },
                year, month, day
        );

        mDatePicker.setTitle(getResources().getString(R.string.ride_date));
        mDatePicker.show();
    }

    private void getTimePicker(View v){

        Calendar mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog mTimePicker = new TimePickerDialog(getContext(), R.style.TimePickerTheme,
                (timePicker, selectedHour, selectedMinute) -> {
                    rideHour.setText( selectedHour + ":" + selectedMinute);
                },
                hour, minute, true
        );

        mTimePicker.setTitle(getResources().getString(R.string.departure_time));
        mTimePicker.show();
    }

    public void initSubmitBtn(int btnText, View.OnClickListener clickListener){

        submitBtn.setText(btnText);
        submitBtn.setOnClickListener(clickListener);
    }
}
