package br.com.lucad.brqandroid.views

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.lucad.brqandroid.MainActivity
import br.com.lucad.brqandroid.R
import br.com.lucad.brqandroid.model.User


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.button_login)
        val editEmail = findViewById<EditText>(R.id.edit_email)
        val editPassword = findViewById<EditText>(R.id.edit_password)


        buttonLogin.setOnClickListener {
            val user = User(editEmail.text.toString(), editPassword.text.toString())
            if(!user.validarEmail() && !user.validarSenha()){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this,  "Login ou password", Toast.LENGTH_SHORT).show()
            }
        }
    }
}