import kotlin.random.Random

class Krieger(name: String, leben: Int) : Held(name, leben) {               //erbt vom Held

    override fun angreifen(boss: Boss) {                                                            //Angriff auswählen
        println("----------------------------")
        println("Wähle einen Angriff")
        println("1: Schwertschwung")
        println("2: Stechen")
        println("3: Schleudern")
        println("4: Trugschlag")
        println("----------------------------")
        println()

        val eingabe = readln()?.toIntOrNull()                                                       //eingabe vom User

        when (eingabe) {
            1 -> {
                val schaden = Random.nextInt(360, 450)                                          // genau wie bei magier
                println("${name} benutzt Schwertschwung und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            2 -> {
                val schaden = Random.nextInt(360, 420)
                println("${name} benutzt Stechen und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            3 -> {
                val schaden = Random.nextInt(200, 350)
                println("${name} benutzt Schleudern und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            4 -> {
                val schaden = Random.nextInt(600, 900)
                println("${name} benutzt Trugschlag udn verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            else -> {
                println("Ungültige Eingabe")
            }
        }
    }

    override fun beutel(held: Held) {
        beutelGezogen = true
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
            val heilung = Random.nextInt(50, 101)
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
            println("${name} aktuelles Leben: ${leben}")
            val dauerhaftLeben = leben / 100 * 10
            leben += dauerhaftLeben
            println("${name} hat jetzt dauerhaft ${leben} Leben")
            vitaminVerwendet = true
        } else {
            println("Vitamine können nur einmal genommen werden")
        }
    }
}