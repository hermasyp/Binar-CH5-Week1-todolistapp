package com.catnip.todolistapp.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.catnip.todolistapp.data.model.Todo
import com.catnip.todolistapp.databinding.ItemTodoBinding

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class TodoAdapter(val itemClick: (Todo) -> Unit) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    var items : List<Todo> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class TodoViewHolder(
        private val binding: ItemTodoBinding,
        private val itemClick: (Todo) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Todo) {
            with(item) {
                binding.tvTitleItemTask.text = title
                itemView.setOnClickListener {
                    itemClick(this)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        //for creating new object of view holder based on items
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        //binding view holder based on items position in every items
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}