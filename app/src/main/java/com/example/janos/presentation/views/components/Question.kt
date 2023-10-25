package com.example.janos.presentation.views.components

data class Question(
    val questionText: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

val questionsList = listOf(
    Question(
        "Como se chamam os dois métodos de conversão de códigos para linguagem de máquina?",
        listOf("Compilação e Interpretação", "Execução e Decomposição", "Tradução e Interpretação", "Compilação e Tradução"),
        0
    ),
    Question(
        "Quem é o autor da obra 'Dom Quixote'?",
        listOf("William Shakespeare", "Charles Dickens", "Jane Austen", "Miguel de Cervantes"),
        3
    ),
    Question(
        "Qual é o maior planeta do nosso sistema solar?",
        listOf("Marte", "Vênus", "Júpiter", "Saturno"),
        2
    ),
    Question(
        "Qual é o símbolo químico para o oxigênio?",
        listOf("O", "O2", "H2O", "CO2"),
        2
    ),
    Question(
        "Quando ocorreu a Revolução Francesa?",
        listOf("1700s", "1800s", "1900s", "2000s"),
        0
    )
)
