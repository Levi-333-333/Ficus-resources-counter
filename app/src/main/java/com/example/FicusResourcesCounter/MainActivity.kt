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

        // Ячейки третьего уровня
        val countSpellIII: TextView? = findViewById(R.id.countSpellIII);
        val minusButtonSpellIII: Button = findViewById(R.id.minusButtonSpellIII)
        val plusButtonSpellIII: Button = findViewById(R.id.plusButtonSpellIII)

        if (countSpellIII?.text.toString() == "")
            countSpellIII?.setText(MAX_SPELL_III_COUNT.toString())

        minusButtonSpellIII.setOnClickListener {
            countSpellIII?.setText((countSpellIII.text.toString().toInt() - 1).toString())
            if (countSpellIII?.text.toString().toInt() < 0)
                countSpellIII?.setText(0.toString())
        }
        plusButtonSpellIII.setOnClickListener {
            countSpellIII?.setText((countSpellIII.text.toString().toInt() + 1).toString())
            if (countSpellIII?.text.toString().toInt() > MAX_SPELL_III_COUNT)
                countSpellIII?.setText(MAX_SPELL_III_COUNT.toString())
        }

        // Ячейки фокальных заклинаний
        val countFocalSpell: TextView? = findViewById(R.id.countFocalSpell);
        val minusButtonFocalSpell: Button = findViewById(R.id.minusButtonFocalSpell)
        val plusButtonFocalSpell: Button = findViewById(R.id.plusButtonFocalSpell)

        if (countFocalSpell?.text.toString() == "")
            countFocalSpell?.setText(MAX_FOCAL_SPELL_COUNT.toString())

        minusButtonFocalSpell.setOnClickListener {
            countFocalSpell?.setText((countFocalSpell.text.toString().toInt() - 1).toString())
            if (countFocalSpell?.text.toString().toInt() < 0)
                countFocalSpell?.setText(0.toString())
        }
        plusButtonFocalSpell.setOnClickListener {
            countFocalSpell?.setText((countFocalSpell.text.toString().toInt() + 1).toString())
            if (countFocalSpell?.text.toString().toInt() > MAX_FOCAL_SPELL_COUNT)
                countFocalSpell?.setText(MAX_FOCAL_SPELL_COUNT.toString())
        }

        // Фрукты Фикуса
        val countFicusFruits: TextView? = findViewById(R.id.countFicusFruits);
        val minusButtonFicusFruits: Button = findViewById(R.id.minusButtonFicusFruits)
        val plusButtonFicusFruits: Button = findViewById(R.id.plusButtonFicusFruits)

        if (countFicusFruits?.text.toString() == "")
            countFicusFruits?.setText(MAX_FICUS_FRUITS.toString())

        minusButtonFicusFruits.setOnClickListener {
            countFicusFruits?.setText((countFicusFruits.text.toString().toInt() - 1).toString())
            if (countFicusFruits?.text.toString().toInt() < 0)
                countFicusFruits?.setText(0.toString())
        }
        plusButtonFicusFruits.setOnClickListener {
            countFicusFruits?.setText((countFicusFruits.text.toString().toInt() + 1).toString())
            if (countFicusFruits?.text.toString().toInt() > MAX_FICUS_FRUITS)
                countFicusFruits?.setText(MAX_FICUS_FRUITS.toString())
        }

        // Обычные ингридиенты
        val countCommonIngredients: TextView? = findViewById(R.id.countCommonIngredients);
        val minusButtonCommonIngredients: Button = findViewById(R.id.minusButtonCommonIngredients)
        val plusButtonCommonIngredients: Button = findViewById(R.id.plusButtonCommonIngredients)

        if (countCommonIngredients?.text.toString() == "")
            countCommonIngredients?.setText(0.toString())

        minusButtonCommonIngredients.setOnClickListener {
            countCommonIngredients?.setText((countCommonIngredients!!.text.toString().toInt() - 1).toString())
            if (countCommonIngredients?.text.toString().toInt() < 0)
                countCommonIngredients?.setText(0.toString())
        }
        plusButtonCommonIngredients.setOnClickListener {
            countCommonIngredients?.setText((countCommonIngredients!!.text.toString().toInt() + 1).toString())
        }

        // Особые ингридиенты
        val countSpecialIngredients: TextView? = findViewById(R.id.countSpecialIngredients)
        val minusButtonSpecialIngredients: Button = findViewById(R.id.minusButtonSpecialIngredients)
        val plusButtonSpecialIngredients: Button = findViewById(R.id.plusButtonSpecialIngredients)

        if (countSpecialIngredients?.text.toString() == "")
            countSpecialIngredients?.setText(0.toString())

        minusButtonSpecialIngredients.setOnClickListener {
            countSpecialIngredients?.setText((countSpecialIngredients!!.text.toString().toInt() - 1).toString())
            if (countSpecialIngredients?.text.toString().toInt() < 0)
                countSpecialIngredients?.setText(0.toString())
        }
        plusButtonSpecialIngredients.setOnClickListener {
            countSpecialIngredients?.setText((countSpecialIngredients!!.text.toString().toInt() + 1).toString())
        }

        // Инструмент маэстро
        val countMaestrosInstrument: TextView? = findViewById(R.id.countMaestrosInstrument)
        val minusButtonMaestrosInstrument: Button = findViewById(R.id.minusButtonMaestrosInstrument)
        val plusButtonMaestrosInstrument: Button = findViewById(R.id.plusButtonMaestrosInstrument)

        if (countMaestrosInstrument?.text.toString() == "")
            countMaestrosInstrument?.setText(1.toString())

        minusButtonMaestrosInstrument.setOnClickListener {
            countMaestrosInstrument?.setText((countMaestrosInstrument!!.text.toString().toInt() - 1).toString())
            if (countMaestrosInstrument?.text.toString().toInt() < 0)
                countMaestrosInstrument?.setText(0.toString())
        }
        plusButtonMaestrosInstrument.setOnClickListener {
            countMaestrosInstrument?.setText((countMaestrosInstrument!!.text.toString().toInt() + 1).toString())
            if (countMaestrosInstrument?.text.toString().toInt() > 1)
                countMaestrosInstrument?.setText(1.toString())
        }

        // Кнопка "Новый день"
        val NewDayButton: Button = findViewById(R.id.NewDayButton)

        NewDayButton.setOnClickListener {
            // Хиты
            countFicusHP?.setText(MAX_FICUS_HP_COUNT.toString())
            countOwlbearHP?.setText(MAX_OWLBEAR_HP_COUNT.toString())
            // Заклинания
            countSpellI?.setText(MAX_SPELL_I_COUNT.toString())
            countSpellII?.setText(MAX_SPELL_II_COUNT.toString())
            countSpellIII?.setText(MAX_SPELL_III_COUNT.toString())
            countFocalSpell?.setText(MAX_FOCAL_SPELL_COUNT.toString())
            // Фрукты
            countFicusFruits?.setText((countFicusFruits.text.toString().toInt() + 1).toString())
            if (countFicusFruits?.text.toString().toInt() > MAX_FICUS_FRUITS)
                countFicusFruits?.setText(MAX_FICUS_FRUITS.toString())
        }
    }
}