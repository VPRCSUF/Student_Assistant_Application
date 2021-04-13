package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class ClassInfo extends AppCompatActivity {

    ClassDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_info);
        myDb = new ClassDatabaseHelper(this);

        Intent i = getIntent();
        String course = i.getStringExtra("COURSE");

        Cursor classInfo = myDb.getClassInfo(course);

        ((TextView) findViewById(R.id.class_name)).setText(course);
        ((TextView) findViewById(R.id.start_time)).setText(course);
        ((TextView) findViewById(R.id.end_time)).setText(course);
        ((TextView) findViewById(R.id.professor)).setText(course);
        ((TextView) findViewById(R.id.unit)).setText(course);
        ((TextView) findViewById(R.id.days)).setText(course);




    }
}