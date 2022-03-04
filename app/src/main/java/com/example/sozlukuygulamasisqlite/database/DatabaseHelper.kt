package com.example.sozlukuygulamasisqlite.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context,"sozluk.sqlite",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS 'kelimeler'(" +
                "'kelime id' INTEGER PRIMARY KEY AUTOINCREMENT," +
                "'ingilizce' TEXT," +
                "'turkce' TEXT);")

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS kelimeler")
        onCreate(db)

    }
}