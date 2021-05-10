package com.example.studentassistantapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Moves to an activity that allows the user to enter a class into the database
    public void goToAddClass(View v)
    {
        Intent i = new Intent(this, addClass.class);
        startActivity(i);
    }

    // Moves to an activity that displays all the classes that are in the database
    public void goToMyCourses(View v)
    {
        Intent i = new Intent(this, MyCourses.class);
        startActivity(i);
    }

}

