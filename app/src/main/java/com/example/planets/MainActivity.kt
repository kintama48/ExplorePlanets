package com.example.planets

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.planets.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root

        binding.planetRadioGroup.setOnCheckedChangeListener{ _, _ ->
            run {
                Log.d("INFO", "inside radio setOnCheckedChangeListener")
                updateView("radioGroup")
            }
        }

        binding.planetSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Have to implement this logic")
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Log.d("INFO", "inside spinner onItemSelected")
                updateView("spinner")
            }
        }

        binding.clearButton.setOnClickListener {
            Log.d("INFO", "clear Button clicked")
            updateEarth()
        }

        setContentView(view)
    }

    private fun updateView(type: String){
        val radioButtons: Array<RadioButton> = arrayOf(binding.EarthRadioButton, binding.MarsRadioButton, binding.VenusRadioButton, binding.PlutoRadioButton)


        when (type){
            "radioGroup"-> {
                Log.d("INFO", "inside radioGroup")
                for (btn in radioButtons){
                    if (btn.isChecked){
                        Log.d("INFO", btn.id.toString())
                        print(btn.text.toString())
                        when (btn.id){
                            2131296260-> updateEarth()
                            2131296263-> updateMars()
                            2131296265-> updatePluto()
                            2131296273-> updateVenus()
                        }
                    }
                }
            }

            "spinner"-> {
                Log.d("INFO", "inside spinner")
                when (binding.planetSpinner.selectedItem.toString()){
                    "Earth" -> updateEarth()
                    "Venus" -> updateVenus()
                    "Mars"  -> updateMars()
                    "Pluto" -> updatePluto()
                }
            }
        }
    }

    private fun updateEarth(){
        Log.d("INFO", "inside updateEarth")
        binding.EarthRadioButton.toggle()
        binding.planetSpinner.setSelection(0)
        binding.planetImage.setImageResource(R.drawable.earth)
        binding.planetDescription.text = resources.getString(R.string.EarthText)
    }

    private fun updateVenus(){
        Log.d("INFO", "inside updateVenus")
        binding.VenusRadioButton.toggle()
        binding.planetSpinner.setSelection(1)
        binding.planetImage.setImageResource(R.drawable.venus)
        binding.planetDescription.text = resources.getString(R.string.VenusText)
    }

    private fun updateMars(){
        Log.d("INFO", "inside updateMars")
        binding.MarsRadioButton.toggle()
        binding.planetSpinner.setSelection(2)
        binding.planetImage.setImageResource(R.drawable.mars)
        binding.planetDescription.text = resources.getString(R.string.MarsText)
    }

    private fun updatePluto(){
        Log.d("INFO", "inside updatePluto")
        binding.PlutoRadioButton.toggle()
        binding.planetSpinner.setSelection(3)
        binding.planetImage.setImageResource(R.drawable.pluto)
        binding.planetDescription.text = resources.getString(R.string.PlutoText)
    }
}
