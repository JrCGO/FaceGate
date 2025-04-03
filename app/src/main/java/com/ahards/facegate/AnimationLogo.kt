package com.ahards.facegate

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AnimationLogo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_animation_logo)

        val logo = findViewById<ImageView>(R.id.logoImage)
        val rootView = findViewById<View>(android.R.id.content)

        // Começa com a logo invisível e pequena
        logo.alpha = 0f
        logo.scaleX = 0.5f
        logo.scaleY = 0.5f

        // Animação de fade-in e zoom simultâneo
        val fadeIn = ObjectAnimator.ofFloat(logo, "alpha", 0f, 1f)
        fadeIn.setDuration(1500)

        val zoomInX = ObjectAnimator.ofFloat(logo, "scaleX", 0.5f, 1f)
        zoomInX.setDuration(1500)

        val zoomInY = ObjectAnimator.ofFloat(logo, "scaleY", 0.5f, 1f)
        zoomInY.setDuration(1500)

        // Inicia a animação de fade-in + zoom
        fadeIn.start()
        zoomInX.start()
        zoomInY.start()

        // Aguarda o tempo e depois faz o zoom total para branco
        Handler(Looper.getMainLooper()).postDelayed({
            val zoomOutX = ObjectAnimator.ofFloat(logo, "scaleX", 1f, 10f)
            val zoomOutY = ObjectAnimator.ofFloat(logo, "scaleY", 1f, 10f)
            val fadeToWhite = ObjectAnimator.ofFloat(logo, "alpha", 1f, 0f)

            zoomOutX.setDuration(1000)
            zoomOutY.setDuration(1000)
            fadeToWhite.setDuration(1000)

            zoomOutX.start()
            zoomOutY.start()
            fadeToWhite.start()
            fadeToWhite.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    rootView.setBackgroundColor(Color.WHITE) // Muda a tela para branco
                    startActivity(Intent(this@AnimationLogo, CadastroUsuario::class.java))
                    finish()
                    overridePendingTransition(R.anim.basic_in, R.anim.basic_out);
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })
        }, 4000) // Inicia o efeito de zoom total após 2 segundos
    }
}

