package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView




class Extended : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_extended, null)

        (v.findViewById(R.id.btn_square) as TextView).setOnClickListener { setTextFields("^2") }
        (v.findViewById(R.id.btn_degree) as TextView).setOnClickListener { setTextFields("^") }
        (v.findViewById(R.id.btn_root) as TextView).setOnClickListener { setTextFields("sqrt(") }
        (v.findViewById(R.id.btn_sin) as TextView).setOnClickListener { setTextFields("sin(") }
        (v.findViewById(R.id.btn_cos) as TextView).setOnClickListener { setTextFields("cos(") }
        (v.findViewById(R.id.btn_tan) as TextView).setOnClickListener { setTextFields("tan(") }
        (v.findViewById(R.id.btn_sinh) as TextView).setOnClickListener { setTextFields("sinh(") }
        (v.findViewById(R.id.btn_cosh) as TextView).setOnClickListener { setTextFields("cosh(") }
        (v.findViewById(R.id.btn_tanh) as TextView).setOnClickListener { setTextFields("tanh(") }
        (v.findViewById(R.id.btn_ln) as TextView).setOnClickListener { setTextFields("log(") }
        (v.findViewById(R.id.btn_log) as TextView).setOnClickListener { setTextFields("log10(") }
        (v.findViewById(R.id.btn_degree_exp) as TextView).setOnClickListener { setTextFields("e^(") }
        (v.findViewById(R.id.btn_abs) as TextView).setOnClickListener { setTextFields("abs(") }
        (v.findViewById(R.id.btn_pi) as TextView).setOnClickListener { setTextFields("π") }
        (v.findViewById(R.id.btn_exp) as TextView).setOnClickListener { setTextFields("e") }

        return v
    }
    private fun setTextFields(str:String)
    {
        val mathOperation = requireActivity().findViewById<View>(R.id.math_operation) as TextView
        val resultText = requireActivity().findViewById<View>(R.id.result_text) as TextView
        if(resultText.text != "")
        {
            mathOperation.text = resultText.text
            resultText.text = ""
        }
        mathOperation.append(str)
    }
}