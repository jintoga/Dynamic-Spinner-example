package com.example.dat.dynamicdualspinnertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WithoutConfigureChangesActivity extends AppCompatActivity {

    public static void startWithoutConfigureChangesActivity(Context context) {
        if (context instanceof WithoutConfigureChangesActivity) {
            return;
        }
        Intent intent = new Intent(context, WithoutConfigureChangesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_without_configure_changes);
    }
}
