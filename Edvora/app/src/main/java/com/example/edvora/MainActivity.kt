package com.example.edvora

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.edvora.adapter.RidesAdapter
import com.example.edvora.api.Service
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = Retrofit.Builder()
            .baseUrl("https://assessment.api.vweb.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = builder.create(Service::class.java)

        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.visibility = View.VISIBLE

        lifecycleScope.launch {
            try{
            val response = service.ListRides()
            progressBar.visibility = View.GONE

            val adapter = RidesAdapter(response)
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.adapter = adapter
        }catch(e: Exception){
                Toast.makeText(applicationContext, "Could not connect", Toast.LENGTH_SHORT).show()
                progressBar.visibility = View.GONE
            }
        }
        val filterImage = findViewById<ImageView>(R.id.filterImage)
        val menuAuto = findViewById<AutoCompleteTextView>(R.id.menuAuto)
        val menu = findViewById<TextInputLayout>(R.id.menu)
        filterImage.setOnClickListener {
            menu.visibility = View.VISIBLE
        }
        val root   = findViewById<CoordinatorLayout>(R.id.root)
        root.setOnClickListener {
            menu.visibility = View.GONE
        }
        val items = listOf("Option 1", "Option 2", "Option 3", "Option 4")
        val adapter = ArrayAdapter<String>(this,R.layout.list_item, items)
        menuAuto.setAdapter(adapter)

        menuAuto.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "This item", Toast.LENGTH_SHORT).show()
        }

        val nearest = findViewById<TextView>(R.id.Nearest)
        nearest.setOnClickListener {
            nearest.text = Html.fromHtml("<u>Nearest</u>")
        }

    }

}