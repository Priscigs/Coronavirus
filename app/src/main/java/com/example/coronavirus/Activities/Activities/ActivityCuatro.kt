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
import com.example.coronavirus.databinding.ActivityCuatroBinding

class ActivityCuatro : AppCompatActivity() {

    private lateinit var binding: ActivityCuatroBinding

    private var comment: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_cuatro)

        binding.commentButton.setOnClickListener{addComment(it)}
    }

    private fun addComment(view: View)
    {
        binding.apply {
            comment = binding.commentText.text.toString()
            binding.commentButton.visibility = View.VISIBLE
        }

        if(comment.isEmpty())
        {
            Toast.makeText(this, "Debes ingresar un comentario.", Toast.LENGTH_SHORT).show()
        }
        else
        {
            binding.commentText.text
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("", comment)
            startActivity(intent)
            finish()
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
