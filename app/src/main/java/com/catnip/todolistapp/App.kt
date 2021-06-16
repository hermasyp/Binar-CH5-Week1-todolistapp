package com.catnip.todolistapp

import android.app.Application
import com.catnip.todolistapp.data.datasource.TodoDataSource

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class App : Application(){
    private var todoDataSource : TodoDataSource? = null

    override fun onCreate() {
        super.onCreate()
        todoDataSource = TodoDataSource()
    }

    fun getTodoDataSource() : TodoDataSource? = todoDataSource

}