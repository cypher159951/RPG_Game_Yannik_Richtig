import kotlin.random.Random

class Druide(name: String, leben: Int) : Held(name, leben) {

    override fun angreifen(boss: Boss) {                                        //Wiederholt sich alles wie beim Magier
        println("----------------------------")
        println("Wähle einen Angriff")
        println("1: Psystrahl")
        println("2: Dunkelklaue")
        println("3: Donnerwelle")
        println("4: Eishieb")
        println("----------------------------")

        val eingabe = readln()?.toIntOrNull()

        when (eingabe) {
            1 -> {
                val schaden = Random.nextInt(400, 500)
                println("${name} benutzt Psystrahl und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            2 -> {
                val schaden = Random.nextInt(380, 460)
                println("${name} benutzt Dunkelklaue und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            3 -> {
                val schaden = Random.nextInt(190, 320)
                println("${name} benutzt Donnerwelle udn verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            4 -> {
                val schaden = Random.nextInt(700, 900)
                println("${name} benutzt Eishieb udn verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            else -> {
                println("Ungültige Eingabe")
            }
        }
    }

    override fun beutel(held: Held) {
        println("----------------------------")
        println("Wähle aus:")
        println("1: Heilung")
        println("2: Vitamine")
        println("----------------------------")
        var eingabeBeutel = readln().toInt()

        when (eingabeBeutel) {
            1 -> heilen(held)

            2 ->
                vitamine(held)

        }
    }

    var heilungVerwendet = 0

    override fun heilen(held: Held) {
        if (heilungVerwendet < 3) {
            val heilung = Random.nextInt(150, 251)
            leben += heilung
            println("${name} heilt sich um $heilung Lebenspunkte und hat nun $leben Lebenspunkte")
            heilungVerwendet++
            println("Sie haben den Heiltrank ${heilungVerwendet} von 3 benutzt")
        } else {
            println("Sie dürfen den Heiltrank nur 3x benutzen. ")
        }
    }

    var vitaminVerwendet = false

    override fun vitamine(held: Held) {
        if (!vitaminVerwendet) {
            println("${name} aktuelles Leben ${leben}")
            val dauerhaftLeben = leben / 100 * 10
            leben += dauerhaftLeben
            println("${name} hat jetzt dauerhaft ${leben} Leben")
            vitaminVerwendet = true
        } else {
            println("Vitamine können nur einmal genommen werden")
        }
    }
}
