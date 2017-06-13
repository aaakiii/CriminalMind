package com.example.aki.climinal;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Calendar;

import static android.R.attr.startYear;


public class CalendarFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year,month,day);

    }
    @Override
    public void onDateSet(android.widget.DatePicker view, int year,int monthOfYear, int dayOfMonth){
        ((Button) getActivity().findViewById(R.id.crime_date)).setText(String.valueOf(monthOfYear+1)+"/"+String.valueOf(dayOfMonth)+"/"+String.valueOf(year));
    }
}
