package com.example.scratchapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.scratchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val todolist1= mutableListOf(
            Todo("make breakfast",false),
            Todo("poop time",false),
            Todo("hehehehe", false),
            Todo("hadfasdfasdas", true),
            Todo("qwerty",false),
            Todo("asdfg",false),
            Todo("zxcv bnn" , false),
            Todo("opkklp",false)
        )


        val adapter= TodoAdapter(todolist1)
        binding.rvTodo.adapter= adapter
        binding.rvTodo.layoutManager= LinearLayoutManager(this)



        binding.btAdd.setOnClickListener{
            val title= binding.etTodo.text.toString()
            val todo = Todo(title,false)
            todolist1.add(todo)
            adapter.notifyItemInserted(todolist1.size-1)
        }


    }

}