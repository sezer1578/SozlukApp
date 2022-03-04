package com.example.sozlukuygulamasisqlite.database

import com.example.sozlukuygulamasisqlite.model.Words

class WordsDAO {

    fun allWords(dp:DatabaseHelper) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val db = dp.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler",null)

        while (c.moveToNext()) {
            val word = Words(c.getInt(c.getColumnIndex("kelime_id"))
                ,c.getString(c.getColumnIndex("ingilizce"))
            ,c.getString(c.getColumnIndex("turkce")))
            wordsList.add(word)
        }
        return wordsList
    }
    fun doSearch(dp:DatabaseHelper, searchWords:String) : ArrayList<Words>{
        val wordsList = ArrayList<Words>()
        val db = dp.writableDatabase
        val c = db.rawQuery("SELECT * FROM kelimeler WHERE ingilizce like '%$searchWords'",null)

        while (c.moveToNext()) {
            val word = Words(c.getInt(c.getColumnIndex("kelime_id"))
                ,c.getString(c.getColumnIndex("ingilizce"))
                ,c.getString(c.getColumnIndex("turkce")))
            wordsList.add(word)
        }
        return wordsList

    }
}