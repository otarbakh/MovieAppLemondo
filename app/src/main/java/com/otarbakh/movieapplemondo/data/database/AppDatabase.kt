package com.otarbakh.movieapplemondo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavoriteMoviesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteMoviesDao(): FavoriteMoviesEntityDao
}