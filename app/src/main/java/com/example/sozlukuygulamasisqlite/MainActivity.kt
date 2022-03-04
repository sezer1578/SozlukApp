package com.example.sozlukuygulamasisqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sozlukuygulamasisqlite.adapter.WordsAdapter
import com.example.sozlukuygulamasisqlite.database.DatabaseHelper
import com.example.sozlukuygulamasisqlite.database.WordsDAO
import com.example.sozlukuygulamasisqlite.model.Words
import com.info.sqlitekullanimihazirveritabani.DatabaseCopyHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , SearchView.OnQueryTextListener{

    private lateinit var wordsList:ArrayList<Words>
    private lateinit var adapter:WordsAdapter
    private lateinit var dp:DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseCopy()
        toolbar.title = "English - Türkçe Sözlük"
        setSupportActionBar(toolbar)

        rv.setHasFixedSize(true)
        rv.layoutManager = LinearLayoutManager(this)

        dp = DatabaseHelper(this)
        wordsList = WordsDAO().allWords(dp)

        adapter = WordsAdapter(this,wordsList)
        rv.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu?.findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView
        searchView.setOnQueryTextListener(this)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }
    fun databaseCopy(){
        val copyHelper = DatabaseCopyHelper(this)
        try {
            copyHelper.createDataBase()
            copyHelper.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun search(searchWord:String){
        wordsList = WordsDAO().doSearch(dp,searchWord)
        adapter = WordsAdapter(this,wordsList)
        rv.adapter = adapter
    }
}