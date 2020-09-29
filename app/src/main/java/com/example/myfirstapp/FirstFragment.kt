package com.example.myfirstapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private fun countMe(view: View){
        //get the text view
        val showCountTextView=view.findViewById<TextView>(R.id.textview_first)
        //Get the value of the showcounttextview
        val countString = showCountTextView.text.toString()
        //convert value to number
        var count = countString.toInt()
        count++
        //display the new value in the text view
        showCountTextView.text=count.toString()
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //random button
        view.findViewById<Button>(R.id.random_button).setOnClickListener {
            val showCountTextView = view.findViewById<TextView>(R.id.textview_first)
            val currentCount = showCountTextView.text.toString().toInt()
            val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(currentCount)
            findNavController().navigate(action)
        }

        // find the toast_button by its ID and set a click listener
        view.findViewById<Button>(R.id.toast_button).setOnClickListener {
            // create a Toast with some text, to appear for a short time
           val myToast= Toast.makeText(context, getString(R.string.Hello), Toast.LENGTH_SHORT)
            //show
            myToast.show()
        }
        //count button
        view.findViewById<Button>(R.id.count_button).setOnClickListener {
            countMe(view)
        }

    }
}