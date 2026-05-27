package com.example.FicusResourcesCounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ХП Фикуса
        val countFicusHP: TextView? = findViewById(R.id.countFicusHP);
        val minusButtonFicusHP: Button = findViewById(R.id.minusButtonFicusHP)
        val plusButtonFicusHP: Button = findViewById(R.id.plusButtonFicusHP)

        if (countFicusHP?.text.toString() == "")
            countFicusHP?.setText(MAX_FICUS_HP_COUNT.toString())

        minusButtonFicusHP.setOnClickListener {
            countFicusHP?.setText((countFicusHP.text!!.toString().toInt() - 1).toString())
            if (countFicusHP?.text.toString().toInt() < 0)
                countFicusHP?.setText(0.toString())
        }
        plusButtonFicusHP.setOnClickListener {
            countFicusHP?.setText((countFicusHP.text!!.toString().toInt() + 1).toString())
            if (countFicusHP?.text.toString().toInt() > MAX_FICUS_HP_COUNT)
                countFicusHP?.setText(MAX_FICUS_HP_COUNT.toString())
        }

        // ХП Совомеда
        val countOwlbearHP: TextView? = findViewById(R.id.countOwlbearHP);
        val minusButtonOwlbearHP: Button = findViewById(R.id.minusButtonOwlbearHP)
        val plusButtonOwlbearHP: Button = findViewById(R.id.plusButtonOwlbearHP)

        if (countOwlbearHP?.text.toString() == "")
            countOwlbearHP?.setText(MAX_OWLBEAR_HP_COUNT.toString())

        minusButtonOwlbearHP.setOnClickListener {
            countOwlbearHP?.setText((countOwlbearHP.text!!.toString().toInt() - 1).toString())
            if (countOwlbearHP?.text.toString().toInt() < 0)
                countOwlbearHP?.setText(0.toString())
        }
        plusButtonOwlbearHP.setOnClickListener {
            countOwlbearHP?.setText((countOwlbearHP.text!!.toString().toInt() + 1).toString())
            if (countOwlbearHP?.text.toString().toInt() > MAX_OWLBEAR_HP_COUNT)
                countOwlbearHP?.setText(MAX_OWLBEAR_HP_COUNT.toString())
        }

        // Ячейки первого уровня
        val countSpellI: TextView? = findViewById(R.id.countSpellI);
        val minusButtonSpellI: Button = findViewById(R.id.minusButtonSpellI)
        val plusButtonSpellI: Button = findViewById(R.id.plusButtonSpellI)

        if (countSpellI?.text.toString() == "")
            countSpellI?.setText(MAX_SPELL_I_COUNT.toString())

        minusButtonSpellI.setOnClickListener {
            countSpellI?.setText((countSpellI.text!!.toString().toInt() - 1).toString())
            if (countSpellI?.text.toString().toInt() < 0)
                countSpellI?.setText(0.toString())
        }
        plusButtonSpellI.setOnClickListener {
            countSpellI?.setText((countSpellI.text!!.toString().toInt() + 1).toString())
            if (countSpellI?.text.toString().toInt() > MAX_SPELL_I_COUNT)
                countSpellI?.setText(MAX_SPELL_I_COUNT.toString())
        }

        // Ячейки второго уровня
        val countSpellII: TextView? = findViewById(R.id.countSpellII);
        val minusButtonSpellII: Button = findViewById(R.id.minusButtonSpellII)
        val plusButtonSpellII: Button = findViewById(R.id.plusButtonSpellII)

        if (countSpellII?.text.toString() == "")
            countSpellII?.setText(MAX_SPELL_II_COUNT.toString())

        minusButtonSpellII.setOnClickListener {
            countSpellII?.setText((countSpellII.text.toString().toInt() - 1).toString())
            if (countSpellII?.text.toString().toInt() < 0)
                countSpellII?.setText(0.toString())
        }
        plusButtonSpellII.setOnClickListener {
            countSpellII?.setText((countSpellII.text.toString().toInt() + 1).toString())
            if (countSpellII?.text.toString().toInt() > MAX_SPELL_II_COUNT)
                countSpellII?.setText(MAX_SPELL_II_COUNT.toString())
        }
    }
}