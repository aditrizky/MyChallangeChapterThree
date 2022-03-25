package com.binar.mychallangechapterthree.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.binar.mychallangechapterthree.Person
import com.binar.mychallangechapterthree.R

class SecondFragment : Fragment() {

    private lateinit var goToThirdButton: Button
    private lateinit var inputNameEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        goToThirdButton= view.findViewById(R.id.to_third_button)
        inputNameEditText=view.findViewById(R.id.input_name_edit_text)

        goToThirdButton.setOnClickListener {
            val firstPerson = Person(
                name = inputNameEditText.text.toString().trim()
            )
            if(TextUtils.isEmpty(firstPerson.name)){
                Toast.makeText(requireActivity(), "Name Required", Toast.LENGTH_SHORT).show()
            }else {
                findNavController().navigate(SecondFragmentDirections.actionSecondFragmentToThirdFragment(person = firstPerson))
            }
        }
    }

}