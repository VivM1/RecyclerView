package com.example.scratchapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.scratchapp.databinding.ItemTodoBinding

class TodoAdapter(var todos : List<Todo>): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>()
/* a object is created of the model class extending from recyclerview adapter*/
{
    inner class TodoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)   /* a custom view holder is defined  */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
       /* inflates the .xml file , the root layout is inflated, attachment to root is false because the recycler is to be attached and view binding is used so val bindning....*/
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo,parent, false)

        return TodoViewHolder(ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent,false ))
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        /* holder is used to access the views inside viewholder i.e chkcox and textview here */
        holder.binding.tvTitle.text = todos[position].title // earlier whn it was showing the whole to do list tab i had used .toString and
                                                            // it returned obj as a whole but i had to only show the title of the to do in the app so i used .title as i should
        holder.binding.checkbox.isChecked = todos[position].isChecked
    }


    override fun getItemCount(): Int {
        return todos.size
    }
}

