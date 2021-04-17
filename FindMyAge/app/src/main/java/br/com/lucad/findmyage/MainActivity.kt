package br.com.lucad.findmyage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.lucad.findmyage.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    fun buttonGetAgeClick(view:View){
        val userBirthDate:Int = Integer.parseInt(binding.edtDate.text.toString())
        val currentYear:Int = Calendar.getInstance().get(Calendar.YEAR)

        val userAgeYears = currentYear - userBirthDate

        binding.txtAgeResult.text = "Your Age is: $userAgeYears"
    }

}