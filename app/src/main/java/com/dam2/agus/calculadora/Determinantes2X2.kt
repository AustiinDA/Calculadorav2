package com.dam2.agus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Determinantes2X2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_det_2x2)

        val btnCalDeterminante = findViewById<Button>(R.id.btnCalcularDet)
        val num1 = findViewById<EditText>(R.id.etNum1a)
        val num2 = findViewById<EditText>(R.id.etNum2a)
        val num3 = findViewById<EditText>(R.id.etNum1b)
        val num4 = findViewById<EditText>(R.id.etNum2b)

        val resultadoText = findViewById<TextView>(R.id.tv_resul)



        fun calcularDet(num1: Int, num2: Int, num3:Int, num4:Int) {
            var resultado: Int = 0

            resultado = num1 * num4 - num3 * num2

            resultadoText.text = resultado.toString()
        }

        btnCalDeterminante.setOnClickListener{
            val valor1 = num1.text.toString().toInt()
            val valor2 = num2.text.toString().toInt()
            val valor3 = num3.text.toString().toInt()
            val valor4 = num4.text.toString().toInt()

            calcularDet(valor1,valor2,valor3,valor4)
        }
    }




}