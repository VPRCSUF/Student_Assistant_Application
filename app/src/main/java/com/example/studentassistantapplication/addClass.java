package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class addClass extends AppCompatActivity {

    ClassDatabaseHelper myDb = new ClassDatabaseHelper(this);
    EditText addCourseName, addProfessor, addUnits, addStart, addEnd, addDays;
    Button subBut;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);

        addCourseName = (EditText)findViewById(R.id.add_class_name);
        addProfessor = (EditText)findViewById(R.id.add_professor;
        addUnits = (EditText)findViewById(R.id.add_unit);
        addStart = (EditText)findViewById(R.id.add_start_time);
        addEnd = (EditText)findViewById(R.id.add_end_time);
       // addDays = (EditText)findViewById(R.id.); Need to work out how to store days
        subBut = (Button)findViewById(R.id.submit);

    }
}