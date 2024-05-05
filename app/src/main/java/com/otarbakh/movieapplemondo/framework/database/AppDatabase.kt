package com.otarbakh.movieapplemondo.framework.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.otarbakh.movieapplemondo.domain.local.FavoriteMoviesEntity
import com.otarbakh.movieapplemondo.domain.local.FavoriteMoviesEntityDao

@Database(entities = [FavoriteMoviesEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteMoviesDao(): FavoriteMoviesEntityDao
}