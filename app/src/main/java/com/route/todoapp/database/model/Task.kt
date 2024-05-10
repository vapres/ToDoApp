package com.route.todoapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val tId: Int,
    @ColumnInfo(name = "name")
    var title: String? = null,
    @ColumnInfo(name = "desc")
    var description: String? = null,
    var dateTime: Long? = null,
    var isDone: Boolean? = null
)