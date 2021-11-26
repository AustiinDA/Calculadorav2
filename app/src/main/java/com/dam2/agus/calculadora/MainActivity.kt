package com.dam2.agus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private lateinit var mostrarCalculo: TextView

    var calculo1: Int = 0
    var calculo2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mostrarCalculo = findViewById(R.id.mostrarCalculoTV)
    }

    fun actualizarTextoNum(lineaAInsertar: String) {
        var lineaOld: String = mostrarCalculo.text.toString()


        mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)

    }


    fun CPulsado(vista: View) {
        mostrarCalculo.text = ""
    }
/*
    fun dividirPulsado(vista: View) {
        mostrarCalculo.text.toString().toFloat()

    }*/

    fun decimalPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.decimalText))
    }

    fun divPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.divisionText))
    }

    fun mulPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.multiplicarText))
    }

    fun sumarPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.sumarText))
    }

    fun restaPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.restarText))
    }

    fun restoPulsado(vista: View) {
        actualizarTextoEsp(resources.getString(R.string.restoText))
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

    fun actualizarTextoEsp(lineaAInsertar: String) {
        var lineaOld: String = mostrarCalculo.text.toString()

        if (!mostrarCalculo.text.contains(".")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (!mostrarCalculo.text.contains("+")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (!mostrarCalculo.text.contains("×")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (!mostrarCalculo.text.contains("/")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (!mostrarCalculo.text.contains("-")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else if (!mostrarCalculo.text.contains("%")) {
            mostrarCalculo.text = String.format("%s%s", lineaOld, lineaAInsertar)
        } else {

        }

    }
}







