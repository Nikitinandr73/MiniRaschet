package com.mihaha.miniraschet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.mihaha.miniraschet.ui.theme.DarkBG
import com.mihaha.miniraschet.ui.theme.MiniRaschetTheme
import com.mihaha.miniraschet.ui.theme.PurpleGrey40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val Pi = 3.1415
        setContent {
            MiniRaschetTheme {
                Screen_1()
            }
        }
    }
}

@Composable
fun Screen_1() {     // содержимое главного окна
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBG),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Площадь детали",
            fontSize = 30.sp,
            color = Color.White
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(PurpleGrey40)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SchetDweKnopki()
        }
    }
}