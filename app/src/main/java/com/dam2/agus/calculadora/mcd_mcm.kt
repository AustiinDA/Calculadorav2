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


        val resultadoMcm = resul1.text.toString()






        btnCal.setOnClickListener {
            val valor1 = num1.text.toString().toInt()
            val valor2 = num2.text.toString().toInt()


            calcularMcd(valor1, valor2)

        }

         fun calcularMcd(num1: Int, num2: Int): String {
            var mcm = if (num1 > num2) {
                num1
            }else num2

            while (true) {
                if (mcm % num1 == 0 && mcm % num2 == 0) {

                     resultadoMcm = "$num1 y $num2 es $mcm"


                    break
                }
                mcm++
            }
        }

    }



    /*fun calcularMcd() {
        val num1Formateado: Int = num1.text.toString().toInt()
        var listaResultados: MutableList<Int> = mutableListOf()
        var index = 0
        resultado = num1Formateado

        for (numero in numPrimos) {

            var primoEncontrado: Int = numPrimos[index]

            if (resultado.mod(numPrimos[index]) == 0) {
                listaResultados.add(primoEncontrado)
                resul1.text = listaResultados.toString()

            } else {
                index++
            }

            resultado.div(numPrimos[index])

        }
    val n1 = 72
    val n2 = 120
    var lcm: Int

    // maximum number between n1 and n2 is stored in lcm
    lcm = if (n1 > n2) n1 else n2

    // Always true
    while (true) {
        if (lcm % n1 == 0 && lcm % n2 == 0) {
            println("The LCM of $n1 and $n2 is $lcm.")
            break
        }
        ++lcm
    }

        */

}