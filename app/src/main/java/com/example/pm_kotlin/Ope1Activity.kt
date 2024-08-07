package com.example.pm_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ope1Activity : AppCompatActivity() {

    public var resultado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ope1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var TextN2 = findViewById<EditText>(R.id.editTextN2)
        var TextN1 = findViewById<EditText>(R.id.editTextN1)



        val btnsuma = findViewById<Button>(R.id.btnsuma)
        btnsuma.setOnClickListener{
            sumarNumeros(TextN1.text.toString().toInt(), TextN2.text.toString().toInt());
        }

        val btnrest = findViewById<Button>(R.id.btnresta)
        btnrest.setOnClickListener{
            restaNumeros(TextN1.text.toString().toInt(), TextN2.text.toString().toInt());
        }

        val btnmulti = findViewById<Button>(R.id.btnmulti)
        btnmulti.setOnClickListener{
            multiNumeros(TextN1.text.toString().toInt(), TextN2.text.toString().toInt());
        }

        val btndiv = findViewById<Button>(R.id.btndiv)
        btndiv.setOnClickListener{
            divNumeros(TextN1.text.toString().toInt(), TextN2.text.toString().toInt());
        }

    }

    private fun sumarNumeros(n1: Int,n2: Int) {
        val a = n1
        val b = n2
        val resultado = sumar(a, b)

        // Crear un Intent para abrir SecondActivity y enviar el resultado
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("resultado", resultado)
        startActivity(intent)
    }

    // Función para realizar la suma
    private fun sumar(a: Int, b: Int): Int {
        return a + b
    }

    private fun restaNumeros(n1: Int,n2: Int) {
        val a = n1
        val b = n2
        resultado = resta(a, b)
        //textResultado.text = "Resultado: $resultado"
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("resultado", resultado)
        startActivity(intent)
    }


    private fun resta(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiNumeros(n1: Int,n2: Int) {
        val a = n1
        val b = n2
        resultado = multi(a, b)
        //textResultado.text = "Resultado: $resultado"
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("resultado", resultado)
        startActivity(intent)
    }


    private fun multi(a: Int, b: Int): Int {
        return a * b
    }

    private fun divNumeros(n1: Int,n2: Int) {
        val a = n1
        val b = n2
        resultado = div(a, b)
        //textResultado.text = "Resultado: $resultado"
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("resultado", resultado)
        startActivity(intent)
    }


    private fun div(a: Int, b: Int): Int {
        return a / b
    }

}