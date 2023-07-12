import kotlin.random.Random

class Krieger(name: String, leben: Int) : Held(name, leben) {                                       //erbt vom Held

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
                val schaden = Random.nextInt(360, 450)                                    // genau wie bei magier
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

            else -> {                                           //Bei falsche eingabe wird folgender Text ausgegeben
                println("Ungültige Eingabe")
            }
        }
    }

    override fun beutel(held: Held) {
        beutelGezogen = true                                    //Beutel gezogen wird auf true gesetzt wenn er 1x benutzt wurde
        println("----------------------------")
        println("Wähle aus:")                                   //Auswählen was man möchte
        println("1: Heilung")
        println("2: Vitamine")
        println("----------------------------")
        var eingabeBeutel = readln().toInt()                    //Eingabe vom User

        when (eingabeBeutel) {
            1 -> heilen(held)                                   //Wenn 1 dann Heiltrank

            2 ->                                                //Wenn 2 dann Vitamine
                vitamine(held)
        }
    }

    var heilungVerwendet = 0                                    //Zählt ob der Held schon Heilung benutzt hat

    override fun heilen(held: Held) {
        if (heilungVerwendet < 3) {                                                         //Wenn der Held noch keine 3 Heiltränke benutzt hat, kann es einen benutzen
            val heilung = Random.nextInt(50, 101)                                 //Heilt sich zufällig in diesem Bereich
            leben += heilung                                                                //Heilung(Leben) wird zum aktuellen Leben addiert
            println("${name} heilt sich um $heilung Lebenspunkte und hat nun $leben Lebenspunkte")  //Text wird ausgegeben mit Infos
            heilungVerwendet++                                                              //Benutzung des Heiltrank wird gezählt
            println("Sie haben den Heiltrank ${heilungVerwendet} von 3 benutzt")            //Test wird ausgegeben
        } else {
            println("Sie dürfen den Heiltrank nur 3x benutzen. ")                           //Wenn schon 3 benutzt, dann wird folgender Text ausgegeben
        }
    }

    var vitaminVerwendet = false                                                    //Gibt an das noch keine Vitamine verwendet wurden

    override fun vitamine(held: Held) {
        if (!vitaminVerwendet) {                                                    //Wenn noch keine Vitamine benutzt, dann....
            println("${name} aktuelles Leben: ${leben}")                            //dauerhaft 10% mehr leben einmalig..
            val dauerhaftLeben = leben / 100 * 10                                   //Rundet bei Zahlen da kein Double verwende
            leben += dauerhaftLeben                                                 //Bei Leben finde ich es gut wenn die Zahlen ohne kommastelle sind
            println("${name} hat jetzt dauerhaft ${leben} Leben")
            vitaminVerwendet = true                                                 //Vitamine benutzt wird auf true gesetzt und kann nicht nochmal benutzt werden
        } else {
            println("Vitamine können nur einmal genommen werden")                   //Wenn schon benutzt wird folgender Text ausgegeben
        }
    }
}