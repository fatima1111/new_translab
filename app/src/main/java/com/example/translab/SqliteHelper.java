package com.example.translab;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {

     String CREATE_TABLE_QUERY = "Create table " + Employee.TABLE_NAME + "(" +
             Employee.EmployeeContract._ID + "INTEGER PRIMARY KEY," +
             Employee.EmployeeContract.COLUMN_NAME + " TEXT NOT NULL," +
             Employee.EmployeeContract.COLUMN_EMAIL + " TEXT NOT NULL," +
             Employee.EmployeeContract.COLUMN_COMPANY + " TEXT NOT NULL," +
             Employee.EmployeeContract.COLUMN_PHONE + " TEXT NOT NULL," +
             Employee.EmployeeContract.COLUMN_CONTACT + " TEXT NOT NULL " + ")";


    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private SQLiteDatabase sqLiteDatabase;

    public SqliteHelper(Context context) {
        super(context,Employee.DATABASE_NAME,null,101);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_QUERY);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insertDataIntoTable(String name,String email,String company,String phnNum,String contact){

        ContentValues contentValues = new ContentValues();
        contentValues.put(Employee.EmployeeContract.COLUMN_NAME,name);
        contentValues.put(Employee.EmployeeContract.COLUMN_EMAIL,email);
        contentValues.put(Employee.EmployeeContract.COLUMN_COMPANY,company);
        contentValues.put(Employee.EmployeeContract.COLUMN_PHONE,phnNum);
        contentValues.put(Employee.EmployeeContract.COLUMN_CONTACT,contact);

        sqLiteDatabase = getWritableDatabase();

        long rowId = sqLiteDatabase.insert(Employee.TABLE_NAME,null,contentValues);

        return rowId;

    }
}
