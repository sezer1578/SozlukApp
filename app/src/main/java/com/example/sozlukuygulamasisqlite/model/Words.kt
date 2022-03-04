package com.example.sozlukuygulamasisqlite.model

import java.io.Serializable

data class Words(var wordId: Int, var english: String, var turkish: String) : Serializable {
}