package com.ahards.facegate

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AcessNotRecognizedActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acessnotrecognizedactivity)

        // Obtendo a data e hora atual
        val currentDate = Calendar.getInstance()

        // Formatando a data e hora no formato "dd/MM/yyyy HH:mm"
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
        val formattedDate = dateFormat.format(currentDate.time)

        // Encontrando para exibir a data e hora
        val dateTextView: TextView = findViewById(R.id.dateTextView)

        // Exibindo a data e hora formatada no TextView
        dateTextView.text = formattedDate

        // Delay de 250ms para iniciar o som
        Handler().postDelayed({
            mediaPlayer = MediaPlayer.create(this, R.raw.notrecognized)
            mediaPlayer?.start()
        }, 250)

        // Atrasar a navegação para MainActivity após 3000ms (3 segundos)
        Handler().postDelayed({
            // Criando o Intent para abrir a MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent) // Iniciando a MainActivity

            // Finaliza a AcessSucessActivity
            finish()
            //overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }, 3000) // 3000ms = 3 segundos
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Libera recursos do MediaPlayer
        mediaPlayer = null
    }

}

