package com.dam2.agus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class mcd_mcm : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mcm_mcd_activity)

        val btnCal = findViewById<Button>(R.id.btnCalcular)

        val num1 = findViewById<EditText>(R.id.etNum1)
        val num2 = findViewById<EditText>(R.id.etNum2)

        var resul1 = findViewById<TextView>(R.id.textoResul1)
        val resul2 = findViewById<TextView>(R.id.textoResul2)


        fun calcularMcm(num1: Int, num2: Int) {
            var resultadoMcm: Int
            var mcm = if (num1 > num2) {
                num1
            } else num2

            while (true) {
                if (mcm % num1 == 0 && mcm % num2 == 0) {

                    resultadoMcm = mcm

                    break
                }
                mcm++
            }
            resul2.text = resultadoMcm.toString()
        }

        fun calcularMcd(num1: Int, num2: Int) {
            var resultadoMcd: Int = 0
            var cont: Int = 1;

            while (cont <= num1 && cont <= num2) {
                if (num1 % cont == 0 && num2 % cont == 0) {
                    resultadoMcd = cont
                }
                cont++
            }
            resul1.text = resultadoMcd.toString()

        }

        btnCal.setOnClickListener {
            val valor1 = num1.text.toString().toInt()
            val valor2 = num2.text.toString().toInt()

            calcularMcm(valor1, valor2)
            calcularMcd(valor1,valor2)
        }

    }


}