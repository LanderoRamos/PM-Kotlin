package Configuracion

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.pm_kotlin.R

class PersonaAdapter(private val context: Context, private val personas: List<Persona>) : BaseAdapter() {

    override fun getCount(): Int = personas.size

    override fun getItem(position: Int): Any = personas[position]

    override fun getItemId(position: Int): Long = personas[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.activity_item_persona, parent, false)
        } else {
            view = convertView
        }

        val persona = getItem(position) as Persona
        val tvNombre = view.findViewById<TextView>(R.id.tvNombre)
        val tvCorreo = view.findViewById<TextView>(R.id.tvCorreo)

        tvNombre.text = persona.nombre
        tvCorreo.text = persona.correo

        return view
    }
}
