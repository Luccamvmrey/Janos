package com.example.janos.presentation.views.quizScreen

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.janos.presentation.views.components.JanosTopBar
import com.example.janos.presentation.views.components.Question
import com.example.janos.presentation.views.quizScreen.components.QuestionDisplay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizScreen(
    navController: NavController,
    questionsList: List<Question>
) {
    var currentQuestionIndex by remember {
        mutableIntStateOf(0)
    }
    var selectedAnswerIndex by remember {
        mutableIntStateOf(-1)
    }
    var successCount by remember {
        mutableIntStateOf(0)
    }

    val context = LocalContext.current

    Scaffold (
        topBar = {
            JanosTopBar(
                title = "${currentQuestionIndex + 1}ª Pergunta"
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Column (
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                QuestionDisplay(
                    question = questionsList[currentQuestionIndex],
                    selectedAnswerIndex = selectedAnswerIndex,
                    onAnswerSelected = {
                        selectedAnswerIndex = it
                    },
                    onAnswerSubmitted = {
                        // if the user hasn't selected an answer, don't do anything
                        if (selectedAnswerIndex == -1) return@QuestionDisplay

                        // check if the answer is correct
                        if (
                            checkIfAnswerIsCorrect(
                                question = questionsList[currentQuestionIndex],
                                selectedAnswerIndex = selectedAnswerIndex
                            )
                        ) {
                            successCount++
                            successToast(context)
                        } else {
                            failureToast(context)
                        }

                        // go to the next question or to the results screen if there are no more questions
                        when (currentQuestionIndex) {
                            questionsList.lastIndex -> {
                                navController.navigate("results-screen/$successCount/${questionsList.size}")
                            }
                            else -> {
                                currentQuestionIndex++
                            }
                        }

                        // reset the selected answer index
                        selectedAnswerIndex = -1
                    }
                )
            }
        }
    }
}

fun checkIfAnswerIsCorrect(
    question: Question,
    selectedAnswerIndex: Int
): Boolean {
    return selectedAnswerIndex == question.correctAnswerIndex
}

fun successToast(
    context: Context
) {
    Toast.makeText(
        context,
        "Você acertou!",
        Toast.LENGTH_SHORT
    ).show()
}

fun failureToast(
    context: Context
) {
    Toast.makeText(
        context,
        "Você errou!",
        Toast.LENGTH_SHORT
    ).show()
}


