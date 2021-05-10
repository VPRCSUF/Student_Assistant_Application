package com.example.studentassistantapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.Nullable;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class ClassDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CourseInfo.db";
    public static final String TABLE_NAME = "Course_table";
    public static final String COL_1_COURSE_NAME = "COURSE";
    public static final String COL_2_PROFESSOR = "PROFESSOR";
    public static final String COL_3_UNITS = "UNITS";
    public static final String COL_4_START_TIME = "START_TIME";
    public static final String COL_5_END_TIME = "END_TIME";
    public static final String COL_6_DAYS = "DAYS";
    private static Context context;




    public ClassDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table " + TABLE_NAME + " (COURSE text primary key, PROFESSOR text, UNITS text, START_TIME text, END_TIME text, DAYS text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }


    // Takes inputed data and inserts it into the database.

    public boolean insertData(String course, String professor, String units, String start, String end, String days)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1_COURSE_NAME, course);
        contentValues.put(COL_2_PROFESSOR, professor);
        contentValues.put(COL_3_UNITS, units);
        contentValues.put(COL_4_START_TIME, start);
        contentValues.put(COL_5_END_TIME, end);
        contentValues.put(COL_6_DAYS, days);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // Pulls all the data from the database

    public Cursor viewData()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "Select * from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        return cursor;

    }

    // Deletes a single entry from the database

    public Integer deleteData (String course)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "COURSE = ?",new String[] {course});
    }


    // Updates a single entry from the database

    public boolean updateData(String course, String professor, String units, String start, String end, String days)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_2_PROFESSOR, professor);
        contentValues.put(COL_3_UNITS, units);
        contentValues.put(COL_4_START_TIME, start);
        contentValues.put(COL_5_END_TIME, end);
        contentValues.put(COL_6_DAYS, days);
        db.update(TABLE_NAME, contentValues, "COURSE = ?",new  String[] { course });
        return true;
    }
}
