package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Ingredients : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingredients)

        val eggCheckbox = findViewById<CheckBox>(R.id.checkBox)
        val lettuceCheckbox = findViewById<CheckBox>(R.id.checkBox2)
        val tomatoCheckbox = findViewById<CheckBox>(R.id.checkBox3)
        val potatoCheckbox = findViewById<CheckBox>(R.id.checkBox4)
        val checkButton = findViewById<Button>(R.id.button)
        val resultTextView = findViewById<TextView>(R.id.textView2)

        checkButton.setOnClickListener {
            val selectedIngredients = mutableListOf<String>()



            if (eggCheckbox.isChecked) {
                selectedIngredients.add("Egg")
            }

            if (lettuceCheckbox.isChecked) {
                selectedIngredients.add("Lettuce")
            }

            if (tomatoCheckbox.isChecked) {
                selectedIngredients.add("Tomato")
            }

            if (potatoCheckbox.isChecked) {
                selectedIngredients.add("Potato")
            }

            if (selectedIngredients.isEmpty()) {
                resultTextView.text = "Please select at least one ingredient."
            } else {
                val resultText = "Selected ingredients: " + selectedIngredients.joinToString(", ")
                resultTextView.text = resultText
            }

        }

        checkButton.setOnClickListener {
            handleNextButtonClick()
            val intent = Intent(this@Ingredients, Recipe::class.java)
            startActivity(intent)
        }
    }

    private fun handleNextButtonClick() {

        // Create an intent to navigate to the next activity (replace with your desired destination)
        val intent = Intent(this, Recipe::class.java)
        startActivity(intent)
    }

}
