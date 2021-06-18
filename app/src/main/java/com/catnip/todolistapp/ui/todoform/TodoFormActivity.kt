package com.catnip.todolistapp.ui.todoform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.catnip.todolistapp.App
import com.catnip.todolistapp.R
import com.catnip.todolistapp.data.model.Todo
import com.catnip.todolistapp.databinding.ActivityTodoFormBinding
import kotlin.random.Random

class TodoFormActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoFormBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setBackButton()
        binding.btnSaveTodo.setOnClickListener {
            saveTodo()
        }
    }

    private fun setBackButton() {
        supportActionBar?.title = getString(R.string.title_toolbar_todo_form_acitivity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun isFormTodoAlreadyFilled() : Boolean{
        val title = binding.etTaskTitle.text.toString()
        val desc = binding.etTaskDesc.text.toString()
        val imgUrl = binding.etHeaderImgUrl.text.toString()
        var isFormValid = true

        //checking title if not null or empty
        if(title.isEmpty()){
            isFormValid = false
            binding.tilTaskTitle.apply {
                isErrorEnabled = true
                error = context.getString(R.string.text_error_form_title_todo)
            }
        }else {
            binding.tilTaskTitle.isErrorEnabled = false
        }

        //checking desc if not null or empty
        if(desc.isEmpty()){
            isFormValid = false
            binding.tilTaskDesc.apply {
                isErrorEnabled = true
                error = context.getString(R.string.text_error_form_desc_todo)
            }
        }else {
            binding.tilTaskDesc.isErrorEnabled = false
        }

        //checking image url if not null or empty
        if(imgUrl.isEmpty()){
            isFormValid = false
            binding.tilTaskHeaderImgUrl.apply {
                isErrorEnabled = true
                error = context.getString(R.string.text_error_form_header_img_url_todo)
            }
        }else {
            binding.tilTaskHeaderImgUrl.isErrorEnabled = false
        }
        return isFormValid
    }

    private fun saveTodo(){
        if(isFormTodoAlreadyFilled()){
            //creating object data
            val todo = Todo(
                Random.nextInt(),
                binding.etTaskTitle.text.toString(),
                binding.etTaskDesc.text.toString(),
                binding.etHeaderImgUrl.text.toString(),
                false
            )
            //saving data to dummy database

            (application as App).getTodoDataSource()?.addTodo(todo)
            Toast.makeText(this, getString(R.string.text_toast_save_todo_success), Toast.LENGTH_SHORT).show()
            //closing form activity, back to main activity ( list of task )
            finish()
        }
    }

}