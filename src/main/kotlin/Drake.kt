import kotlin.random.Random

class Drake(name: String, leben: Int) : Boss(name, leben) {

    val attacken = listOf("gifthieb", "schwerttanz", "durchbruch",
        "seitlicherHieb", "panzerSchlag", "boeserFluch")                               //Hilfe vom Tutor

    fun gifthieb(held: Held) {
        val schaden = Random.nextInt(280, 320)                              //Macht einen zufälligen Schaden in dem Bereich
        println("${name} führt die Attacke Gifthieb aus und macht ${schaden} Schaden an ${held.name}")  //Text mit Infos wird ausgegeben
        held.schaden(schaden)                                                  //hilfe vom tutor, Schaden wird vom Leben vom Held abgezogen
        if(held.leben >= 1) {                                                           // Wenn der Held noch über 1 HP hat, dann ..
            println("${held.name} hat noch ${held.leben} Leben.")                       // wird folgender text ausgegeben
        } else {
            println("Der Held ${held.name} ist tot")                                   //wenn unter 0 dann folgender Text
        }

    }

    fun schwerttanz(held: Held) {
        val schaden = Random.nextInt(300, 420)
        println("${name} führt die Attacke Schwerttanz aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                                      //hilfe vom tutor, Schaden wird vom Leben vom Held abgezogen
        if(held.leben >= 1) {                                                      //Wenn der Held noch über 1 HP hat, dann ..
            println("${held.name} hat noch ${held.leben} Leben.")                  //wird folgender text ausgegeben
        } else {
            println("Der Held ${held.name} ist tot")                               //wenn unter 0 dann folgender Text
    }
    }

    fun durchbruch(held: Held) {
        val schaden = Random.nextInt(400, 440)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                                      //hilfe vom tutor, Schaden wird vom Leben vom Held abgezogen
        if (held.leben >= 1) {                                                     //Wenn der Held noch über 1 HP hat, dann ..
            println("${held.name} hat noch ${held.leben} Leben.")                  //wird folgender text ausgegeben
        } else {
            println("Der Held ${held.name} ist tot")                               //wenn unter 0 dann folgender Text
        }
    }

    fun seitlicherHieb(held: Held) {
        val schaden = Random.nextInt(430, 470)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                                 //hilfe vom tutor, Schaden wird vom Leben vom Held abgezogen
        if (held.leben >= 1) {                                                //Wenn der Held noch über 1 HP hat, dann ..
            println("${held.name} hat noch ${held.leben} Leben.")             //wird folgender text ausgegeben
        } else {
            println("Der Held ${held.name} ist tot")                          //wenn unter 0 dann folgender Text
        }
    }

    fun panzerSchlag(held: Held) {
        val schaden = Random.nextInt(480, 520)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                                //hilfe vom tutor, Schaden wird vom Leben vom Held abgezogen
        if (held.leben >= 1) {                                               //Wenn der Held noch über 1 HP hat, dann ..
            println("${held.name} hat noch ${held.leben} Leben.")            //wird folgender text ausgegeben
        } else {
            println("Der Held ${held.name} ist tot")                         //wenn unter 0 dann folgender Text
        }
    }

    fun boeserFluch(helden: List<Held>) {
        for (held in helden) {                                                      //Diese Attacke trifft alle Helden
            val schaden = Random.nextInt(320, 420)
            held.schaden(schaden)                                                   //Macht Schaden an allen Helden
            if (held.leben >= 1) {
                println("${name} führt die Attacke Böser Fluch aus und macht ${schaden} Schaden an ${held.name}")
            } else {
                println("Der Held ${held.name} ist tot")                            //wenn unter 0 dann folgender Text
            }
        }
    }

    override fun angreifen(held: Held, helden: List<Held>) {
        val zufaelligeAttacke = attacken.random()                              //wählt zufällige Attacke oben aus der Liste
        when (zufaelligeAttacke) {                                             //Hilfe vom tutor
            "gifthieb" -> gifthieb(held)                                       //führt gewählt attacke aus
            "schwerttanz" -> schwerttanz(held)
            "durchbruch" -> durchbruch(held)
            "seitlicherHieb" -> seitlicherHieb(held)
            "panzerSchlag" -> panzerSchlag(held)
            "boeserFluch" -> boeserFluch(helden)
        }
    }
}