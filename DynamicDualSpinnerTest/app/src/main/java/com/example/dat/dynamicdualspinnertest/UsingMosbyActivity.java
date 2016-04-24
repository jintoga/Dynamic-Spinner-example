package com.example.dat.dynamicdualspinnertest;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by DAT on 23-Apr-16.
 */
public class UsingMosbyActivity extends AppCompatActivity {

    public static void startActivity(Context context) {
        if (context instanceof UsingMosbyActivity) {
            return;
        }
        Intent intent = new Intent(context, UsingMosbyActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_using_configure_changes);
    }
}
