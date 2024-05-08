package com.otarbakh.movieapplemondo.ui.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.otarbakh.movieapplemondo.R
import com.otarbakh.movieapplemondo.ui.presentation.navigation.HomeScreen
import com.otarbakh.movieapplemondo.ui.presentation.navigation.homeNavGraph
import com.otarbakh.movieapplemondo.ui.theme.PADDING_0_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_16_DP
import com.otarbakh.movieapplemondo.ui.theme.PADDING_80_DP


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DashboardScreen() {
    val navController: NavHostController = rememberNavController()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            BottomBarCustom(navController = navController)
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            homeNavGraph(navController = navController)
        }
    }
}


@Composable
fun BottomBarCustom(navController: NavHostController) {
    val menuItems = listOf(
        HomeScreen.MoviesHomeScreen,
        HomeScreen.FavoritesHomeScreen
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val bottomBarDestination = menuItems.any { it.route == currentDestination?.route }

    if (bottomBarDestination) {
        NavigationBar(
            modifier = Modifier
                .height(PADDING_80_DP)
                .clip(RoundedCornerShape(topStart = PADDING_16_DP,
                    topEnd = PADDING_16_DP)),
            containerColor = Color.Gray,
        ) {
            menuItems.forEach { screen ->
                val isSelectedMenu =
                    currentDestination?.hierarchy?.any { it.route == screen.route } == true
                val backgroundAlpha = if (isSelectedMenu) 1f else 0.6f

                NavigationBarItem(
                    label = {
                        Text(text = screen.title,
                            color = Color.White.copy(alpha = backgroundAlpha))
                    },
                    icon = {
                        Icon(
                            painterResource(id = screen.icon),
                            contentDescription = screen.title,
                        )
                    },
                    selected = currentDestination?.hierarchy?.any
                    {
                        it.route == screen.route
                    } == true,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    })
            }
        }
    }
}


