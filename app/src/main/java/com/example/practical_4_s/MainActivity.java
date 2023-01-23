package com.example.practical_4_s;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.annotation.SuppressLint;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    ImageButton imgbtn;
    Button explicitIntent, implicitIntent;
    String[] courses = { "C","C++","JAVA","Data structures",
            "Interview prep", "Algorithms","CRNS","AWS","Cloud",
            "DSA with java", "OS" };
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbtn =(ImageButton) findViewById(R.id.imageButton);
        imgbtn.setOnClickListener(this);
        implicitIntent = findViewById(R.id.implecitInt);
        implicitIntent.setOnClickListener(this);
        explicitIntent = findViewById(R.id.explecitInt);
        explicitIntent.setOnClickListener(this);


        Spinner spin = findViewById(R.id.coursesspinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(ad);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),
                        courses[position],
                        Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }




    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.imageButton){
            Toast.makeText(MainActivity.this, "Clicked on Image", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.explecitInt){
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        } else if(v.getId() == R.id.implecitInt){
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 1);
        }
    }
}