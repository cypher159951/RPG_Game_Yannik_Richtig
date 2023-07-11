fun main() {
    // val kleinerHelferJohn = KleinerHelferJohn("Kleiner Helfer John", 100)
    //  kleinerHelferJohn.attackeSchwaechung(InGame("Spieler", 200))
    val drake = Drake("Drake", 5800)           //Meine Helden
    val magier = Magier("Magier", 800)
    val krieger = Krieger("Krieger", 1000)
    val druide = Druide("Druide", 970)

    val helden = listOf(magier, krieger, druide)            //Liste der Helden damit der drake einen Held zufällig angreifen kann
    var attackeAusgefuehrt = 0                             //zählt wie oft meine Helden schon angegriffen haben
    var drakeAngriffAusgefuehrt =
        false                    //überprüft ob der drake nach dem 3. mal einmal angegriffen hat

    println("Willkommen im Spiel!")                        //Willkommensbildschirm
    println("Der Kampf gegen den Boss beginnt.")


    while (drake.lebenspunkte > 0 && helden.any { it.leben > 0 }) {           // der drake mehr als 0 HP und alle helden mehr als 0 HP haben,
        println("----------------------------")                             // dann gehts los...
        println("Wählen Sie einen Helden:")                                 // Helden wählen
        println("1: Magier")
        println("2: Krieger")
        println("3: Druide")
        println("----------------------------")


        val eingabe = readLine()?.toIntOrNull()                             //eingabe vom User

        val held = when (eingabe) {                                         //Held wird gewählt
            1 -> magier
            2 -> krieger
            3 -> druide
            else -> null
        }

        if (held != null && held.leben > 0) {                                    //Wenn es den Held gibt und der held mehr als 0 HP hat
            println("----------------------------")                              //dann kann der Held eine ktion wählen
            println("Gewählter Held: ${held.name}")                              //Gewählter Held wird angezeigt
            println("Wählen Sie eine Aktion:")                                   //Aktion wählen
            println("1: Angreifen")
            println("2: Beutel")
            println("----------------------------")

            val aktion = readLine()?.toIntOrNull()                               //eingabe User

            when (aktion) {
                1 -> {                                                           //wenn die 1 gedrückt wird, wird angegriffen
                    held.angreifen(drake)
                    attackeAusgefuehrt++                                         //attacke vom Held wird (oben) gezählt


                    if (attackeAusgefuehrt >= 3 && !drakeAngriffAusgefuehrt) {                  //wenn die Attacke noch nicht 3x ausgeführt wurden ist und drake noch nicht angegriffen hat..
                        val zufaelligerHeld = helden.filter { it.leben > 0 }
                            .random()           //dann greift der drake an und wählt einen zufälligen Held aus der Liste oben der noch mehr als 0 HP hat
                        println("----------------------------")
                        println("Gegner ist am zug:")                                           //Gegner greift an
                        print("3")
                        Thread.sleep(100)
                        print(".")
                        Thread.sleep(100)
                        print(". ")
                        Thread.sleep(1000)                                                //kurze Pause 1 sek
                        print("2")
                        Thread.sleep(100)
                        print(".")
                        Thread.sleep(100)
                        print(". ")
                        Thread.sleep(1000)
                        print("1")
                        Thread.sleep(100)
                        print(".")
                        Thread.sleep(100)
                        println(". ")
                        Thread.sleep(1000)
                        drake.angreifen(zufaelligerHeld)                                        //drake greift zufälligen Held an
                        drakeAngriffAusgefuehrt =
                            true                                          //angriff vom drake wird auf true gesetzt

                    }
                    if (attackeAusgefuehrt < 3) {                                               //wenn die attacke weniger als 3 ist..
                        println("Angriff ${attackeAusgefuehrt} von 3")                          //angriff x von 3 wird angezeit

                    } else {
                        attackeAusgefuehrt =
                            0                                                  //andererseits wiederholen
                        drakeAngriffAusgefuehrt =
                            false                                         //wenn drake noch nicht auf true (nach dem 3. angriff) dann ist immernoch false
                    }
                }

                2 -> {
                    held.beutel(held)                                                           // Nr. 2 für Beutel wählen
                }

                else -> println("Ungültige Eingabe")                                            // Wird was anderes einegegebn wie gefordert, gibt er ungültige eingabe aus
            }
        } else {
            println("Ungültige Eingabe oder Held tot. Probiere es noch einmal.")                //Wenn falsche eingabe oder held tot dann nochmal ein probieren
        }

        println("---------")
    }

    if (drake.lebenspunkte <= 0) {                                                              //Wenn drake wniger als 0 HP ist das spiel vorbei
        println("Herzlichen Glückwunsch! Sie haben den Boss besiegt!")                          //Bei Sieg wird der Text ausgegeben
    } else {
        println("Leider haben Sie den Kampf verloren. Der Boss hat noch ${drake.lebenspunkte} Lebenspunkte.")         //Wenn User verloren wird folgender Text ausgegeben
    }

    println("Das Spiel ist beendet.")                                                           //spiele beendet


}


/*

Schleife {
   held1.attacke()
   held2.attacke()
   held3.attacke()
   gegner.attacke()
}
 */