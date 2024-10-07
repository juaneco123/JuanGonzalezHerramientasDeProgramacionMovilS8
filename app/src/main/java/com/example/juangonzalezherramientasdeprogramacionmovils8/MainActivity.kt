package com.example.juangonzalezherramientasdeprogramacionmovils8

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var inputNumber: EditText
    private lateinit var btnDecimalToBinary: Button
    private lateinit var btnBinaryToDecimal: Button
    private lateinit var btnSumar: Button
    private lateinit var btnRestar: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inicializar las vistas
        inputNumber = findViewById(R.id.inputNumber)
        btnDecimalToBinary = findViewById(R.id.btnDecimalToBinary)
        btnBinaryToDecimal = findViewById(R.id.btnBinaryToDecimal)
        btnSumar = findViewById(R.id.btnSumar)
        btnRestar = findViewById(R.id.btnRestar)
        txtResultado = findViewById(R.id.txtResultado)

        // Establecer los listeners de los botones
        btnDecimalToBinary.setOnClickListener { convertDecimalToBinary() }
        btnBinaryToDecimal.setOnClickListener { convertBinaryToDecimal() }
        btnSumar.setOnClickListener { sumNumbers() }
        btnRestar.setOnClickListener { subtractNumbers() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        requestNotificationPermission()
    }


    private fun requestNotificationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 1) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permiso otorgado, puedes enviar notificaciones
            } else {
                // Permiso denegado, informa al usuario
            }
        }
    }



    private fun convertDecimalToBinary() {
        val decimalNumber = inputNumber.text.toString().toIntOrNull()
        if (decimalNumber != null) {
            val binaryString = Integer.toBinaryString(decimalNumber)
            txtResultado.text = "Binario: $binaryString"
        } else {
            txtResultado.text = "Ingrese un número válido."
        }
    }

    private fun convertBinaryToDecimal() {
        val binaryString = inputNumber.text.toString()
        if (binaryString.matches(Regex("[01]+"))) {
            val decimalNumber = Integer.parseInt(binaryString, 2)
            txtResultado.text = "Decimal: $decimalNumber"
        } else {
            txtResultado.text = "Ingrese número binario válido."
        }
    }

    private fun sumNumbers() {
        // Implementar la lógica para sumar números
        val numbers = inputNumber.text.toString().split(",").map { it.trim().toIntOrNull() }
        val sum = numbers.filterNotNull().sum()
        txtResultado.text = "Suma: $sum"
    }

    private fun subtractNumbers() {
        // Implementar la lógica para restar números
        val numbers = inputNumber.text.toString().split(",").map { it.trim().toIntOrNull() }
        if (numbers.size >= 2) {
            val result = numbers[0] ?: 0 - (numbers.drop(1).filterNotNull().sum())
            txtResultado.text = "Resta: $result"
        } else {
            txtResultado.text = "Ingrese al menos dos números para restar."
        }
    }
}
