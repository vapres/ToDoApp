package com.route.todoapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.route.todoapp.R
import com.route.todoapp.databinding.ActivityHomeBinding
import com.route.todoapp.fragments.AddTaskBottomSheet
import com.route.todoapp.fragments.SettingsFragment
import com.route.todoapp.fragments.TasksFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        binding.fabAddTask.setOnClickListener {
            showAddTaskBottomSheet()
        }
    }

    private fun showAddTaskBottomSheet() {
        val addTask = AddTaskBottomSheet()
        addTask.show(supportFragmentManager, null)
    }

    private fun initViews() {
        binding.bottomNavbar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.ic_tasks -> {
                    pushFragment(TasksFragment())
                }

                R.id.ic_settings -> {
                    pushFragment(SettingsFragment())
                }
            }
            true
        }
        binding.bottomNavbar.selectedItemId = R.id.ic_tasks
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.content.fragmentContainer.id, fragment)
            .commit()
    }
}