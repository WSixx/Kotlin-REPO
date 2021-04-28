package br.com.lucad.brqandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button_login.setOnClickListener {
            Toast.makeText(this,  "Button Login Clicked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,LoginActivity2::class.java)
            startActivity(intent)

        }
    }
}