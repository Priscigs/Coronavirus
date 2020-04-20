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
import com.example.coronavirus.databinding.ActivityDosBinding
import kotlinx.android.synthetic.main.activity_dos.*

class ActivityDos : AppCompatActivity() {

    private lateinit var binding: ActivityDosBinding

    private var comentario: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_dos)

        binding.commentButton.setOnClickListener{addComment(it)}
    }


    private fun addComment(view: View)
    {
        binding.apply {
            comentario = binding.commentText.text.toString()
            binding.commentButton.visibility = View.VISIBLE
        }

        if(comentario.isEmpty())
        {
            Toast.makeText(this, "Debes ingresar un comentario.", Toast.LENGTH_SHORT).show()
        }
        else
        {
            binding.commentText.text
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("", comentario)
            startActivity(intent)
            finish()
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
