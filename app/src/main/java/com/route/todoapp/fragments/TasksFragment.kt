package com.route.todoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.route.todoapp.adapters.TasksAdapter
import com.route.todoapp.database.TasksDatabase
import com.route.todoapp.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        retrieveTasksList()
    }

    private fun retrieveTasksList() {
        val allTasks = TasksDatabase.getInstance().getTasksDao().getAllTasks()
        adapter.changeData(allTasks)
    }

    private val adapter = TasksAdapter()
    private fun initRecyclerView() {
        binding.rvTasks.adapter = adapter
    }
}