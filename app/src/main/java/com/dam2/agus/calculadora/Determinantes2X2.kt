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

class Determinantes2X2 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_det_2x2)
        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaC)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutDeterminantes2x2)

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

        val btnCalDeterminante = findViewById<Button>(R.id.btnCalDet2X2)
        val num1 = findViewById<EditText>(R.id.edtA1)
        val num2 = findViewById<EditText>(R.id.edtY1)
        val num3 = findViewById<EditText>(R.id.etA3)
        val num4 = findViewById<EditText>(R.id.etY3)

        val resultadoText = findViewById<TextView>(R.id.tv_resulX)


        fun calcularDet(num1: Int, num2: Int, num3: Int, num4: Int) {
            var resultado: Int = 0

            resultado = num1 * num4 - num3 * num2

            resultadoText.text = resultado.toString()
        }

        btnCalDeterminante.setOnClickListener {

            try {
                val valor1 = num1.text.toString().toInt()
                val valor2 = num2.text.toString().toInt()
                val valor3 = num3.text.toString().toInt()
                val valor4 = num4.text.toString().toInt()

                calcularDet(valor1, valor2, valor3, valor4)

            } catch (e: Exception) {
                Toast.makeText(this, "No hay entrada introducida!", Toast.LENGTH_SHORT).show();
                num1.error = "No hay entrada"
                num2.error = "No hay entrada"
                num3.error = "No hay entrada"
                num4.error = "No hay entrada"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
}