data class Produkt(
    val nazwa: String,
    val cena: Double,
    val ilosc: Int
)

class Koszyk {

    private val produkty = mutableListOf<Produkt>()

    fun dodaj(produkt: Produkt) {
        produkty.add(produkt)
    }

    fun usun(nazwa: String) {
        produkty.removeAll {
            it.nazwa == nazwa
        }
    }

    fun suma(): Double {

        val sumaBrutto = produkty.sumOf {
            it.cena * it.ilosc
        }

        return when {
            sumaBrutto > 200 -> sumaBrutto * 0.90
            else -> sumaBrutto
        }
    }
}

fun main() {

    val koszyk = Koszyk()

    koszyk.dodaj(Produkt("Laptop", 150.0, 1))
    koszyk.dodaj(Produkt("Mysz", 30.0, 2))
    koszyk.dodaj(Produkt("Klawiatura", 50.0, 1))

    println("Suma po rabacie: ${koszyk.suma()} zł")

    koszyk.usun("Mysz")

    println("Suma po usunięciu myszy: ${koszyk.suma()} zł")
}