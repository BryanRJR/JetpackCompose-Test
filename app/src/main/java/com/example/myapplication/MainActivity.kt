package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent()
                    MyCard()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Main Activity", color = Color.White) }, backgroundColor = Color(0xFF3700B3)) },
        content = { MyContent() }
    )
}

@Composable
fun MyContent(){
    // Fetching Local Context
    val mContext = LocalContext.current
    Column(Modifier.fillMaxSize().padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {

        Button(onClick = {
            mContext.startActivity(Intent(mContext, RegisActivity::class.java))
        },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF3700B3)),
        ) {
            Text("Go to Second Activity", color = Color.White)
        }
    }
}

@Composable
fun MyCard(){
    Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Card{
            Column(Modifier.padding(10.dp)) {
                Text("Uncheck Check Box")
                Spacer(modifier = Modifier.size(16.dp))
                Row {
                    val isChecked = remember { mutableStateOf(false) }
                    Checkbox(
                        checked = isChecked.value,
                        onCheckedChange = {
                            isChecked.value = it
                        }
                    )
                    Spacer(modifier = Modifier.size(16.dp))
                    Text("Team Hore")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainContent()
        MyCard()
    }
}