package com.google.firebase.quickstart.auth.abslotapiscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.firebase.quickstart.auth.abslotapiscompose.ui.theme.AbSlotAPIsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AbSlotAPIsComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SlotDemo(
                        topContent = { Text("Top Text") },
                        middleContent = { ButtonDemo() },
                        bottomContent = { Text("Bottom Text") }
                    )
                }
            }
        }
    }
}

/* //Here is how you do single slot
@Composable
fun ButtonDemo() {
    Button(onClick = { }) {
        Text("Click Me")
    }
}

@Composable
fun SlotDemo(middleContent: @Composable () -> Unit) {
    Column {
        Text("Top Text")
        middleContent()
        Text("Bottom Text")
    }
}
*/

// Here is how we create multiple slot

@Composable
fun SlotDemo(
    topContent: @Composable () -> Unit,
    middleContent: @Composable () -> Unit,
    bottomContent: @Composable () -> Unit) {
    Column {
        topContent()
        middleContent()
        bottomContent()
    }
}
@Composable
fun ButtonDemo() {
    Button(onClick = { }) {
        Text("Click Me")
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    AbSlotAPIsComposeTheme {
        SlotDemo(
            topContent = { Text("Top Text") },
            middleContent = { ButtonDemo() },
            bottomContent = { Text("Bottom Text") }
        )


    }
}