package com.example.studentassistantapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ClassDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "CourseInfo.db";
    public static final String TABLE_NAME = "Course_table";
    public static final String COL_1_COURSE_NAME = "COURSE";
    public static final String COL_2_PROFESSOR = "PROFESSOR";
    public static final String COL_3_UNITS = "UNITS";
    public static final String COL_4_START_TIME = "START_TIME";
    public static final String COL_5_END_TIME = "END_TIME";
    public static final String COL_6_DAYS = "DAYS";




    public ClassDatabaseHelper(/*@Nullable*/ Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
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
}
