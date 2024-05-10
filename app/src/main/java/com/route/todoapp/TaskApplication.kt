package com.route.todoapp

import android.app.Application
import com.route.todoapp.database.TasksDatabase

class TaskApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TasksDatabase.getInstance(this)
    }
}