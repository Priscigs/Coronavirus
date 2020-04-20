package com.example.coronavirus.Activities.Activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.coronavirus.R
import com.example.coronavirus.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var edad: String = ""
    private var nombre: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var intent = intent
        val commentario = intent.getStringExtra("")
        val comment = intent.getStringExtra("")

        Toast.makeText(this, commentario, Toast.LENGTH_LONG).show()
        Toast.makeText(this, comment, Toast.LENGTH_LONG).show()

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        binding.starButton.setOnClickListener{addProb(it)}
        binding.virusButton.setOnClickListener{virusInfo(it)}
        binding.symthomsButton.setOnClickListener{simthoms(it)}
        binding.indiButton.setOnClickListener{indicaciones(it)}
    }

    private fun addProb(view: View)
    {

        binding.apply {
            nombre = binding.nameEditText.text.toString()
            edad = binding.ageEditText.text.toString()
        }

        if(nombre.isEmpty() || edad.isEmpty())
        {
            Toast.makeText(this, "Debes ingresar el campo.", Toast.LENGTH_LONG).show()
        }
        else
        {
            binding.apply {
                binding.nameEditText.visibility = View.GONE
                binding.ageEditText.visibility = View.GONE
                binding.nameText.visibility = View.GONE
                binding.ageText.visibility = View.GONE
            }

            if(edad >= 0.toString() && edad <= 10.toString())
            {
                binding.probText.visibility = View.VISIBLE
                binding.infoText.visibility = View.VISIBLE
            }
            if(edad >= 11.toString() && edad <= 19.toString())
            {
                binding.probText.visibility = View.VISIBLE
                binding.info2Text.visibility = View.VISIBLE
            }
            if(edad >= 20.toString() && edad <= 29.toString())
            {
                binding.probText.visibility = View.VISIBLE
                binding.info3Text.visibility = View.VISIBLE
            }
            if(edad >= 30.toString() && edad <= 49.toString())
            {
                binding.probText.visibility = View.VISIBLE
                binding.info4Text.visibility = View.VISIBLE
            }
            if(edad >= 50.toString() && edad <= 100.toString())
            {
                binding.probText.visibility = View.VISIBLE
                binding.info5Text.visibility = View.VISIBLE
            }
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun virusInfo(view: View)
    {
        startActivity(Intent(this, ActivityDos::class.java))
        finish()
    }

    fun simthoms(view: View)
    {
        startActivity(Intent(this, ActivityTres::class.java))
        finish()
    }

    fun indicaciones(view: View)
    {
        startActivity(Intent(this, ActivityTres::class.java))
        finish()
    }
}
