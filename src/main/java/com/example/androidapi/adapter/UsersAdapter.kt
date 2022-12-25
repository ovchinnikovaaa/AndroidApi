package com.example.androidapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.androidapi.R
import com.example.androidapi.models.User


class UsersAdapter(private val context: Context, private val userList: ArrayList<User>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): User {
        return userList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        val rowView = inflater.inflate(R.layout.houses_list_item, parent, false)

        val idTextView = rowView.findViewById(R.id.user_id) as TextView
        val nameTextView = rowView.findViewById(R.id.name) as TextView
        val usernameTextView = rowView.findViewById(R.id.username) as TextView
        val emailTextView = rowView.findViewById(R.id.email) as TextView

        val user = getItem(position) as User

        idTextView.text = user.id
        nameTextView.text = user.name
        usernameTextView.text = user.username
        emailTextView.text = user.email

        return rowView
    }

}