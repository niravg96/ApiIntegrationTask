package com.example.mytask.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mytask.Model.User
import com.example.mytask.databinding.UserDataRowBinding

class userDetailsAdapter(val userList: List<User?>) : RecyclerView.Adapter<userDetailsAdapter.ViewHolder>(){

    class ViewHolder(binding:UserDataRowBinding) : RecyclerView.ViewHolder(binding.root){

        val name = binding.userNameTxt
        val email = binding.userEmailTxt
        val phone = binding.userPhoneTxt
        val address = binding.userAddressTxt
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = UserDataRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return userList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val userData = userList[position]

        holder.name.setText("Name : "+userData!!.name)
        holder.email.setText("Email : "+userData.email)
        holder.phone.setText("Phone : "+userData.phone)
        holder.address.setText("Street : "+userData.address.street +"\n"+"City : "+userData.address.city +"\n"+"Zip code : "+userData.address.zipcode)
    }
}