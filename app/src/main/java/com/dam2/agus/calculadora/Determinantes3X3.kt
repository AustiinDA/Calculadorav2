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

class Determinantes3X3 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_determinantes3x3)

        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaC)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutDeterminantes3x3)

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
        val btnCalDet = findViewById<Button>(R.id.btnCalDeterminante)
        val numa11 = findViewById<EditText>(R.id.edtA1)
        val numa12 = findViewById<EditText>(R.id.edtY1)
        val numa13 = findViewById<EditText>(R.id.etNumA13)
        val numa21 = findViewById<EditText>(R.id.etA3)
        val numa22 = findViewById<EditText>(R.id.etY3)
        val numa23 = findViewById<EditText>(R.id.etNumA23)
        val numa31 = findViewById<EditText>(R.id.etNumA31)
        val numa32 = findViewById<EditText>(R.id.etNumA32)
        val numa33 = findViewById<EditText>(R.id.etNumA33)

        val resultadoText = findViewById<TextView>(R.id.tv_resulX)

        fun calcularDet(
            num11: Int,
            num12: Int,
            num13: Int,
            num21: Int,
            num22: Int,
            num23: Int,
            num31: Int,
            num32: Int,
            num33: Int
        ) {
            var resultado: Int = 0

            resultado =
                num11 * num22 * num33 + num12 * num23 * num31 + num21 * num32 * num13 - num31 * num22 * num13 - num32 * num23 * num11 - num21 * num12 * num33

            resultadoText.text = resultado.toString()

            //resultadoText.text = resultado.toString()
        }



        btnCalDet.setOnClickListener {
            try {


                val valor1 = numa11.text.toString().toInt()
                val valor2 = numa12.text.toString().toInt()
                val valor3 = numa13.text.toString().toInt()
                val valor4 = numa21.text.toString().toInt()
                val valor5 = numa22.text.toString().toInt()
                val valor6 = numa23.text.toString().toInt()
                val valor7 = numa31.text.toString().toInt()
                val valor8 = numa32.text.toString().toInt()
                val valor9 = numa33.text.toString().toInt()

                calcularDet(valor1, valor2, valor3, valor4, valor5, valor6, valor7, valor8, valor9)
            } catch (e: Exception) {
                Toast.makeText(this, "No hay entrada introducida!", Toast.LENGTH_SHORT).show();
                
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
}