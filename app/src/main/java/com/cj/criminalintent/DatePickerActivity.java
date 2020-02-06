package com.cj.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Date;

public class DatePickerActivity extends AppCompatActivity {

    private static final String EXTRA_DATE = "com.cj.criminalintent.date";

    public static Intent newIntent(Context packageContext, Date date) {
        Intent intent = new Intent(packageContext, DatePickerActivity.class);
        intent.putExtra(EXTRA_DATE, date);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Date date = (Date) getIntent().getSerializableExtra(EXTRA_DATE);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = DatePickerFragment.newInstance(date);
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
