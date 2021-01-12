package com.ujjwal.softuserreplica.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ujjwal.softuserreplica.R
import com.ujjwal.softuserreplica.`object`.student
import com.ujjwal.softuserreplica.adapter.StudentAdapter
import com.ujjwal.softuserreplica.model.Student

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment() {
    private lateinit var listStudent: ArrayList<Student>
    private lateinit var studentDetailsRecyclerView: RecyclerView
    private var param1 : String? =null
    private var param2 : String? = null
//    private val defaultStudents = addStudent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }
    companion object{
        fun newInstance(param1: String, param2: String) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        studentDetailsRecyclerView = view.findViewById(R.id.studentDetailsRecyclerView)
        studentDetailsRecyclerView.adapter?.notifyDataSetChanged()
        listStudent= arrayListOf()
        val adapter = StudentAdapter(student.listStudent, context!!)
        studentDetailsRecyclerView.adapter = adapter
        studentDetailsRecyclerView.layoutManager = LinearLayoutManager(context!!)
    }
}