package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.TodoItemBinding

class TodoAdapter(var datalist : ArrayList<String>):RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TodoItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).linkAdapter(this)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datalist[position])
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

}

class ViewHolder(private val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var adapter : TodoAdapter;
    fun bind(get: String) {
        binding.todo.text = get
        binding.deleteButton.setOnClickListener(View.OnClickListener() {
            var position = adapterPosition
            if(position != RecyclerView.NO_POSITION){
                adapter.datalist.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        })
    }
    fun linkAdapter(adapter: TodoAdapter) : ViewHolder{
        this.adapter = adapter
        return this
    }
}