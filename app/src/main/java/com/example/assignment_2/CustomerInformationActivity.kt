package com.example.assignment_2

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class CustomerInformationActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.checkout_activity)

        val tv = findViewById<EditText>(R.id.editTextTextPersonName9)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        tv.setOnClickListener{
            val datePickerDialog = DatePickerDialog(this, {view: DatePicker, mYear:Int, mMonth: Int, mDay: Int ->
                val dat = (mMonth.toString() + "/" + (mMonth + 1) + "/" + year)
                tv.setText(dat)
            },
                year,
                month,
                day
            )
            datePickerDialog.show()
        }
        val a = findViewById<EditText>(R.id.nameEdit)
        val b = findViewById<EditText>(R.id.addressEdit)
        val d = findViewById<EditText>(R.id.cityEdit)
        val e = findViewById<EditText>(R.id.postalEdit)
        val f = findViewById<EditText>(R.id.numberEdit)
        val g = findViewById<EditText>(R.id.cardEdit)
        val h = findViewById<EditText>(R.id.securityEdit)
        val i = findViewById<EditText>(R.id.editTextTextPersonName9)
        fun validate() : Boolean{
            if(a.text.toString().isEmpty()){
                a.error = "Name should not be empty"
                return false
            }else if(b.text.toString().isEmpty()){
                b.error = "Address should not be empty"
                return false
            }else if(d.text.toString().isEmpty()){
                d.error = "City should not be empty"
                return false
            }else if(e.text.toString().isEmpty()){
                e.error = "Postal Code should not be empty"
                return false
            }else if(f.text.toString().isEmpty()){
                f.error = "Phone Number should not be empty"
                return false
            }else if(g.text.toString().isEmpty()){
                g.error = "Card Number should not be empty"
                return false
            }else if(h.text.toString().isEmpty()){
                h.error = "Security Code should not be empty"
                return false
            }
            else if(i.text.toString().isEmpty()){
                i.error = "Date should not be empty"
                return false
            }
            return true
        }
        findViewById<View>(R.id.btnCheckout).setOnClickListener(){
            if(validate()){
                val intent = Intent(this, LastActivity::class.java)
                startActivity(intent)
            }
        }
    }
}