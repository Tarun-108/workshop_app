package com.cl.workshop_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView timeText,timeDisplay;
    Button goButton;
    ImageView eggImage;
    int time = 10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.editTextTime);
        goButton = findViewById(R.id.button);
        timeDisplay = findViewById(R.id.textViewTimeDisplay);
        eggImage = findViewById(R.id.imageView);

        CountDownTimer timer = new CountDownTimer(time*1000 + 100, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {



                String min = String.valueOf(time/60);
                String sec = String.valueOf(time%60);

                String display = min+" : "+sec;

                timeDisplay.setText(display);

                if(time>0) time --;

            }

            @Override
            public void onFinish() {

                timeDisplay.setText("0 : 0");
                eggImage.setImageDrawable(getDrawable(R.drawable.cracked_egg));

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

                    timer.start();



                }

            }
        });
    }
}