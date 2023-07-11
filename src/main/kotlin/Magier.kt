import kotlin.random.Random

class Magier(name: String, leben: Int) : Held(name, leben) {                //erbt vom Held

    var heilungVerwendet = 0                                                //Zählt ob der Held schon Heilung benutzt hat

    override fun angreifen(boss: Boss) {                                    //Angriff auswählen
        println("----------------------------")
        println("Wähle einen Angriff")
        println("1: Froststrahl")
        println("2: Eisblitz")
        println("3: Festhalten")
        println("4: Sternenschauer")
        println("----------------------------")

        val eingabe = readln()?.toIntOrNull()                                       //eingabe vom User

        when (eingabe) {
            1 -> {
                val schaden = Random.nextInt(200, 350)                                  // wenn 1 gewählt wird macht er zfälligen schaden zwischen 200 und 350
                println("${name} benutzt Froststrahl und verursacht ${schaden} Schaden")          // habe extra Random.nextInt gewählt (statt (300<..<380).random()) weil ich es übersichtlicher finde
                boss.schaden(schaden)                                                             // schaden wird am drake(Boss) abgezogen
            }

            2 -> {
                val schaden = Random.nextInt(300, 380)                                  //Das ganze wiederholt sich
                println("${name} benutzt Eisblitz und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            3 -> {
                val schaden = Random.nextInt(180, 248)
                println("${name} benutzt Festhalten und verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            4 -> {
                val schaden = Random.nextInt(590, 780)
                println("${name} benutzt Sternenschauer verursacht ${schaden} Schaden")
                boss.schaden(schaden)
            }

            else -> {
                println("Ungültige Eingabe")                                          //Bei falsche eingabe wird folgender Text ausgegeben
            }
        }

    }

    override fun beutel(held: Held) {                                           //Beutel vom Held
        println("----------------------------")
        println("Wähle aus:")                                                   //Auswählen was man möchte
        println("1: Heilung")
        println("2: Vitamine")
        println("----------------------------")
        var eingabeBeutel = readln().toInt()                                    //Eingabe vom User

        when (eingabeBeutel) {
            1 -> heilen(held)                                                   //Wenn 1 dann Heiltrank

            2 ->                                                                //Wenn 2 dann Vitamine
                vitamine(held)
        }
    }

    override fun heilen(held: Held) {
        if (heilungVerwendet < 3) {                                                     //Wenn der Held noch keine 3 Heiltränke benutzt hat, kann es einen benutzen
            val heilung = Random.nextInt(100, 201)                            //Heilt sich zufällig in diesem Bereich
            leben += heilung                                                            //Heilung(Leben) wird zum aktuellen Leben addiert
            println("${name} heilt sich um ${heilung} Lebenspunkte und hat nun ${leben} Lebenspunkte")      //Test wird ausgegeben mit Infos
            heilungVerwendet++                                                          //Benutzung des Heiltrank wird gezählt
            println("Sie haben den Heiltrank ${heilungVerwendet} von 3 benutzt")        //Test wird ausgegeben
        } else {
            println("Sie dürfen den Heiltrank nur 3x benutzen. ")                       //Wenn schon 3 benutzt, dann wird folgender Text ausgegeben
        }
    }

    var vitaminVerwendet = false                                                    //Gibt an das noch keine Vitamine verwendet wurden

    override fun vitamine(held: Held) {
        if (!vitaminVerwendet) {                                                    //Wenn noch keine Vitamine benutzt, dann....
            println("${name} akteulles Leben: ${leben}")                            //dauerhaft 10% mehr leben einmalig..
            val dauerhaftLeben = leben / 100 * 10                                   //Rundet bei Zahlen da kein Double verwende
            leben += dauerhaftLeben                                                 //Bei Leben finde ich es gut wenn die Zahlen ohne kommastelle sind
            println("${name} hat jetzt dauerhaft ${leben} Leben")
            vitaminVerwendet = true                                                 //Vitamine benutzt wird auf true gesetzt und kann nicht nochmal benutzt werden
        } else {
            println("Vitamine können nur einmal genommen werden")                   //Wenn schon benutzt wird folgender Text ausgegeben
        }
    }
}