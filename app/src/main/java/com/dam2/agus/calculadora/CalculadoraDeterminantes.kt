package com.dam2.agus.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class CalculadoraDeterminantes : AppCompatActivity() {
    var a: Int = 0
    var b: Int = 0
    var c: Int = 0
    var d: Int = 0
    var matriz2x2 = arrayOf(intArrayOf(a, b), intArrayOf(c, d))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_determinantes)

        getMatriz()

    }


    fun getMatriz(){
        var i: Int = 0
        val acab = arrayOf( 2, 3 )
        val bab = arrayOf( 1, 4 )
        var resultado: Int = acab[0]*bab[1]-acab[1]-acab[0]
        println(resultado)
    }


}