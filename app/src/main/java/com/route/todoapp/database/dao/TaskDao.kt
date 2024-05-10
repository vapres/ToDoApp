package com.route.todoapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.route.todoapp.database.model.Task
import kotlinx.coroutines.selects.select

@Dao
interface TaskDao {
    @Insert
    fun addTask(task: Task)

    @Update
    fun updateTask(task: Task)

    @Delete
    fun deleteTask(task: Task)

    @Query("select * from task")
    fun getAllTasks(): List<Task>

    @Query("select * from task where dateTime = :dateTime")
    fun getTasksByDate(dateTime: Long): List<Task>
}