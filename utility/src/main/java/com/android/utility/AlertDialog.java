package com.android.utility;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by pawan on 10/2/17.
 */

public class AlertDialog {

    public void showSingleButtonAlertDialog(Activity activity, String positiveButtonText, String negativeButtonText, String title, String message, final AlertDialogInterface alertDialogInterface) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(positiveButtonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialogInterface.positiveButtonPressed();
                        dialogInterface.cancel();
                    }
                }).setNegativeButton(negativeButtonText, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogInterface.negativeButtonPressed();
                dialogInterface.cancel();
            }
        });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public void showSingleButtonAlertDialog(Activity activity, String buttonText, String title, String message, final AlertDialogSingleInterface dialogSingleInterface) {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(activity);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton(buttonText, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogSingleInterface.doTaskOnClick();
                        dialogInterface.cancel();
                    }
                });
        android.app.AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
        private TimeInterface timeInterface;

        public TimeInterface getTimeInterface() {
            return timeInterface;
        }

        public void setTimeInterface(TimeInterface timeInterface) {
            this.timeInterface = timeInterface;
        }

        public TimePickerFragment() {
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current time as the default values for the picker
            final Calendar c = Calendar.getInstance();
            int hour = c.get(Calendar.HOUR_OF_DAY);
            int minute = c.get(Calendar.MINUTE);

            // Create a new instance of TimePickerDialog and return it
            return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
        }

        @SuppressWarnings("WrongConstant")
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            int hour, min;
            Calendar datetime = Calendar.getInstance();
            String am_pm = "" ;
            datetime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            datetime.set(Calendar.MINUTE, minute);

            if (datetime.get(Calendar.AM_PM) == Calendar.AM)
                am_pm = "AM";
            else if (datetime.get(Calendar.AM_PM) == Calendar.PM)
                am_pm = "PM";
            hourOfDay = hourOfDay > 12 ? hourOfDay - 12 : hourOfDay;
            hour = hourOfDay > 9 ? hourOfDay : hourOfDay;
            min = minute > 9 ? minute : minute;
            timeInterface.setTime(hour, min, am_pm);
        }
    }

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        private DateInterface dateInterface;

        public DateInterface getDateInterface() {
            return dateInterface;
        }

        public void setDateInterface(DateInterface dateInterface) {
            this.dateInterface = dateInterface;
        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {
            int updateMonth = month++;
            Date date = new Date(year, updateMonth, day);
            dateInterface.setDate(date);
        }
    }
}
