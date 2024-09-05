package com.nomaddeveloper.haleki.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.google.android.material.button.MaterialButton
import com.nomaddeveloper.haleki.databinding.ActivityMainBinding
import com.nomaddeveloper.haleki.util.ViewUtil

class MainActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var startGameButton: MaterialButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        ViewUtil.apply {
            setContentView(this@MainActivity, binding)
            edgeToEdge(this@MainActivity, binding.root)
        }
        initViews()
    }

    private fun startGame() {
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun initViews() {
        binding.apply {
            startGameButton = buttonStartGame
        }
        startGameButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                startGameButton.id -> startGame()
            }
        }
    }
}