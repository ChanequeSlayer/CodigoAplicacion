package com.example.bdapp

import android.content.ContentValues
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import androidx.drawerlayout.widget.DrawerLayout


import androidx.appcompat.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var txtUsuario:EditText?=null
    var txtMembrecia:EditText?=null
    var txtApellidoP:EditText?=null
    var txtApellidoM:EditText?=null
    var txtEdad: EditText?=null
    var txtTelefono:EditText?=null
    var txtDireccion:EditText?=null







    private lateinit var drawer: DrawerLayout
    private lateinit var toggle: ActionBarDrawerToggle


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        txtMembrecia = findViewById(R.id.txtMembrecia)
        txtUsuario = findViewById(R.id.txtUsuario)
        txtApellidoP = findViewById(R.id.txtApellidoP)
        txtApellidoM = findViewById(R.id.txtApellidoM)
        txtEdad = findViewById(R.id.txtEdad)
        txtTelefono = findViewById(R.id.txtTelefono)
        txtDireccion = findViewById(R.id. txtDireccion)





        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)

        drawer = findViewById(R.id.drawer_layout)

        toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }
    fun insertar(view: View){
        var con=SQLite(this,"Vales",null,1)
        var baseDatos = con.writableDatabase

        var membrecia = txtMembrecia?.text.toString()
        var nombre = txtUsuario?.text.toString()
        var apellidoP = txtApellidoP?.text.toString()
        var apellidoM = txtApellidoM?.text.toString()
        var edad = txtEdad?.text.toString()
        var Telefono = txtTelefono?.text.toString()
        var Direccion = txtDireccion?.text.toString()
        if(membrecia.isEmpty() == false && nombre.isEmpty() == false && apellidoP.isEmpty() == false && apellidoM.isEmpty() == false &&
                edad.isEmpty() == false && Telefono.isEmpty() == false && Direccion.isEmpty() == false){
                var registro = ContentValues()
                registro.put("membrecia",membrecia)
                registro.put("nombre", nombre)
                registro.put("apellidoP", apellidoP)
                registro.put("apellidoM", apellidoM)
                registro.put("edad", edad)
                registro.put("Telefono", Telefono)
                registro.put("Direccion", Direccion)

                baseDatos.insert("usuarios",null,registro)

                txtMembrecia?.setText("");
                txtUsuario?.setText("");
                txtApellidoP?.setText("");
                txtApellidoM?.setText("");
                txtEdad?.setText("");
                txtTelefono?.setText("");
                txtDireccion?.setText("");
            Toast.makeText(this,"Se ha insertado exitosamente",Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"Los campos deben estar llenos para su registro",Toast.LENGTH_LONG).show()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_one -> Toast.makeText(this, "Item 1", Toast.LENGTH_SHORT).show()
            R.id.nav_item_two -> Toast.makeText(this, "Item 2", Toast.LENGTH_SHORT).show()
            R.id.nav_item_three -> Toast.makeText(this, "Item 3", Toast.LENGTH_SHORT).show()
        }

        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


}

