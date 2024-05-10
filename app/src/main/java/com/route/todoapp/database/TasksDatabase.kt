package com.route.todoapp.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.route.todoapp.database.dao.TaskDao
import com.route.todoapp.database.model.Task
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [Task::class], version = 1, exportSchema = true)
abstract class TasksDatabase : RoomDatabase() {
    abstract fun tasksDao(): TaskDao

    companion object {
        private const val DATABASE_NAME = "tasks_database"
        private var INSTANCE: TasksDatabase? = null

        fun getInstance(context: Context):TasksDatabase {
            if (INSTANCE == null) {
                val db = Room.databaseBuilder(
                    context.applicationContext,
                    TasksDatabase::class.java,
                    DATABASE_NAME
                ).build()
                INSTANCE = db
            }
            return INSTANCE!!
        }
    }
}
