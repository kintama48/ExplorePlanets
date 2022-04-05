package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.tiptime.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateButton.setOnClickListener {
            calculateTip()
        }

    }

    private fun calculateTip(){
        var cost = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        if(cost == null){
            cost = 0.0
        }
        var selectedId = binding.tipOptions.checkedRadioButtonId
        val tipPercentage = when(selectedId){
            R.id.option_twenty_percent -> 0.2
            R.id.option_eighteen_percent -> 0.18
            else -> 0.15
        }
        var tip = cost * tipPercentage
        if(binding.roundUpSwitch.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        binding.tipResult.text = tip.toString()
    }
    /*
    private fun calculateTip(){
        var editbox = findViewById<EditText>(R.id.cost_of_service)
        var cost = editbox.text.toString().toDouble()
        var tip = 0.0

        var r1 = findViewById<RadioButton>(R.id.option_twenty_percent)
        var r2 = findViewById<RadioButton>(R.id.option_eighteen_percent)
        var r3 = findViewById<RadioButton>(R.id.option_fifteen_percent)

        if(r1.isChecked){
            tip = cost * .2
        }
        else if(r2.isChecked){
            tip = cost * .18
        }
        else{
            tip = cost * .15
        }
        var lbl : TextView = findViewById(R.id.tip_result)
        lbl.text = "" + tip
    }
    */
}