package com.example.level5gamebacklog.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.level5gamebacklog.model.Game
import com.example.level5gamebacklog.repo.GameRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {

    private val gameRepository = GameRepository(application.applicationContext)

    val games : LiveData<List<Game>> = gameRepository.getAllGames()

    private val ioScope = CoroutineScope(Dispatchers.IO)

    fun insertGame(game: Game){

        ioScope.launch {
            gameRepository.insertGame(game)
        }
    }



    fun deleteGame(game: Game){

        ioScope.launch {
            gameRepository.deleteGame(game)
        }
    }
}