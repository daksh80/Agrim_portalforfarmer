package com.example.agrim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    Button btnLogout;
    private Button MandiPrice;
    private Button Maps;
    private Button Weather;
    private Button Details;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListeer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ImageView imageView = findViewById(R.id.imageView);
        AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
        animationDrawable.start();
        btnLogout = findViewById(R.id.Button);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View View) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(intToMain);

            }
        });

        MandiPrice = findViewById(R.id.button2);
        MandiPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMandi();
            }
        });
        Maps = findViewById(R.id.button3);
        Maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaps();
            }
        });
        Weather = findViewById(R.id.button4);
        Weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWeather();
            }
        });
        Details = findViewById(R.id.button6);
        Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails();
            }
        });
    }


        public void openMandi()
        {
            Intent intent = new Intent(this,Mandi.class);
            startActivity(intent);
        }
        public void openMaps()
        {
            Intent intent =new Intent(this,Maps.class);
            startActivity(intent);
        }
    public void openWeather()
    {
        Intent intent =new Intent(this,Weather.class);
        startActivity(intent);
    }
    public void openDetails()
    {
        Intent intent =new Intent(this,Details.class);
        startActivity(intent);
    }


}
