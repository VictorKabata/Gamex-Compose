package com.vickikbt.gamex.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.vickikbt.gamex.ui.navigation.Navigation
import com.vickikbt.gamex.ui.navigation.NavigationItem
import com.vickikbt.gamex.ui.theme.ColorPrimary
import com.vickikbt.gamex.ui.theme.GamexTheme

@ExperimentalFoundationApi
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

@ExperimentalFoundationApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(bottomBar = { BottomNavigationBar(navController = navController) }) {
        Navigation(navController = navController)
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(NavigationItem.Home, NavigationItem.Favorite, NavigationItem.Settings)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp), elevation = 10.dp, shape = RoundedCornerShape(10.dp)
    ) {
        val backStackEntry = navController.currentBackStackEntryAsState()

        BottomNavigation(
            backgroundColor = MaterialTheme.colors.surface,
            contentColor = ColorPrimary
        ) {
            items.forEach { item ->
                val isSelected = item.route == backStackEntry.value?.destination?.route

                BottomNavigationItem(
                    icon = {
                        Icon(
                            painterResource(id = item.icon),
                            contentDescription = item.title
                        )
                    },
                    label = { Text(text = item.title) },
                    selectedContentColor = ColorPrimary,
                    unselectedContentColor = Color.Gray,
                    alwaysShowLabel = false,
                    selected = isSelected,
                    onClick = {
                        navController.navigate(item.route) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route = route) {
                                    saveState = true
                                }
                            }

                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()

    GamexTheme {
        BottomNavigationBar(navController)
    }
}