package com.example.m19_location.presentation

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.m19_location.databinding.MyListphotoBinding
import com.example.m19_location.entity.Gallery
import java.time.LocalDate

class MyListAdapter(
    val onClickPhoto: (Gallery) -> Unit,
) : ListAdapter<Gallery, MyListAdapter.MyViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            MyListphotoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("SetTextI18n", "SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val item = getItem(position)

        Glide
            .with(holder.binding.photo)
            .load(item.photo)
            .into(holder.binding.photo)


        val currentDate = LocalDate.now().toString()
        holder.binding.currentDate.text = currentDate

        holder.binding.root.setOnClickListener {
            onClickPhoto(item)
            Toast.makeText(it.context, "Clicked item: $item", Toast.LENGTH_SHORT).show()
        }

    }


    class DiffUtilCallback : DiffUtil.ItemCallback<Gallery>() {
        override fun areItemsTheSame(oldItem: Gallery, newItem: Gallery): Boolean =
            oldItem.photo == newItem.photo

        override fun areContentsTheSame(oldItem: Gallery, newItem: Gallery): Boolean =
            oldItem == newItem
    }

    class MyViewHolder(val binding: MyListphotoBinding) : RecyclerView.ViewHolder(binding.root)
}
