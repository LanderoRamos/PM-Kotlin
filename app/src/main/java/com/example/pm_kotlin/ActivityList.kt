package com.example.pm_kotlin

import Configuracion.PersonaAdapter
import Configuracion.SqliteConexion
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.cursoradapter.widget.CursorAdapter

class ActivityList : AppCompatActivity() {
    lateinit var personasql: SqliteConexion


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets }

        /*personasql = SqliteConexion(this)

        val db : SQLiteDatabase = personasql.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM personas", null
        )*/

        var listView = findViewById<ListView>(R.id.listapersona)
        var databaseHelper = SqliteConexion(this)

        val personas = databaseHelper.getAllPersonas()
        val adapter = PersonaAdapter(this, personas)
        listView.adapter = adapter

    }

    /*inner class CursoAdapterlistView(context: Context, cursor: Cursor) : CursorAdapter(context, cursor, FLAG_REGISTER_CONTENT_OBSERVER){
        override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
            val inflater = LayoutInflater.from(context)
            return inflater.inflate(R.layout.activity_list, parent, false)
        }

        override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
            val lista = findViewById<ListView>(R.id.listapersona)
            val nombre = cursor!!.getString(1)

        }

    }*/

    fun obtenerdatos(){
       /* val db : SQLiteDatabase = personasql.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM personas",null)

        if (cursor.moveToFirst()){
            do{

            }while (cursor.moveToNext())
        }*/
    }
}