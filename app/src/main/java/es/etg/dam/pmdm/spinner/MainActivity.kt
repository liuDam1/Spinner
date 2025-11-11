package es.etg.dam.pmdm.spinner

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Parte de Spinner
        val sp: Spinner = findViewById(R.id.spinner)
        sp.adapter = getAdapter()
        sp.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(view?.context, "Seleccionado $position", Toast.LENGTH_SHORT).show()
            }
        }

        // Parte de ListView
        val lv: ListView = findViewById(R.id.listView)
        lv.adapter = getAdapter()
        lv.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                Toast.makeText(view?.context, "Seleccionado $position", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Funcion para cargar las listas usando XML
    fun getAdapter(): ArrayAdapter<CharSequence> {
        val adapter = ArrayAdapter.createFromResource(this,
            R.array.lista_ciudades,
            android.R.layout.simple_spinner_item)
        return adapter;
    }

    // Funcion para cargar las listas usando Array
//    fun getAdapter(): ArrayAdapter<String> {
//        val ciudades = arrayOf("Parla", "Barcelona", "Madrid")
//        val adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item,ciudades)
//        return adapter;
//    }
}