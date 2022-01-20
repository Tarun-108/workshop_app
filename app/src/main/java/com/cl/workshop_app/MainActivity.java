package com.cl.workshop_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView timeText,timeDisplay;
    Button goButton;
    int time = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.editTextTime);
        goButton = findViewById(R.id.button);
        timeDisplay = findViewById(R.id.textViewTimeDisplay);

        CountDownTimer timer = new CountDownTimer(time*1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {

            }
        };

        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time = Integer.parseInt(timeText.getText().toString());

                if(time==0) {
                    Toast.makeText(MainActivity.this, "Enter time", Toast.LENGTH_SHORT).show();
                }else{
                    String min = String.valueOf(time/60);
                    String sec = String.valueOf(time%60);

                    String display = min+" : "+sec;

                    timeDisplay.setText(display);



                }

            }
        });
    }
}