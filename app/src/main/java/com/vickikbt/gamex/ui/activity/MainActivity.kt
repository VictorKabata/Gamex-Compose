package com.vickikbt.gamex.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.vickikbt.gamex.R
import com.vickikbt.gamex.ui.navigation.NavigationItem
import com.vickikbt.gamex.ui.theme.ColorPrimary
import com.vickikbt.gamex.ui.theme.GamexTheme
import com.vickikbt.gamex.ui.theme.White

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamexTheme {
                Surface(color = MaterialTheme.colors.background) {
                    //Greeting("Victor")
                }
            }
        }
    }

}

@Composable
fun BottomNavigationBar(){
    val items=listOf(NavigationItem.Home,NavigationItem.Search,NavigationItem.Settings)

    BottomNavigation(backgroundColor = White, contentColor = ColorPrimary) {
        items.forEach{item->

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GamexTheme {
        BottomNavigationBar()
    }
}