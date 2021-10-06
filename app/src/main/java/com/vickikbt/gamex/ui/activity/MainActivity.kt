package com.vickikbt.gamex.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vickikbt.gamex.ui.navigation.NavigationItem
import com.vickikbt.gamex.ui.theme.ColorPrimary
import com.vickikbt.gamex.ui.theme.GamexTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GamexTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainScreen()
                }
            }
        }
    }

}

@Composable
fun MainScreen() {
    Scaffold(bottomBar = { BottomNavigationBar() }) {
        //ToDo: Add code later
    }
}

@Composable
fun BottomNavigationBar() {
    val items = listOf(NavigationItem.Home, NavigationItem.Search, NavigationItem.Settings)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), elevation = 10.dp, shape = RoundedCornerShape(10.dp)
    ) {

        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = ColorPrimary
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = ColorPrimary,
                    unselectedContentColor = Color.White.copy(alpha = 0.4f),
                    alwaysShowLabel = true,
                    selected = false,
                    onClick = {
                        //ToDo: Add later
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    GamexTheme {
        BottomNavigationBar()
    }
}