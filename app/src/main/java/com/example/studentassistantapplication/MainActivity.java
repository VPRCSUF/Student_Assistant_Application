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

    public void goToAddClass(View v)
    {
        Intent i = new Intent(this, addClass.class);
        startActivity(i);
    }

    public void goToMyCourses(View v)
    {
        Intent i = new Intent(this, MyCourses.class);
        startActivity(i);
    }

}

