package br.com.lucad.contentproviderclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.actions.FloatAction
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var notesRecycle: RecyclerView
    lateinit var notesRefreshButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notesRefreshButton = findViewById(R.id.client_button_refresh)
        notesRecycle = findViewById(R.id.client_list)

        notesRefreshButton.setOnClickListener{

        }
    }
}