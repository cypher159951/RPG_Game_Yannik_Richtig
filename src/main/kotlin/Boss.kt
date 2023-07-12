import kotlin.random.Random

open class Boss(var name: String, var lebenspunkte: Int) {

    open fun schaden(schaden: Int) {                                        //Wenn drake schaden erhält...
        lebenspunkte -= schaden                                             //Der Schaden wird vom Drake sein Leben abgeogen
        println("${name} erleidet ${schaden} Schaden. Es bleiben ${lebenspunkte} Lebenspunkte übrig")       //Text mit Infos werden ausgegeben
        if (lebenspunkte <= 0) {                                            //Wenn der drake weniger als 0 HP hat, dann...
            println("${name} wurde besiegt")                                //Wird der Text ausgegeben das man gewonnen hat
        }
    }

    open fun heilen() {                                                     //Funktion wird nicht benutzt
        val heilung = Random.nextInt(400, 900)
        lebenspunkte += heilung
        println("${name} heilt sich um ${heilung} und hat nun wieder ${lebenspunkte} Lebenspunkte")
    }

    open fun angreifen(held: Held, helden: List<Held>){                                          //Drake greift Held an
        val schaden = Random.nextInt(200, 300)                                        //Macht einen zufälligen Schaden in dem Bereich
        println("${name} greift ${held.name} an und verursacht ${schaden} Schaden")             //Text mit Info wird ausgegeben
        held.schaden(schaden)                                                                   //Schaden wird vom Held abgezogen

    }

}