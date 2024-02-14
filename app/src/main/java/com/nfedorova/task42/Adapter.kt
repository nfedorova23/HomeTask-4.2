package com.nfedorova.task42

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val users: MutableList<User>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val user = users[position]
        with(holder) {
            photo.setImageResource(user.image)
            firstName.text = user.firstName
            lastName.text = user.lastName
            number.text = user.phoneNumber

            itemView.setOnClickListener {
                (itemView.context as? MainActivity)?.editFragment(user)
            }
        }
    }

    override fun getItemCount(): Int = users.size

    @SuppressLint("NotifyDataSetChanged")
    fun update() {
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo: ImageView = itemView.findViewById(R.id.photo)
        val firstName: TextView = itemView.findViewById(R.id.firstname)
        val lastName: TextView = itemView.findViewById(R.id.lastname)
        val number: TextView = itemView.findViewById(R.id.phone)
    }
}