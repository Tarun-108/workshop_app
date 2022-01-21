package com.cl.workshop_app;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView timeText,timeDisplay;
    Button goButton;
    ImageView eggImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timeText = findViewById(R.id.editTextTime);
        goButton = findViewById(R.id.button);
        timeDisplay = findViewById(R.id.textViewTimeDisplay);
        eggImage = findViewById(R.id.imageView);


        goButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(timeText.getText())) {
                    Toast.makeText(MainActivity.this, "Enter time", Toast.LENGTH_SHORT).show();
                }else{


                    eggImage.setImageDrawable(getDrawable(R.drawable.egg));

                    int time = Integer.parseInt(timeText.getText().toString());

                    String min = String.valueOf(time/60);
                    String sec = String.valueOf(time%60);

                    String display = min+" : "+sec;

                    timeDisplay.setText(display);

                    CountDownTimer timer = new CountDownTimer(time* 1000L + 100, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {

                            int counter = (int) (millisUntilFinished/1000);

                            String min = String.valueOf(counter/60);
                            String sec = String.valueOf(counter%60);

                            String display = min+" : "+sec;

                            timeDisplay.setText(display);

                        }

                        @Override
                        public void onFinish() {

                            timeDisplay.setText("0 : 0");
                            MediaPlayer.create(MainActivity.this,R.raw.frying_pan_hit).start();
                            eggImage.setImageDrawable(getDrawable(R.drawable.cracked_egg));

                        }
                    };
                    timer.start();




                }

            }
        });
    }
}