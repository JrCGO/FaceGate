package com.ahards.facegate

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class CadastroUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cadastro_usuario)

        // Botão de voltar para o menu
        val menuArrow: ImageView = findViewById(R.id.btn_menu_arrow)
        menuArrow.setOnClickListener {
            val intent = Intent(this, Funcionarios::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }
    }
}