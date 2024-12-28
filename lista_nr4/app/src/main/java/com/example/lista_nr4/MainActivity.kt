package com.example.lista_nr4

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import com.example.lista_nr4.ui.theme.Lista_nr4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizApp()
        }
    }
}

@Composable
fun QuizApp() {
    val currentQuestionIndex = remember { mutableStateOf(0) }
    val selectedAnswerIndex = remember { mutableStateOf<Int?>(null) }
    var score by remember { mutableStateOf(0) } // Zmienna przechowująca punkty
    val questions = listOf(
        Question("Jaki jest kolor nieba?", listOf("Niebieski", "Czerwony", "Zielony", "Pomarańczowy"), 0),
        Question("Ile wynosi 2 + 2?", listOf("3", "4", "5", "6"), 1),
        Question("Kto napisał 'Pana Tadeusza'?", listOf("Mickiewicz", "Słowacki", "Norwid", "Prus"), 0),
        Question("Jaki jest największy ocean na Ziemi?", listOf("Atlantycki", "Indyjski", "Arktyczny", "Spokojny"), 3),
        Question("Które miasto jest stolicą Polski?", listOf("Kraków", "Gdańsk", "Warszawa", "Wrocław"), 2),
        Question("Kto jest autorem teorii względności?", listOf("Newton", "Einstein", "Galileusz", "Hawking"), 1),
        Question("Ile wynosi liczba Pi?", listOf("3.14", "3.15", "3.16", "3.13"), 0),
        Question("Jakie zwierzę jest symbolem Australii?", listOf("Koala", "Kangur", "Panda", "Lemur"), 1),
        Question("Który pierwiastek ma symbol H?", listOf("Hel", "Wodór", "Tlen", "Azot"), 1),
        Question("Kto jest autorem 'Harry'ego Pottera'?", listOf("J.R.R. Tolkien", "J.K. Rowling", "C.S. Lewis", "George R.R. Martin"), 1)
    )
    val question = questions[currentQuestionIndex.value]
    val context = LocalContext.current

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            // Wyświetlanie numeru pytania
            Text(
                text = "Pytanie ${currentQuestionIndex.value + 1} / ${questions.size}",
                style = TextStyle(fontSize = 20.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Pasek postępu
            LinearProgressIndicator(
                progress = { (currentQuestionIndex.value + 1).toFloat() / questions.size },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .padding(horizontal = 16.dp),
            )

            // Wyświetlanie pytania w szarej ramce
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.LightGray)
                    .clip(RoundedCornerShape(16.dp))
                    .padding(16.dp)
            ) {
                Text(
                    text = question.text,
                    style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
                    color = Color.Black
                )
            }

            // Wyświetlanie odpowiedzi jako radio buttony
            question.answers.forEachIndexed { index, answer ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedAnswerIndex.value == index,
                        onClick = {
                            selectedAnswerIndex.value = index
                        },
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(text = answer, style = TextStyle(fontSize = 24.sp))
                }
            }

            // Przycisk do przejścia do następnego pytania
            Button(
                onClick = {
                    if (selectedAnswerIndex.value != null) {
                        if (selectedAnswerIndex.value == question.correctAnswerIndex) {
                            score += 1
                        }

                        // Przejście do następnego pytania
                        if (currentQuestionIndex.value < questions.size - 1) {
                            currentQuestionIndex.value += 1
                            selectedAnswerIndex.value = null
                        } else {
                            // Koniec quizu, wyświetlenie punktów
                            Toast.makeText(context, "Koniec quizu! Twoje punkty: $score", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(context, "Proszę wybrać odpowiedź!", Toast.LENGTH_SHORT).show()
                    }
                },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Następny")
            }

            // Wyświetlanie liczby punktów na końcu quizu
            if (currentQuestionIndex.value == questions.size) {
                Text(
                    text = "Twoje punkty: $score",
                    style = TextStyle(fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold),
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally)
                )
            }
        }
    }
}

data class Question(
    val text: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lista_nr4Theme {
        QuizApp()
    }
}
