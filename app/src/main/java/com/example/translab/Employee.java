package com.example.translab;

import android.provider.BaseColumns;

public final class Employee {

    public static final String DATABASE_NAME = "company";
    public static final String TABLE_NAME = "employee";

    private Employee(){}

    public static class EmployeeContract implements BaseColumns{

        public static String COLUMN_NAME = "Employee_Name";
        public static String COLUMN_EMAIL = "Employee_Email";
        public static String COLUMN_COMPANY = "Employee_Company";
        public static String COLUMN_PHONE = "Employee_Phone";
        public static String COLUMN_CONTACT = "Employee_Contact";

    }
}
