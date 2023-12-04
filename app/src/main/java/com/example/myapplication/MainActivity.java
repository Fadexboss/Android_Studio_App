package com.example.myapplication;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView No = findViewById(R.id.No);
        final TextView Ad = findViewById(R.id.Ad);

        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        // Buton ve Textviewler için animasyonu başlat
        button1.startAnimation(fadeInAnimation);
        button2.startAnimation(fadeInAnimation);
        button3.startAnimation(fadeInAnimation);
        No.startAnimation(fadeInAnimation);
        Ad.startAnimation(fadeInAnimation);



        button1.setOnClickListener(view -> {
            // Butona tıklandığında yapılacak işlemler buraya yazılır
            Intent intent = new Intent(MainActivity.this, FirstActivity.class);
            startActivity(intent);
        });
        button2.setOnClickListener(view -> {
            // Butona tıklandığında yapılacak işlemler buraya yazılır
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
        button3.setOnClickListener(view -> {
            // Butona tıklandığında yapılacak işlemler buraya yazılır
            Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
            startActivity(intent);
        });
    }
}


