package com.ujjwal.softuserreplica.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.ujjwal.softuserreplica.R
import com.ujjwal.softuserreplica.`object`.student
import com.ujjwal.softuserreplica.model.Student


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class AddStudentFragment : Fragment() {
    private lateinit var rdoGenderGroup: RadioGroup
    private lateinit var etFullName: EditText
    private lateinit var etAge: EditText
    private lateinit var etAddress: EditText
    private lateinit var etMobile: EditText
    private lateinit var rdoMale: RadioButton
    private lateinit var rdoFemale: RadioButton
    private lateinit var rdoOthers : RadioButton
    private lateinit var btnRegister: Button
    var gender = ""
    private var param1: String? = null
    private var param2: String? = null

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
        val view= inflater.inflate(R.layout.fragment_add_student, container, false)
        return view
    }
    companion object {
        fun newInstance(param1: String, param2: String) =
                AddStudentFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rdoGenderGroup=view.findViewById(R.id.rdoGenderGroup)
        rdoMale=view.findViewById(R.id.rdoMale)
        rdoFemale=view.findViewById(R.id.rdoFemale)
        rdoOthers=view.findViewById(R.id.rdoOthers)
        etFullName=view.findViewById(R.id.etFullName)
        etAddress=view.findViewById(R.id.etAddress)
        etAge=view.findViewById(R.id.etAge)
        etMobile=view.findViewById(R.id.etMobile)
        btnRegister=view.findViewById(R.id.btnRegister)
        selectGender()
        btnRegisterAction()

    }

    private fun btnRegisterAction(){
        btnRegister.setOnClickListener {
            if (checkValues()){
                student.listStudent.add(Student(
                        name = etFullName.text.toString(),
                        age = etAge.text.toString(),
                        address = etAddress.text.toString(),
                        gender = gender,
                        mobileNumber = etMobile.text.toString()
                ))
                clearValues()
            }
            else{
                return@setOnClickListener
            }
        }
    }
    private fun clearValues(){
        etFullName.setText("")
        etAge.setText("")
        etAddress.setText("")
        rdoMale.isChecked=false
        rdoFemale.isChecked=false
        rdoOthers.isChecked=false
        etMobile.setText("")

    }
    private fun selectGender(){
        rdoGenderGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rdoMale -> {
                    gender = rdoMale.text.toString()
                }
                R.id.rdoFemale -> {
                    gender = rdoFemale.text.toString()
                }
                R.id.rdoOthers ->{
                    gender = rdoOthers.text.toString()
                }
            }
        }
    }
    private fun checkValues():Boolean{
        when {
            etFullName.text.isEmpty() -> {
                etFullName.error="Name cannot be Empty"
                etFullName.requestFocus()
                return false
            }
            etAge.text.isEmpty() -> {
                etAge.error="Age cannot be Empty"
                etAge.requestFocus()
                return false
            }
            !rdoMale.isChecked && !rdoFemale.isChecked && !rdoOthers.isChecked -> {
                Toast.makeText(context,"Please Select a Gender",Toast.LENGTH_SHORT).show()
                rdoGenderGroup.requestFocus()
                return false
            }
            etAddress.text.isEmpty() -> {
                etAddress.error="Address cannot be Empty"
                etAddress.requestFocus()
                return false
            }
            etMobile.text.isEmpty() -> {
                etMobile.error="Mobile cannot be Empty"
                etMobile.requestFocus()
                return false
            }

        }
        return true
    }
}