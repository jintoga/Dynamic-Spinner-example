package com.example.dat.dynamicdualspinnertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class UsingConfigureChangesActivity extends AppCompatActivity {

    public static void startUsingConfigureChangesActivity(Context context) {
        if (context instanceof UsingConfigureChangesActivity) {
            return;
        }
        Intent intent = new Intent(context, UsingConfigureChangesActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_configure_changes);
    }
}
