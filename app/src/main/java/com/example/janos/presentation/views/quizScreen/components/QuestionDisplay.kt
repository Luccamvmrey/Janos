package com.example.janos.presentation.views.quizScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.janos.presentation.views.components.Question

@Composable
fun QuestionDisplay(
    question: Question,
    selectedAnswerIndex: Int,
    onAnswerSelected: (Int) -> Unit,
    onAnswerSubmitted: () -> Unit
) {
    val cardColors = CardDefaults.cardColors(
        containerColor = MaterialTheme.colorScheme.surface,
    )
    val buttonColors = ButtonDefaults.elevatedButtonColors(
        containerColor = MaterialTheme.colorScheme.tertiary,
        contentColor = MaterialTheme.colorScheme.onTertiary
    )

    Card (
        shape = RoundedCornerShape(16.dp),
        colors = cardColors
    ) {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 48.dp)
        ) {
            Text(
                text = question.questionText,
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

    Spacer(modifier = Modifier.height(32.dp))

    question.answers.forEachIndexed { index, answer ->
        Answer(
            answerText = answer,
            isSelected = index == selectedAnswerIndex,
            onAnswerSelected = {
                onAnswerSelected(index)
            }
        )
        when {
            index != question.answers.size - 1 -> {
                Spacer(modifier = Modifier.height(16.dp))
            }
            else -> {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        ElevatedButton(
            modifier = Modifier.fillMaxWidth(0.75f),
            colors = buttonColors,
            onClick = {
                onAnswerSubmitted()
            }
        ) {
            Text(
                text = "Responder",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}