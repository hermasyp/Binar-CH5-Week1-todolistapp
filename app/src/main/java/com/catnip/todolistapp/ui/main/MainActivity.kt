package com.catnip.todolistapp.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.catnip.todolistapp.R
import com.catnip.todolistapp.databinding.ActivityMainBinding
import com.catnip.todolistapp.ui.aboutdialog.AboutDialogFragment
import com.catnip.todolistapp.ui.todoform.TodoFormActivity
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //inflate menu layout that we created before
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //to handle every click event in the menu
        return when(item.itemId){
            R.id.menu_add_todo ->{
                //todo : navigate to Todo Form Activity
                navigateToFormTodo()
                true
            }
            R.id.menu_about ->{
                //todo : show dialog about app
                AboutDialogFragment().show(supportFragmentManager,null)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun navigateToFormTodo(){
        startActivity(Intent(this,TodoFormActivity::class.java))
    }

}