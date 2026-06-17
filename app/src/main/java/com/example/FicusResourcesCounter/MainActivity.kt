package com.example.FicusResourcesCounter

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val countFicusHP: TextView? = findViewById(R.id.countFicusHP);
    private val minusButtonFicusHP: Button = findViewById(R.id.minusButtonFicusHP)
    private val plusButtonFicusHP: Button = findViewById(R.id.plusButtonFicusHP)

    private val countOwlbearHP: TextView? = findViewById(R.id.countOwlbearHP);
    private val minusButtonOwlbearHP: Button = findViewById(R.id.minusButtonOwlbearHP)
    private val plusButtonOwlbearHP: Button = findViewById(R.id.plusButtonOwlbearHP)

    private val countSpellI: TextView? = findViewById(R.id.countSpellI);
    private val minusButtonSpellI: Button = findViewById(R.id.minusButtonSpellI)
    private val plusButtonSpellI: Button = findViewById(R.id.plusButtonSpellI)

    private val countSpellII: TextView? = findViewById(R.id.countSpellII);
    private val minusButtonSpellII: Button = findViewById(R.id.minusButtonSpellII)
    private val plusButtonSpellII: Button = findViewById(R.id.plusButtonSpellII)

    private val countSpellIII: TextView? = findViewById(R.id.countSpellIII);
    private val minusButtonSpellIII: Button = findViewById(R.id.minusButtonSpellIII)
    private val plusButtonSpellIII: Button = findViewById(R.id.plusButtonSpellIII)

    private val countFocalSpell: TextView? = findViewById(R.id.countFocalSpell);
    private val minusButtonFocalSpell: Button = findViewById(R.id.minusButtonFocalSpell)
    private val plusButtonFocalSpell: Button = findViewById(R.id.plusButtonFocalSpell)

    private val countFicusFruits: TextView? = findViewById(R.id.countFicusFruits);
    private val minusButtonFicusFruits: Button = findViewById(R.id.minusButtonFicusFruits)
    private val plusButtonFicusFruits: Button = findViewById(R.id.plusButtonFicusFruits)

    val countCommonIngredients: TextView? = findViewById(R.id.countCommonIngredients);
    val minusButtonCommonIngredients: Button = findViewById(R.id.minusButtonCommonIngredients)
    val plusButtonCommonIngredients: Button = findViewById(R.id.plusButtonCommonIngredients)

    private val countSpecialIngredients: TextView? = findViewById(R.id.countSpecialIngredients)
    private val minusButtonSpecialIngredients: Button = findViewById(R.id.minusButtonSpecialIngredients)
    private val plusButtonSpecialIngredients: Button = findViewById(R.id.plusButtonSpecialIngredients)

    private val countMaestrosInstrument: TextView? = findViewById(R.id.countMaestrosInstrument)
    private val minusButtonMaestrosInstrument: Button = findViewById(R.id.minusButtonMaestrosInstrument)
    private val plusButtonMaestrosInstrument: Button = findViewById(R.id.plusButtonMaestrosInstrument)

    private val NewDayButton: Button = findViewById(R.id.NewDayButton)

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
            // Восстанавливающиеся расходники
            countMaestrosInstrument?.setText(1.toString())
        }
    }
}