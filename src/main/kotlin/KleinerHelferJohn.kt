import kotlin.random.Random

class KleinerHelferJohn(name: String, leben: Int) : Boss(name, leben) {

    fun schwaechung(held: Held) {
        val schaden = Random.nextInt(100, 150)
        held.schaden(schaden)
        println("${name} führt die Attacke Schwächung aus und verursacht $schaden Schaden bei ${held.name}")
    }
}

