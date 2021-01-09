package com.ujjwal.softuserreplica.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ujjwal.softuserreplica.R
import com.ujjwal.softuserreplica.model.Student
import de.hdodenhof.circleimageview.CircleImageView

class StudentAdapter(
    val listStudent:ArrayList<Student>,
    val context: Context
) :RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(view:View):RecyclerView.ViewHolder(view){
        val imgProfile : CircleImageView
        val tvName : TextView
        val tvAddress : TextView
        val tvMobile : TextView
        val tvGender : TextView
        val tvAge : TextView
        init {
            imgProfile=view.findViewById(R.id.imgProfile)
            tvName=view.findViewById(R.id.tvName)
            tvAddress=view.findViewById(R.id.tvAddress)
            tvMobile=view.findViewById(R.id.tvMobile)
            tvGender=view.findViewById(R.id.tvGender)
            tvAge=view.findViewById(R.id.tvAge)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_display_layout,parent,false)
        return StudentViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val student = listStudent[position]
        holder.tvName.text=student.name
        holder.tvAddress.text=student.address
        holder.tvMobile.text=student.mobileNumber
        holder.tvGender.text=student.gender
        holder.tvAge.text=student.age
        // Load image with Glide Library
        if (student.profilePicture!=null){
            Glide.with(context)
                .load(student.profilePicture)
                .into(holder.imgProfile)
        }
        else{
            holder.imgProfile
        }
    }

    override fun getItemCount(): Int {
        return listStudent.size
    }

}