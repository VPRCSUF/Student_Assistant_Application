package com.example.studentassistantapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addClass extends AppCompatActivity {

    ClassDatabaseHelper myDb;
    EditText addCourseName, addProfessor, addUnits, addStart, addEnd, addDays;
    Button subBut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_class);
        myDb = new ClassDatabaseHelper(this);

        addCourseName = (EditText) findViewById(R.id.add_class_name);
        addProfessor = (EditText) findViewById(R.id.add_professor);
        addUnits = (EditText) findViewById(R.id.add_unit);
        addStart = (EditText) findViewById(R.id.add_start_time);
        addEnd = (EditText) findViewById(R.id.add_end_time);
        addDays = (EditText) findViewById(R.id.add_days);
        subBut = (Button) findViewById(R.id.submit);

        AddData();

    }


       public void AddData() {
        subBut.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(
                                addCourseName.getText().toString(),
                                addProfessor.getText().toString(),
                                addUnits.getText().toString(),
                                addStart.getText().toString(),
                                addEnd.getText().toString(),
                                addDays.getText().toString());

                        if (isInserted == true) {
                            Toast.makeText(addClass.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(addClass.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}