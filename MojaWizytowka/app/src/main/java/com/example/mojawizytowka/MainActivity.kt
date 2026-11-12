package com.example.mojawizytowka


import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp

//zadanie 1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                EkranGlowny()
            }
        }
    }
}

@Composable
fun Wizytowka() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color(0xFF6750A4)),
            contentAlignment = Alignment.Center
        ) {
            Text("BM", color = Color.White)
        }

        Spacer(Modifier.height(16.dp))

        Text(
            "Bohdan Moskovchenko",
            style = MaterialTheme.typography.headlineMedium
        )
        Text("Informatyka")

        Spacer(Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Kontakt(Icons.Filled.Email, "Email")
            Kontakt(Icons.Filled.Phone, "Telefon")
            Kontakt(Icons.Filled.LocationOn, "Miasto")
        }
    }
}

@Composable
fun Kontakt(icon: ImageVector, podpis: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(icon, contentDescription = podpis)
        Text(podpis)
    }
}

@Preview(showBackground = true)
@Composable
fun WizytowkaPreview() {
    MaterialTheme {
        Wizytowka()
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun WizytowkaDarkPreview() {
    MaterialTheme {
        Wizytowka()
    }
}


//zadanie 2
data class Produkt(
    val nazwa: String,
    val cena: String,
    val obrazek: Int
)

@Composable
fun KartaProduktu(produkt: Produkt) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Image(
                painter = painterResource(produkt.obrazek),
                contentDescription = produkt.nazwa,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = produkt.nazwa,
                    modifier = Modifier.weight(1f),
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = produkt.cena,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Do koszyka")
            }
        }
    }
}

@Composable
fun ListaProduktow() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.LightGray),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        KartaProduktu(
            Produkt("Laptop", "2999 zł", R.drawable.laptop)
        )

        KartaProduktu(
            Produkt("Telefon", "1499 zł", R.drawable.telefon)
        )

        KartaProduktu(
            Produkt("Słuchawki", "199 zł", R.drawable.sluchawki)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ListaProduktowPreview() {
    MaterialTheme {
        ListaProduktow()
    }
}


//zadanie 3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EkranGlowny() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mój sklep") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "Witaj w sklepie!",
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "Polecane produkty",
                style = MaterialTheme.typography.titleLarge
            )

            ElementProduktu(
                nazwa = "Laptop",
                opis = "Wydajny komputer",
                cena = "2999 zł"
            )

            ElementProduktu(
                nazwa = "Telefon",
                opis = "Smartfon na co dzień",
                cena = "1499 zł"
            )

            ElementProduktu(
                nazwa = "Słuchawki",
                opis = "Dobra jakość dźwięku",
                cena = "199 zł"
            )
        }
    }
}

@Composable
fun ElementProduktu(
    nazwa: String,
    opis: String,
    cena: String
) {
    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = nazwa,
                style = MaterialTheme.typography.titleMedium
            )

            Text(text = opis)

            Text(
                text = cena,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EkranGlownyPreview() {
    MaterialTheme {
        EkranGlowny()
    }
}