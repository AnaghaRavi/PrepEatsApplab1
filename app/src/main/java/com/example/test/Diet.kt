package com.example.test

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.example.test.Ingredients
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Diet : AppCompatActivity() {
    private lateinit var veganCheckbox: CheckBox
    private lateinit var vegetarianCheckbox: CheckBox
    private lateinit var glutenFreeCheckbox: CheckBox
    private lateinit var lactoseIntoleranceCheckbox: CheckBox
    private lateinit var peanutAllergyCheckbox: CheckBox
    private lateinit var nextButton: Button

    private lateinit var auth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    private lateinit var dietaryRestrictionsRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diet2)

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance()

        // Initialize Firebase Database
        database = FirebaseDatabase.getInstance()
        dietaryRestrictionsRef = database.reference.child("dietary_restrictions")

        veganCheckbox = findViewById(R.id.checkbox_vegan)
        vegetarianCheckbox = findViewById(R.id.checkbox_vegetarian)
        glutenFreeCheckbox = findViewById(R.id.checkbox_gluten_free)
        lactoseIntoleranceCheckbox = findViewById(R.id.checkbox_lactose_intolerance)
        peanutAllergyCheckbox = findViewById(R.id.checkbox_peanut_allergy)
        nextButton = findViewById(R.id.button_next)

        nextButton.setOnClickListener {
            handleNextButtonClick()
            val intent = Intent(this@Diet, Ingredients::class.java)
            startActivity(intent)
        }
    }

    private fun handleNextButtonClick() {
        val isVeganSelected = veganCheckbox.isChecked
        val isVegetarianSelected = vegetarianCheckbox.isChecked
        val isGlutenFreeSelected = glutenFreeCheckbox.isChecked
        val isLactoseIntoleranceSelected = lactoseIntoleranceCheckbox.isChecked
        val isPeanutAllergySelected = peanutAllergyCheckbox.isChecked

        // Store checkbox data in Firebase Realtime Database
        dietaryRestrictionsRef.child("vegan").setValue(isVeganSelected)
        dietaryRestrictionsRef.child("vegetarian").setValue(isVegetarianSelected)
        dietaryRestrictionsRef.child("glutenFree").setValue(isGlutenFreeSelected)
        dietaryRestrictionsRef.child("lactoseIntolerance").setValue(isLactoseIntoleranceSelected)
        dietaryRestrictionsRef.child("peanutAllergy").setValue(isPeanutAllergySelected)

        // Create an intent to navigate to the next activity (replace with your desired destination)
        val intent = Intent(this, Ingredients::class.java)
        startActivity(intent)
    }
}
