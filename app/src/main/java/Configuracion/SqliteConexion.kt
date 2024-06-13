package Configuracion

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteConexion(context: Context) : SQLiteOpenHelper(
    context, "PM01", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        //query
        val ordenCreacion = "CREATE TABLE personas (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT, " +
                "apellido TEXT, " +
                "edad INTEGER, " +
                "correo TEXT, " +
                "foto TEXT )"
        //ejecutador del query
        db!!.execSQL(ordenCreacion)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenborrar = "DROP TABLE IF EXISTS personas"
        db!!.execSQL(ordenborrar)
        onCreate(db)
    }

    fun agregardatos(nombre: String,apellido: String, correo: String, edad: Int){

        val datos = ContentValues()
        datos.put("nombre", nombre)
        datos.put("apellido", apellido)
        datos.put("correo", correo)
        datos.put("edad", edad)


        val db = this.writableDatabase
        db.insert("personas",null,datos)
        db.close()
    }

    fun getAllPersonas(): List<Persona> {
        val personas = mutableListOf<Persona>()
        val db = this.readableDatabase
        val cursor = db.query("personas", arrayOf("id", "nombre", "correo"),
            null, null, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
                val correo = cursor.getString(cursor.getColumnIndexOrThrow("correo"))
                personas.add(Persona(id, nombre, correo))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return personas
    }
}

data class Persona(val id: Int, val nombre: String, val correo: String)
