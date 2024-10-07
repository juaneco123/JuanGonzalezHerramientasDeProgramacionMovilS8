package com.example.juangonzalezherramientasdeprogramacionmovils8

object ConverterUtils {
    fun decimalToBinary(decimalNumber: Int): String {
        return Integer.toBinaryString(decimalNumber)
    }

    fun binaryToDecimal(binaryString: String): Int {
        return Integer.parseInt(binaryString, 2)
    }
}