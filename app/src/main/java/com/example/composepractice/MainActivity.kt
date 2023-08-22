package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.composepractice.ui.theme.ComposePracticeTheme

// Composable List
// 1. Layout Composable
// Box, BoxWithConstraints, ContainerLayout, Row, Column

// 2. Foundation Composable
// BaseTextField, LazyRow, Canvas, Shape, Image, Text, LazyColumn

// 3. Material Design Composable
// AlertDialog, RadioButton, Button, Scaffold, Card, Slider ...

// Intelligent Composition !!

// Composable type
// 1. State Composable 2. Stateless Composable

class MainActivity : ComponentActivity() {
  companion object {
    val TAG = "speldipn"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      ComposePracticeTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
          DemoScreen()
        }
      }
    }
  }
}

@Composable
fun DemoScreen() {
  var (text, setText) = rememberSaveable { mutableStateOf("") }

  val onTextChange = { t: String -> setText(t) }

  Column {
    MyTextField(text = text, onTextChange = onTextChange)
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField(text: String, onTextChange: (String) -> Unit) {
  TextField(value = text, onValueChange = onTextChange)
}

@Composable
fun FunctionA() {
  var switchState by remember { mutableStateOf(true) }
  val onSwitchChange = { value: Boolean -> switchState = value }
  FunctionB(switchState = switchState, onSwitchChange = onSwitchChange)
}

@Composable
fun FunctionB(switchState: Boolean, onSwitchChange: (Boolean) -> Unit) {
  Switch(checked = switchState, onCheckedChange = onSwitchChange)
}

//@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
  ComposePracticeTheme {
    DemoScreen()
  }
}