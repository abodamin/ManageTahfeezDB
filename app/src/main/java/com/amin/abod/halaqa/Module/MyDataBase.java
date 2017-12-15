package com.amin.abod.halaqa.Module;
/**
 * Created by abody on 12/6/2017.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class MyDataBase extends SQLiteOpenHelper{
    public static final String DB_NAME = "SQLite.db";
    public static final String DB_Table_Student = "Student";
    public static final String DB_Table_Parent = "Parent";
    public static final String DB_Table_Halaqa = "Halaqa";
    public static final String DB_Table_Teacher = "Teacher";

    public MyDataBase(Context context) {
        super(context, DB_NAME, null, 1);
    }

    public long setData(String sName, int studentSSN , String sHifz , String sHalaqa , String sMobile , int parentSSN){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("name", sName);
        contentValues.put("SSN", studentSSN);
        contentValues.put("Hifz", sHifz);
        contentValues.put("HalaqaName", sHalaqa);
        contentValues.put("Mobile", sMobile);
        contentValues.put("PSSN", parentSSN);
        long r = db.insert(DB_Table_Student, null, contentValues);

        return r;
    }

    public long setParentData(String parentName, int parentSSN, String parentMobile){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();

        contentValues2.put("Pname",parentName);
        contentValues2.put("SSN",parentSSN);
        contentValues2.put("Mobile",parentMobile);

        long r2 = db2.insert(DB_Table_Parent , null , contentValues2);
        return r2;
    }

    public long setHalaqaData(String halaqaName, String category, int halaqaTeacherSSN){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();

        contentValues2.put("Hname",halaqaName);
        contentValues2.put("category",category);
        contentValues2.put("HTSSN",halaqaTeacherSSN);

        long r2 = db2.insert(DB_Table_Halaqa , null , contentValues2);
        return r2;
    }

    public long setTeacherDate(int teacherSSN, String teacherName, String teacherMobile){
        SQLiteDatabase db2 = this.getWritableDatabase();
        ContentValues contentValues2 = new ContentValues();

        contentValues2.put("TSSN",teacherSSN);
        contentValues2.put("Tname",teacherName);
        contentValues2.put("Mobile",teacherMobile);

        long r2 = db2.insert(DB_Table_Teacher , null , contentValues2);
        return r2;
    }

    public Cursor getAllRecords(){
        SQLiteDatabase db = this.getReadableDatabase();
        return  db.rawQuery("select * from " + DB_Table_Student , null);

    }

    public Cursor getAllStudentsParents(){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from "+DB_Table_Parent, null);
    }

    public ArrayList getAllTeachers(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("select * from "+DB_Table_Teacher, null);
        result.moveToFirst();
        while (result.isAfterLast() == false){
            String a1 = result.getString(0);
            String a2 = result.getString(1);
            String a3 = result.getString(2);
            arrayList.add(a1 +" - "+ a2 +" - "+ a3 );
            result.moveToNext();
        }
        return arrayList;
    }

    public ArrayList getAllStudents(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("select * from "+DB_Table_Student, null);
        result.moveToFirst();
        while (result.isAfterLast() == false){
            String a1 = result.getString(1);
            String a2 = result.getString(0);
            String a3 = result.getString(3);
            String a4 = result.getString(2);
            String a5 = result.getString(4);
            arrayList.add(a1 +" - "+ a2 +" - "+ a3 +" - "+ a4 +" - "+ a5);
            result.moveToNext();
        }
        return arrayList;
    }

    public ArrayList getAllHalaqa(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("select * from "+DB_Table_Halaqa, null);
        result.moveToFirst();
        //Cursor teacherHalaqa = db.rawQuery("select Tname from "+DB_Table_Teacher+" where TSSN=HTSSN.Halaqa ",null);

        while (result.isAfterLast() == false){
            String a1 = result.getString(0);
            String a2 = result.getString(1);
            String a3 = result.getString(2);
            // Cursor teacherName = db.rawQuery("select Tname from "+DB_Table_Teacher+" where TSSN=",null);
            //  String a4 = teacherName.getString(0);
            //String a3 = teacherHalaqa.getString(0);

            arrayList.add(a1 +" - "+ a2 +" - "+ a3 );
            result.moveToNext();
        }
        return arrayList;
    }

    public boolean getParentBySSN(int pSSN){
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {"Pname"};
        String[] selectionArgs = {String.valueOf(pSSN)};
        boolean result = db.query(DB_Table_Parent, columns, "SSN = ?", selectionArgs, null, null, null, null).moveToFirst();

        return result;
    }

    public static int numOfRaws;
    public boolean updateStudentHifz(String newHifz , int Sid){    //update data of last soura
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put("Hifz",newHifz);
        numOfRaws = db.update(DB_Table_Student,contentValues,"SSN = ?",new String[] {String.valueOf(Sid)});  //id here should be as String because of the data table

        return true;
    }

    public ArrayList getAllHalaqa(){
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor result = db.rawQuery("select * from "+DB_Table_Halaqa, null);
        result.moveToFirst();
        //Cursor teacherHalaqa = db.rawQuery("select Tname from "+DB_Table_Teacher+" where TSSN=HTSSN.Halaqa ",null);

        while (result.isAfterLast() == false){
            String a1 = result.getString(0);
            String a2 = result.getString(1);
            String a3 = result.getString(2);
            // Cursor teacherName = db.rawQuery("select Tname from "+DB_Table_Teacher+" where TSSN=",null);
            //  String a4 = teacherName.getString(0);
            //String a3 = teacherHalaqa.getString(0);

            arrayList.add(a1 +" - "+ a2 +" - "+ a3 );
            result.moveToNext();
        }
        return arrayList;
    }

    @Override
    public void onConfigure(SQLiteDatabase db){
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table "+ DB_Table_Student +" ( " +       //Student
                "  SSN INTEGER " +
                ", name TEXT " +
                ", Hifz TEXT " +
                ", HalaqaName TEXT" +
                ", Mobile TEXT" +
                ", PSSN INTEGER" +
                ",FOREIGN KEY(HalaqaName) REFERENCES "+DB_Table_Halaqa+"(Hname) ON DELETE CASCADE " +
                ",FOREIGN KEY(PSSN) REFERENCES "+DB_Table_Parent+"(SSN) ON UPDATE CASCADE " +
                ", PRIMARY KEY(SSN) )");   // student  F,L



        db.execSQL("create table "+ DB_Table_Parent +" (" +     //parent
                "SSN INTEGER ," +
                "Pname TEXT ," +
                "Mobile TEXT ," +
                "PRIMARY KEY(SSN))"
        );

        db.execSQL("create table "+ DB_Table_Halaqa+" " +   //Halaqa
                "( Hname TEXT " +   //Halaqa name
                ",category TEXT" +  //categoru of Halaqa
                ", HTSSN INTEGER" +  //Halaqa Teacher ID
                ", FOREIGN KEY(HTSSN) REFERENCES "+DB_Table_Teacher+"(TSSN) " +
                ", PRIMARY KEY(Hname) )");

        db.execSQL("create table "+DB_Table_Teacher +"(" +  //teacher
                " TSSN INTEGER" +     //teacher SSN
                ",Tname TEXT" +     //* F,L
                ",Mobile TEXT" +
                ", PRIMARY KEY (TSSN) )");

    }
    //create table created_topics_table (Pid INTEGER PRIMARY KEY , FOREIGN KEY(Pid) REFERENCES DB_Table_Student(id))
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+ DB_Table_Student);
        onCreate(db);
    }
}

