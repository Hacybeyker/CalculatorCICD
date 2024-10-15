package com.hacybeyker.calculatorcicd.domain

enum class Operation(val symbol: Char) {
    ADD(symbol = '+'),
    SUBTRACT(symbol = '-'),
    MULTIPLY(symbol = '*'),
    DIVIDE(symbol = '/'),
    PERCENT(symbol = '%')
}

val operationSymbols = Operation.entries.map { it.symbol }.joinToString(separator = "")

fun operationFromSymbol(symbol: Char): Operation {
    return Operation.entries.find { it.symbol == symbol }
        ?: throw IllegalArgumentException("Invalid symbol")
}