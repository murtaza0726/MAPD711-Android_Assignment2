package com.example.assignment_2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class SecondActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.iphone14)
        val spinner = findViewById<Spinner>(R.id.spinner)

        //val spinner = findViewById<Spinner>(R.id.spinner)

        val arrayAdapter = ArrayAdapter.createFromResource(this, R.array.colorSpinner, android.R.layout.simple_spinner_item)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(this@SecondActivity, "Hello", Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val radio128 = findViewById<RadioButton>(R.id.radioButton128)
        val radio256 = findViewById<RadioButton>(R.id.radioButton256)
        val radio512 = findViewById<RadioButton>(R.id.radioButton512)

        findViewById<View>(R.id.btnBuy).setOnClickListener(){
            if(radio128.isChecked() || radio256.isChecked() || radio512.isChecked()){
                val intent = Intent(this, CustomerInformationActivity::class.java)
                startActivity(intent)
            }
        }
    }
}