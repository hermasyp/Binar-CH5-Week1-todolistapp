package com.catnip.todolistapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.catnip.todolistapp.R
import com.catnip.todolistapp.databinding.ActivityMainBinding
import com.catnip.todolistapp.ui.todolist.TodoListFragment
import com.catnip.todolistapp.utils.views.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewPager()
    }

    private fun initViewPager(){
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager,lifecycle)
        viewPagerAdapter.addFragment(TodoListFragment.newInstance(false),getString(R.string.title_tab_todo_undone))
        viewPagerAdapter.addFragment(TodoListFragment.newInstance(true),getString(R.string.title_tab_todo_done))
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }
        TabLayoutMediator(binding.tabLayout,binding.viewPager) { tab, position ->
            tab.text = viewPagerAdapter.getPageTitle(position)
        }.attach()
    }

}