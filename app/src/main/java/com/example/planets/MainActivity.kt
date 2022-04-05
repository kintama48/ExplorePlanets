package com.example.planets

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.planets.databinding.ActivityMainBinding


//lateinit var binding: ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(R.layout.activity_main)

        binding.planetRadioGroup.setOnCheckedChangeListener{ _, _ -> updateView("radioGroup")}


        binding.planetSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Have to implement this logic")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                updateView("spinner")
            }
        }

        binding.clearButton.setOnClickListener {
            selectEarth()
        }

        val spinner: Spinner = binding.planetSpinner
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.PlanetsArray,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }
    }

    private fun updateView(type: String){
        val radioButtons: Map<String, RadioButton> = mapOf("earthRadio" to binding.EarthRadioButton, "marsRadio" to binding.MarsRadioButton,
                                 "venusRadio" to binding.VenusRadioButton, "plutoRadio" to binding.PlutoRadioButton)

        fun  updateEarth(){
            radioButtons.getValue("earthRadio").toggle()
            binding.planetSpinner.setSelection(0)
            binding.planetImage.setImageResource(R.drawable.earth)
            binding.planetDescription.text = R.string.EarthText.toString()
        }

        fun updateVenus(){
            radioButtons.getValue("venusRadio").toggle()
            binding.planetSpinner.setSelection(1)
            binding.planetImage.setImageResource(R.drawable.venus)
            binding.planetDescription.text = R.string.VenusText.toString()
        }

        fun updateMars(){
            radioButtons.getValue("marsRadio").toggle()
            binding.planetSpinner.setSelection(2)
            binding.planetImage.setImageResource(R.drawable.mars)
            binding.planetDescription.text = R.string.MarsText.toString()
        }

        fun updatePluto(){
            radioButtons.getValue("plutoRadio").toggle()
            binding.planetSpinner.setSelection(3)
            binding.planetImage.setImageResource(R.drawable.pluto)
            binding.planetDescription.text = R.string.PlutoText.toString()
        }


        when (type){
            "radioGroup"-> {
                for (key in radioButtons){
                    if (radioButtons.getValue(key.toString()).isChecked()){
                        when (key.toString()){
                            "earthRadio" -> {
                                updateEarth()
                            }
                            "venusRadio" -> {
                                updateVenus()
                            }
                            "marsRadio" -> {
                                updateMars()
                            }
                            "plutoRadio" -> {
                                updatePluto()
                            }
                        }
                    }
                }
            }
            "spinner"-> {
                when (binding.planetSpinner.selectedItem.toString()){
                    "Earth" -> {
                        updateEarth()
                    }
                    "Venus" -> {
                        updateVenus()
                    }
                    "Mars" -> {
                        updateMars()
                    }
                    "Pluto" -> {
                        updatePluto()
                    }
                }
            }
        }
    }

    private fun selectEarth(){
        return
    }



}

