package com.example.lista_6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
        Navigation()
            }
    }
}

data class Exercise(val content: String, val points: Int)
data class Subject(val name: String)
data class ExerciseList(val subject: Subject, val grade: Double, val exercises: List<Exercise>)

val exerciseLists = listOf(
    ExerciseList(Subject("Matematyka"), 4.5, listOf(
        Exercise("Zadanie 1: Oblicz całkę nieoznaczoną", 10),
        Exercise("Zadanie 2: Rozwiąż układ równań liniowych", 20),
        Exercise("Zadanie 3: Oblicz granicę funkcji", 15),
        Exercise("Zadanie 4: Oblicz pochodną funkcji", 12)
    )),
    ExerciseList(Subject("Fizyka"), 3.8, listOf(
        Exercise("Zadanie 1: Oblicz przyspieszenie ciała", 15),
        Exercise("Zadanie 2: Wyjaśnij zasadę dynamiki Newtona", 25),
        Exercise("Zadanie 3: Oblicz siłę w polu grawitacyjnym", 18),
        Exercise("Zadanie 4: Oblicz energię kinetyczną ciała", 20)
    )),
    ExerciseList(Subject("Chemia"), 4.2, listOf(
        Exercise("Zadanie 1: Oblicz masę molową związku", 12),
        Exercise("Zadanie 2: Wyważ reakcję chemiczną", 18),
        Exercise("Zadanie 3: Oblicz ilość moli w danej próbce", 20),
        Exercise("Zadanie 4: Opisz reakcję redoks", 22)
    )),
    ExerciseList(Subject("Informatyka"), 5.0, listOf(
        Exercise("Zadanie 1: Napisz program w Pythonie", 30),
        Exercise("Zadanie 2: Stwórz algorytm sortowania", 20),
        Exercise("Zadanie 3: Zaimplementuj strukturę danych", 25),
        Exercise("Zadanie 4: Napisz testy jednostkowe", 15)
    )),
    ExerciseList(Subject("Biologia"), 4.7, listOf(
        Exercise("Zadanie 1: Opisz proces fotosyntezy", 20),
        Exercise("Zadanie 2: Objaśnij działanie układu odpornościowego", 18),
        Exercise("Zadanie 3: Opisz cykl komórkowy", 22),
        Exercise("Zadanie 4: Objaśnij procesy biochemiczne w komórce", 15)
    )),
    ExerciseList(Subject("Historia"), 3.5, listOf(
        Exercise("Zadanie 1: Opisz przyczyny I wojny światowej", 20),
        Exercise("Zadanie 2: Przedstaw najważniejsze bitwy w II wojnie światowej", 15),
        Exercise("Zadanie 3: Opisz skutki rewolucji francuskiej", 18),
        Exercise("Zadanie 4: Omów historię starożytnego Egiptu", 25)
    )),
    ExerciseList(Subject("Geografia"), 4.0, listOf(
        Exercise("Zadanie 1: Opisz cykl hydrologiczny", 12),
        Exercise("Zadanie 2: Wyjaśnij procesy erozyjne", 15),
        Exercise("Zadanie 3: Przedstaw mapę topograficzną", 20),
        Exercise("Zadanie 4: Omów zagrożenia związane z globalnym ociepleniem", 18)
    )),
    ExerciseList(Subject("Literatura"), 4.3, listOf(
        Exercise("Zadanie 1: Przedstaw analizę wiersza Adama Mickiewicza", 18),
        Exercise("Zadanie 2: Opisz bohatera literackiego", 20),
        Exercise("Zadanie 3: Omów tematykę książki 'Pan Tadeusz'", 25),
        Exercise("Zadanie 4: Przedstaw styl pisarski Jana Kochanowskiego", 12)
    )),
    ExerciseList(Subject("Wiedza o społeczeństwie"), 3.9, listOf(
        Exercise("Zadanie 1: Opisz systemy polityczne", 15),
        Exercise("Zadanie 2: Wyjaśnij pojęcie demokracji", 18),
        Exercise("Zadanie 3: Omów zagadnienia związane z prawami człowieka", 20),
        Exercise("Zadanie 4: Przedstaw struktury administracyjne państwa", 25)
    )),
    ExerciseList(Subject("Edukacja fizyczna"), 4.6, listOf(
        Exercise("Zadanie 1: Zaplanuj program treningowy", 20),
        Exercise("Zadanie 2: Opisz zasady gry w siatkówkę", 18),
        Exercise("Zadanie 3: Zademonstruj ćwiczenia rozciągające", 15),
        Exercise("Zadanie 4: Omów techniki biegu na średnich dystansach", 25)
    ))
)

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Moje Listy Zadań", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
        exerciseLists.forEachIndexed { index, exerciseList ->
            ListItem(exerciseList) {
                navController.navigate("taskList/$index")
            }
        }
    }
}

