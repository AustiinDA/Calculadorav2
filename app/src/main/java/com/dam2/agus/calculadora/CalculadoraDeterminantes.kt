package com.dam2.agus.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class CalculadoraDeterminantes : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var navVista: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora_determinantes)

        val btnMenu2x2 = findViewById<Button>(R.id.btnMenu2x2)
        val btnMenu3x3 = findViewById<Button>(R.id.btnMenu3x3)

        val toolbar: Toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true);

        val navVista: NavigationView = findViewById(R.id.navVistaD)
        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayoutDeterminantesGeneral)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navVista.setNavigationItemSelectedListener {
            val intent = Intent(this, McdYMcm::class.java)
            val intent2 = Intent(this, MainActivity::class.java)
            val intent3 = Intent(this, CalculadoraDeterminantes::class.java)

            when (it.itemId) {
                R.id.miItem1 -> {
                    startActivity(intent2)
                    Toast.makeText(
                        applicationContext,
                        "Clicked item1 ", Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.miItem2 -> {
                    startActivity(intent)
                    Toast.makeText(
                        applicationContext,
                        "Clicked item2 ", Toast.LENGTH_SHORT
                    ).show()
                }
                R.id.miItem3 -> {
                    startActivity(intent3)
                    Toast.makeText(
                        applicationContext,
                        "Clicked item3 ", Toast.LENGTH_SHORT
                    ).show()
                }
            }
            true
        }

        btnMenu2x2.setOnClickListener{
            val intent = Intent(this, Determinantes2X2::class.java)
            startActivity(intent)
        }

        btnMenu3x3.setOnClickListener{
            val intent2 = Intent(this, Determinantes3X3::class.java)
            startActivity(intent2)
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            true
        return super.onOptionsItemSelected(item)
    }




}