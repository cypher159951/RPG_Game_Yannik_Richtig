import kotlin.random.Random

class KleinerHelferJohn(name: String, leben: Int) : Boss(name, leben) {

    val attacken = listOf("schwaechung")

    fun schwaechung(held: Held) {
        val schaden = Random.nextInt(100, 150)
        held.schaden(schaden)
        println("${name} führt die Attacke Schwächung aus und verursacht $schaden Schaden bei ${held.name}")
    }

    fun heilung(boss: Boss) {                                                                          //Funktion wird nicht benutzt
        val heilung = Random.nextInt(400, 900)
        lebenspunkte += heilung
        println("${name} heilt sich um ${heilung} und hat nun wieder ${lebenspunkte} Lebenspunkte")
    }


    override fun angreifen(held: Held, helden: List<Held>) {
        val zufaelligeAttacke = attacken.random()
        when (zufaelligeAttacke) {
            "gifthieb" -> schwaechung(held)
        }
    }
}