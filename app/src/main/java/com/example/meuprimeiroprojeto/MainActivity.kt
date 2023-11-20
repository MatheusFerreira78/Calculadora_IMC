package com.example.meuprimeiroprojeto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)

        // val btnCalcular: Button = findViewById(R.id.btnCalcular) pode ser usado assim também

        btnCalcular.setOnClickListener(){

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val recAltura: Float = alturaStr.toFloat()
                val recPeso: Float = pesoStr.toFloat()

                val calcImc: Float = recPeso / (recAltura * recAltura)

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", calcImc)
                    }
                startActivity(intent)
            } else {
                Toast.makeText(this,"Preeencher todos os campos", Toast.LENGTH_LONG).show()
            }
        }
   }
}


