package com.ahards.facegate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ListAcess : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listacess)

        // Achando o botão voltar | Retornar para MenuActivity
        val menuArrow: ImageView = findViewById(R.id.arrowmenu)
        menuArrow.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent) // Iniciando a nova activity
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }



    }
}
