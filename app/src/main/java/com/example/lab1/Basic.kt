package com.example.lab1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception






class Basic : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v: View = inflater.inflate(R.layout.fragment_basic, null)

        (v.findViewById(R.id.btn_0) as TextView).setOnClickListener { setTextFields("0") }
        (v.findViewById(R.id.btn_1) as TextView).setOnClickListener { setTextFields("1") }
        (v.findViewById(R.id.btn_2) as TextView).setOnClickListener { setTextFields("2") }
        (v.findViewById(R.id.btn_3) as TextView).setOnClickListener { setTextFields("3") }
        (v.findViewById(R.id.btn_4) as TextView).setOnClickListener { setTextFields("4") }
        (v.findViewById(R.id.btn_5) as TextView).setOnClickListener { setTextFields("5") }
        (v.findViewById(R.id.btn_6) as TextView).setOnClickListener { setTextFields("6") }
        (v.findViewById(R.id.btn_7) as TextView).setOnClickListener { setTextFields("7") }
        (v.findViewById(R.id.btn_8) as TextView).setOnClickListener { setTextFields("8") }
        (v.findViewById(R.id.btn_9) as TextView).setOnClickListener { setTextFields("9") }

        (v.findViewById(R.id.btn_minus) as TextView).setOnClickListener { setTextFields("-") }
        (v.findViewById(R.id.btn_plus) as TextView).setOnClickListener { setTextFields("+") }
        (v.findViewById(R.id.btn_mult) as TextView).setOnClickListener { setTextFields("*") }
        (v.findViewById(R.id.btn_div) as TextView).setOnClickListener { setTextFields("/") }
        (v.findViewById(R.id.btn_left_bracket) as TextView).setOnClickListener { setTextFields("(") }
        (v.findViewById(R.id.btn_right_bracket) as TextView).setOnClickListener { setTextFields(")") }
        (v.findViewById(R.id.btn_dot) as TextView).setOnClickListener { setTextFields(".") }

        (v.findViewById(R.id.btn_C) as TextView).setOnClickListener { clear() }
        (v.findViewById(R.id.btn_back) as TextView).setOnClickListener { back() }
        (v.findViewById(R.id.btn_equal) as TextView).setOnClickListener { equal() }

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
    private fun clear()
    {
        val mathOperation = requireActivity().findViewById<View>(R.id.math_operation) as TextView
        val resultText = requireActivity().findViewById<View>(R.id.result_text) as TextView

        mathOperation.text = ""
        resultText.text = ""
    }
    private fun back()
    {
        val mathOperation = requireActivity().findViewById<View>(R.id.math_operation) as TextView
        val resultText = requireActivity().findViewById<View>(R.id.result_text) as TextView

        val str = mathOperation.text.toString()
        if (str.isNotEmpty())
        {
            mathOperation.text = str.substring(0, str.length - 1)
        }
        resultText.text = ""
    }
    private fun equal()
    {
        val mathOperation = requireActivity().findViewById<View>(R.id.math_operation) as TextView
        val resultText = requireActivity().findViewById<View>(R.id.result_text) as TextView
        try
        {
            val ex = ExpressionBuilder(mathOperation.text.toString()).build()
            val result = ex.evaluate()

            val longRes = result.toLong()
            if (result == longRes.toDouble())
            {
                resultText.text = longRes.toString()
            }
            else
            {
                resultText.text =result.toString()
            }

        }
        catch (e: Exception)
        {
            Log.d("Ошибка", "сообщение: ${e.message}")
        }
    }
}