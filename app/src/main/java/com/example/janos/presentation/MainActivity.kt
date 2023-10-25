package com.example.janos.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.janos.presentation.ui.theme.JanosTheme
import com.example.janos.presentation.views.components.questionsList
import com.example.janos.presentation.views.quizScreen.QuizScreen
import com.example.janos.presentation.views.resultsScreen.ResultsScreen
import com.example.janos.presentation.views.startingScreen.StartingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JanosTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "starting-screen"
                    ) {
                        composable("starting-screen") {
                            StartingScreen(navController = navController)
                        }
                        composable("quiz-screen") {
                            QuizScreen(
                                navController = navController,
                                questionsList = questionsList
                            )
                        }
                        composable("results-screen/{successCount}/{questionsCount}") { backStackEntry ->
                            val successCount = backStackEntry.arguments?.getString("successCount")?.toInt() ?: 0
                            val questionsCount = backStackEntry.arguments?.getString("questionsCount")?.toInt() ?: 0
                            ResultsScreen(
                                navController = navController,
                                successCount = successCount,
                                questionsCount = questionsCount
                            )
                        }
                    }
                }
            }
        }
    }
}