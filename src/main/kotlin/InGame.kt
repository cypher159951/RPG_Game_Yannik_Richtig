
//Diese Klasse wird nicht benötigt, könnte ich eigentlich löschen habe sie aber vorsichtshalber behalten fals ich
//hier doch etwas programmieren möchte


open class InGame(val name: String, var lebenspunkte: Int) {

    fun aktionAuswaehlen() {
    }

    open fun angreifen() {
    }

    open fun heilen() {
    }

    open fun beutel() {
   }

    open fun schaden(schaden: Int) {
        lebenspunkte -= schaden
        if (lebenspunkte < 0) {
            lebenspunkte = 0
        }
        println("${name} erleidet ${schaden} Schaden. Es bleiben ${lebenspunkte} Lebenspunkte übrig.")
    }
}