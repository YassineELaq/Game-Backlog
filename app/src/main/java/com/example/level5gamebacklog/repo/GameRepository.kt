package com.example.level5gamebacklog.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.level5gamebacklog.dao.GameDao
import com.example.level5gamebacklog.db.GameRoomDatabase
import com.example.level5gamebacklog.model.Game

class GameRepository (context: Context) {


    private var gameDao :GameDao?


    init {
        val gameRoomDatabase = GameRoomDatabase.getReminderRoomDatabse(context)
        gameDao = gameRoomDatabase?.gameDoa()
    }

    fun getAllGames(): LiveData<List<Game>>{
        return gameDao?.getAllGames() ?: MutableLiveData(emptyList())
    }

    suspend fun insertGame(game: Game){
        gameDao?.insertGame(game)
    }

    suspend fun deleteGame(game: Game){

        gameDao?.deleteGame(game)
    }

}