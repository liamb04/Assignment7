package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BMICalculatorApp()
                }
            }
        }
    }
}



@Composable
fun BMICalculatorApp() {
    Surface(color = MaterialTheme.colorScheme.background) {
        val viewModel: ViewModel = viewModel()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(stringResource(R.string.calculate_your_bmi))

            OutlinedTextField(
                value = viewModel.height.value,
                onValueChange = { viewModel.updateHeight(it) },
                label = { Text(stringResource(R.string.height_cm) )},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = viewModel.weight.value,
                onValueChange = { viewModel.updateWeight(it) },
                label = { Text(stringResource(R.string.weight_kg))},
                modifier = Modifier.fillMaxWidth()
            )
            Button(
                onClick = { viewModel.updateText()}) {
                Text(stringResource(R.string.calculate))

            }
            Text(
                text = "Your BMI is: ${viewModel.bmiResult.value}",

            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BMICalculatorApp()
}