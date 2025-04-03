package com.ahards.facegate

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Button
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class Funcionarios : AppCompatActivity() {

    private var selectedButton: Button? = null // Armazena o botão selecionado

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionarios)

        // Botão de voltar para o menu
        val menuArrow: ImageView = findViewById(R.id.btn_menu_arrow)
        menuArrow.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }


        // Achando o CardView: Funcionário | Ir para CadastroUsuario
        val CadastroUser: CardView = findViewById(R.id.cardViewFunc)
        CadastroUser.setOnClickListener {
            val intent = Intent(this, CadastroUsuario::class.java)
            startActivity(intent)
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }

        // Botão para alternar a visibilidade do layout de filtros
        val filterIcon: ImageView = findViewById(R.id.icon_menu_filter)
        val filterLayout: LinearLayout = findViewById(R.id.filterLayout)

        // Deixar invisível por padrão
        filterLayout.visibility = View.GONE

        filterIcon.setOnClickListener {
            filterLayout.visibility = if (filterLayout.visibility == View.GONE) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        // Encontrar os botões de filtro
        val btnCadastrado: Button = findViewById(R.id.btn_filter_cadastrado)
        val btnSemfacial: Button = findViewById(R.id.btn_filter_semfacial)

        // Criar uma lista de botões para alternar estado
        val buttons = listOf(btnCadastrado, btnSemfacial)

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

