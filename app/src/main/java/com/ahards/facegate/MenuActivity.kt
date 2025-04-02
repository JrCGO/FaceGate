package com.ahards.facegate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.ImageView
import androidx.cardview.widget.CardView
import android.view.View
import android.widget.LinearLayout


class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menuactivity)

        // Achando o botão voltar | Retornar para MainActivity
        val menuArrow: ImageView = findViewById(R.id.btn_menu_arrow)
        menuArrow.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Iniciando a nova activity
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }

        // Achando a botão: Lista de Acessos | Ir para ListAcess
        val AcessList: CardView = findViewById(R.id.menu_btn_listAcess)
        AcessList.setOnClickListener {
            val intent = Intent(this, ListAcess::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }


    }
}
