import kotlin.random.Random

class Drake(name: String, leben: Int) : Boss(name, leben) {

    val attacken = listOf("gifthieb", "schwerttanz", "durchbruch", "seitlicherHieb", "panzerSchlag", "boeserFluch")      //Hilfe vom Tutor

    fun gifthieb(held: Held) {
        val schaden = Random.nextInt(280, 320)                              //Macht einen zufälligen Schaden in dem Bereich
        println("${name} führt die Attacke Gifthieb aus und macht ${schaden} Schaden an ${held.name}")  //Text mit Infos wird ausgegeben
        held.schaden(schaden)                                           //hilfe vom tutor
        if(held.leben >= 1) {
            println("${held.name} hat noch ${held.leben} Leben.")                                                             //Schaden wird vom Leben vom Held abgezogen
        } else {
            println("Der Held ${held.name} ist tot")                    //Text mit Infos ausgegeben
        }

    }

    fun schwerttanz(held: Held) {                                         //Wiederholt sich s.o.
        val schaden = Random.nextInt(300, 420)
        println("${name} führt die Attacke Schwerttanz aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                              //hilfe vom tutor
        println("${held.name} hat noch ${held.leben} Leben.")
    }

    fun durchbruch(held: Held) {                                          //Wiederholt sich s.o.
        val schaden = Random.nextInt(400, 440)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                              //hilfe vom tutor
        println("${held.name} hat noch ${held.leben} Leben.")
    }

    fun seitlicherHieb(held: Held) {                                          //Wiederholt sich s.o.
        val schaden = Random.nextInt(430, 470)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)
        println("${held.name} hat noch ${held.leben} Leben.")
    }

    fun panzerSchlag(held: Held) {                                          //Wiederholt sich s.o.
        val schaden = Random.nextInt(480, 520)
        println("${name} führt die Attacke Durchbruch aus und macht ${schaden} Schaden an ${held.name}")
        held.schaden(schaden)                                               //hilfe vom tutor
        println("${held.name} hat noch ${held.leben} Leben.")
    }

    fun boeserFluch(helden: List<Held>) {                                           //Wiederholt sich s.o.
        for (held in helden) {
            val schaden = Random.nextInt(320, 420)
            held.schaden(schaden)
            println("${name} führt die Attacke Böser Fluch aus und macht ${schaden} Schaden an ${held.name}")
            println("${held.name} hat noch ${held.leben} Leben.")
        }

    }

    override fun angreifen(held: Held, helden: List<Held>) {                   // Damit die verschiedenen attacken zufällig ausgeführt werden,
        val zufaelligeAttacke = attacken.random()
        when (zufaelligeAttacke) {                                             //Hilfe vom tutor
            "gifthieb" -> gifthieb(held)
            "schwerttanz" -> schwerttanz(held)
            "durchbruch" -> durchbruch(held)
            "seitlicherHieb" -> seitlicherHieb(held)
            "panzerSchlag" -> panzerSchlag(held)
            "boeserFluch" -> boeserFluch(helden)
        }
    }
}






/*  val attacken = listOf(
        ::gifthieb,                 //doppelpunkt damit ich die methoden (funktionen / attacken) einzelt verwenden kann
        ::schwerttanz,
        ::durchbruch,
        ::boeserFluch,
        ::seitlicherHieb,
        ::panzerSchlag
    )
                                  // doppelpunkt nochmal bei google nachgeschaut: https://kotlinlang.org/docs/reflection.html#function-references
   */