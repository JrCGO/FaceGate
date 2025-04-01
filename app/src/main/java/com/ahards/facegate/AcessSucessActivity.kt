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

class AcessSucessActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acesssucessoactivity)

        // Obtendo a data e hora atual
        val currentDate = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR"))
        val formattedDate = dateFormat.format(currentDate.time)

        // Exibir a data e hora no TextView
        val dateTextView: TextView = findViewById(R.id.dateTextView)
        dateTextView.text = formattedDate

        // Delay de 250ms para iniciar o som
        Handler().postDelayed({
            mediaPlayer = MediaPlayer.create(this, R.raw.sucess)
            mediaPlayer?.start()
        }, 250)

        // Atrasar a navegação para MainActivity após 3 segundos
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
            overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
        }, 3000)
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release() // Libera recursos do MediaPlayer
        mediaPlayer = null
    }
}
