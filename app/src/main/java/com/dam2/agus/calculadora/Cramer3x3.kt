package com.dam2.agus.calculadora

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class Cramer3x3 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cramer3x3)

        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaC)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutCramer3X3)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navVista.setNavigationItemSelectedListener {
            val intent = Intent(this, McdYMcm::class.java)
            val intent2 = Intent(this, MainActivity::class.java)
            val intent3 = Intent(this, CalculadoraDeterminantes::class.java)
            val intent4 = Intent(this, CramerMenu::class.java)
            when (it.itemId) {
                R.id.miItem1 -> {
                    startActivity(intent2)
                    Toast.makeText(
                        applicationContext,
                        "Calculadora", Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.miItem2 -> {
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "MCM y MCD", Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.miItem3 -> {
                    startActivity(intent3)
                    Toast.makeText(
                        applicationContext,
                        "Determinantes", Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.miItem4 -> {
                    startActivity(intent4)
                    Toast.makeText(
                        applicationContext,
                        "Regla de Cramer", Toast.LENGTH_SHORT
                    ).show()
                }
            }
            true
        }
        val btnCalDeterminante = findViewById<Button>(R.id.btnMenu2x2)
        val numa11 = findViewById<EditText>(R.id.edtA1)
        val numa12 = findViewById<EditText>(R.id.edtY1)
        val numa13 = findViewById<EditText>(R.id.etdZ1)
        val numa21 = findViewById<EditText>(R.id.edtA2)
        val numa22 = findViewById<EditText>(R.id.edtY2)
        val numa23 = findViewById<EditText>(R.id.edtZ2)
        val numa31 = findViewById<EditText>(R.id.edtA3)
        val numa32 = findViewById<EditText>(R.id.edtY3)
        val numa33 = findViewById<EditText>(R.id.edtZ3)

        val termI1 = findViewById<EditText>(R.id.EtC1)
        val termI2 = findViewById<EditText>(R.id.EtC2)
        val termI3 = findViewById<EditText>(R.id.EtC3)

        val resultadoIgX = findViewById<TextView>(R.id.tv_resulX)
        val resultadoIgY = findViewById<TextView>(R.id.tv_resulY)
        val resultadoIgZ = findViewById<TextView>(R.id.tv_resulZ)

        fun calcularIncog(num11: Int, num12: Int, num13: Int, num21: Int,num22:Int, num23:Int,num31:Int, num32:Int, num33:Int,  termI1: Int, termI2: Int, termI3:Int) {
            var detX: Int = 0
            var detY: Int = 0
            var detZ: Int = 0
            var detS: Int = 0
            //Calculo de los determinantes

            detS =  num11 * num22 * num33 + num12 * num23 * num31 + num21 * num32 * num13 - num31 * num22 * num13 - num32 * num23 * num11 - num21 * num12 * num33
            detX = termI1 * num22 * num33 + num12 * num23 * termI3 + num13 * termI2 * num21 - num13 * num22 * termI3 + termI1 * num23 * num32 + num12 * termI2 * num33
            detY =  num11 * termI2 * num33 + num21 * termI3 * num13 + num31 * termI1 * num13 - num13 * termI2 * num31 + num23 * termI3 * num11 + num33 * termI1 * num21
            detZ =  num11 * num22 * termI3 + num12 * num23 * num31 + termI1 * num21 * num32 - termI1 * num22 * num31 + num11 * termI2 * num32 + num12 * num21 * termI3

            var resultadoX: Int = 0
            var resultadoY: Int = 0
            var resultadoZ: Int = 0
            //Calculo de las incognitas
            resultadoX = detX / detS
            resultadoY = detY / detS
            resultadoZ = detZ / detS
            println(detS)

            resultadoIgX.text = resultadoX.toString()
            resultadoIgY.text = resultadoY.toString()
            resultadoIgZ.text = resultadoZ.toString()
        }

        btnCalDeterminante.setOnClickListener {
            val valor1 = numa11.text.toString().toInt()
            val valor2 = numa12.text.toString().toInt()
            val valor3 = numa13.text.toString().toInt()
            val valor4 = numa21.text.toString().toInt()
            val valor5 = numa22.text.toString().toInt()
            val valor6 = numa23.text.toString().toInt()
            val valor7 = numa31.text.toString().toInt()
            val valor8 = numa32.text.toString().toInt()
            val valor9 = numa33.text.toString().toInt()
            val deter1 = termI1.text.toString().toInt()
            val deter2 = termI2.text.toString().toInt()
            val deter3 = termI2.text.toString().toInt()
            calcularIncog(valor1, valor2, valor3, valor4, valor5, valor6, valor7, valor8, valor9,deter1,deter2,deter3)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
}