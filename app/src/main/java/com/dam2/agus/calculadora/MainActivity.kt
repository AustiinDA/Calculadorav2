package com.dam2.agus.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    private lateinit var mostrarCalculo: TextView
    var sumado: Boolean = false
    var restado: Boolean = false
    var multiplicado: Boolean = false
    var dividido: Boolean = false

    private var calculo1: Float = 0.0f
    private var calculo2: Float = 0.0f
    private var resultado: Float = 0.0f;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnProAvz = findViewById<Button>(R.id.btnPro)

        btnProAvz.setOnClickListener{
            val intent = Intent(this, mcd_mcm::class.java)
            startActivity(intent)
        }

        mostrarCalculo = findViewById(R.id.mostrarCalculoTV)
    }

    private fun actualizarTextoNum(lineaAInsertar: String) {
        var lineaOld: String = mostrarCalculo.text.toString()
        mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
    }


    fun CPulsado(vista: View) {
        mostrarCalculo.text = ""
    }

    fun BorrarPulsado(vista: View) {
        mostrarCalculo.text = mostrarCalculo.text.dropLast(1)
    }

    fun dividirPulsado(vista: View) {
        calculo1 = (mostrarCalculo.text as String).toFloat()
        mostrarCalculo.text = ""

        sumado = false
        restado = false
        dividido = true
        multiplicado = false

    }

    fun decimalPulsado(vista: View) {
        actualizarTextoPunto(resources.getString(R.string.decimalText))
    }


    fun multiplicadoPulsado(vista: View) {
        calculo1 = (mostrarCalculo.text as String).toFloat()
        mostrarCalculo.text = ""

        sumado = false
        restado = false
        dividido = false
        multiplicado = true
    }

    fun igualPulsado(vista: View) {

        calculo2 = (mostrarCalculo.text as String).toFloat()

        mostrarCalculo.text = "";

        if (sumado) {
            resultado = calculo1 + calculo2
            calculo1 = 0.0f
            mostrarCalculo.text = resultado.toString()
        }
        if (restado) {
            resultado = calculo1 - calculo2
            calculo1 = 0.0f
            mostrarCalculo.text = resultado.toString()
        }
        if (dividido) {
            if (calculo2 != 0.0f) {
                resultado = calculo1 / calculo2
                calculo1 = 0.0f
                mostrarCalculo.text = resultado.toString()
            } else {
                mostrarCalculo.text = "Error"
            }
        }
        if (multiplicado) {
            resultado = calculo1 * calculo2
            calculo1 = 0.0f
            mostrarCalculo.text = resultado.toString()
        }
    }

    fun sumarPulsado(vista: View) {
        calculo1 = (mostrarCalculo.text as String).toFloat()
        mostrarCalculo.text = ""

        sumado = true
        restado = false
        dividido = false
        multiplicado = false
    }

    fun restaPulsado(vista: View) {
        calculo1 = (mostrarCalculo.text as String).toFloat()
        mostrarCalculo.text = ""
        sumado = false
        restado = true
        dividido = false
        multiplicado = false
    }

    fun ceroPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textCero))
    }

    fun unoPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textUno))
    }

    fun dosPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textDos))
    }

    fun tresPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textTres))
    }

    fun cuatroPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textCuatro))
    }

    fun cincoPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textCinco))
    }

    fun seisPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textSeis))
    }

    fun sietePulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textSiete))
    }

    fun ochoPulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textOcho))
    }

    fun nuevePulsado(vista: View) {
        actualizarTextoNum(resources.getString(R.string.textNueve))
    }


    private fun actualizarTextoPunto(lineaAInsertar: String) {
        var lineaOld: String = mostrarCalculo.text.toString()

        if (!mostrarCalculo.text.contains(".")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (mostrarCalculo.text.contains(".")) {
        }
    }

}








