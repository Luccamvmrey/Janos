package com.example.janos.presentation.views.startingScreen

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartingScreen(
    navController: NavController
) {
    val buttonColors = ButtonDefaults.elevatedButtonColors(
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.onTertiary
    )
    val cardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
    )
    val activity = LocalContext.current as Activity

    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Card (
            shape = RoundedCornerShape(16.dp),
            colors = cardColors
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Bem-Vindo!",
                        style = MaterialTheme.typography.displaySmall,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .align(alignment = CenterHorizontally),
                    colors = buttonColors,
                    onClick = {
                        navController.navigate("quiz-screen")
                    }
                ) {
                    Text(
                        text = "Jogar",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                ElevatedButton(
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .align(alignment = CenterHorizontally),
                    colors = buttonColors,
                    onClick = {
                        activity.finishAndRemoveTask()
                    }
                ) {
                    Text(
                        text = "Sair",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
        }
    }
}