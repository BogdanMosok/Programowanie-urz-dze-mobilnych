package pl.merito.Moskovchenko.wizytowka

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pl.merito.Moskovchenko.wizytowka.ui.theme.WizytowkaTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        sprawdzStudentow()

        setContent {
            WizytowkaTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Greeting(
                        name = "Bohdan",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

//zadanie 2
data class Student(
    val imie: String,
    val punkty: Int,
    val grupa: String
)

val studenci = listOf(
    Student("Bohdan", 80, "A"),
    Student("Jan", 60, "A"),
    Student("Anna", 40, "A"),
    Student("Piotr", 90, "B"),
    Student("Kasia", 70, "B"),
    Student("Tomek", 30, "B")
)

fun Student.czyZaliczyl() = punkty >= 50

fun sprawdzStudentow() {

    val zaliczyli = studenci.filter {
        it.czyZaliczyl()
    }

    Log.d("STUDENCI", "Zaliczyli:")

    zaliczyli.forEach {
        Log.d("STUDENCI", "${it.imie} - ${it.punkty} punktów")
    }

    val grupy = studenci.groupBy {
        it.grupa
    }

    Log.d("STUDENCI", "Średnia w każdej grupie:")

    grupy.forEach { (grupa, studenciWGrupie) ->

        val srednia = studenciWGrupie
            .map { it.punkty }
            .average()

        Log.d(
            "STUDENCI",
            "Grupa $grupa: średnia = $srednia"
        )
    }
}






@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WizytowkaTheme {
        Greeting("Bohdan")
    }
}