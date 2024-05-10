package com.route.todoapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.todoapp.database.model.Task
import com.route.todoapp.databinding.TaskItemBinding

class TasksAdapter(private var taskList: MutableList<Task>? = null) :
    RecyclerView.Adapter<TasksAdapter.ViewHolder>() {


    class ViewHolder(private val itemBinding: TaskItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(task: Task) {
            itemBinding.taskTitle.text = task.title
            itemBinding.time.text = task.dateTime.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding: TaskItemBinding =
            TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount() = taskList?.size ?: 0


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        taskList!![position]
    }

    fun changeData(allTasks: List<Task>) {
        taskList?.clear()
        taskList?.addAll(allTasks)
        notifyDataSetChanged()
    }
}