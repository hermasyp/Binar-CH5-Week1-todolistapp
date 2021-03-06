package com.catnip.todolistapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.catnip.todolistapp.App
import com.catnip.todolistapp.R
import com.catnip.todolistapp.data.constant.Constant
import com.catnip.todolistapp.data.model.Todo
import com.catnip.todolistapp.databinding.ActivityDetailTaskBinding
import com.catnip.todolistapp.utils.ShareUtils
import com.google.android.material.snackbar.Snackbar

class DetailTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTaskBinding
    private var todo: Todo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getIntentData()
        bindData()
    }

    private fun getIntentData() {
        todo = intent?.getParcelableExtra(Constant.EXTRAS_TODO_DATA)
    }

    private fun bindData() {
        supportActionBar?.hide()
        binding.tvDescDetailTask.text = todo?.desc
        binding.tvTitleDetailTask.text = todo?.title
        Glide.with(this)
            .load(todo?.headerImageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_placeholder)
            .into(binding.ivHeaderDetailTask)
        binding.ivShare.setOnClickListener {
            //todo : do share
            ShareUtils.shareText(
                this,
                "Title Task : ${todo?.title}\nDesc Task :  ${todo?.desc}"
            )
        }
        setFABIcon()
        binding.fabChangeTodoStatus.setOnClickListener {
            setTodoStatus()
        }
    }

    private fun setFABIcon(){
        binding.fabChangeTodoStatus.setImageResource(
            if (todo?.isTaskCompleted == true) R.drawable.ic_todo_done_true else R.drawable.ic_todo_done_false
        )
    }
    private fun setTodoStatus(){
        todo?.let {
            (application as App).getTodoDataSource()?.changeTodoStatus(it.id)
            todo = todo?.apply { isTaskCompleted = isTaskCompleted.not() }
            setFABIcon()
            if(todo?.isTaskCompleted == true){
                Snackbar.make(binding.root,getString(R.string.text_snackbar_change_status_done),Snackbar.LENGTH_SHORT).show()
            }else{
                Snackbar.make(binding.root,getString(R.string.text_snackbar_change_status_undone),Snackbar.LENGTH_SHORT).show()
            }
        }
    }


}