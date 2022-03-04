package com.example.sozlukuygulamasisqlite.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.sozlukuygulamasisqlite.DetailActivity
import com.example.sozlukuygulamasisqlite.R
import com.example.sozlukuygulamasisqlite.model.Words

class WordsAdapter(private val mContext: Context, private val wordLists: List<Words>) : RecyclerView.Adapter<WordsAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design:View) : RecyclerView.ViewHolder(design){
        var wordsCard:CardView
        var textviewEnglish:TextView
        var textviewTurkish:TextView

        init {
            wordsCard = design.findViewById(R.id.wordsCard)
            textviewEnglish = design.findViewById(R.id.textViewEnglish)
            textviewTurkish = design.findViewById(R.id.textViewTurkish)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.card_design,parent,false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val word = wordLists.get(position)
        holder.textviewEnglish.text = word.english
        holder.textviewTurkish.text = word.turkish

        holder.wordsCard.setOnClickListener {
            val intent = Intent(mContext,DetailActivity::class.java)
            intent.putExtra("object",word)
            mContext.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return wordLists.size
    }
}