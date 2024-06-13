package com.example.pm_kotlin

import Configuracion.SqliteConexion
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityFormulario : AppCompatActivity() {

    /*val nombre = findViewById<EditText>(R.id.nombre)
    val apellido = findViewById<EditText>(R.id.apellido)
    val correo = findViewById<EditText>(R.id.correo)
    val edad = findViewById<EditText>(R.id.edad)
    val btnagregar = findViewById<Button>(R.id.btnIngresar)*/

    lateinit var personasql: SqliteConexion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_formulario)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets}

        personasql = SqliteConexion(this)

        //variables aqui porque arriba parece que es error de codigo
        val nombre = findViewById<EditText>(R.id.nombre)
        val apellido = findViewById<EditText>(R.id.apellido)
        val correo = findViewById<EditText>(R.id.correo)
        val edad = findViewById<EditText>(R.id.edad)
        val btnagregar = findViewById<Button>(R.id.btnIngresar)

        btnagregar.setOnClickListener {
            //Toast.makeText(this, ""+nombre.text+" "+apellido.text, Toast.LENGTH_LONG).show()
            if(nombre.text.isNotBlank() && apellido.text.isNotBlank() && correo.text.isNotBlank() && edad.text.isNotBlank()){

                personasql.agregardatos(
                    nombre.text.toString(), apellido.text.toString(), correo.text.toString(), Integer.parseInt(edad.text.toString())
                )
                Toast.makeText(this, "Se ha Guardado con Exito", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No se ha guardado", Toast.LENGTH_LONG).show()
            }
        }
    }

}