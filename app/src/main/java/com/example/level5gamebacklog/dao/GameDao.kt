package com.example.level5gamebacklog.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.level5gamebacklog.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM gameTable")
    fun getAllGames(): LiveData<List<Game>>

    @Insert
    suspend fun insertGame(game: Game)

    @Delete
    suspend fun deleteGame(game: Game)




}