package com.binar.mychallangechapterthree.fragment

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.binar.mychallangechapterthree.R

class ThirdFragment : Fragment() {

    private lateinit var bottomNameTextView: TextView
    private lateinit var topNameTextView: TextView
    private lateinit var ageTextView: TextView
    private lateinit var addressTextView: TextView
    private lateinit var jobTextView: TextView
    private lateinit var goToScreenfourth: Button

    private val args: ThirdFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_third, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNameTextView = view.findViewById(R.id.name_bottom_textView)
        topNameTextView = view.findViewById(R.id.name_top_textView)
        ageTextView = view.findViewById(R.id.age_textView)
        addressTextView = view.findViewById(R.id.address_textView)
        jobTextView = view.findViewById(R.id.job_textView)
        goToScreenfourth = view.findViewById(R.id.to_fourth_button)

        if (TextUtils.isEmpty(args.person?.age)) {
            bottomNameTextView.text = args.person?.name
        } else {
            topNameTextView.text = args.person?.name
            ageTextView.text = args.person?.age
            addressTextView.text = args.person?.address
            jobTextView.text = args.person?.job
        }

        goToScreenfourth.setOnClickListener {
            findNavController().navigate(
                ThirdFragmentDirections.actionThirdFragmentToFourthFragment(
                    name = args.person?.name.toString()
                )
            )
        }

    }

}