package com.example.FicusResourcesCounter

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class MainActivity : AppCompatActivity() {
    private lateinit var countFicusHP: TextView
    private lateinit var minusButtonFicusHP: Button
    private lateinit var plusButtonFicusHP: Button

    private lateinit var countOwlbearHP: TextView
    private lateinit var minusButtonOwlbearHP: Button
    private lateinit var plusButtonOwlbearHP: Button

    private lateinit var countSpellI: TextView
    private lateinit var minusButtonSpellI: Button
    private lateinit var plusButtonSpellI: Button

    private lateinit var countSpellII: TextView
    private lateinit var minusButtonSpellII: Button
    private lateinit var plusButtonSpellII: Button

    private lateinit var countSpellIII: TextView
    private lateinit var minusButtonSpellIII: Button
    private lateinit var plusButtonSpellIII: Button

    private lateinit var countFocalSpell: TextView
    private lateinit var minusButtonFocalSpell: Button
    private lateinit var plusButtonFocalSpell: Button

    private lateinit var countFicusFruits: TextView
    private lateinit var minusButtonFicusFruits: Button
    private lateinit var plusButtonFicusFruits: Button

    private lateinit var countCommonIngredients: TextView
    private lateinit var minusButtonCommonIngredients: Button
    private lateinit var plusButtonCommonIngredients: Button

    private lateinit var countSpecialIngredients: TextView
    private lateinit var minusButtonSpecialIngredients: Button
    private lateinit var plusButtonSpecialIngredients: Button

    private lateinit var countMaestrosInstrument: TextView
    private lateinit var minusButtonMaestrosInstrument: Button
    private lateinit var plusButtonMaestrosInstrument: Button

    private lateinit var NewDayButton: Button
    private lateinit var SaveButton: Button

    private val gson = Gson()

    private fun getCounterMap(): Map<String, TextView> = mapOf(
        "countFicusHP" to countFicusHP,
        "countOwlbearHP" to countOwlbearHP,
        "countSpellI" to countSpellI,
        "countSpellII" to countSpellII,
        "countSpellIII" to countSpellIII,
        "countFocalSpell" to countFocalSpell,
        "countFicusFruits" to countFicusFruits,
        "countCommonIngredients" to countCommonIngredients,
        "countSpecialIngredients" to countSpecialIngredients,
        "countMaestrosInstrument" to countMaestrosInstrument
    )

    private fun saveProgramm(context: Context) {
        val mapForJson: MutableMap<String, Int> = mutableMapOf()

        for ((key, textView) in getCounterMap()) {
            val value = textView.text.toString().toInt()
            mapForJson.put(key, value)
        }
        val json = gson.toJson(mapForJson)

        val file = File(context.filesDir, "save.json")
        file.writeText(json)
    }
    private fun loadProgramm(context: Context) {
        val file = File(context.filesDir, "save.json")
        if (!file.exists()) return

        val json = file.readText()
        val mapType = object : TypeToken<Map<String, Int>>() {}.type
        val mapFromJson = gson.fromJson<Map<String, Int>>(json, mapType)

        for ((key, textView) in getCounterMap()) {
            mapFromJson[key].let {value -> textView.setText(value.toString())}
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Инициализация полей
        countFicusHP = findViewById(R.id.countFicusHP)
        minusButtonFicusHP = findViewById(R.id.minusButtonFicusHP)
        plusButtonFicusHP = findViewById(R.id.plusButtonFicusHP)

        countOwlbearHP = findViewById(R.id.countOwlbearHP)
        minusButtonOwlbearHP = findViewById(R.id.minusButtonOwlbearHP)
        plusButtonOwlbearHP = findViewById(R.id.plusButtonOwlbearHP)

        countSpellI = findViewById(R.id.countSpellI)
        minusButtonSpellI = findViewById(R.id.minusButtonSpellI)
        plusButtonSpellI = findViewById(R.id.plusButtonSpellI)

        countSpellII = findViewById(R.id.countSpellII)
        minusButtonSpellII = findViewById(R.id.minusButtonSpellII)
        plusButtonSpellII = findViewById(R.id.plusButtonSpellII)

        countSpellIII = findViewById(R.id.countSpellIII)
        minusButtonSpellIII = findViewById(R.id.minusButtonSpellIII)
        plusButtonSpellIII = findViewById(R.id.plusButtonSpellIII)

        countFocalSpell = findViewById(R.id.countFocalSpell)
        minusButtonFocalSpell = findViewById(R.id.minusButtonFocalSpell)
        plusButtonFocalSpell = findViewById(R.id.plusButtonFocalSpell)

        countFicusFruits = findViewById(R.id.countFicusFruits)
        minusButtonFicusFruits = findViewById(R.id.minusButtonFicusFruits)
        plusButtonFicusFruits = findViewById(R.id.plusButtonFicusFruits)

        countCommonIngredients = findViewById(R.id.countCommonIngredients)
        minusButtonCommonIngredients = findViewById(R.id.minusButtonCommonIngredients)
        plusButtonCommonIngredients = findViewById(R.id.plusButtonCommonIngredients)

        countSpecialIngredients = findViewById(R.id.countSpecialIngredients)
        minusButtonSpecialIngredients = findViewById(R.id.minusButtonSpecialIngredients)
        plusButtonSpecialIngredients = findViewById(R.id.plusButtonSpecialIngredients)

        countMaestrosInstrument = findViewById(R.id.countMaestrosInstrument)
        minusButtonMaestrosInstrument = findViewById(R.id.minusButtonMaestrosInstrument)
        plusButtonMaestrosInstrument = findViewById(R.id.plusButtonMaestrosInstrument)

        NewDayButton = findViewById(R.id.NewDayButton)
        SaveButton = findViewById(R.id.SaveButton)

        // Загрузка программы
        loadProgramm(this)

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

        //Кнопка "Сохранить"
        SaveButton.setOnClickListener {
            saveProgramm(this)
        }
    }
}