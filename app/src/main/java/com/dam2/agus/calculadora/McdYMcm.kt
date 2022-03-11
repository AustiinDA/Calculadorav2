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

class McdYMcm : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mcm_mcd_activity)

        val btnCal = findViewById<Button>(R.id.btnCalcular)

        val num1 = findViewById<EditText>(R.id.edtA1)
        val num2 = findViewById<EditText>(R.id.etNum2)

        var resul1 = findViewById<TextView>(R.id.textoResul1)
        val resul2 = findViewById<TextView>(R.id.textoResul2)


        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaMcm)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutMcm)

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

            try {
                val valor1 = num1.text.toString().toInt()
                val valor2 = num2.text.toString().toInt()

                calcularMcm(valor1, valor2)
                calcularMcd(valor1, valor2)
            } catch (e: Exception) {
                Toast.makeText(this,"No hay entrada introducida!" , Toast.LENGTH_SHORT).show();
                num1.error = "No hay entrada"
                num2.error = "No hay entrada"
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)


        // val intent = Intent(this, mcd_mcm::class.java)
        // startActivity(intent)
    }


}