package com.catnip.todolistapp.ui.todolist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.catnip.todolistapp.App
import com.catnip.todolistapp.data.constant.Constant
import com.catnip.todolistapp.databinding.FragmentTodoListBinding
import com.catnip.todolistapp.ui.detail.DetailTaskActivity
import com.catnip.todolistapp.ui.todolist.adapter.TodoAdapter


class TodoListFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var isFilterTaskCompleted: Boolean = false
    private lateinit var binding: FragmentTodoListBinding
    private lateinit var todoAdapter: TodoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isFilterTaskCompleted = it.getBoolean(ARG_PARAM_IS_TASK_COMPLETE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initList()
    }

    private fun initList() {
        todoAdapter = TodoAdapter {
            val intent = Intent(context, DetailTaskActivity::class.java)
            intent.putExtra(Constant.EXTRAS_TODO_DATA, it)
            startActivity(intent)
        }
        binding.rvTask.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = todoAdapter
        }
        // todoAdapter.items = generateDummyData()
        (activity?.application as App)
            .getTodoDataSource()?.getTodosByStatus(isFilterTaskCompleted)?.let {
                todoAdapter.items = it
            }
    }

    companion object {
        private const val ARG_PARAM_IS_TASK_COMPLETE = "ARG_PARAM_IS_TASK_COMPLETE"

        @JvmStatic
        fun newInstance(isFilteredByTaskComplete: Boolean) =
            TodoListFragment().apply {
                arguments = Bundle().apply {
                    putBoolean(ARG_PARAM_IS_TASK_COMPLETE, isFilteredByTaskComplete)
                }
            }
    }
}