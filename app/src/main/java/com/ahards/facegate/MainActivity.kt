package com.ahards.facegate

import android.animation.AnimatorInflater
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import android.content.Intent
import android.widget.ImageView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mainactivity)

        // Carregando as animações de fade-out e fade-in do arquivo XML
        val fadeOut = AnimatorInflater.loadAnimator(this, R.animator.fade_out)
        val fadeIn = AnimatorInflater.loadAnimator(this, R.animator.fade_in)

        // Obtendo o TextView para exibir a data
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        // Obtendo o TextView para exibir o dia da semana
        val weekDayTextView: TextView = findViewById(R.id.weekDayTextView)

        // Criando o objeto Calendar para pegar a data atual
        val currentDate = Calendar.getInstance()

        // Formatar a data como "28 de mar"
        val dateFormat = SimpleDateFormat("d 'de' MMM", Locale("pt", "BR"))
        // Remover o ponto "." no final
        val formattedDate = dateFormat.format(currentDate.time).replace(".", "")

        // Atualizando a TextView com a data formatada
        dateTextView.text = formattedDate

        // Formatar o nome do dia da semana como "quinta-feira"
        val weekDayFormat = SimpleDateFormat("EEEE", Locale("pt", "BR"))
        val formattedWeekDay =
            weekDayFormat.format(currentDate.time).toLowerCase(Locale("pt", "BR"))

        // Atualizando a TextView com o nome do dia da semana em minúsculas
        weekDayTextView.text = formattedWeekDay


        // Encontrando o botão btn_acess
        val btnAcess: androidx.appcompat.widget.AppCompatButton = findViewById(R.id.btn_acess)

        // Configurando o clique no botão para navegar para RecognizedActivity
        btnAcess.setOnClickListener {
            // Criando o Intent para abrir a nova Activity
            val intent = Intent(this, RecognizedActivity::class.java)
            startActivity(intent) // Iniciando a nova Activity
            //overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)

        }

        // Encontrando a imagem logo
        val logoAhards: ImageView = findViewById(R.id.logo_ahards)

        // Configurando o clique na imagem para navegar para MenuActivity
        logoAhards.setOnClickListener {
            //Criando o Intent para abrir a nova Activity
            val intent = Intent(this, AcessBlocked::class.java)
            startActivity(intent) // Iniciando a nova activity
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)

        }

        // Encontrando a imagem Hamburguer
        val menuHamburguer: ImageView = findViewById(R.id.btn_hamburguer)
        menuHamburguer.setOnClickListener {
            //Criando o Intent para abrir a nova Activity
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent) // Iniciando a nova activity
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }

    }
}


