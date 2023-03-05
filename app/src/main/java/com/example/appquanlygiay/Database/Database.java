package com.example.appquanlygiay.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    //truy van ko tra ket qua insert,update
    public void QueryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);//thuc thi cau lenh
    }
    //truy van tra ket qua select ko co dieu kien
    public Cursor GetData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,null); // thuc hien cau lenh truy van truc tiep
    }
    //truy van tra ket qua select co dieu kien
    public Cursor GetData_Condition(String sql,String[] condition){
        SQLiteDatabase database=getReadableDatabase();
        return database.rawQuery(sql,condition); // thuc hien cau lenh truy van truc tiep
    }
    //truy van tra ket qua select ko co dieu kien
    public long insertData(String nameTable, ContentValues valuse){
        SQLiteDatabase database=getWritableDatabase();
        return database.insert(nameTable,null,valuse);
    }
    public int updateData(String nameTabale,ContentValues values,String condition,String[] conditionArgs){
        SQLiteDatabase database=getWritableDatabase();
        return database.update(nameTabale,values,condition,conditionArgs);
    }
    public int deleteData(String nameTabale,String condition,String[] conditionArgs){
        SQLiteDatabase database=getWritableDatabase();
        return database.delete(nameTabale,condition,conditionArgs);
    }

}
