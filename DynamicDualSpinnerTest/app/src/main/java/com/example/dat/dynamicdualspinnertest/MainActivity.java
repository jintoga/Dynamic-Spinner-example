package com.example.dat.dynamicdualspinnertest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUsingConfigureChangesActivity();
            }
        });

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWithoutConfigureChangesActivity();
            }
        });
    }

    private void goToWithoutConfigureChangesActivity() {
        WithoutConfigureChangesActivity.startWithoutConfigureChangesActivity(this);
    }

    private void goToUsingConfigureChangesActivity() {
        UsingConfigureChangesActivity.startUsingConfigureChangesActivity(this);
    }


}
