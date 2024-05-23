package com.example.tiptime

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculate: Button = findViewById(R.id.hitungtip)
        calculate.setOnClickListener {
            tip()
        }
    }

    private fun tip() {
        val biayaText: EditText = findViewById(R.id.totalbiaya)
        val tipText: TextView = findViewById(R.id.totaltip)
        val pilihTip: RadioGroup = findViewById(R.id.pilihantip)
        val bulatkanTip: Switch = findViewById(R.id.pembulatantip)

        val biayaString = biayaText.text.toString()
        val biayaDouble = biayaString.toDoubleOrNull()

        if (biayaDouble != null) {
            val selectedId = pilihTip.checkedRadioButtonId
            val tipPersen = when (selectedId) {
                R.id.amazing -> 0.20
                R.id.good -> 0.18
                R.id.okay -> 0.15
                else -> 0.0 }

            var hasilAkhir = biayaDouble * tipPersen

            if (bulatkanTip.isChecked) {
                hasilAkhir = ceil(hasilAkhir) }

            val tipAkhir = "Tip Amount : $%.2f".format(hasilAkhir)
            tipText.text = tipAkhir
        }
    }
}
