package com.ahards.facegate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class ListAcess : AppCompatActivity() {

    private var selectedButton: Button? = null // Armazena o botão selecionado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recibo_de_acesso)

        // Botão de voltar para o menu
        val menuArrow: ImageView = findViewById(R.id.btn_menu_arrow)
        menuArrow.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }

        // Botão para alternar a visibilidade do layout de filtros
        val filterIcon: ImageView = findViewById(R.id.icon_menu_filter)
        val filterLayout: LinearLayout = findViewById(R.id.filterLayout)

        // Deixar invisível por padrão (apenas por precaução, já está no XML)
        filterLayout.visibility = View.GONE

        filterIcon.setOnClickListener {
            filterLayout.visibility = if (filterLayout.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        // Encontrar os botões de filtro
        val btnLiberado: Button = findViewById(R.id.btn_filter_liberado)
        val btnBloqueado: Button = findViewById(R.id.btn_filter_bloqueado)
        val btnNegado: Button = findViewById(R.id.btn_filter_nreconhecido)

        // Criar uma lista de botões para alternar estado
        val buttons = listOf(btnLiberado, btnBloqueado, btnNegado)

        // Configurar clique para cada botão
        buttons.forEach { button ->
            button.setOnClickListener {
                toggleButtonState(button, buttons)
            }
        }
    }

    private fun toggleButtonState(button: Button, allButtons: List<Button>) {
        if (selectedButton == button) {
            // Se clicar novamente no mesmo botão, desmarca
            button.setBackgroundResource(R.drawable.btn_menu_filter)
            button.setTextColor(ContextCompat.getColor(this, R.color.btn_menu_filter)) // Cor original do texto
            selectedButton = null
        } else {
            // Desmarca todos os botões antes de selecionar um novo
            allButtons.forEach {
                it.setBackgroundResource(R.drawable.btn_menu_filter)
                it.setTextColor(ContextCompat.getColor(this, R.color.btn_menu_filter)) // Cor original do texto
            }

            // Marca o botão atual como selecionado
            button.setBackgroundResource(R.drawable.btn_menu_filter_pressed) // Fundo alterado
            button.setTextColor(ContextCompat.getColor(this, R.color.White)) // Texto branco
            selectedButton = button
        }
    }
}

