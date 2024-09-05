package com.nomaddeveloper.haleki.ui

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import com.nomaddeveloper.haleki.R
import com.nomaddeveloper.haleki.databinding.ActivityGameBinding
import com.nomaddeveloper.haleki.util.Constant.MAX_ROWS
import com.nomaddeveloper.haleki.util.Constant.WORD_LENGTH
import com.nomaddeveloper.haleki.util.ViewUtil

class GameActivity : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityGameBinding
    private lateinit var gridLayoutGuess: GridLayout
    private lateinit var buttonSubmit: MaterialButton
    private lateinit var inputEditText: EditText

    private var currentRow = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)

        ViewUtil.apply {
            setContentView(this@GameActivity, binding)
            edgeToEdge(this@GameActivity, binding.root)
        }
        initGameMap()
    }

    private fun initGameMap() {
        binding.apply {
            gridLayoutGuess = gridLayoutGuessWord
            buttonSubmit = buttonSubmitInput
            inputEditText = edittextInput
        }
        buttonSubmit.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.let {
            when (it.id) {
                buttonSubmit.id -> {
                    handleGuess()
                }
            }
        }
    }

    private fun handleGuess() {
        val guess = inputEditText.text.toString().trim()
        if (guess.length == WORD_LENGTH) {
            updateGridWithGuess(guess)
            inputEditText.text.clear()
        } else {
            inputEditText.error = getString(R.string.error_must_be_5_letters)
        }
    }

    private fun updateGridWithGuess(guess: String) {
        if (currentRow >= MAX_ROWS) return
        val rowLayout = gridLayoutGuess.getChildAt(currentRow) as LinearLayout

        for (i in 0 until WORD_LENGTH) {
            val textView = rowLayout.getChildAt(i) as TextView
            textView.text = guess[i].toString()
        }
        currentRow++
        if (currentRow == WORD_LENGTH) {
            handleResult()
        }
    }

    private fun handleResult() {

    }

}