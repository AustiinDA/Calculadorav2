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

class Cramer2x2 : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cramer2x2)

        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaC)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutCramer2x2)

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

        val btnCalDeterminante = findViewById<Button>(R.id.btnCramer2x2)
        val num1 = findViewById<EditText>(R.id.edtA1)
        val num2 = findViewById<EditText>(R.id.edtY1)
        val num3 = findViewById<EditText>(R.id.etA3)
        val num4 = findViewById<EditText>(R.id.etY3)

        val termI1 = findViewById<EditText>(R.id.EtC1)
        val termI2 = findViewById<EditText>(R.id.EtC2)
        val resultadoIgX = findViewById<TextView>(R.id.tv_resulX)
        val resultadoIgY = findViewById<TextView>(R.id.tv_resulY)


        fun calcularIncog(num1: Int, num2: Int, num3: Int, num4: Int, termI1: Int, termI2: Int) {
            var detX: Int = 0
            var detY: Int = 0
            var detS: Int = 0
            //Calculo de los determinantes
            detS = num1 * num4 - num3 * num2
            detX = termI1 * num4 - num2 * termI2
            detY = num1 * termI2 - num3 * termI1

            var resultadoX: Int = 0
            var resultadoY: Int = 0
            //Calculo de las incognitas
            resultadoX = detX / detS
            resultadoY = detY / detS

            resultadoIgX.text = resultadoX.toString()
            resultadoIgY.text = resultadoY.toString()
        }

        btnCalDeterminante.setOnClickListener {
            val valor1 = num1.text.toString().toInt()
            val valor2 = num2.text.toString().toInt()
            val valor3 = num3.text.toString().toInt()
            val valor4 = num4.text.toString().toInt()
            val deter1 = termI1.text.toString().toInt()
            val deter2 = termI2.text.toString().toInt()
            calcularIncog(valor1, valor2, valor3, valor4, deter1, deter2)

         /*   if (valor1.toString().isEmpty()){
                    Toast.makeText(baseContext, "No has introducido valores", Toast.LENGTH_SHORT).show();
            }else if (valor2.toString().isEmpty()){
                    Toast.makeText(baseContext, "No has introducido valores", Toast.LENGTH_SHORT).show();
            }else if (valor3.toString().isEmpty()){
                    Toast.makeText(baseContext, "No has introducido valores", Toast.LENGTH_SHORT).show();
            }else if (valor4.toString().isEmpty()){
                    Toast.makeText(baseContext, "No has introducido valores", Toast.LENGTH_SHORT).show();
            }else{
            }
*/
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }
}