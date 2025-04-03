package com.ahards.facegate

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class RecognizedActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recognizedactivity)

        val statusImageView: ImageView = findViewById(R.id.status_recognized_1)

        // Carregando animações corretamente
        val basicOut = AnimationUtils.loadAnimation(this, R.anim.basic_out)
        val basicIn = AnimationUtils.loadAnimation(this, R.anim.basic_in)

        Handler(Looper.getMainLooper()).postDelayed({
            // Alterando a imagem para a nova
            statusImageView.setImageResource(R.drawable.status_recognized_2)

            // Aplicando basicIn à nova imagem
            statusImageView.startAnimation(basicIn)

            Handler(Looper.getMainLooper()).postDelayed({
                // Intent para próxima tela
                val intent = Intent(this, AcessSucessActivity::class.java)
                startActivity(intent)
                finish()

                // Aplicando transição suave
                overridePendingTransition(R.anim.basic_in, R.anim.basic_out)
            }, 1500)  // Tempo para exibir a segunda imagem
        }, 600)  // Tempo para concluir o basicOut antes da troca
    }
}