@Composable
fun TaskListScreen(index: Int) {
    val exerciseList = exerciseLists[index]
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Zadania dla przedmiotu: ${exerciseList.subject.name}", fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))

        exerciseList.exercises.forEachIndexed { idx, exercise ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color(0xFFF0F0F0), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    .padding(16.dp)
            ) {
                Text("${idx + 1}. ${exercise.content} - ${exercise.points} punktów", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun GradeScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("Moje oceny:", fontSize = 24.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)

        exerciseLists.forEach { exerciseList ->
            val averageGrade = exerciseList.grade
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .background(Color(0xFFF0F0F0), shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp))
                    .padding(16.dp)

            ) {
                Text("Średnia ocena dla przedmiotu ${exerciseList.subject.name}: %.2f".format(averageGrade), fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}


@Composable
fun ListItem(exerciseList: ExerciseList, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.LightGray, shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp))
            .padding(16.dp)
            .clickable(onClick = onClick)
    ) {
        Text("Przedmiot: ${exerciseList.subject.name}", fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold)
        Text("Ocena: ${exerciseList.grade}", fontSize = 16.sp, color = Color(0xFF4CAF50)) // Zielony kolor dla ocen
        Text("Liczba zadań: ${exerciseList.exercises.size}", fontSize = 14.sp)
    }
}

@Composable
fun BottomMenu(navController: NavHostController) {
    val screens = listOf(
        BottomBar.Home, BottomBar.Second
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar {
        screens.forEach { screen ->
            NavigationBarItem(
                label = { Text(text = screen.title) },
                icon = { Icon(imageVector = screen.icon, contentDescription = "icon") },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = { navController.navigate(screen.route) }
            )
        }
    }
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomMenu(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screens.HomeScreen.route, modifier = Modifier.padding(innerPadding)) {
            composable(Screens.HomeScreen.route) { HomeScreen(navController) }
            composable("taskList/{index}") { backStackEntry ->
                val index = backStackEntry.arguments?.getString("index")?.toInt() ?: 0
                TaskListScreen(index)
            }
            composable(Screens.FirstScreen.route) { FirstScreen() }
            composable(Screens.SecondScreen.route) { GradeScreen() }
        }
    }
}

@Composable
fun FirstScreen() {
    Box(Modifier.fillMaxSize().background(Color.LightGray), contentAlignment = Alignment.Center) {
        Text("Ekran 1: Zadania", fontSize = 24.sp)
    }
}

@Composable
fun SecondScreen() {
    Box(Modifier.fillMaxSize().background(Color.Green), contentAlignment = Alignment.Center) {
        Text("Ekran 2: Oceny", fontSize = 24.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Navigation()
}

sealed class Screens(val route: String) {
    data object HomeScreen : Screens("home")
    data object FirstScreen : Screens("first")
    data object SecondScreen : Screens("second")
}

sealed class BottomBar(val route: String, val title: String, val icon: ImageVector) {
    data object Home : BottomBar(Screens.HomeScreen.route, "Listy zadań", Icons.Default.Menu)
    data object Second : BottomBar(Screens.SecondScreen.route, "Oceny", Icons.Default.CheckCircle)
}


