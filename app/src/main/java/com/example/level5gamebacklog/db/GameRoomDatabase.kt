package com.example.level5gamebacklog.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.level5gamebacklog.dao.GameDao
import com.example.level5gamebacklog.model.Game
import com.example.level5learningtask1notepad.extra.Converters


@Database(entities = [Game::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)

abstract class GameRoomDatabase : RoomDatabase() {

    abstract fun gameDoa(): GameDao
    companion object {


        private const val DB_NAME = "gameDb3"
        @Volatile
        private var gameRoomDatabase: GameRoomDatabase? = null

        fun getReminderRoomDatabse(context: Context): GameRoomDatabase? {
            if (gameRoomDatabase != null) return gameRoomDatabase
            synchronized(GameRoomDatabase::class.java) {
                if (gameRoomDatabase == null) {
                    gameRoomDatabase = Room.databaseBuilder(
                        context.applicationContext,
                        GameRoomDatabase::class.java, DB_NAME
                    )

                        .build()
                }
            }
            return gameRoomDatabase
        }
    }


}