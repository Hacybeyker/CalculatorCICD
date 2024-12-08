package com.hacybeyker.calculatorcicd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hacybeyker.calculatorcicd.presentation.CalculatorScreen
import com.hacybeyker.calculatorcicd.ui.theme.CalculatorCICDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorCICDTheme {
                CalculatorScreen()
            }
        }
    }
}